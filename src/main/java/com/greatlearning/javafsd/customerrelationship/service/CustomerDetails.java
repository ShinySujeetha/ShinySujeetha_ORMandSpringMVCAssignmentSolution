package com.greatlearning.javafsd.customerrelationship.service;

import java.util.List;

import com.greatlearning.javafsd.customerrelationship.entity.Customer;

public interface CustomerDetails {	
	
		List<Customer> listAll();

		Customer findById(int theId);

		void save(Customer thecustomer);

		void deleteById(int theId);


}
