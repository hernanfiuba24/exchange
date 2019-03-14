package com.exchange.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.exchange.service.SistemaSolarService;
import com.exchange.service.impl.SistemaSolarServiceImpl;

@Configuration
@EnableAutoConfiguration
@PropertySource("classpath:application.properties")
@ComponentScan(basePackages = {"com.exchange"})
@EnableAspectJAutoProxy
@EnableJpaRepositories(basePackages={"com.exchange.repository"})
@EntityScan(basePackages= {"com.exchange.model"})
public class ApplicationContext {
		/*	Services bean */
	@Bean
	@Lazy
	public SistemaSolarService sistemaSolarService() {
		return new SistemaSolarServiceImpl();
	}
}
