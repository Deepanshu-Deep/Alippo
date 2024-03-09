package com.growskill.service;

import java.util.List;

import com.growskill.model.Course;

public interface CourseService {

	 public List<Course> getAllCourses();
	
	
	 public Course getCourseById(Long id);
	 
	 
	 public Course createCourse(Course course);
	 
	 public void deleteCourse(Long id);
	 
	 
}
