package com.graphql.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.graphql.model.Customer;

@Component
public class LegacyRestCalls {

	private String restUrl = "http://localhost:8081/customer/";

	@Autowired
	RestTemplate resttemplate;

	public List<Customer> getListOfCustomers() {

		return resttemplate.exchange(restUrl + "getAllCustomers", HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Customer>>() {
				}).getBody();
	}

	public Customer getCustomerById(String customerid) {
		Map<String, String> vars = new HashMap<>();
		vars.put("Id", customerid);
		return resttemplate.getForEntity(restUrl + "getCustomerById/{Id}", Customer.class, vars).getBody();
	}

	public Customer getCustomerByPhonenumber(String phonenumber) {
		Map<String, String> vars = new HashMap<>();
		vars.put("phonenumber", phonenumber);
		return resttemplate.getForEntity(restUrl + "getCustomerByPhonenumber/{phonenumber}", Customer.class, vars)
				.getBody();
	}

	public Customer signUp(Customer customer) {
		return resttemplate.postForEntity(restUrl + "signup", customer, Customer.class).getBody();
	}

	public Customer updateCustomerById(Customer customer, String Id) {
		HttpEntity<Customer> requestEntity = new HttpEntity<>(customer, null);
		return resttemplate.exchange(restUrl + "updateCustomerById/{Id}".replaceAll("\\{Id\\}", String.valueOf(Id)),
				HttpMethod.PUT, requestEntity, Customer.class).getBody();
	}

	public String deleteCustomerById(String Id) {
		Map<String, String> vars = new HashMap<>();
		vars.put("Id", Id);

		return resttemplate.exchange(restUrl + "deleteCustomerById/{Id}".replaceAll("\\{Id\\}", String.valueOf(Id)),
				HttpMethod.DELETE, null, String.class).getBody();
	}
}
