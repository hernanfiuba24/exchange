package com.exchange.logic.sistemaSolar;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.exchange.exeption.RectaCreateException;
import com.exchange.model.sistemaSolar.CuerpoCeleste;

public class PlanetUtils {
	
	private static final Logger logger = Logger.getLogger(PlanetUtils.class.getName());
	
	/*
	 * Minimamente tienen que haber dos planetas
	 */
	public static boolean arePlanetsAlign(List<CuerpoCeleste> planets) {
		boolean isAling = true;
		if (planets != null && planets.size()>=2) {
			CuerpoCeleste p1 = planets.get(0);
			CuerpoCeleste p2 = planets.get(1);
			try {
				Recta r = new Recta(p1.getCoordenadaCartesiana(),p2.getCoordenadaCartesiana());
				if (planets.size()>2) {
					for(int i = 2; i < planets.size() && isAling;i++) {
						isAling = r.pointIsInRecta(planets.get(i).getCoordenadaCartesiana());
					}
				}
			} catch (RectaCreateException e) {
				logger.log(Level.SEVERE, "Not create a recta", e);
				isAling = false;
			}
		}
		return isAling;
	}
}
