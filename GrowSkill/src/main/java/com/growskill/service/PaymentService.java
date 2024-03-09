package com.growskill.service;

import java.util.List;

import com.growskill.model.Payment;

public interface PaymentService {

	
	public List<Payment> getAllPayments();
	
	public Payment getPaymentById(Long id);
	
	public Payment createPayment(Payment payment);
	
	public void deletePayment(Long id);
	
	
}
