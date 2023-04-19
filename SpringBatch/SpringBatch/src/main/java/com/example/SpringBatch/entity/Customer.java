package com.example.SpringBatch.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Customer_Info")
public class Customer {
	
	@Id
	@Column(name = "CUSTOMER_ID")
	private int CUSTOMERID;
	@Column(name = "COUNTRY")
	private String COUNTRY;
	@Column(name = "FULL_NAME")
	private String FULL_NAME;
	public int getCUSTOMERID() {
		return CUSTOMERID;
	}
	public void setCUSTOMERID(int cUSTOMERID) {
		CUSTOMERID = cUSTOMERID;
	}
	public String getCOUNTRY() {
		return COUNTRY;
	}
	public void setCOUNTRY(String cOUNTRY) {
		COUNTRY = cOUNTRY;
	}
	public String getFULL_NAME() {
		return FULL_NAME;
	}
	public void setFULL_NAME(String fULL_NAME) {
		FULL_NAME = fULL_NAME;
	}


}
