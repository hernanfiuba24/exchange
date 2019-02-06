package com.exchange.exchange;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
@Service
public class WeatherEEUU implements WeatherService{

	@Override
	public String weather() {
		return "This is EEUU's weather";
	}

}
