package com.springboot.customers.monica.dao;

import java.util.List;

import com.springboot.customers.monica.model.Customers;
import com.springboot.customers.monica.model.Statistic;

public interface CustomersDao {

	List<Customers> getAllCustomers();
	Integer saveCustomers(Customers customers);
	Statistic getStatistics();
}
