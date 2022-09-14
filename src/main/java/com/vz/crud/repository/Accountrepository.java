package com.vz.crud.repository;

import java.awt.print.Pageable;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.vz.crud.bean.Account;
import com.vz.crud.bean.Customer;


@Repository
public interface Accountrepository extends JpaRepository<Account, Integer> {
	//Page<Account>findAll(Pageable pageable);
}
