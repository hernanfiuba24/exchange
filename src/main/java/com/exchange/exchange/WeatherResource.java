package com.exchange.exchange;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class WeatherResource {
	
	Map<String, WeatherService> weathers = new HashMap<>();
	
	public WeatherResource() {
		weathers.put("eeuu", new WeatherEEUU());
		weathers.put("argentina", new WeatherArgentina());
	}
	
	@SuppressWarnings("finally")
	@GetMapping("/weather/{country}")
	@ResponseBody
	public String weather(@PathVariable String country) {
		
		String response = "";
		try {
			response = weathers.get(country).weather();
		} catch (Exception e) {
			response = "Does not find this country";
		} finally {
			return response;
		}
		
	}
}
