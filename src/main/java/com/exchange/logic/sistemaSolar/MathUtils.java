package com.exchange.logic.sistemaSolar;

import java.math.BigDecimal;

import com.exchange.model.sistemaSolar.CoordenadaCartesiana;
import com.exchange.model.sistemaSolar.CoordenadaPolar;

public class MathUtils {
	/*
	 * Convierte coordenada polar a coordenada cartesiana.
	 * El angulo esta en grados.
	 */
	public static CoordenadaCartesiana convertFromCoordenadaPolarToCartesiana(CoordenadaPolar cp) {
		Double y = Math.sin(Math.toRadians(cp.getAnguloConEjeX())) * cp.getDistanciaAOrigen();
		Double x = Math.cos(Math.toRadians(cp.getAnguloConEjeX())) * cp.getDistanciaAOrigen();
		return new CoordenadaCartesiana(x, y, 0.00);
	}
	/*
	 * Convierte coordenada cartesiana a coordenada polar.
	 * El angulo esta en grados.
	 */	
	public static CoordenadaPolar convertFromCoordenadaCartesianaToPolar(CoordenadaCartesiana cc) {
		Double r = Math.sqrt((Math.pow(cc.getX(), 2)) + (Math.pow(cc.getY(), 2)));
		Double anguloConEjeX = Math.toDegrees(Math.acos(((new BigDecimal(cc.getX())).divide(new BigDecimal(r))).doubleValue()));
		if(isInThirdQuadrant(cc)) {
			anguloConEjeX += 90;
		} else if(isInFourthQuadrant(cc)) {
			anguloConEjeX += 180;
		}
		return new CoordenadaPolar(r, anguloConEjeX);
	}
	private static boolean isInThirdQuadrant(CoordenadaCartesiana cc) {
		return cc.getX()<0 && cc.getY()<0;
	}
	private static boolean isInFourthQuadrant(CoordenadaCartesiana cc) {
		return cc.getX()>=0 && cc.getY()<0; 
	}
	public static boolean trianguloTieneOrientacionHorario(CoordenadaCartesiana p1, CoordenadaCartesiana p2,
			CoordenadaCartesiana p3) {
		Double value = (p1.getX()-p3.getX())*(p2.getY()-p3.getY()) - (p1.getY()-p3.getY())*(p2.getX()-p3.getX());
		return value < 0;
	}
	public static Double calculatePerimeter(CoordenadaCartesiana p1, CoordenadaCartesiana p2, CoordenadaCartesiana p3) {
		Double d1 = Math.hypot(p1.getX()- p2.getX(), p1.getY()- p2.getY());
		Double d2 = Math.hypot(p2.getX()- p3.getX(), p2.getY()- p3.getY());
		Double d3 = Math.hypot(p3.getX()- p1.getX(), p3.getY()- p1.getY());
		return d1 + d2 + d3;
	}
}
