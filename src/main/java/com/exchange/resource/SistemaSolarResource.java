package com.exchange.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.exchange.service.SistemaSolarService;

@Controller
public class SistemaSolarResource {
	
	@Autowired
	private SistemaSolarService sistemaSolarService;
	
	@GetMapping("/sistemaSolar/isDrougthing")
	@ResponseBody
	public String isDroughting() {
		boolean isDroughting = sistemaSolarService.isDroughting();
		return String.valueOf(isDroughting);
	}

	@GetMapping("/sistemaSolar/isRainning")
	@ResponseBody
	public String isRainning() {
		boolean isRainning = sistemaSolarService.isRainning();
		return String.valueOf(isRainning);
	}
	
	@GetMapping("/sistemaSolar/isTheBestPresionAndTemperatureConditions")
	@ResponseBody
	public String isTheBestPresionAndTemperatureConditions() {
		boolean isTheBestPresionAndTemperatureConditions = sistemaSolarService.isTheBestPresionAndTemperatureConditions();
		return String.valueOf(isTheBestPresionAndTemperatureConditions);
	}
}
