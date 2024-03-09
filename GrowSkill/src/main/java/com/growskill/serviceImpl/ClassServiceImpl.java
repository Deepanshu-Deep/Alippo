package com.growskill.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.growskill.model.Class;
import com.growskill.repository.ClassRepository;
import com.growskill.service.ClassService;

@Service
public class ClassServiceImpl implements ClassService{

	
	@Autowired
	private ClassRepository classRepository;
	
	
	@Override
	public List<Class> getAllClasses() {
		
		return classRepository.findAll();
	}

	
	@Override
	public Class getClassById(Long id) {
		
		return classRepository.findById(id).orElse(null);
	}

	
	@Override
	public Class createClass(Class classEntity) {
		
		 return classRepository.save(classEntity);
		
	}

	@Override
	public void deleteClass(Long id) {
		
		classRepository.deleteById(id);
		
	}
	
	

}
