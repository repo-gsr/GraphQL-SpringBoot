package com.graphql.service.impl;

import java.util.List;

import com.graphql.model.Customer;

public interface CustomerService {

	public List<Customer> getListOfCustomers();
	
	public Customer getCustomerById(String customerid);
	
	public Customer getCustomerByPhonenumber(String phonenumber);

	public Customer signUp(Customer customer);
	
	public Customer updateCustomerById(Customer customer, String customerID);

	public String deleteCustomerById(String customerId);

}
