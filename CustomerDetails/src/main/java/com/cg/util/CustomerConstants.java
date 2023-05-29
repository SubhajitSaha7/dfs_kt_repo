package com.cg.util;

public class CustomerConstants {
	
	public static final String INSERT_QUERY = "INSERT INTO cg_customer (customerId,customerName,dateOfBirth,phoneNumber) VALUES (?,?,?,?)";

	public static final String FINDALL_QUERY = "SELECT * FROM cg_customer";
	
	public static final String FINDBYID_QUERY = "SELECT * FROM cg_customer WHERE customerId=?";

	public static final String CUSTOMER_ADDED = "Customer Added.";
	
}
