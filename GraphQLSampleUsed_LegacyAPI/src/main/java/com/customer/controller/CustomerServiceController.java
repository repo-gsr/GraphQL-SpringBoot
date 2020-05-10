package com.customer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.customer.model.Customer;
import com.customer.service.impl.CustomerServiceImpl;
import com.customer.util.AbstractMapper;

import io.swagger.annotations.Api;

@RestController
@Api("CustomerService Controller")
@RequestMapping(value = "/customer")
public class CustomerServiceController extends AbstractMapper {

	@Autowired
	CustomerServiceImpl customerService;

	@PostMapping("/signup")
	public Customer signupCustomer(@RequestBody Customer customer) {
		return customerService.signUp(customer);
	}

	@GetMapping("/getAllCustomers")
	public List<Customer> getAllCustomers() {
		return customerService.getListOfCustomers();
	}
	
	@GetMapping("/getCustomerById/{Id}")
	public Customer getAllCustomers(@PathVariable(value = "Id", required = true) String Id) {
		return customerService.getCustomerById(Id);
	}
	
	@GetMapping("/getCustomerByPhonenumber/{phonenumber}")
	public Customer getCustomerByPhonenumber(@PathVariable(value = "phonenumber", required = true) String phonenumber) {
		return customerService.getCustomerByPhonenumber(phonenumber);
	}
	

	@PutMapping("/updateCustomerById/{Id}")
	public Customer updateCustomerById(@RequestBody Customer customer,
			@PathVariable(value = "Id", required = false) String Id) {
		return customerService.updateCustomerById(customer, Id);
	}

	@DeleteMapping("/deleteCustomerById/{Id}")
	public String deleteCustomerById(@PathVariable(value = "Id", required = true) String Id) {
		return customerService.deleteCustomerById(Id);
	}
}
