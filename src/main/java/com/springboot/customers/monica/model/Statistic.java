package com.springboot.customers.monica.model;

public class Statistic {
	private Integer promedio;
	private Integer desviacionEstandar;

	public Statistic() {
		super();
	}

	public Statistic(Integer promedio, Integer desviacionEstandar) {
		super();
		this.promedio = promedio;
		this.desviacionEstandar = desviacionEstandar;
	}

	public Integer getPromedio() {
		return promedio;
	}

	public void setPromedio(Integer promedio) {
		this.promedio = promedio;
	}

	public Integer getDesviacionEstandar() {
		return desviacionEstandar;
	}

	public void setDesviacionEstandar(Integer desviacionEstandar) {
		this.desviacionEstandar = desviacionEstandar;
	}

	@Override
	public String toString() {
		return "Statistic [promedio=" + promedio + ", desviacionEstandar=" + desviacionEstandar + "]";
	}

}
