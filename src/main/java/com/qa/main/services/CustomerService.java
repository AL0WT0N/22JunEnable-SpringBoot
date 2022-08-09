package com.qa.main.services;

import java.util.List;
import org.springframework.stereotype.Service;

import com.qa.main.domain.Customer;
import com.qa.main.repos.CustomerRepo;

@Service
public class CustomerService {
	
	private CustomerRepo repo;
	
	public CustomerService(CustomerRepo repo) {
		this.repo = repo;
	}
	
	public Customer create(Customer customer) {
		return repo.saveAndFlush(customer);
	}
	
	public List<Customer> getAll() {
		return repo.findAll();
	}
	
	public Customer getByID(long id) {
		return repo.findById(id).get();
	}
	
	public Customer update(long id, Customer customer) {
		// We get the existing entry
		Customer existing = repo.findById(id).get();
		
		// Update the existing entry, to match the incoming object
		existing.setFirstName(customer.getFirstName());
		existing.setLastName(customer.getLastName());
		existing.setAge(customer.getAge());
		
		// Save the updated entry back into the DB (ID is the same)
		return repo.saveAndFlush(existing);
		
	}
	
	public boolean delete(long id) {
		repo.deleteById(id);
		
		return !repo.existsById(id);
	}
	
}
