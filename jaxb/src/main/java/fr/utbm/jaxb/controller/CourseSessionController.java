package fr.utbm.jaxb.controller;

import java.io.Serializable;
import java.util.List;

import fr.utbm.jaxb.entity.CourseSession;
import fr.utbm.jaxb.service.CourseSessionService;

public class CourseSessionController implements Serializable {

	private static final long serialVersionUID = 1L;
	private CourseSessionService courseSessionService;

	public CourseSessionController() {
		courseSessionService = new CourseSessionService();
	}
	
	public CourseSessionService getCourseSessionService() {
		return courseSessionService;
	}

	public void setCourseSessionService(CourseSessionService courseSessionService) {
		this.courseSessionService = courseSessionService;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public List<CourseSession> getCourseSessionByCode(String code) {
		List<CourseSession> myCourseSession = courseSessionService.getCourseSessionByCode(code);
		return myCourseSession;
	}
	
	public CourseSession getCourseSessionByID(Integer id) {
		CourseSession myCourseSession = courseSessionService.getCourseSessionByID(id);
		return myCourseSession;
	}
	
	public List<Object> getCourseSessionWithLocation() {
		List<Object> myObject = courseSessionService.getCourseSessionWithLocation();
		return myObject;
	}
}
