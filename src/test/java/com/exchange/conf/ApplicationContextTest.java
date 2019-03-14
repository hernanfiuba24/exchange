package com.exchange.conf;

import org.junit.Ignore;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.web.WebAppConfiguration;

@EnableAutoConfiguration
@ComponentScan(basePackages = {"com.exchange"})
@EnableJpaRepositories(basePackages={"com.exchange.repository"})
@EntityScan(basePackages= {"com.exchange.model"})
@WebAppConfiguration
@Ignore
public class ApplicationContextTest {

}
