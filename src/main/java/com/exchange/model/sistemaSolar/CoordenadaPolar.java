package com.exchange.model.sistemaSolar;

import org.apache.commons.lang.builder.ToStringBuilder;

public class CoordenadaPolar {
	private Double distanciaAOrigen;
	private Double anguloConEjeX;
	
	public CoordenadaPolar(Double distanciaAOrigen, Double anguloConEjeX) {
		this.distanciaAOrigen = distanciaAOrigen;
		this.anguloConEjeX = anguloConEjeX;
	}
	public Double getDistanciaAOrigen() {
		return distanciaAOrigen;
	}
	public void setDistanciaAOrigen(Double distanciaAOrigen) {
		this.distanciaAOrigen = distanciaAOrigen;
	}
	public Double getAnguloConEjeX() {
		return anguloConEjeX;
	}
	public void setAnguloConEjeX(Double anguloConEjeX) {
		this.anguloConEjeX = anguloConEjeX;
	}
	@Override
	public String toString() {
		return new ToStringBuilder(this).append("distanciaAOrigen", distanciaAOrigen).append("anguloConEjeX", anguloConEjeX).toString();
	}
	@Override
	public boolean equals(Object o) {
		boolean equals = true;
		if (o == null) {
			equals = false;
		}
		if (!(o instanceof CoordenadaPolar)) {
			equals = false;
		}
		CoordenadaPolar cp = (CoordenadaPolar) o;
		if (!(cp.getDistanciaAOrigen().equals(distanciaAOrigen) && cp.getAnguloConEjeX().equals(anguloConEjeX))) {
			equals = false;
		}
		return equals;
	}
}
