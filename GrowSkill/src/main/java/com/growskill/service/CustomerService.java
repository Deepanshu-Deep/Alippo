package com.growskill.service;

import java.util.List;

import com.growskill.model.Customer;

public interface CustomerService {

	public List<Customer> getAllCustomers();
	
	public Customer getCustomerById(Long id);
	
	 public Customer createCustomer(Customer customer);
	 
	 public void deleteCustomer(Long id);
	
	
}
