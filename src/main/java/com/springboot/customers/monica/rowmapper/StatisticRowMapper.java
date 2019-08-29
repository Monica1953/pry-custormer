package com.springboot.customers.monica.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.springboot.customers.monica.model.Statistic;

public class StatisticRowMapper implements RowMapper<Statistic> {

	@Override
	public Statistic mapRow(ResultSet rs, int rowNum) throws SQLException {
		Statistic promedio = new Statistic();
		promedio.setPromedio(rs.getInt("promedio"));
		promedio.setDesviacionEstandar(rs.getInt("desviacion"));
		return promedio;
	}

}
