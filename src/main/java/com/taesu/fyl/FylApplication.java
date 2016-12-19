package com.taesu.fyl;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.servlet.Filter;
import javax.sql.DataSource;

@SpringBootApplication
@ComponentScan
@EnableWebMvc
@Slf4j
@MapperScan(value = ("com.taesu.fyl"))
public class FylApplication extends SpringBootServletInitializer{

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		builder.web(true);
		return builder.sources(FylApplication.class);
	}

	@Bean
	public Filter characterEncodingFilter() {
		CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
		characterEncodingFilter.setEncoding("UTF-8");
		characterEncodingFilter.setForceEncoding(true);
		return characterEncodingFilter;
	}

	@Bean
	public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
		SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
		sessionFactory.setDataSource(dataSource);
		Resource[] resources = new PathMatchingResourcePatternResolver().getResources("classpath:mapper/*.xml");
		System.out.println("DEBUG : SQL MAPPER LENGTH : " + resources.length);
		sessionFactory.setMapperLocations(resources);
		sessionFactory.setTypeAliasesPackage("com.taesu.fyl");

		Configuration config = new Configuration();
		config.setMapUnderscoreToCamelCase(true);
		sessionFactory.setConfiguration(config);

		return sessionFactory.getObject();
	}
	public static void main(String[] args) {
		SpringApplication.run(FylApplication.class, args);
	}
}
