package com.qa.main.services;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.qa.main.domain.Customer;
import com.qa.main.repos.CustomerRepo;

@SpringBootTest
public class CustomerServiceUnitTest {
	
	@Autowired
	private CustomerService service;
	
	@MockBean
	private CustomerRepo repo;
	
	@Test
	public void testCreate() {
		// Create and object for saving
		Customer entry = new Customer("A", "L", 30);
		
		// Create an object for the result
		Customer result = new Customer(10L, "A", "L", 30);
		
		Mockito.when(repo.saveAndFlush(entry)).thenReturn(result);
		
		assertEquals(result, service.create(entry));
	}
	
	@Test
	public void testGetAll() {
		// Create and object for saving
		List<Customer> result = new ArrayList<>();
		result.add(new Customer(1L, "Anoush", "Lowton", 29));

		Mockito.when(repo.findAll()).thenReturn(result);
		
		assertEquals(result, service.getAll());
	}
	
}
