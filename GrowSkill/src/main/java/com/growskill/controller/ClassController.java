package com.growskill.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;
import com.growskill.model.Class;
import com.growskill.serviceImpl.ClassServiceImpl;

@RestController
@RequestMapping("/classes")
public class ClassController {
	
	@Autowired
    private ClassServiceImpl classService;


    @GetMapping
    public ResponseEntity<List<Class>> getAllClasses() {
    	
        List<Class> classes = classService.getAllClasses();
        return new ResponseEntity<>(classes, HttpStatus.OK);
        
    }

    @GetMapping("/{id}")
    public ResponseEntity<Class> getClassById(@PathVariable Long id) {
    	
        Class classEntity = classService.getClassById(id);
        
        if (classEntity != null) {
        	
            return new ResponseEntity<>(classEntity, HttpStatus.OK);
            
        } else {
        	
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        
        
    }

    @PostMapping
    public ResponseEntity<Class> createClass(@RequestBody Class classEntity) {
    	
        Class createdClass = classService.createClass(classEntity);
        
        return new ResponseEntity<>(createdClass, HttpStatus.CREATED);
    }

    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClass(@PathVariable Long id) {
    	
        classService.deleteClass(id);
        
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    
}