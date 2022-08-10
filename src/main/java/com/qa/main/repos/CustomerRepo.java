package com.qa.main.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.qa.main.domain.Customer;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Long> {
	
	// SELECT * FROM customer WHERE first_name = {firstName}
	List<Customer> findCustomerByFirstName(String firstName);
	
	@Query(value = "SELECT * FROM customer WHERE last_name = ?1", nativeQuery = true)
	List<Customer> getByLastName(String lastName);
	
}
