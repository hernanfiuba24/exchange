package com.exchange.service;

public interface SistemaSolarService {

	public boolean isDroughting();
	public boolean isRainning();
	public boolean isTheBestPresionAndTemperatureConditions();
	public Double amountOfRain();
}
