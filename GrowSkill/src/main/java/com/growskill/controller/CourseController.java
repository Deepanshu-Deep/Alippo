package com.growskill.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.growskill.model.Course;
import com.growskill.serviceImpl.CourseServiceImpl;


@RestController
public class CourseController {

		@Autowired
		private CourseServiceImpl cServiceImpl;
		
		
		 @GetMapping
		 public ResponseEntity<List<Course>> getAllCourses() {
			 
		   List<Course> courses = cServiceImpl.getAllCourses();
		   
		      return new ResponseEntity<>(courses, HttpStatus.OK);
		 }
		 
		 
		 
		 @GetMapping("/{id}")
		 public ResponseEntity<Course> getCourseById(@PathVariable Long id) {
			 
		        Course course = cServiceImpl.getCourseById(id);
		        
		        if (course != null) {
		        	
		            return new ResponseEntity<>(course, HttpStatus.OK);
		            
		        } else {
		        	
		            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		        }
		        
		 }
		 
		 
		 @PostMapping
		 public ResponseEntity<Course> createCourse(@RequestBody Course course) {
			 
		        Course createdCourse = cServiceImpl.createCourse(course);
		        
		        return new ResponseEntity<>(createdCourse, HttpStatus.CREATED);
		        
		 }
	 
	 
	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> deleteCourse(@PathVariable Long id) {
	    	
	    	cServiceImpl.deleteCourse(id);
	    	
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	        
	    }
	
	
}
