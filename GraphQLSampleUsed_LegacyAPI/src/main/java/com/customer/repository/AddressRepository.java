package com.customer.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.customer.model.Address;

@Repository
public interface AddressRepository extends MongoRepository<Address, String> {

}
