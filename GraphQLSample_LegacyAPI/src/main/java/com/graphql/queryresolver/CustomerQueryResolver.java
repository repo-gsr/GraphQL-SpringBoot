package com.graphql.queryresolver;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.graphql.model.Customer;
import com.graphql.service.impl.LegacyRestCalls;

@Component
public class CustomerQueryResolver implements GraphQLQueryResolver {

	@Autowired
	LegacyRestCalls legacycalls;

	public List<Customer> getAllCustomers() {
		return legacycalls.getListOfCustomers();
	}

	public Customer getCustomerById(String customerid) {
		return legacycalls.getCustomerById(customerid);
	}

	public Customer getCustomerByPhonenumber(String phonenumber) {
		return legacycalls.getCustomerByPhonenumber(phonenumber);
	}

}
