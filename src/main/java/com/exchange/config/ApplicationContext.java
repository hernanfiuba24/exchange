package com.exchange.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Lazy;

import com.exchange.service.SistemaSolarService;
import com.exchange.service.impl.SistemaSolarServiceImpl;

@Configuration
@ComponentScan(basePackages = { "com.exchange" })
@EnableAspectJAutoProxy
public class ApplicationContext {
		/*	Services bean */
	@Bean
	@Lazy
	public SistemaSolarService sistemaSolarService() {
		return new SistemaSolarServiceImpl();
	}
}
