package com.customer.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.customer.model.CustomerHistory;

@Repository
public interface CustomerHistoryRepository extends MongoRepository<CustomerHistory, String> {

}
