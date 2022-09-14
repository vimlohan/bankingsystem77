package com.vz.crud.repository;

import java.awt.print.Pageable;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.vz.crud.bean.Branch;
import com.vz.crud.bean.Customer;


@Repository
public interface Branchrepository extends JpaRepository<Branch, Integer> {

	//Page<Branch>findAll(Pageable pageable);

}
