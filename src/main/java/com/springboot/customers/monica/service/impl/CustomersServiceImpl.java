package com.springboot.customers.monica.service.impl;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.customers.monica.dao.CustomersDao;
import com.springboot.customers.monica.model.Customers;
import com.springboot.customers.monica.model.Statistic;
import com.springboot.customers.monica.service.CustomersService;

@Service
public class CustomersServiceImpl implements CustomersService {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private CustomersDao customersDao;

	@Override
	public List<Customers> obtenerCustomers() {
		logger.info("obteniendo la lista de customers by monica baldeon baldeon");
		return customersDao.getAllCustomers();
	}

	@Override
	public Integer guardarCustomers(Customers customers) {
		logger.info("guardando la lista de customers by monica baldeon baldeon");
		//calcular la edad apartir de la fecha de nacimiento
		
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate fechaNac = LocalDate.parse(customers.getFechaNacimiento(), fmt);
		LocalDate ahora = LocalDate.now();

		Period periodo = Period.between(fechaNac, ahora);
		logger.info("La edad calculada es: "+periodo.getYears());
		
		customers.setEdad(periodo.getYears());
		
		return customersDao.saveCustomers(customers);
	}

	@Override
	public Statistic obtenerStatistics() {
		logger.debug("obteniendo la lista de statistics by monica baldeon baldeon");
		return customersDao.getStatistics();
	}

}
