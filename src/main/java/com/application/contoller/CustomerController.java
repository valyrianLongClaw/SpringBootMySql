package com.application.contoller;

import java.util.List;

import javax.ws.rs.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.application.model.Customer;
import com.application.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@CrossOrigin
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public @ResponseBody List<Customer> getAllCustomers() {
		List<Customer> customers = customerService.getAllCustomers();
		System.out.println("cusotmers: " + customers);
		return customers;
	}
	
	@RequestMapping(value = "/id/{id}", method = RequestMethod.GET)
	public Customer getCustomer(@PathParam("id") Long id, @PathParam("timeZoneId") String timeZoneId) {
		Customer customer = customerService.getCustomerById(id);
		return customer;
	}

}
