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

import com.vz.crud.bean.Branch;

import com.vz.crud.service.BranchService;

@RestController
@RequestMapping("/Branch")
@CrossOrigin("*")
public class BranchController {
	@Autowired
	 BranchService branchmaping;
	@PostMapping("/addBranch")
	public ResponseEntity<?> addBranch(@RequestBody Branch branch) throws Exception{
		
		return branchmaping.addBranch(branch);
	}
	@PutMapping("/updateBranch")
	public ResponseEntity<?> updateBranch(@RequestBody Branch branch) throws Exception{
		
		return branchmaping.updateBranch(branch);
	}
	
	@DeleteMapping("/deleteBranch/{id}")
	public ResponseEntity<?> deleteBranch(@PathVariable("id") int branchid) throws Exception{
		return branchmaping.deleteBranch(branchid);
	}
	
	@GetMapping("/viewAcccountById/{BranchId}")
	public ResponseEntity<?> viewBranch(@PathVariable("BranchId") int id) throws Exception{
		return branchmaping.viewBranch(id);
		

	}

	
	@GetMapping("/viewAllBranch")
	public ResponseEntity<?> viewAllBranch() throws Exception{
		return branchmaping.viewAllBranch();
	}
	
}


