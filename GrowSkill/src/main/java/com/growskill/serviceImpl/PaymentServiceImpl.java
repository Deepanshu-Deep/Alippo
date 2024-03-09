package com.growskill.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.growskill.model.Payment;
import com.growskill.repository.PaymentRepository;
import com.growskill.service.PaymentService;

public class PaymentServiceImpl implements PaymentService{

	
	@Autowired
	private PaymentRepository paymentRepository;
	
	@Override
	public List<Payment> getAllPayments() {
		
		return paymentRepository.findAll();
	}

	@Override
	public Payment getPaymentById(Long id) {
		
		 return paymentRepository.findById(id).orElse(null);
	}

	@Override
	public Payment createPayment(Payment payment) {
		
		return paymentRepository.save(payment);
	}

	@Override
	public void deletePayment(Long id) {
		
		paymentRepository.deleteById(id);
		
	}
	
	
	

}
