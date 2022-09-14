package com.vz.crud.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.vz.crud.bean.Account;
import com.vz.crud.bean.Customer;
import com.vz.crud.repository.Accountrepository;

@Service
public class AccountService {
	@Autowired
	Accountrepository accountservice;

	public ResponseEntity<?> addAccount(Account account) throws Exception {

		if (account.getCurrentBalance() > 10000) {
			//account.setAccountId(hashCode());
			account.setOpeningdate(LocalDate.now());
			accountservice.save(account);
			return new ResponseEntity<Account>(account, HttpStatus.OK);

		} else {
			throw new Exception("Can't add Account ");
		}

	}

	public ResponseEntity<?> updateAccount(Account account) throws Exception {
		if (accountservice.existsById(account.getAccountId())) {
			account.setUpdateddate(LocalDate.now());
			accountservice.save(account);
			return new ResponseEntity<Account>(account, HttpStatus.OK);
		}
		throw new Exception("cant update");
	}

	// delete Customer from database
	public ResponseEntity<?> deleteAccount(int AccountId) throws Exception {
		if (accountservice.existsById(AccountId)) {
			Account a = accountservice.findById(AccountId).get();
			accountservice.deleteById(AccountId);
			return new ResponseEntity<Account>(a, HttpStatus.ACCEPTED);
		}
		throw new Exception(" cant delete");

	}

	// retrival of a Customer by its ID
	public ResponseEntity<?> viewAccount(int AccountId) throws Exception {
		if (accountservice.existsById(AccountId)) {
			Account account = accountservice.findById(AccountId).get();
			return new ResponseEntity<Account>(account, HttpStatus.OK);
		}
		throw new Exception("No provided Id ");
	}

	// List of all Customer
	public ResponseEntity<?> viewAllAccount() throws Exception {

		List<Account> AccountList = accountservice.findAll();
		if (AccountList.size() == 0)
			throw new Exception("No Account");
		return new ResponseEntity<List<Account>>(AccountList, HttpStatus.OK);
	}

}
