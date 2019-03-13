package com.exchange.logic.sistemaSolar;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.exchange.config.SistemaSolarConstants;
import com.exchange.model.sistemaSolar.CuerpoCeleste;

public class PlanetUtilsTest {
	
	@Before
	public void init() {
		
	}
	
	@Test
	public void ThreePlanetsAreAlign() {
		CuerpoCeleste p1 = new CuerpoCeleste(SistemaSolarConstants.SOL_NAME, SistemaSolarConstants.SOL_DISTANCE_TO_ORIGIN, SistemaSolarConstants.SOL_SPEED_ANGULAR);
		CuerpoCeleste p2 = new CuerpoCeleste(SistemaSolarConstants.BETASOIDE_NAME, SistemaSolarConstants.BETASOIDE_DISTANCE_TO_ORIGIN, SistemaSolarConstants.BETASOIDE_SPEED_ANGULAR);
		CuerpoCeleste p3 = new CuerpoCeleste(SistemaSolarConstants.VULCANO_NAME, SistemaSolarConstants.VULCANO_DISTANCE_TO_ORIGIN, SistemaSolarConstants.VULCANO_SPEED_ANGULAR);
		List<CuerpoCeleste> planets = new ArrayList<>();
		planets.add(p1);
		planets.add(p2);
		planets.add(p3);
		assertTrue(PlanetUtils.arePlanetsAlign(planets));
	}
	@Test
	public void ThreePlanetsAreNotAlign() {
		CuerpoCeleste p1 = new CuerpoCeleste(SistemaSolarConstants.SOL_NAME, SistemaSolarConstants.SOL_DISTANCE_TO_ORIGIN, SistemaSolarConstants.SOL_SPEED_ANGULAR);
		CuerpoCeleste p2 = new CuerpoCeleste(SistemaSolarConstants.BETASOIDE_NAME, SistemaSolarConstants.BETASOIDE_DISTANCE_TO_ORIGIN, SistemaSolarConstants.BETASOIDE_SPEED_ANGULAR);
		CuerpoCeleste p3 = new CuerpoCeleste(SistemaSolarConstants.VULCANO_NAME, SistemaSolarConstants.VULCANO_DISTANCE_TO_ORIGIN, SistemaSolarConstants.VULCANO_SPEED_ANGULAR);
		List<CuerpoCeleste> planets = new ArrayList<>();
		planets.add(p1);
		planets.add(p2);
		planets.add(p3);
		p3.move(1);
		assertFalse(PlanetUtils.arePlanetsAlign(planets));
	}
}
