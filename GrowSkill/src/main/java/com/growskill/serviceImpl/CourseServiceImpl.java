package com.growskill.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.growskill.model.Course;
import com.growskill.repository.CourseRepository;
import com.growskill.service.CourseService;


@Service
public class CourseServiceImpl implements CourseService{

	
	@Autowired
	 private CourseRepository courseRepository;
	
	
	@Override
	public List<Course> getAllCourses() {
		
		return courseRepository.findAll();
	}

	@Override
	public Course getCourseById(Long id) {
		
		return courseRepository.findById(id).orElse(null);
	}

	@Override
	public Course createCourse(Course course) {
		
		return courseRepository.save(course);
	}

	@Override
	public void deleteCourse(Long id) {
		
		courseRepository.deleteById(id);
		
	}

}
