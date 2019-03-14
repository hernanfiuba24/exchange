package com.exchange.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exchange.repository.SistemaSolarRepository;
import com.exchange.service.SistemaSolarService;

@Service
public class SistemaSolarServiceImpl implements SistemaSolarService{
	
	@Autowired
	SistemaSolarRepository repositorySS;
	
	@Override
	public boolean isDroughting() {
		System.out.println(repositorySS.findAll());
		return repositorySS.existsById(Integer.valueOf(2));
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
