package com.vz.crud.repository.mongo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Repository;

import com.vz.crud.bean.Customer;
@EnableMongoRepositories
public interface CustomerMongoRepo extends MongoRepository<Customer, Integer> {

}
