package com.springboot.customers.monica.service;

import java.util.List;

import com.springboot.customers.monica.model.Customers;
import com.springboot.customers.monica.model.Statistic;

public interface CustomersService {
	
	List<Customers> obtenerCustomers();

	Integer guardarCustomers(Customers customers);
	
	Statistic obtenerStatistics();
}
