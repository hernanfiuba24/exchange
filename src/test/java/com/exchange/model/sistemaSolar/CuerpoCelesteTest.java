package com.exchange.model.sistemaSolar;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.junit.Test;

import com.exchange.config.SistemaSolarConstants;

public class CuerpoCelesteTest {
	
	@Test
	public void crearEstrellaFormaCorrectaTest() {
		CuerpoCeleste sol = new CuerpoCeleste(SistemaSolarConstants.SOL_NAME, SistemaSolarConstants.SOL_DISTANCE_TO_ORIGIN, SistemaSolarConstants.SOL_SPEED_ANGULAR);
		assertNotNull(sol);
	}
	@Test
	public void EstrellaEstaEnCoodenadaCartesianaInicialTest() {
		CuerpoCeleste betasoide = new CuerpoCeleste(SistemaSolarConstants.BETASOIDE_NAME, SistemaSolarConstants.BETASOIDE_DISTANCE_TO_ORIGIN, SistemaSolarConstants.BETASOIDE_SPEED_ANGULAR);
		assertTrue(betasoide.getCoordenadaCartesiana().equals(new CoordenadaCartesiana(SistemaSolarConstants.BETASOIDE_DISTANCE_TO_ORIGIN, 0d, 0d)));
	}
	@Test
	public void EstrellaEstaEnCoodenadaPolarInicialTest() {
		CuerpoCeleste betasoide = new CuerpoCeleste(SistemaSolarConstants.BETASOIDE_NAME, SistemaSolarConstants.BETASOIDE_DISTANCE_TO_ORIGIN, SistemaSolarConstants.BETASOIDE_SPEED_ANGULAR);
		assertTrue(betasoide.getCoordenadaPolar().equals(new CoordenadaPolar(SistemaSolarConstants.BETASOIDE_DISTANCE_TO_ORIGIN, 0d)));
	}
	@Test
	public void EstrellaEstaEnCoordenadaCartesianaInicialYSeMueveUnDiaTest() {
		CuerpoCeleste betasoide = new CuerpoCeleste(SistemaSolarConstants.BETASOIDE_NAME, SistemaSolarConstants.BETASOIDE_DISTANCE_TO_ORIGIN, SistemaSolarConstants.BETASOIDE_SPEED_ANGULAR);
		betasoide.move(1);
		betasoide.getCoordenadaCartesiana().setX((new BigDecimal(betasoide.getCoordenadaCartesiana().getX())).setScale(2, RoundingMode.HALF_EVEN).doubleValue());
		betasoide.getCoordenadaCartesiana().setY((new BigDecimal(betasoide.getCoordenadaCartesiana().getY())).setScale(2, RoundingMode.HALF_EVEN).doubleValue());
		assertTrue(betasoide.getCoordenadaCartesiana().equals(new CoordenadaCartesiana(1997.26d, 104.67d, 0d)));
	}
	@Test
	public void EstrellaEstaEnCoordenadaPolarInicialYSeMueveUnDiaTest() {
		CuerpoCeleste betasoide = new CuerpoCeleste(SistemaSolarConstants.BETASOIDE_NAME, SistemaSolarConstants.BETASOIDE_DISTANCE_TO_ORIGIN, SistemaSolarConstants.BETASOIDE_SPEED_ANGULAR);
		betasoide.move(1);
		betasoide.getCoordenadaPolar().setAnguloConEjeX((new BigDecimal(betasoide.getCoordenadaPolar().getAnguloConEjeX())).setScale(2, RoundingMode.HALF_EVEN).doubleValue());
		assertTrue(betasoide.getCoordenadaPolar().equals(new CoordenadaPolar(2000d, 3d)));
	}
	@Test
	public void EstrellaEstaEnCoordenadaCartesianaInicialYSeMueveCienDiaTest() {
		CuerpoCeleste betasoide = new CuerpoCeleste(SistemaSolarConstants.BETASOIDE_NAME, SistemaSolarConstants.BETASOIDE_DISTANCE_TO_ORIGIN, SistemaSolarConstants.BETASOIDE_SPEED_ANGULAR);
		betasoide.move(100);
		betasoide.getCoordenadaCartesiana().setX((new BigDecimal(betasoide.getCoordenadaCartesiana().getX())).setScale(2, RoundingMode.HALF_EVEN).doubleValue());
		betasoide.getCoordenadaCartesiana().setY((new BigDecimal(betasoide.getCoordenadaCartesiana().getY())).setScale(2, RoundingMode.HALF_EVEN).doubleValue());
		assertTrue(betasoide.getCoordenadaCartesiana().equals(new CoordenadaCartesiana(1000.0d, -1732.05d, 0d)));
	}
	@Test
	public void EstrellaEstaEnCoordenadaPolarInicialYSeMueveCienDiaTest() {
		CuerpoCeleste betasoide = new CuerpoCeleste(SistemaSolarConstants.BETASOIDE_NAME, SistemaSolarConstants.BETASOIDE_DISTANCE_TO_ORIGIN, SistemaSolarConstants.BETASOIDE_SPEED_ANGULAR);
		betasoide.move(100);
		betasoide.getCoordenadaPolar().setAnguloConEjeX((new BigDecimal(betasoide.getCoordenadaPolar().getAnguloConEjeX())).setScale(2, RoundingMode.HALF_EVEN).doubleValue());
		assertTrue(betasoide.getCoordenadaPolar().equals(new CoordenadaPolar(2000d, 300d)));
	}
}
