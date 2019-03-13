package com.exchange.logic.sistemaSolar;

import java.math.BigDecimal;
import java.math.RoundingMode;

import com.exchange.exeption.RectaCreateException;
import com.exchange.model.sistemaSolar.CoordenadaCartesiana;

public class Recta {
	private Double m;
	private Double b;
	private Double axiX;
	
	public Recta(Double m, Double b) {
		this.m = m;
		this.b= b;
	}
	public Recta(CoordenadaCartesiana p1, CoordenadaCartesiana p2) throws RectaCreateException {
		CoordenadaCartesiana cero = new CoordenadaCartesiana(0d, 0d, 0d);
		if ((p1.equals(cero) && p2.equals(cero)) || p1.equals(p2)) {
			throw new RectaCreateException("Doesn't create a recta with that points");
		}
		
		if (p1.getX().equals(p2.getX())) {
			/*
			 * Pendiente infinita
			 */
			this.m = Double.POSITIVE_INFINITY;
			this.axiX = p1.getX();
		} else if (p1.getY().equals(p2.getY())) {
			/*
			 * pendiente nula
			 */
			this.m = 0d;
			this.b = p1.getY();
		} else {
			/*
			 * con pendiente
			 */
			this.m = new BigDecimal(p2.getY()-p1.getY()).divide(new BigDecimal(p2.getX() - p1.getX())).doubleValue();
			this.b = p1.getY() - this.m*p1.getX();
		}
	}
	public boolean pointIsInRecta(CoordenadaCartesiana p1) {
		if (!m.isInfinite()) {
			return p1.getY() == p1.getX()*m + b;
		} else {
			return p1.getX().equals(axiX);
		}
	}
	public boolean hasPendienteInf( ) {
		return m.isInfinite();
	}
	public boolean hasPendienteNula() {
		return new BigDecimal(m).setScale(2, RoundingMode.HALF_EVEN).equals(new BigDecimal(0.00d).setScale(2, RoundingMode.HALF_EVEN));
	}
	public Double getM() {
		return m;
	}
	public void setM(Double m) {
		this.m = m;
	}
	public Double getB() {
		return b;
	}
	public void setB(Double b) {
		this.b = b;
	}
	public Double getAxiX() {
		return axiX;
	}
	public void setAxiX(Double axiX) {
		this.axiX = axiX;
	}
}
