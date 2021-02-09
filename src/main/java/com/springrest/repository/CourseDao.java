package com.springrest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springrest.entities.Course;

@Repository
public interface CourseDao extends JpaRepository<Course, Long> {

}
