package com.vz.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vz.crud.bean.Customer;
import com.vz.crud.repository.Accountrepository;
import com.vz.crud.repository.Customersrepository;
import com.vz.crud.service.AccountService;
import com.vz.crud.service.Customerservice;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@RestController
@RequestMapping("/Customer")
@CrossOrigin("*")
@CacheConfig(cacheNames = "{Customer}")
public class CustomerController {

//	@Autowired
//	Customersrepository custtomerrepo;
//	@Autowired
//	Accountrepository accountrepository;
//	@Autowired
//	public Customersrepository customerservice;
	@Autowired
	Customerservice customermaping;

	@PostMapping("/addCustomer")
	public ResponseEntity<?> addCustomer(@RequestBody Customer Customer) throws Exception {
		return customermaping.addCustomer(Customer);

	}

	// @CachePut(key = "#id", value = "Customer")
	@PutMapping("/updateCustomer")
	public ResponseEntity<?> updateCustomer(@RequestBody Customer Customer) throws Exception {

		return customermaping.updateCustomer(Customer);
	}

	// @CacheEvict(key = "#customerId", value = "Customer")

	@DeleteMapping("/deleteCustomer/{CustomerId}")
	public ResponseEntity<?> deleteCustomer(@PathVariable("CustomerId") int customerId) throws Exception {
		return customermaping.deleteCustomer(customerId);
	}

	@DeleteMapping("/deleteCustomer1/{CustomerId}")
	public ResponseEntity<?> deleteCustomer1(@PathVariable("CustomerId") int customerId) throws Exception {
		return customermaping.deleteCustomer(customerId);
	}

	// @Cacheable(key = "#customerId", value = "Customer", sync = true)
	@GetMapping("/viewCustomerById/{CustomerId}")
	public ResponseEntity<?> viewCustomer(@PathVariable("CustomerId") int id) throws Exception {
		return customermaping.viewCustomer(id);

	}

	// @Cacheable(key = "#CustomerId", value = "Customer")
	@GetMapping("/viewAllCustomer")
	public ResponseEntity<?> viewAllCustomer() throws Exception {

		return customermaping.viewAllCustomer();
	}

	@GetMapping("/viewAllCustomerpage")
	public ResponseEntity<?> viewAllCustomerpage(@RequestParam(defaultValue = "0") Integer pagenb,
			@RequestParam(defaultValue = "5") Integer pagesize) throws Exception {
		customermaping.viewAllCustomerpage(pagenb, pagesize);
		return (ResponseEntity<?>) customermaping.viewAllCustomerpage(pagenb, pagesize);
	}
	
	@GetMapping("/pageing")
	Page<Customer>getCustomers(@RequestParam int pagesize,@RequestParam int pageNumber){
		return customermaping.getCustomers(pagesize,pageNumber);
	}
}
