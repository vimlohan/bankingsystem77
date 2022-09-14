package com.vz.crud.repository;

import java.awt.print.Pageable;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.vz.crud.bean.Account;
import com.vz.crud.bean.Customer;
@Repository
public interface Customersrepository extends JpaRepository<Customer, Integer>{
// Page<Customer>findAll(Pageable pageable);


}

