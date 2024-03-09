package com.growskill.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.growskill.model.Instructor;
import com.growskill.serviceImpl.InstructorServiceImpl;


@RestController
public class InstructorController {

	@Autowired
	private InstructorServiceImpl instructorServiceImpl;
	
	@GetMapping
    public ResponseEntity<List<Instructor>> getAllInstructors() {
		
        List<Instructor> instructors = instructorServiceImpl.getAllInstructors();
        
        return new ResponseEntity<>(instructors, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Instructor> getInstructorById(@PathVariable Long id) {
    	
    	
        Instructor instructor = instructorServiceImpl.getInstructorById(id);
        
        if (instructor != null) {
        	
            return new ResponseEntity<>(instructor, HttpStatus.OK);
            
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        
    }
    

    @PostMapping
    public ResponseEntity<Instructor> createInstructor(@RequestBody Instructor instructor) {
    	
        Instructor createdInstructor = instructorServiceImpl.createInstructor(instructor);
        
        return new ResponseEntity<>(createdInstructor, HttpStatus.CREATED);
    }
    

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInstructor(@PathVariable Long id) {
    	
    	instructorServiceImpl.deleteInstructor(id);
    	
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    
    
	
}
