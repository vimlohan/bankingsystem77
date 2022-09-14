package com.vz.crud.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vz.crud.bean.Account;
import com.vz.crud.repository.Customersrepository;
import com.vz.crud.service.AccountService;

@RestController
@RequestMapping("/Account")
@CrossOrigin("*")

public class AccountController {
	@Autowired
	AccountService accountmapping;
//	@Autowired
//	Customersrepository customerservice;
	@PostMapping("/addAccount")
	public ResponseEntity<?> addAccount(@RequestBody Account Account) throws Exception{
		
		return accountmapping.addAccount(Account);
	}

	@PutMapping("/updateAccount")
	public ResponseEntity<?> updateAccount(@RequestBody Account Account) throws Exception{
		
		return accountmapping.updateAccount(Account);
	}
	
	@DeleteMapping("/deleteAccount/{id}")
	public ResponseEntity<?> deleteAccount(@PathVariable("id") int accountId) throws Exception{
		return accountmapping.deleteAccount(accountId);
	}
	
	@GetMapping("/viewAcccountById/{AccountId}")
	public ResponseEntity<?> viewAccount(@PathVariable("AccountId") int id) throws Exception{
		return accountmapping.viewAccount(id);
		

	}

	
	@GetMapping("/viewAllAccount")
	public ResponseEntity<?> viewAllAccount() throws Exception{
		return accountmapping.viewAllAccount();
	}
	
	
}

