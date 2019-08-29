package com.springboot.customers.monica.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.springboot.customers.monica.model.Customers;

public class CustomersRowMapper implements RowMapper<Customers> {

	@Override
	public Customers mapRow(ResultSet rs, int rowNum) throws SQLException {
		Customers customers = new Customers();
		customers.setId(rs.getInt("id"));
		customers.setNombres(rs.getString("nombres"));
		customers.setApellidos(rs.getString("apellidos"));
		customers.setFechaNacimiento(rs.getString("fechaNacimiento"));
		customers.setEdad(rs.getInt("edad"));
		return customers;
	}

}
