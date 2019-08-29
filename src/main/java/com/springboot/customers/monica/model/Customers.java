package com.springboot.customers.monica.model;

public class Customers {

	private Integer id;
	private String nombres;
	private String apellidos;
	private Integer edad;
	private String fechaNacimiento;

	public Customers() {
		super();
	}

	public Customers(Integer id, String nombres, String apellidos, Integer edad, String fechaNacimiento) {
		super();
		this.id = id;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.edad = edad;
		this.fechaNacimiento = fechaNacimiento;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	@Override
	public String toString() {
		return "Customers [id=" + id + ", nombres=" + nombres + ", apellidos=" + apellidos + ", edad=" + edad
				+ ", fechaNacimiento=" + fechaNacimiento + "]";
	}

}
