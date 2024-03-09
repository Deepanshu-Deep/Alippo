package com.growskill.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.growskill.model.Customer;
import com.growskill.repository.CustomerRepository;
import com.growskill.service.CustomerService;

public class CustomerServiceImpl implements CustomerService{

	@Autowired
	private CustomerRepository customerRepository;
	
	@Override
	public List<Customer> getAllCustomers() {
		
		return customerRepository.findAll();
	}

	@Override
	public Customer getCustomerById(Long id) {
		
		 return customerRepository.findById(id).orElse(null);
	}

	@Override
	public Customer createCustomer(Customer customer) {
		
		 return customerRepository.save(customer);
	}

	@Override
	public void deleteCustomer(Long id) {
	
		customerRepository.deleteById(id);
		
	}
	

}
