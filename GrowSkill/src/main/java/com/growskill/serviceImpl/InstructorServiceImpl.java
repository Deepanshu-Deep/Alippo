package com.growskill.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.growskill.model.Instructor;
import com.growskill.repository.InstructorRepository;
import com.growskill.service.InstructorService;


@Service
public class InstructorServiceImpl implements InstructorService{

	
	@Autowired
	 private InstructorRepository instructorRepository;
	
	
	@Override
	public List<Instructor> getAllInstructors() {
		
		
		return instructorRepository.findAll();
	}

	
	@Override
	public Instructor getInstructorById(Long id) {
		
		Optional<Instructor> optionalInstructor = instructorRepository.findById(id);
		
        return optionalInstructor.orElse(null);
	}
	
	

	@Override
	public Instructor createInstructor(Instructor instructor) {
				
		return instructorRepository.save(instructor);
	}

	
	@Override
	public void deleteInstructor(Long id) {
		
		
		instructorRepository.deleteById(id);
		
	}
	
	
	
	

}
