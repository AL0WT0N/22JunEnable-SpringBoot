package com.qa.main.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.main.domain.Customer;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Long> {
	
}
