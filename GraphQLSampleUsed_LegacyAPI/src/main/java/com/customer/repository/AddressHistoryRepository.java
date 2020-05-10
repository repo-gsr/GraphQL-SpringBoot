package com.customer.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.customer.model.AddressHistory;

@Repository
public interface AddressHistoryRepository extends MongoRepository<AddressHistory, String> {

}
