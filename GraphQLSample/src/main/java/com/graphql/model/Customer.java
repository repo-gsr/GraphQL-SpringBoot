package com.graphql.model;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.fasterxml.jackson.annotation.JsonFormat;

@Document(collection = "Customer")
public class Customer {
	private String id;
	private String fname;
	private String lname;
	private String gmail;
	private String phonenumber;
	@DBRef
	@Field(value = "address")
	private List<Address> address;
	@DateTimeFormat(iso = ISO.DATE_TIME)
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate signupDate;

	public Customer(String fname, String lname, String gmail, String phonenumber, List<Address> address,
			LocalDate signupDate) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.gmail = gmail;
		this.phonenumber = phonenumber;
		this.address = address;
		this.signupDate = signupDate;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getGmail() {
		return gmail;
	}

	public void setGmail(String gmail) {
		this.gmail = gmail;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public List<Address> getAddress() {
		return address;
	}

	public void setAddress(List<Address> address) {
		this.address = address;
	}

	public LocalDate getSignupDate() {
		return signupDate;
	}

	public void setSignupDate(LocalDate signupDate) {
		this.signupDate = signupDate;
	}

}
