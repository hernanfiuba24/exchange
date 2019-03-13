package com.exchange.model.sistemaSolar;

import org.apache.commons.lang.builder.ToStringBuilder;

public class CuerpoCeleste {
	private String name;
	private final Double distanciaAOrigen;
	private final Double velocidad;
	private CoordenadaPolar coordenadaPolar;
	private CoordenadaCartesiana coordenadaCartesiana;
	
	public CuerpoCeleste(String name, Double distanciaAOrigen, Double velocidad) {
		/*
		 *  Al crear las estrellas se esta en el día 0
		 */
		this.name = name;
		this.distanciaAOrigen = distanciaAOrigen;
		this.velocidad = velocidad;
		this.coordenadaPolar = new CoordenadaPolar(this.distanciaAOrigen, 0d);
		this.coordenadaCartesiana = new CoordenadaCartesiana(this.distanciaAOrigen, 0d, 0d);
	}
	
	public CoordenadaPolar getCoordenadaPolar() {
		return coordenadaPolar;
	}
	public void setCoordenadaPolar(CoordenadaPolar coordenadaPolar) {
		this.coordenadaPolar = coordenadaPolar;
	}
	public CoordenadaCartesiana getCoordenadaCartesiana() {
		return coordenadaCartesiana;
	}
	public void setCoordenadaCartesiana(CoordenadaCartesiana coordenadaCartesiana) {
		this.coordenadaCartesiana = coordenadaCartesiana;
	}
	public Double getDistanciaAOrigen() {
		return distanciaAOrigen;
	}
	public Double getVelocidad() {
		return velocidad;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("coordenadaPolar", coordenadaPolar).append("coordenadaCartesiana", coordenadaCartesiana).toString();
	}

	public void move(int deltaDay) {
		Double anguloConElEjeXNuevo = this.coordenadaPolar.getAnguloConEjeX()+this.velocidad*deltaDay;
		Double xNuevo = Math.cos(Math.toRadians(anguloConElEjeXNuevo))*this.coordenadaPolar.getDistanciaAOrigen();
		Double yNuevo = Math.sin(Math.toRadians(anguloConElEjeXNuevo))*this.coordenadaPolar.getDistanciaAOrigen();
		this.coordenadaCartesiana.setX(xNuevo);
		this.coordenadaCartesiana.setY(yNuevo);
		this.coordenadaPolar.setAnguloConEjeX(anguloConElEjeXNuevo);
	}
}
