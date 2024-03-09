package com.growskill.service;

import java.util.List;

import com.growskill.model.Instructor;

public interface InstructorService {

	
	 public List<Instructor> getAllInstructors();
	
	 public Instructor getInstructorById(Long id);
	 
	 public Instructor createInstructor(Instructor instructor);
	 
	 public void deleteInstructor(Long id);
	 
	 
	
}
