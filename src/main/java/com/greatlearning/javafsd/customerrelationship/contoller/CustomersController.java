package com.greatlearning.javafsd.customerrelationship.contoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.greatlearning.javafsd.customerrelationship.entity.Customer;
import com.greatlearning.javafsd.customerrelationship.service.CustomerDetails;

@Controller
@RequestMapping("/customers")
public class CustomersController {
	
	@Autowired
	private CustomerDetails customerDetails;

	@RequestMapping("/list")
	
	public String handleListStudents(Model theModel) {

		List<Customer> customers = customerDetails.listAll();

		theModel.addAttribute("customers", customers);

		return "customers-lister";
	}
	
	

}
