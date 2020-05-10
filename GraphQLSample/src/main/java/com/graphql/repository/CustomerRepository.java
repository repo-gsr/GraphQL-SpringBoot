package com.graphql.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.graphql.model.Customer;

@Repository
public interface CustomerRepository extends MongoRepository<Customer, String> {
	public Customer findByPhonenumber(String phonenumber);
}
