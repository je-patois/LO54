package fr.utbm.jaxb.controller;

import java.io.Serializable;
import java.util.List;

import fr.utbm.jaxb.entity.Course;
import fr.utbm.jaxb.service.CourseService;

public class CourseController implements Serializable {
	 
	private static final long serialVersionUID = 1L;
	
	private CourseService courseService;
	
	public CourseController() {
		courseService = new CourseService();
	}

	public CourseService getCourseService() {
		return courseService;
	}

	public void setCourseService(CourseService courseService) {
		this.courseService = courseService;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public List<Course> getAllCourses() {
		List<Course> myList = courseService.getAllCourses();
		return myList;
	}
	
	public boolean addCourse(Course course) {
		boolean success = courseService.addCourse(course);
		return success;
	}
}
