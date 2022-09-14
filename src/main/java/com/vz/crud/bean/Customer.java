package com.vz.crud.bean;

import java.time.LocalDate;

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

import org.hibernate.annotations.SQLDelete;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
//@SQLDelete(sql = "UPDATE  Customer SET deleted=true WHERE id=customerId")
//@Where(clause = "deleted=false")

public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int customerId;
	@Column
	public String name;
	@Column
	int age;
	@Column
	public String address;
	@Column
	public String status;
	@Column
	public int mobile;

	
	@OneToMany(fetch = FetchType.LAZY, targetEntity = Account.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "coustomerproduct_fk", referencedColumnName = "customerId")
	public List<Account> accountId;
	@Column
	private LocalDate createDate;
	@Column
	private LocalDate updateDate;
	public boolean deleted = Boolean.TRUE;
	public Customer(int customerId, String name, int age, String address, String status, List<Account> accountId,
			LocalDate createDate, LocalDate updateDate) {
		super();
		this.customerId = customerId;
		this.name = name;
		this.age = age;
		this.address = address;
		this.status = status;
		this.accountId = accountId;
		this.createDate = createDate;
		this.updateDate = updateDate;
	}
//
//	public Customer() {
//
//	}

	public LocalDate getCreateDate() {
		return createDate;
	}

	public void setCreateDate(LocalDate createDate) {
		this.createDate = createDate;
	}

	public LocalDate getUpdateDate() {
		return updateDate;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<Account> getAccountId() {
		return accountId;
	}

	public void setAccountId(List<Account> accountId) {
		this.accountId = accountId;
	}

	public void setUpdateDate(LocalDate updateDate) {
		this.updateDate = updateDate;
	}

	

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}
	public int getMobile() {
		return mobile;
	}

	public void setMobile(int mobile) {
		this.mobile = mobile;
	}

	
}
