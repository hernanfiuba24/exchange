package com.exchange.logic.sistemaSolar;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.junit.Test;

import com.exchange.model.sistemaSolar.CoordenadaCartesiana;

public class TrianguloTest {
	@Test
	public void initTrianguloNull() {
		Triangulo t = null;
		assertNull(t);
	}
	@Test
	public void initTrianguloNotNull() {
		Triangulo t = new Triangulo(new CoordenadaCartesiana(0d, 0d, 0d), new CoordenadaCartesiana(100d, 0d, 0d), new CoordenadaCartesiana(50d, 50d, 0d));
		assertNotNull(t);
	}
	@Test
	public void initTrianguloWithRigthCoordenates() {
		Triangulo t = new Triangulo(new CoordenadaCartesiana(0d, 0d, 0d), new CoordenadaCartesiana(100d, 0d, 0d), new CoordenadaCartesiana(50d, 50d, 0d));
		assertTrue(t.getP1().equals(new CoordenadaCartesiana(0d,0d,0d)));
		assertTrue(t.getP2().equals(new CoordenadaCartesiana(100d,0d,0d)));
		assertTrue(t.getP3().equals(new CoordenadaCartesiana(50d,50d,0d)));
	}
	@Test
	public void trianguloWithHourHand() {
		Triangulo t = new Triangulo(new CoordenadaCartesiana(0d, 0d, 0d), new CoordenadaCartesiana(100d, 0d, 0d), new CoordenadaCartesiana(-50d, -50d, 0d));
		assertTrue(t.isHourHand());
	}
	@Test
	public void trianguloWithNotHourHand() {
		Triangulo t = new Triangulo(new CoordenadaCartesiana(0d, 0d, 0d), new CoordenadaCartesiana(100d, 0d, 0d), new CoordenadaCartesiana(50d, 50d, 0d));
		assertFalse(t.isHourHand());
	}
	@Test
	public void trianguloPerimeter() {
		Triangulo t = new Triangulo(new CoordenadaCartesiana(0d, 0d, 0d), new CoordenadaCartesiana(100d, 0d, 0d), new CoordenadaCartesiana(50d, 50d, 0d));
		assertTrue(new BigDecimal(t.getPerimeter()).setScale(2, RoundingMode.HALF_EVEN).equals(new BigDecimal(241.42d).setScale(2, RoundingMode.HALF_EVEN)));
	}
}
