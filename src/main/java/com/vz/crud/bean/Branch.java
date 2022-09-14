package com.vz.crud.bean;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table

public class Branch {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private int branchid;
@Column
public String address;
@Column
public int phone;

@OneToMany(fetch = FetchType.LAZY, targetEntity = Account.class, cascade = CascadeType.ALL)
@JoinColumn(name = "product_fk", referencedColumnName = "branchid")
public List<Account> accountDetails;
public Branch(int branchid, String address, int phone) {
	super();
	this.branchid = branchid;
	this.address = address;
	this.phone = phone;
}
public List<Account> getAccountDetails() {
	return accountDetails;
}
public void setAccountDetails(List<Account> accountDetails) {
	this.accountDetails = accountDetails;
}
public int getBranchid() {
	return branchid;
}
public void setBranchid(int branchid) {
	this.branchid = branchid;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public int getPhone() {
	return phone;
}
public void setPhone(int phone) {
	this.phone = phone;
}
@Override
public String toString() {
	return "Branch [branchid=" + branchid + ", address=" + address + ", phone=" + phone + "]";
}

}



