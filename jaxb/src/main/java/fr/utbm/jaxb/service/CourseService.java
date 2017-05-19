package fr.utbm.jaxb.service;

import java.io.Serializable;
import java.util.List;

import fr.utbm.jaxb.entity.Course;
import fr.utbm.jaxb.repository.CourseDao;

public class CourseService implements Serializable {

	private static final long serialVersionUID = 1L;

	private CourseDao courseDao;
	
	public CourseService() {
		courseDao = new CourseDao();
	}

	public CourseDao getCourseDao() {
		return courseDao;
	}

	public void setCourseDao(CourseDao courseDao) {
		this.courseDao = courseDao;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public List<Course> getAllCourses() {
		List<Course> myList = courseDao.getCourse();
		return myList;
	}
}
