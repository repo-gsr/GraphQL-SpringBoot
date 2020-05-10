package com.customer.service;

import java.util.List;

import com.customer.model.Customer;

public interface CustomerService {
	public Customer signUp(Customer customer);

	public List<Customer> getListOfCustomers();
	
	public Customer getCustomerById(String customerID);
	
	public Customer getCustomerByPhonenumber(String phonenumber);

	public Customer updateCustomerById(Customer customer, String customerID);

	public String deleteCustomerById(String customerId);

}
