package com.springrest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springrest.entities.Course;
import com.springrest.services.CourseService;

@RestController
public class CoursesController {
	@Autowired
	private CourseService service;
	
	@GetMapping("/home")
	public String getcon() {
		return "welcome to controller is running";
		
	}
	//getting all values
	@GetMapping("/courses")
	public List<Course> getCourse(){
		return this.service.getCourses();
		
	}
	//getting single value by id
	@GetMapping("/courses/{courseId}")
	public Course getCourseById(@PathVariable long courseId) {
		return this.service.getCourseById(courseId);
		
	}
	//creating course
	@PostMapping("/courses")
	public Course saveCourse(@RequestBody Course course) {
		return this.service.saveCourse(course);
		
	}
	//updating course
	@PutMapping("/courses")
	public Course updateCourse(@RequestBody Course course) {
		return this.service.updateCourse(course);
		
	}
	//delete course
	@DeleteMapping("/courses/{courseId}")
	public ResponseEntity<HttpStatus> deleteCourse(@PathVariable long courseId){
		try {
		this.service.deleteCourse(courseId);
		return new ResponseEntity<>(HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}

}
