package com.greatlearning.javafsd.customerrelationship.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.greatlearning.javafsd.customerrelationship.entity.Customer;
import com.greatlearning.javafsd.customerrelationship.service.CustomerDetails;



@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private CustomerDetails customerDetails;

	@RequestMapping("/begin-add")
	public String handleBeginAdd(Model theModel) {

		Customer customer = new Customer();

		theModel.addAttribute("customer", customer);

		return "customer-details";
	}

	@RequestMapping("/begin-update")
	public String handleBeginUpdate(
			@RequestParam("customerId") int theId, 
			Model theModel) {

		Customer customer = customerDetails.findById(theId);
		theModel.addAttribute("customer", customer);
		return "customer-details";
	}

	@PostMapping("/save")
	public String handleSave(
		@RequestParam("id") int id, 
		@RequestParam("firstName") String firstName,
		@RequestParam("lastName") String lastName, 		
		@RequestParam("course") String email) {

		Customer customer;
		if (id != 0) {
			
			// Update Student
			customer = customerDetails.findById(id);
			customer.setFirstName(firstName);
			customer.setLastName(lastName);
			customer.setEmail(email);
	
		} else {
		
			// Add Student
			customer = new Customer(firstName, lastName, email);
		}	
		customerDetails.save(customer);
		return "redirect:/customers/list";

	}

	@RequestMapping("/delete")
	public String handleDelete(@RequestParam("customerId") int theId) {

		customerDetails.deleteById(theId);

		return "redirect:/customers/list";

	}


}
