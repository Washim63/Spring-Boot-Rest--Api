package com.springrestapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springrestapi.entities.Course;

public interface CourseRepository  extends JpaRepository <Course, Long>{

}
