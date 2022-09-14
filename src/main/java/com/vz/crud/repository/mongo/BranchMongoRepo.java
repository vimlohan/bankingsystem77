package com.vz.crud.repository.mongo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.vz.crud.bean.Branch;

public interface BranchMongoRepo extends MongoRepository<Branch, Integer> {

}
