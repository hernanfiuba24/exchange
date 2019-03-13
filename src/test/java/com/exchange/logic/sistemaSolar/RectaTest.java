package com.exchange.logic.sistemaSolar;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.exchange.exeption.RectaCreateException;
import com.exchange.model.sistemaSolar.CoordenadaCartesiana;

public class RectaTest {

	@Test
	public void seCreaRectaConPendienteYPuntoDeInterseccionConEjeYCorrectamenteTest() {
		Recta r = new Recta(20.00d, 10.00d);
		assertNotNull(r);
	}
	@Test
	public void seCreaRectaConDosPuntosConPendienteInfinitaCorrectamenteTest() throws RectaCreateException {
		Recta r = new Recta(new CoordenadaCartesiana(0d, 0d, 0d), new CoordenadaCartesiana(0d, 2000d, 0d));
		assertTrue(r.getM().equals(Double.POSITIVE_INFINITY));
	}
	@Test
	public void seCreaRectaConDosPuntosConPendienteNulaCorrectamenteTest() throws RectaCreateException {
		Recta r = new Recta(new CoordenadaCartesiana(-1000d, 2000d, 0d), new CoordenadaCartesiana(0d, 2000d, 0d));
		assertTrue(r.getM().equals(0d));
		assertTrue(r.getB().equals(2000d));
	}
	@Test
	public void seCreaRectaConDosPuntosConPendienteNoNulaCorrectamenteTest() throws RectaCreateException {
		Recta r = new Recta(new CoordenadaCartesiana(1000d, 1000d, 0d), new CoordenadaCartesiana(2000d, 2000d, 0d));
		assertTrue(r.getM().equals(1d));
		assertTrue(r.getB().equals(0d));
	}
	@Test(expected=RectaCreateException.class)
	public void seCreaRectaConDosPuntosIgualesIncorrectamenteTest() throws RectaCreateException {
		Recta r = new Recta(new CoordenadaCartesiana(1000d, 1000d, 0d), new CoordenadaCartesiana(1000d, 1000d, 0d));
	}
	@Test(expected=RectaCreateException.class)
	public void seCreaRectaConDosPuntosCerosIncorrectamenteTest() throws RectaCreateException {
		Recta r = new Recta(new CoordenadaCartesiana(0d, 0d, 0d), new CoordenadaCartesiana(0d, 0d, 0d));
	}
	@Test
	public void rectaTienePendienteNula() {
		Recta r = new Recta(0.00d, 10.00d);
		assertTrue(r.hasPendienteNula());
	}
	@Test
	public void rectaNoTienePendienteNula() {
		Recta r = new Recta(10.00d, 10.00d);
		assertFalse(r.hasPendienteNula());
	}
	@Test
	public void rectaTienePendienteInfinitaPositiva() {
		Recta r = new Recta(Double.POSITIVE_INFINITY, 10.00d);
		assertTrue(r.hasPendienteInf());
	}
	@Test
	public void rectaTienePendienteInfinitaNegativa() {
		Recta r = new Recta(Double.NEGATIVE_INFINITY, 10.00d);
		assertTrue(r.hasPendienteInf());
	}
	@Test
	public void rectaNoTienePendienteInfinita() {
		Recta r = new Recta(100.00d, 10.00d);
		assertFalse(r.hasPendienteInf());
	}
	@Test
	public void puntoPerteneceARecta() {
		Recta r = new Recta(10.00d, 10.00d);
		CoordenadaCartesiana p1 = new CoordenadaCartesiana(1.00d, 20.00d, 0.00d);
		assertTrue(r.pointIsInRecta(p1));
	}
	@Test
	public void puntoNoPerteneceARecta() {
		Recta r = new Recta(10.00d, 10.00d);
		CoordenadaCartesiana p1 = new CoordenadaCartesiana(20.00d, 20.00d, 0.00d);
		assertFalse(r.pointIsInRecta(p1));
	}
}
