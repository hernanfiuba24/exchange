package com.exchange.config;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;

@Configurable
@PropertySource("classpath:application.properties")
@ConfigurationProperties(prefix="com.sistema.solar")
public interface SistemaSolarConstants {
	static String SOL_NAME = "sol";
	static String VULCANO_NAME = "vulcano";
	static String FERENGI_NAME = "ferengi";
	static String BETASOIDE_NAME = "betasoide";
	static Double FERENGI_DISTANCE_TO_ORIGIN = 500d;
	static Double FERENGI_SPEED_ANGULAR = 1d;
	static Double BETASOIDE_DISTANCE_TO_ORIGIN = 2000d;
	static Double BETASOIDE_SPEED_ANGULAR = 3d;
	static Double VULCANO_DISTANCE_TO_ORIGIN = 1000d;
	static Double VULCANO_SPEED_ANGULAR = -5d;
	static Double SOL_DISTANCE_TO_ORIGIN = 0d;
	static Double SOL_SPEED_ANGULAR = 0d;
}
