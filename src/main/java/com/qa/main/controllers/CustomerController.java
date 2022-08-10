package com.qa.main.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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
@CrossOrigin
@RequestMapping("/customer")
public class CustomerController {
	
	private CustomerService service;
	
	public CustomerController(CustomerService service) {
		this.service = service;
	}
	
	// POST REQUESTS - CREATE
	@PostMapping("/create")
	public ResponseEntity<Customer> create(@RequestBody Customer customer) {
		return new ResponseEntity<Customer>(service.create(customer), HttpStatus.CREATED);
	}
	
	// GET REQUESTS - READ
	@GetMapping("/getAll")
	public ResponseEntity<List<Customer>> getAll() {
		return new ResponseEntity<List<Customer>>(service.getAll(), HttpStatus.OK);
	}
	
	@GetMapping("/getByID/{id}")
	public Customer getByID(@PathVariable long id) {
		return service.getByID(id);
	}
	
	@GetMapping("/getByFirstName/{firstName}")
	public ResponseEntity<List<Customer>> getByFirstName(@PathVariable String firstName) {
		return new ResponseEntity<List<Customer>>(service.getByFirstName(firstName), HttpStatus.OK);
	}
	
	@GetMapping("/getByLastName/{lastName}")
	public ResponseEntity<List<Customer>> getByLastName(@PathVariable String lastName) {
		return new ResponseEntity<List<Customer>>(service.getByLastName(lastName), HttpStatus.OK);
	}
	
	// PUT REQUESTS - UPDATE
	@PutMapping("/update/{id}")
	public Customer update(@PathVariable long id, @RequestBody Customer customer) {
		return service.update(id, customer);
	}
	
	// DELETE REQUESTS - DELETE
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Boolean> delete(@PathVariable long id) {
		return new ResponseEntity<Boolean>(service.delete(id), HttpStatus.NO_CONTENT);
	}

}
