package fr.utbm.jaxb.service;

import java.io.Serializable;
import java.util.List;

import fr.utbm.jaxb.entity.CourseSession;
import fr.utbm.jaxb.repository.CourseSessionDAO;

public class CourseSessionService implements Serializable {

	private static final long serialVersionUID = 1L;
	private CourseSessionDAO courseSessionDao;
	
	public CourseSessionService() {
		courseSessionDao = new CourseSessionDAO();
	}
	
	public List<CourseSession> getCourseSessionByCode(String code) {
		List<CourseSession> myCourseSession = courseSessionDao.getCourseSessionByCode(code);
		return myCourseSession;
	}
	
	public CourseSession getCourseSessionByID(Integer id) {
		CourseSession myCourseSession = courseSessionDao.getCourseSessionByID(id);
		return myCourseSession;
	}

	public List<Object> getCourseSessionWithLocation() {
		List<Object> myObject = courseSessionDao.getCourseSessionWithLocation();
		return myObject;
	}
}
