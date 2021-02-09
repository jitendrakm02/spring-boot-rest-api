package com.springrest.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springrest.entities.Course;
import com.springrest.repository.CourseDao;

@Service
public class CourseServiceImpl implements CourseService {
	@Autowired
	private CourseDao courseDao;

	@Override
	public List<Course> getCourses() {
		// all data
		return courseDao.findAll();
	}

	@Override
	public Course getCourseById(long courseId) {
		// TODO Auto-generated method stub
		return courseDao.getOne(courseId);
	}

	@Override
	public Course saveCourse(Course course) {
		// TODO Auto-generated method stub
		return courseDao.save(course);
	}

	@Override
	public Course updateCourse(Course course) {
		// TODO Auto-generated method stub
		return courseDao.save(course);
	}

	@Override
	public void deleteCourse(long courseId) {
		// TODO Auto-generated method stub
		Course entity = courseDao.getOne(courseId);
		courseDao.delete(entity);
		
	}
	/*//without database connection code
	 * List<Course> list;
	 * 
	 * public CourseServiceImpl() {
	 * 
	 * list=new ArrayList<Course>(); list.add(new Course(125, "java class",
	 * "java programming language", "j k singh")); list.add(new Course(124,
	 * "python class", "python programming language", "durgesh")); }
	 * 
	 * @Override public List<Course> getCourses() {
	 * 
	 * return list; }
	 * 
	 * @Override public Course getCourseById(long courseId) { Course c=null;
	 * for(Course course : list) { if(course.getId()==courseId) { c=course; break; }
	 * } return c; }
	 * 
	 * @Override public Course saveCourse(Course course) { list.add(course); return
	 * course; }
	 * 
	 * @Override public Course updateCourse(Course course) {
	 * 
	 * list.forEach(e->{ if(e.getId()==course.getId()) {
	 * e.setTitle(course.getTitle()); e.setDescription(course.getDescription());
	 * e.setTeacher(course.getTeacher()); } }); return course; }
	 * 
	 * @Override public void deleteCourse(long courseId) { // TODO Auto-generated
	 * method stub
	 * list=this.list.stream().filter(e->e.getId()!=courseId).collect(Collectors.
	 * toList()); }
	 */
}
