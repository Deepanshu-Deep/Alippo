package com.growskill.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.growskill.model.Customer;
import com.growskill.serviceImpl.CustomerServiceImpl;

@RestController
@RequestMapping("/customers")
public class CustomerController {
	
	
	@Autowired
    private CustomerServiceImpl customerServiceImpl;


    @GetMapping
    public ResponseEntity<List<Customer>> getAllCustomers() {
    	
    	
        List<Customer> customers = customerServiceImpl.getAllCustomers();
        
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable Long id) {
    	
    	
        Customer customer = customerServiceImpl.getCustomerById(id);
        
        if (customer != null) {
        	
            return new ResponseEntity<>(customer, HttpStatus.OK);
            
        } else {
        	
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    
    @PostMapping
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
    	
        Customer createdCustomer = customerServiceImpl.createCustomer(customer);
        
        return new ResponseEntity<>(createdCustomer, HttpStatus.CREATED);
    }

    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable Long id) {
    	
    	customerServiceImpl.deleteCustomer(id);
    	
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    
}