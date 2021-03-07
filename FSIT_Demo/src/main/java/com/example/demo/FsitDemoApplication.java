package com.example.demo;

import java.util.Locale;

import org.apache.tomcat.util.descriptor.LocalResolver;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@SpringBootApplication
public class FsitDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(FsitDemoApplication.class, args);
	}
	
//	@Bean
//	public SessionLocaleResolver localResolver() {
//		SessionLocaleResolver localResolver= new SessionLocaleResolver();
//		localResolver.setDefaultLocale(Locale.US);
//		return localResolver;
//	}
//	
//	@Bean
//	public ResourceBundleMessageSource messageSource() {
//		return null;
//		
//	}
	
}

