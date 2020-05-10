package com.graphql.queryresolver;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.graphql.model.Customer;
import com.graphql.service.impl.CustomerServiceImpl;

@Component
public class CustomerQueryResolver implements GraphQLQueryResolver {

	@Autowired
	CustomerServiceImpl customerservice;

	public List<Customer> getAllCustomers() {
		return customerservice.getListOfCustomers();
	}

	public Customer getCustomerById(String customerid) {
		return customerservice.getCustomerById(customerid);
	}
	
	public Customer getCustomerByPhonenumber(String phonenumber) {
		return customerservice.getCustomerByPhonenumber(phonenumber);
	}

}
