package com.springboot.customers.monica.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.customers.monica.model.Customers;
import com.springboot.customers.monica.model.Respuesta;
import com.springboot.customers.monica.model.Statistic;
import com.springboot.customers.monica.service.CustomersService;

@RestController
@RequestMapping("/customers")
public class CustomersController {

	@Autowired
	private CustomersService customersService;

	@GetMapping(value = "/", produces = "application/json")
	public List<Customers> getAllPersonas() {
		return customersService.obtenerCustomers();
	}
	
	@GetMapping(value = "/statistics", produces = "application/json")
	public Statistic getStatistics() {
		
		
		return customersService.obtenerStatistics();
	}
	
	@PostMapping(value = "/", produces = "application/json")	
	public Respuesta savePersona(@RequestBody Customers customer){
		
		Respuesta respuesta=new Respuesta();
		if(customersService.guardarCustomers(customer)==1) {
			respuesta.setCodigo(1);
			respuesta.setDescripcion("Exito");
		}else {
			respuesta.setCodigo(0);
			respuesta.setDescripcion("Error");
		}
		
		return respuesta;
	}	
}
