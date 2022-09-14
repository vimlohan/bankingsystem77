package com.vz.crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import com.vz.crud.bean.Branch;
import com.vz.crud.repository.Branchrepository;

@Service
public class BranchService {
@Autowired
Branchrepository branchservice;

public ResponseEntity<?> addBranch(Branch branch) throws Exception{
	
	
	branchservice.save(branch);
	return new ResponseEntity<Branch>(branch, HttpStatus.OK);
	
}
public ResponseEntity<?> updateBranch(Branch branch) throws Exception {
	if(branchservice.existsById(branch.getBranchid())){
		branchservice.save(branch);
		return new ResponseEntity<Branch>(branch, HttpStatus.OK);
	}
	throw new Exception("cant update");
}


//delete Customer from database
public ResponseEntity<?> deleteBranch(int BranchId) throws Exception {
	if(branchservice.existsById(BranchId)) {
		Branch b=branchservice.findById(BranchId).get();
        branchservice.deleteById(BranchId);
        return new ResponseEntity<Branch>(b, HttpStatus.ACCEPTED);
	}
	throw new Exception(" cant delete");
	
}


//Retrieval of a Customer by its ID
public ResponseEntity<?> viewBranch(int BranchId) throws Exception {
	if(branchservice.existsById(BranchId)) {
		Branch branch=branchservice.findById(BranchId).get();
		return new ResponseEntity<Branch>(branch, HttpStatus.OK);
	}
	throw new Exception("No provided Id ");
}




//List of all Customer
public ResponseEntity<?> viewAllBranch() throws Exception {
	
	List<Branch> BranchList=branchservice.findAll();
	if(BranchList.size()==0)
		throw new Exception("No Account");
	return new ResponseEntity<List<Branch>>(BranchList, HttpStatus.OK);
}

}
	
	
	
		
	
	


