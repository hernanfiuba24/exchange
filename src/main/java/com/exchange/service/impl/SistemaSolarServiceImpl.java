package com.exchange.service.impl;

import org.springframework.stereotype.Service;

import com.exchange.service.SistemaSolarService;

@Service
public class SistemaSolarServiceImpl implements SistemaSolarService{
	
	@Override
	public boolean isDroughting() {
		return true;
	}

	@Override
	public boolean isRainning() {
		return false;
	}

	@Override
	public boolean isTheBestPresionAndTemperatureConditions() {
		return false;
	}

	@Override
	public Double amountOfRain() {
		return 100d;
	}

}
