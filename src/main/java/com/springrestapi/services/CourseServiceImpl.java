package com.springrestapi.services;

//import java.util.ArrayList;
import java.util.List;
//import java.util.stream.Collector;
//import java.util.stream.Collectors;

//import org.hibernate.annotations.DialectOverride.OverridesAnnotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springrestapi.entities.Course;
import com.springrestapi.repository.CourseRepository;

@Service
public class CourseServiceImpl implements CourseService {
	
@Autowired
private CourseRepository courseRepository;

//List<Course>list;

 public CourseServiceImpl(){
	// list = new ArrayList<>(); 
	 //list.add(new Course( 786, "java Course","this course his created in Java"));
     //list.add(new Course(788,"SpringBoot Course", "this course his created in SpringBoot"));
 }
 

	@Override
	public List<Course> getCourses() {
		
		return courseRepository.findAll();
	}


	@SuppressWarnings("deprecation")
	@Override
	public Course getCourse(long courseId) {
		/*Course c = null;
		for(Course course : list)
		{
			if(course.getId() == courseId)
			{
				c = course;
				
				break;
			}
		}*/
		
		
		return courseRepository.getOne(courseId);
	}


	@Override
	public Course addCourse(Course course) {
		//list.add(course);
		courseRepository.save(course);
		return course;
	}


	@Override
	public Course updateCourse(Course course) {
	/*	list.forEach(e -> {
			if (e.getId()==course.getId()) {
				e.setTitle(course.getTitle());
				e.setDescription(course.getDescription());
				
			}
		});*/
		
		courseRepository.save(course);
		return course;
	
		
		
	} 


	@Override
	public void deleteCourse(long parseLong) {
		// list=this.list.stream().filter(e->e.getId()!=parseLong).collect(Collectors.toList());
		
		@SuppressWarnings("deprecation")
		Course entity = courseRepository.getOne(parseLong);{
			courseRepository.delete(entity);	
		}
	}



	
}
