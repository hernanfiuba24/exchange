package com.exchange.logic.sistemaSolar;

import com.exchange.model.sistemaSolar.CoordenadaCartesiana;

public class Triangulo {
	private CoordenadaCartesiana p1;
	private CoordenadaCartesiana p2;
	private CoordenadaCartesiana p3;
	/*
	 * Se da de acuerdo al orden que se visitan sus vertices.
	 */
	private boolean hourHand;
	private Double perimeter;
	
	public Triangulo(CoordenadaCartesiana p1, CoordenadaCartesiana p2, CoordenadaCartesiana p3) {
		this.p1 = p1;
		this.p2 = p2;
		this.p3 = p3;
		setHourHand(MathUtils.trianguloTieneOrientacionHorario(p1,p2,p3));
		perimeter = MathUtils.calculatePerimeter(p1,p2,p3);
	}
	public CoordenadaCartesiana getP1() {
		return p1;
	}
	public void setP1(CoordenadaCartesiana p1) {
		this.p1 = p1;
	}
	public CoordenadaCartesiana getP2() {
		return p2;
	}
	public void setP2(CoordenadaCartesiana p2) {
		this.p2 = p2;
	}
	public CoordenadaCartesiana getP3() {
		return p3;
	}
	public void setP3(CoordenadaCartesiana p3) {
		this.p3 = p3;
	}
	public Double getPerimeter() {
		return perimeter;
	}
	public void setPerimeter(Double perimeter) {
		this.perimeter = perimeter;
	}
	public boolean isHourHand() {
		return hourHand;
	}
	public void setHourHand(boolean hourHand) {
		this.hourHand = hourHand;
	}
}
