package com.qa.main.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.qa.main.domain.Customer;
import com.qa.main.services.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	
	private CustomerService service;
	
	public CustomerController(CustomerService service) {
		this.service = service;
	}
	
	// POST REQUESTS - CREATE
	@PostMapping("/create")
	public Customer create(@RequestBody Customer customer) {
		return service.create(customer);
	}
	
	// GET REQUESTS - READ
	@GetMapping("/getAll")
	public List<Customer> getAll() {
		return this.service.getAll();
	}
	
	@GetMapping("/getByID/{id}")
	public Customer getByID(@PathVariable long id) {
		return this.service.getByID(id);
	}
	
	// PUT REQUESTS - UPDATE
	@PutMapping("/update/{id}")
	public Customer update(@PathVariable long id, @RequestBody Customer customer) {
		return this.service.update(id, customer);
	}
	
	// DELETE REQUESTS - DELETE
	@DeleteMapping("/delete/{id}")
	public boolean delete(@PathVariable long id) {
		return this.service.delete(id);
	}

}
