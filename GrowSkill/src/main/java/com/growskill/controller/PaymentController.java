package com.growskill.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import com.growskill.model.Payment;
import com.growskill.serviceImpl.PaymentServiceImpl;

@RestController
@RequestMapping("/payments")
public class PaymentController {
	
	@Autowired
    private PaymentServiceImpl paymentServiceImpl;

   

    @GetMapping
    public ResponseEntity<List<Payment>> getAllPayments() {
    	
        List<Payment> payments = paymentServiceImpl.getAllPayments();
        
        return new ResponseEntity<>(payments, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Payment> getPaymentById(@PathVariable Long id) {
    	
        Payment payment = paymentServiceImpl.getPaymentById(id);
        
        if (payment != null) {
        	
            return new ResponseEntity<>(payment, HttpStatus.OK);
            
        } else {
        	
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Payment> createPayment(@RequestBody Payment payment) {
    	
        Payment createdPayment = paymentServiceImpl.createPayment(payment);
        
        return new ResponseEntity<>(createdPayment, HttpStatus.CREATED);
        
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePayment(@PathVariable Long id) {
    	
    	paymentServiceImpl.deletePayment(id);
    	
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        
    }
    
    
}