package com.exchange.model.sistemaSolar;

import org.apache.commons.lang.builder.ToStringBuilder;

import lombok.EqualsAndHashCode;

public class CoordenadaCartesiana {
	private Double x;
	private Double y;
	private Double z;
	
	public CoordenadaCartesiana(Double x, Double y, Double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	public Double getX() {
		return x;
	}
	public void setX(Double x) {
		this.x = x;
	}
	public Double getY() {
		return y;
	}
	public void setY(Double y) {
		this.y = y;
	}
	public Double getZ() {
		return z;
	}
	public void setZ(Double z) {
		this.z = z;
	}
	@Override
	public String toString() {
		return new ToStringBuilder(this).append("x", x).append("y", y).append("z", z).toString();
	}
	@Override
	public boolean equals(Object o) {
		boolean equals = true;
		if (o == null) {
			equals = false;
		}
		if (!(o instanceof CoordenadaCartesiana)) {
			equals = false;
		}
		CoordenadaCartesiana cc = (CoordenadaCartesiana) o;
		if (!(cc.getX().equals(x) && cc.getY().equals(y) && cc.getZ().equals(z))) {
			equals = false;
		}
		return equals;
	}
}
