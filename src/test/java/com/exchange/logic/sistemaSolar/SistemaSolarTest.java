package com.exchange.logic.sistemaSolar;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.exchange.config.SistemaSolarConstants;
import com.exchange.model.sistemaSolar.CuerpoCeleste;
import com.exchange.model.sistemaSolar.SistemaSolar;

public class SistemaSolarTest {
	
	Map<String, CuerpoCeleste> estrellas = new HashMap();
	SistemaSolar sistemaSolar;
	
	@Before
	public void init() {
		estrellas.put(SistemaSolarConstants.SOL_NAME, new CuerpoCeleste(SistemaSolarConstants.SOL_NAME, SistemaSolarConstants.SOL_DISTANCE_TO_ORIGIN, SistemaSolarConstants.SOL_SPEED_ANGULAR));
		estrellas.put(SistemaSolarConstants.BETASOIDE_NAME, new CuerpoCeleste(SistemaSolarConstants.BETASOIDE_NAME, SistemaSolarConstants.BETASOIDE_DISTANCE_TO_ORIGIN, SistemaSolarConstants.BETASOIDE_SPEED_ANGULAR));
		estrellas.put(SistemaSolarConstants.VULCANO_NAME, new CuerpoCeleste(SistemaSolarConstants.VULCANO_NAME, SistemaSolarConstants.VULCANO_DISTANCE_TO_ORIGIN, SistemaSolarConstants.VULCANO_SPEED_ANGULAR));
		estrellas.put(SistemaSolarConstants.FERENGI_NAME, new CuerpoCeleste(SistemaSolarConstants.FERENGI_NAME, SistemaSolarConstants.FERENGI_DISTANCE_TO_ORIGIN, SistemaSolarConstants.FERENGI_SPEED_ANGULAR));
		sistemaSolar = new SistemaSolar(estrellas);
	}
	
	@Test
	public void SistemaSolarNotNull() {
		assertNotNull(sistemaSolar);
	}
	
	@Test
	public void SistemaSolarIsDroughting() {
		assertTrue(sistemaSolar.isDroughting());
	}
	
	@Test
	public void SistemaSolarIsInTheBestPresionAndTemperatureNorteCondition() {
		CuerpoCeleste ferengi = estrellas.get(SistemaSolarConstants.FERENGI_NAME);
		CuerpoCeleste vulcano = estrellas.get(SistemaSolarConstants.VULCANO_NAME);
		CuerpoCeleste betasoide = estrellas.get(SistemaSolarConstants.BETASOIDE_NAME);
		vulcano.getCoordenadaCartesiana().setX(ferengi.getCoordenadaCartesiana().getX());
		vulcano.getCoordenadaCartesiana().setY(866.03d);
		betasoide.getCoordenadaCartesiana().setX(ferengi.getCoordenadaCartesiana().getX());
		betasoide.getCoordenadaCartesiana().setY(1936.49d);
		assertTrue(sistemaSolar.isTheBestPresionAndTemperatureConditions());
	}
	
	@Test
	public void SistemaSolarIsInTheBestPresionAndTemperatureSurCondition() {
		CuerpoCeleste ferengi = estrellas.get(SistemaSolarConstants.FERENGI_NAME);
		CuerpoCeleste vulcano = estrellas.get(SistemaSolarConstants.VULCANO_NAME);
		CuerpoCeleste betasoide = estrellas.get(SistemaSolarConstants.BETASOIDE_NAME);
		vulcano.getCoordenadaCartesiana().setX(ferengi.getCoordenadaCartesiana().getX());
		vulcano.getCoordenadaCartesiana().setY(-866.03d);
		betasoide.getCoordenadaCartesiana().setX(ferengi.getCoordenadaCartesiana().getX());
		betasoide.getCoordenadaCartesiana().setY(-1936.49d);
		assertTrue(sistemaSolar.isTheBestPresionAndTemperatureConditions());
	}
	
	@Test
	public void SistemaSolarRainingCondition() {
		CuerpoCeleste ferengi = estrellas.get(SistemaSolarConstants.FERENGI_NAME);
		CuerpoCeleste vulcano = estrellas.get(SistemaSolarConstants.VULCANO_NAME);
		CuerpoCeleste betasoide = estrellas.get(SistemaSolarConstants.BETASOIDE_NAME);
		vulcano.getCoordenadaCartesiana().setX(-vulcano.getCoordenadaCartesiana().getX());
		betasoide.getCoordenadaCartesiana().setY(betasoide.getCoordenadaCartesiana().getX());
		betasoide.getCoordenadaCartesiana().setX(0.00d);
		assertTrue(sistemaSolar.amountOfRain().equals(1500.00d + 2061.55d + 2236.07d));
	}
}
