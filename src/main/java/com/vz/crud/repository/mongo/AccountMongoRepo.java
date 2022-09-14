package com.vz.crud.repository.mongo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.vz.crud.bean.Account;

public interface AccountMongoRepo extends MongoRepository<Account, Integer> {

}
