package com.growskill.service;

import java.util.List;
import com.growskill.model.Class;


public interface ClassService {

	
	public List<Class> getAllClasses();
	
	public Class getClassById(Long id);
	
	 public Class createClass(Class classEntity);
	 
	 public void deleteClass(Long id);
	
}
