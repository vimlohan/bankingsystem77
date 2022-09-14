package com.vz.crud.service;

import java.awt.print.Pageable;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.vz.crud.bean.Account;
import com.vz.crud.bean.Customer;
import com.vz.crud.repository.Accountrepository;
import com.vz.crud.repository.Customersrepository;

import com.vz.crud.repository.mongo.AccountMongoRepo;
import com.vz.crud.repository.mongo.CustomerMongoRepo;

@Service
//@CacheConfig(cacheNames = "{Customer}")
public class Customerservice {
	@Autowired
	public Customersrepository customerservice;
//	@Autowired
//	public Accountrepository accountservice;
	@Autowired
	public CustomerMongoRepo mongoRepo;
	@Autowired
	public AccountMongoRepo accountMonRepo;
//	@Autowired
//	public PagingRepo pegiservice;

	public ResponseEntity<?> addCustomer(Customer Customer) throws Exception {
		// Customer.setCustomerId(hashCode());

		Customer.setCreateDate(LocalDate.now());
		customerservice.save(Customer);
		mongoRepo.save(Customer);

		return new ResponseEntity<Customer>(Customer, HttpStatus.OK);

	}

	// update existing Customer in database
	// @CachePut(key = "#id", value = "Customer")
	public ResponseEntity<?> updateCustomer(Customer Customer) throws Exception {
		if (customerservice.existsById(Customer.getCustomerId())) {
			Customer.setUpdateDate(LocalDate.now());
			customerservice.save(Customer);

//			if (mongoRepo.existsById(Customer.getCustomerId())) {
//				Customer.setUpdateDate(LocalDate.now());

			mongoRepo.save(Customer);
			return new ResponseEntity<Customer>(Customer, HttpStatus.OK);
		}
		throw new Exception("cant update");
	}

	// delete Customer from database
	// @Cacheable(key="#CustomerId",value="Customer")
	public ResponseEntity<?> deleteCustomer(int CustomerId) throws Exception {
		if (customerservice.existsById(CustomerId)) {
			Customer customer = customerservice.findById(CustomerId).get();
			customerservice.deleteById(CustomerId);

			return new ResponseEntity<Customer>(customer, HttpStatus.ACCEPTED);

		}
		throw new Exception(" cant delete");

	}

	public ResponseEntity<?> deleteCustomer1(int CustomerId) throws Exception {
		if (mongoRepo.existsById(CustomerId)) {
			Customer customer = mongoRepo.findById(CustomerId).get();
			mongoRepo.deleteById(CustomerId);
			return new ResponseEntity<Customer>(customer, HttpStatus.ACCEPTED);
		}
		throw new Exception(" cant delete");

	}

	// Retrieval of a Customer by its ID
	// @Cacheable(key="#CustomerId",value="Customer")
	public ResponseEntity<?> viewCustomer(int customerId) throws Exception {
		if (customerservice.existsById(customerId)) {
			Customer Customer = customerservice.findById(customerId).get();
			mongoRepo.findById(customerId).get();

			return new ResponseEntity<Customer>(Customer, HttpStatus.OK);
		}
		throw new Exception("No  provided Id ");
	}

	// List of all Customer

	public ResponseEntity<?> viewAllCustomer() throws Exception {

		List<Customer> CustomerList = customerservice.findAll();
		mongoRepo.findAll();
		if (CustomerList.size() == 0)
			throw new Exception("No customer");
		return new ResponseEntity<List<Customer>>(CustomerList, HttpStatus.OK);
	}

	public List<Customer> viewAllCustomerpage(int pagenb, int pagesize) throws Exception {

		PageRequest pageing = PageRequest.of(pagenb, pagesize);
		Page<Customer> page = customerservice.findAll(pageing);
		List<Customer> customer = page.getContent();
		return customer;

	}

	public Page<Customer> getCustomers(int pageNumber,int pagesize){
		org.springframework.data.domain.Pageable page =PageRequest.of(pageNumber, pagesize);
		return customerservice.findAll(page);
	//	return customerservice.findAll();
	}


	
}
