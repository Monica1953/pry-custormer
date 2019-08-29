package com.springboot.customers.monica.dao.impl;

import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.springboot.customers.monica.dao.CustomersDao;
import com.springboot.customers.monica.model.Customers;
import com.springboot.customers.monica.model.Statistic;
import com.springboot.customers.monica.rowmapper.CustomersRowMapper;
import com.springboot.customers.monica.rowmapper.StatisticRowMapper;

@Repository
public class CustomersDaoImpl extends JdbcDaoSupport implements CustomersDao {

	public CustomersDaoImpl(DataSource dataSource) {
		this.setDataSource(dataSource);
	}

	@Override
	public List<Customers> getAllCustomers() {
		List<Customers> lstCustomers = new ArrayList<Customers>();
		String sql = " SELECT id, nombres, apellidos, fechaNacimiento,edad\n" + " FROM inretail.customers";
		try {
			RowMapper<Customers> customersRow = new CustomersRowMapper();
			lstCustomers = getJdbcTemplate().query(sql, customersRow);
			logger.debug("Se han listado " + lstCustomers.size() + " customers");
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return lstCustomers;
	}

	@Override
	public Integer saveCustomers(Customers customers) {
		
		String sql = "insert into inretail.customers (nombres, apellidos, fechaNacimiento,edad) "  
				+ "values (?, ?, ?, ?);";
		
		Object[] params = {customers.getNombres(),customers.getApellidos(),customers.getFechaNacimiento(),customers.getEdad()};
		
		int[] tipos = { Types.VARCHAR, Types.VARCHAR, Types.VARCHAR,Types.INTEGER};
		int filas = 0;
		try {
			
			filas = getJdbcTemplate().update(sql, params,tipos);
			
			logger.debug("Se han insertado : "+filas+" filas");
			logger.debug("Se ha registrado a la persona "+customers.toString());
			
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		
		return filas;
	}

	@Override
	public Statistic getStatistics() {
		List<Statistic> lstStatistic=new ArrayList<Statistic>();
		String sql = " SELECT avg(edad) as promedio,STDDEV_POP(edad) as desviacion\n" + " FROM inretail.customers";
		try {
			RowMapper<Statistic> customersRow = new StatisticRowMapper();
			lstStatistic = getJdbcTemplate().query(sql, customersRow);
			logger.debug("obteniendo promedios " + lstStatistic.get(0).toString()+ " customers");
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return lstStatistic.get(0);
	}

}
