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
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table
public class Account {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int accountId;
	@Column
	public String status;
	@Column
	public LocalDate openingdate;
	@Column
	public LocalDate updateddate;
	@Column
	public double currentBalance;
	@Column
	public double interestRate;
	
	
	
//	@OneToMany(fetch = FetchType.LAZY, targetEntity = Account.class, cascade = CascadeType.ALL)
//	@JoinColumn(name = "accountproduct_fk", referencedColumnName = "accountId")
//	private List<Customer>customerId;
//     
//	public List<Branch> getBranchid() {
//		return branchid;
	//}

//	public List<Customer> getCustomerId() {
//		return customerId;
//	}
//
//	public void setCustomerId(List<Customer> customerId) {
//		this.customerId = customerId;
//	}

	
	

	public void setOpeningdate(LocalDate openingdate) {
		this.openingdate = openingdate;
	}

	public void setUpdateddate(LocalDate updateddate) {
		this.updateddate = updateddate;
	}

	public Account(int accountid, String status, int openingdate, int updateddate, int currentBalance,
			int interestRate) {
		super();
		this.accountId = accountid;
		this.status = status;

		this.currentBalance = currentBalance;
		this.interestRate = interestRate;

	}

//	public Account() {
//		super();
//
//	}

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public LocalDate getOpeningdate() {
		return openingdate;
	}

	public LocalDate getUpdateddate() {
		return updateddate;
	}

	public double getCurrentBalance() {
		return currentBalance;
	}

	public double getInterestRate() {
		return interestRate;
	}

	public Account(int accountId, String status, LocalDate openingdate, LocalDate updateddate, double currentBalance,
			double interestRate, List<Branch> branchid) {
		super();
		this.accountId = accountId;
		this.status = status;
		this.openingdate = openingdate;
		this.updateddate = updateddate;
		this.currentBalance = currentBalance;
		this.interestRate = interestRate;
		
	}

	@Override
	public String toString() {
		return "Account [accountId=" + accountId + ", status=" + status + ", openingdate=" + openingdate
				+ ", updateddate=" + updateddate + ", currentBalance=" + currentBalance + ", interestRate="
				+ interestRate + "]";
	}

	public void setCurrentBalance(double currentBalance) {
		this.currentBalance = currentBalance;
	}

	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}

}
