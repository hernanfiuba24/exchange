package com.exchange.exchange;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
@Service
public class WeatherArgentina implements WeatherService{

	@Override
	public String weather() {
		return "this is Argentina's weather";
	}
	
}
