package com.exchange.logic.sistemaSolar;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.junit.Test;

import com.exchange.model.sistemaSolar.CoordenadaCartesiana;
import com.exchange.model.sistemaSolar.CoordenadaPolar;

import junit.framework.Assert;

@SuppressWarnings("deprecation")
public class MathUtilsTest {
	
	/*
	 * Se realiza la conversion de Coordenada Polar a Cartesiana con 2 decimales.
	 */
	@Test
	public void converCoodenadaPolarToCoordenadaCartesianaCorrect() {
		CoordenadaPolar cp = new CoordenadaPolar(2000.00d, 3.00d);
		CoordenadaCartesiana cc = MathUtils.convertFromCoordenadaPolarToCartesiana(cp);
		Assert.assertEquals((new BigDecimal(cc.getX())).setScale(2, RoundingMode.HALF_EVEN).doubleValue(), Double.valueOf("1997.26"));
		Assert.assertEquals((new BigDecimal(cc.getY())).setScale(2, RoundingMode.HALF_EVEN).doubleValue(), Double.valueOf("104.67"));
	}
	@Test
	public void converCoodenadaPolarToCoordenadaCartesiana0GradosCorrect() {
		CoordenadaPolar cp = new CoordenadaPolar(2000.00d, 0.00d);
		CoordenadaCartesiana cc = MathUtils.convertFromCoordenadaPolarToCartesiana(cp);
		Assert.assertEquals((new BigDecimal(cc.getX())).setScale(2, RoundingMode.HALF_EVEN).doubleValue(), Double.valueOf("2000.00"));
		Assert.assertEquals((new BigDecimal(cc.getY())).setScale(2, RoundingMode.HALF_EVEN).doubleValue(), Double.valueOf("0.00"));
	}
	@Test
	public void converCoodenadaPolarToCoordenadaCartesiana90GradosCorrect() {
		CoordenadaPolar cp = new CoordenadaPolar(2000.00d, 90.00d);
		CoordenadaCartesiana cc = MathUtils.convertFromCoordenadaPolarToCartesiana(cp);
		Assert.assertEquals((new BigDecimal(cc.getX())).setScale(2, RoundingMode.HALF_EVEN).doubleValue(), Double.valueOf("0.00"));
		Assert.assertEquals((new BigDecimal(cc.getY())).setScale(2, RoundingMode.HALF_EVEN).doubleValue(), Double.valueOf("2000.00"));
	}
	@Test
	public void converCoodenadaPolarToCoordenadaCartesiana180GradosCorrect() {
		CoordenadaPolar cp = new CoordenadaPolar(2000.00d, 180.00d);
		CoordenadaCartesiana cc = MathUtils.convertFromCoordenadaPolarToCartesiana(cp);
		Assert.assertEquals((new BigDecimal(cc.getX())).setScale(2, RoundingMode.HALF_EVEN).doubleValue(), Double.valueOf("-2000.00"));
		Assert.assertEquals((new BigDecimal(cc.getY())).setScale(2, RoundingMode.HALF_EVEN).doubleValue(), Double.valueOf("0.00"));
	}
	@Test
	public void converCoodenadaPolarToCoordenadaCartesiana270GradosCorrect() {
		CoordenadaPolar cp = new CoordenadaPolar(2000.00d, 270.00d);
		CoordenadaCartesiana cc = MathUtils.convertFromCoordenadaPolarToCartesiana(cp);
		Assert.assertEquals((new BigDecimal(cc.getX())).setScale(2, RoundingMode.HALF_EVEN).doubleValue(), Double.valueOf("0.00"));
		Assert.assertEquals((new BigDecimal(cc.getY())).setScale(2, RoundingMode.HALF_EVEN).doubleValue(), Double.valueOf("-2000.00"));
	}
	@Test
	public void converCoodenadaPolarToCoordenadaCartesiana360GradosCorrect() {
		CoordenadaPolar cp = new CoordenadaPolar(2000.00d, 360.00d);
		CoordenadaCartesiana cc = MathUtils.convertFromCoordenadaPolarToCartesiana(cp);
		Assert.assertEquals((new BigDecimal(cc.getX())).setScale(2, RoundingMode.HALF_EVEN).doubleValue(), Double.valueOf("2000.00"));
		Assert.assertEquals((new BigDecimal(cc.getY())).setScale(2, RoundingMode.HALF_EVEN).doubleValue(), Double.valueOf("0.00"));
	}
	/*
	 * Se realiza conversion de Coordenada Cartesiana a Polar con 2 decimales
	 */
	@Test
	public void converCoodenadaCartesianaToPolar0GradosCorrect() {
		CoordenadaCartesiana cc = new CoordenadaCartesiana(2000.00d, 0.00d, 0.00d);
		CoordenadaPolar cp = MathUtils.convertFromCoordenadaCartesianaToPolar(cc);
		Assert.assertEquals((new BigDecimal(cp.getDistanciaAOrigen())).setScale(2, RoundingMode.HALF_EVEN).doubleValue(), 2000.00d);
		Assert.assertEquals((new BigDecimal(cp.getAnguloConEjeX())).setScale(2, RoundingMode.HALF_EVEN).doubleValue(), 0.00d);
	}
	@Test
	public void converCoodenadaCartesianaToPolar90GradosCorrect() {
		CoordenadaCartesiana cc = new CoordenadaCartesiana(0.00d, 2000.00d, 0.00d);
		CoordenadaPolar cp = MathUtils.convertFromCoordenadaCartesianaToPolar(cc);
		Assert.assertEquals((new BigDecimal(cp.getDistanciaAOrigen())).setScale(2, RoundingMode.HALF_EVEN).doubleValue(), 2000.00d);
		Assert.assertEquals((new BigDecimal(cp.getAnguloConEjeX())).setScale(2, RoundingMode.HALF_EVEN).doubleValue(), 90.00d);
	}
	@Test
	public void converCoodenadaCartesianaToPolar180GradosCorrect() {
		CoordenadaCartesiana cc = new CoordenadaCartesiana(-2000.00d, 0.00d, 0.00d);
		CoordenadaPolar cp = MathUtils.convertFromCoordenadaCartesianaToPolar(cc);
		Assert.assertEquals((new BigDecimal(cp.getDistanciaAOrigen())).setScale(2, RoundingMode.HALF_EVEN).doubleValue(), 2000.00d);
		Assert.assertEquals((new BigDecimal(cp.getAnguloConEjeX())).setScale(2, RoundingMode.HALF_EVEN).doubleValue(), 180.00d);
	}
	@Test
	public void converCoodenadaCartesianaToPolar270GradosCorrect() {
		CoordenadaCartesiana cc = new CoordenadaCartesiana(0.00d, -2000.00d, 0.00d);
		CoordenadaPolar cp = MathUtils.convertFromCoordenadaCartesianaToPolar(cc);
		Assert.assertEquals((new BigDecimal(cp.getDistanciaAOrigen())).setScale(2, RoundingMode.HALF_EVEN).doubleValue(), 2000.00d);
		Assert.assertEquals((new BigDecimal(cp.getAnguloConEjeX())).setScale(2, RoundingMode.HALF_EVEN).doubleValue(), 270.00);
	}
}
