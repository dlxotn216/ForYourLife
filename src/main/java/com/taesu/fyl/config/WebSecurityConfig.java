package com.taesu.fyl.config;

import com.taesu.fyl.security.AuthSuccessHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.csrf.CsrfTokenRepository;
import org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import java.util.EnumSet;

/**
 * Created by dlxot on 2016-12-21.
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter
{

    @Autowired
    private AuthenticationProvider customAutnenticationProvider;

    @Autowired
    private AuthSuccessHandler authSuccessHandler;

    @Override
    public void configure(WebSecurity web) throws Exception
    {
        web.ignoring().antMatchers("/resources/**");
    }
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //auth.userDetailsService(customUserDetailsService);
        auth.authenticationProvider(customAutnenticationProvider);

        // In case of password encryption - for production site
        //auth.userDetailsService(customUserDetailsService).passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception
    {
        http.authorizeRequests()
                .antMatchers("/master/**").access("hasRole('ROLE_MASTER')")
                .antMatchers("/admin/**").hasAnyRole("ADMIN","MASTER")//spring security automatically insert ROLE_
                .antMatchers("/login").hasRole("ANONYMOUS")
                .antMatchers("/account/create").hasRole("ANONYMOUS")
                .antMatchers("/account/update").authenticated()
                .antMatchers("/**").permitAll()
                .and()
                .formLogin()
                .loginPage("/authentication")
                .loginProcessingUrl("/authenticationProcess")
                .successHandler(authSuccessHandler)
                .failureUrl("/authentication")
                .usernameParameter("userId")
                .passwordParameter("passwd")
                .and()
                .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))     //logout default require post action
                .logoutSuccessUrl("/")
                .deleteCookies("remove")
                .invalidateHttpSession(true)
                .and()
                .exceptionHandling().accessDeniedPage("/error/403");


        //login 일때 post 보내면 "Invalid CSRF Token 'null' was found
        // on the request parameter '_csrf' or header 'X-CSRF-TOKEN'. 에러 발생 해결
        http.csrf()
                .csrfTokenRepository(csrfTokenRepository());

        // Advanced Rest Client에서 request 보낼 때 위와 동일 403 에러 발생시 해결
        http.csrf()
                .disable();

        http.sessionManagement()
                .maximumSessions(1)
                .maxSessionsPreventsLogin(false)
                .expiredUrl("/error/expire")
                .sessionRegistry(this.getSessionRegistry());
    }

    private CsrfTokenRepository csrfTokenRepository()
    {
        HttpSessionCsrfTokenRepository repository = new HttpSessionCsrfTokenRepository();
        repository.setSessionAttributeName("_csrf");
        return repository;
    }

    @Bean
    public FilterRegistrationBean getSpringSecurityFilterChainBindedToError(
            @Qualifier("springSecurityFilterChain") Filter springSecurityFilterChain) {

        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(springSecurityFilterChain);
        registration.setDispatcherTypes(EnumSet.allOf(DispatcherType.class));
        return registration;
    }


    @Bean
    public SessionRegistry getSessionRegistry(){
        return new SessionRegistryImpl();
    }

    //custom password encoder 등록
    @Bean
    public PasswordEncoder passwordEncoder() {
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder;
    }
}
