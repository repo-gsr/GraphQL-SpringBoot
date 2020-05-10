package com.graphql.mutationresolver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.graphql.model.Customer;
import com.graphql.model.CustomerInput;
import com.graphql.service.impl.LegacyRestCalls;

@Component
public class CustomerMutationResolver implements GraphQLMutationResolver {

	@Autowired
	LegacyRestCalls legacyRestCalls;

	public Customer signUp(CustomerInput customerinput) {
		return legacyRestCalls
				.signUp(new Customer(customerinput.getFname(), customerinput.getLname(), customerinput.getGmail(),
						customerinput.getPhonenumber(), customerinput.getAddress(), customerinput.getSignupDate()));
	}

	public Customer updateCustomerById(CustomerInput customerinput, String customerid) {
		return legacyRestCalls.updateCustomerById(
				new Customer(customerinput.getFname(), customerinput.getLname(), customerinput.getGmail(),
						customerinput.getPhonenumber(), customerinput.getAddress(), customerinput.getSignupDate()),
				customerid);
	}

	public String deleteCustomerById(String customerid) {
		return legacyRestCalls.deleteCustomerById(customerid);
	}
}
