package com.taesu.fyl.config;


import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Created by dlxot on 2016-12-20.
 */

@Configuration
@EnableTransactionManagement
@MapperScan(value = ("com.taesu.fyl"))
public class DatabaseConfig {

    @Bean
    public PersistenceExceptionTranslationPostProcessor postProcessor(){
        return new PersistenceExceptionTranslationPostProcessor();
    }

    @Bean
    public DataSource dataSource(){
        DataSource ds = new DataSource();
        ds.setDriverClassName("net.sf.log4jdbc.sql.jdbcapi.DriverSpy");
        ds.setUrl("jdbc:log4jdbc:mysql://localhost:3306/fyl?allowMultiQueries=true");
        ds.setUsername("taesu");
        ds.setPassword("0216");

        return ds;
    }

    @Bean
    public PlatformTransactionManager transactionManager(){
        DataSourceTransactionManager tm = new DataSourceTransactionManager();
        tm.setDataSource(dataSource());

        return tm;
    }

    @Bean
    public SqlSessionFactory sqlSessionFactory(javax.sql.DataSource dataSource) throws Exception {
        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(dataSource);
        Resource[] resources = new PathMatchingResourcePatternResolver().getResources("classpath:mapper/*.xml");
        System.out.println("DEBUG : SQL MAPPER LENGTH : " + resources.length);
        sessionFactory.setMapperLocations(resources);
        sessionFactory.setTypeAliasesPackage("com.taesu.fyl");

        org.apache.ibatis.session.Configuration config = new org.apache.ibatis.session.Configuration();
        config.setMapUnderscoreToCamelCase(true);
        sessionFactory.setConfiguration(config);

        return sessionFactory.getObject();
    }

}
