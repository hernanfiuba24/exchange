package com.exchange.model.sistemaSolar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import com.exchange.config.SistemaSolarConstants;
import com.exchange.exeption.RectaCreateException;
import com.exchange.logic.sistemaSolar.PlanetUtils;
import com.exchange.logic.sistemaSolar.Recta;
import com.exchange.logic.sistemaSolar.Triangulo;

public class SistemaSolar{
	
	private static final Logger logger = Logger.getLogger(SistemaSolar.class.getName());
	
	private int day;
	private Map<String, CuerpoCeleste> estrellas = new HashMap<>();
	
	
	public SistemaSolar(Map<String, CuerpoCeleste> estrellas) {
		this.day = 0; 
		this.estrellas = estrellas;
	}
	
	public void move(int days) {
		estrellas.keySet().stream().forEach(estrellaName -> {
			CuerpoCeleste estrella = estrellas.get(estrellaName);
			estrella.move(days);
		});
	}
	/*
	 * El Sistema Solar experimenta un periodo de sequia cuando los planetas estan alineados 
	 * y el Sol tambien
	 */
	public boolean isDroughting() {
//		List<CuerpoCeleste> planets = estrellas.values().stream().filter(cc -> !cc.getName().equals(SistemaSolarConstants.SOL_NAME)).collect(Collectors.toList());
		return PlanetUtils.arePlanetsAlign((new ArrayList<CuerpoCeleste>(estrellas.values())));
	}
	/*
	 * El Sistema Solar experimenta un periodo de lluvia cuando los planetas forman un triangulo y 
	 * el sol esta contenido dentro del triangulo.
	 */ 
	public boolean isRainning() {
		return amountOfRain() > 0;
	}
	
	/*
	 * El Sistema Solar esta en condiciones de presion optima cuando los planetas estan alineados y  el sol no
	 */ 
	public boolean isTheBestPresionAndTemperatureConditions() {
		boolean isTheBestPresionAndTemperatureConditions = false;
		List<CuerpoCeleste> planets = estrellas.values().stream().filter(cc -> !cc.getName().equals(SistemaSolarConstants.SOL_NAME)).collect(Collectors.toList());
		if (PlanetUtils.arePlanetsAlign(planets)) {
			try {
				Recta r = new Recta(planets.get(0).getCoordenadaCartesiana(), planets.get(1).getCoordenadaCartesiana());
				if (!r.pointIsInRecta(estrellas.get(SistemaSolarConstants.SOL_NAME).getCoordenadaCartesiana())) {
					isTheBestPresionAndTemperatureConditions = true;
				}
			} catch (RectaCreateException e) {
				logger.log(Level.SEVERE, e.getMessage());
			}	
		}
		return  isTheBestPresionAndTemperatureConditions;
	}
	
	/*
	 * Se tiene el pico maximo cuando el perimetro es maximo
	 */
	public Double amountOfRain() {
		Double rain = 0d;
		List<CuerpoCeleste> planets = estrellas.values().stream().filter(cc -> !cc.getName().equals(SistemaSolarConstants.SOL_NAME)).collect(Collectors.toList());
		boolean exitsTriangulo = !PlanetUtils.arePlanetsAlign(planets);
		if (exitsTriangulo) {
			CuerpoCeleste betasoide = planets.get(0);
			CuerpoCeleste ferengi = planets.get(1);
			CuerpoCeleste vulcano = planets.get(2);
			Triangulo abc = new Triangulo(betasoide.getCoordenadaCartesiana(), ferengi.getCoordenadaCartesiana(), vulcano.getCoordenadaCartesiana());
			Triangulo abp = new Triangulo(betasoide.getCoordenadaCartesiana(), ferengi.getCoordenadaCartesiana(), estrellas.get(SistemaSolarConstants.SOL_NAME).getCoordenadaCartesiana());
			Triangulo cap = new Triangulo(vulcano.getCoordenadaCartesiana(), betasoide.getCoordenadaCartesiana(), estrellas.get(SistemaSolarConstants.SOL_NAME).getCoordenadaCartesiana());
			Triangulo bcp = new Triangulo(ferengi.getCoordenadaCartesiana(), vulcano.getCoordenadaCartesiana(), estrellas.get(SistemaSolarConstants.SOL_NAME).getCoordenadaCartesiana());
			boolean isRainning = (abc.isHourHand() && abp.isHourHand() && cap.isHourHand() && bcp.isHourHand()) 
						|| (!abc.isHourHand() && !abp.isHourHand() && !cap.isHourHand() && !bcp.isHourHand());
			if (isRainning) {
				rain = abc.getPerimeter();
			}
		}
		return rain;
	}
	
	public Map<String, CuerpoCeleste> getEstrellas() {
		return estrellas;
	}

	public void setEstrellas(Map<String, CuerpoCeleste> estrellas) {
		this.estrellas = estrellas;
	}
	
	public boolean isAlingPlanets() {
		boolean isAling = false;

		return isAling;
	}
	
	public void print() {
		estrellas.keySet().stream().forEach(estrellaName -> {
			CuerpoCeleste estrella = estrellas.get(estrellaName);
			System.out.println(estrella.toString());
		});
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}
}
