package com.qa.main.exceptions;

import java.util.NoSuchElementException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.I_AM_A_TEAPOT, reason = "Customer not found with that ID")
public class CustomerNotFoundException extends NoSuchElementException {

	
	
}
