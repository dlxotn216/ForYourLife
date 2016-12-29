package com.taesu.fyl.config;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.mail.MailSender;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import javax.mail.Authenticator;
import java.util.Properties;

/**
 * Created by kim on 2016-12-29.
 */
@Configuration
@PropertySource(
        value = {
                "classpath:/properties/google.mail.properties",
                "classpath:/properties/naver.mail.properties",
        }
)
public class MailConfig {
    @Value("${google.mail.host}")      private String g_mailHost;
    @Value("${google.mail.port}")      private int g_mailPort;
    @Value("${google.mail.protocol}")    private String g_protocol;
    @Value("${google.mail.username}")  private String g_mailUserName;
    @Value("${google.mail.password}")  private String g_mailPassword;
    @Value("${google.mail.encoding}")  private String g_mailEncoding;
    @Value("${google.mail.smtp.auth}") private boolean g_smtpAuth;

    @Value("${naver.mail.host}")      private String n_mailHost;
    @Value("${naver.mail.port}")      private int n_mailPort;
    @Value("${naver.mail.protocol}")    private String n_protocol;
    @Value("${naver.mail.username}")  private String n_mailUserName;
    @Value("${naver.mail.password}")  private String n_mailPassword;
    @Value("${naver.mail.encoding}")  private String n_mailEncoding;
    @Value("${naver.mail.smtp.auth}") private boolean n_smtpAuth;

    @Bean
    @Qualifier("google")
    public JavaMailSender javaMailSenderVersionGoogle(){
        JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();
        javaMailSender.setHost(g_mailHost);
        javaMailSender.setPort(g_mailPort);
        javaMailSender.setUsername(g_mailUserName);
        javaMailSender.setPassword(g_mailPassword);
        javaMailSender.setDefaultEncoding(g_mailEncoding);
        javaMailSender.setProtocol(g_protocol);
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", g_smtpAuth);
        properties.put("mail.smtp.starttls.enable", g_smtpAuth);
        javaMailSender.setJavaMailProperties(properties);
        return javaMailSender;
    }

    @Bean
    @Qualifier("naver")
    public JavaMailSender javaMailSenderVersionNaver(){
        JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();
        javaMailSender.setHost(n_mailHost);
        javaMailSender.setPort(n_mailPort);
        javaMailSender.setUsername(n_mailUserName);
        javaMailSender.setPassword(n_mailPassword);
        javaMailSender.setDefaultEncoding(n_mailEncoding);
        javaMailSender.setProtocol(n_protocol);
        Properties properties = new Properties();
        properties.put("mail.smtps.auth", n_smtpAuth);
        properties.put("mail.smtp.starttls.enable", n_smtpAuth);
        properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.ssl.trust", n_mailHost);
        properties.put("mail.debug", "true");
        properties.put("mail.smtp.socketFactory.fallback", "false");
        javaMailSender.setJavaMailProperties(properties);
        return javaMailSender;
    }

}
