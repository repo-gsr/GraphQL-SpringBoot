package com.graphql.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.graphql.model.CustomerHistory;

@Repository
public interface CustomerHistoryRepository extends MongoRepository<CustomerHistory, String> {

}
