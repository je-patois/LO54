package fr.utbm.jaxb;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import fr.utbm.jaxb.controller.CourseController;
import fr.utbm.jaxb.entity.Course;

// ZONE DE TEST

public class App 
{
	public static void main( String[] args ) {
		//Session session = HibernateUtil.getSessionFactory().openSession();
		
		/*ClientDao myClientDao = new ClientDao();*/
		
		//Client myNewClient = new Client("Oui", "Aloïs", "1 rue de l'UTBM", "06.06.06.06.06", "alois.kende@utbm.fr");
		//myClientDao.addClient(myNewClient);
		//myNewClient.setId(4);
		
		//myClientDao.updateClient(myNewClient);
		
		//myClientDao.deleteClient(myNewClient);
		
		/*System.out.println(myClientDao.getClientById(2).toString());
		
		
		
		List<Client> myList = myClientDao.getClient();
		for(Client myClient: myList) {
            System.out.println(myClient.toString());
        }*/
		
		/*CourseController myController = new CourseController();
		List<Course> myList = myController.getAllCourses();
		for(Course myCourse: myList) {
            System.out.println(myCourse.toString());
        }*/
		
		/*CourseSessionController myCourseSessionController = new CourseSessionController();
		CourseSession myCourseSession = myCourseSessionController.getCourseSessionByCode("LO54");
		System.out.println(myCourseSession.toString());*/
		
		/*CourseSessionController myCourseSessionController = new CourseSessionController();
		List<CourseSession> myCourseSessions = myCourseSessionController.getCourseSessionByCode("LO54");
		for(CourseSession myCourseSession: myCourseSessions) {
            System.out.println(myCourseSession.getCourseCode());
        }*/
		
		/*CourseSessionController myCourseSessionController = new CourseSessionController();
		Object myObject = myCourseSessionController.getCourseSessionWithLocation();
		System.out.println(myObject.toString());*/
		
		/*CourseController courseController = new CourseController();
		List<Course> myList = courseController.getCourseFilteredByTitle("Conception");
		for(Course myCourse: myList) {
            System.out.println(myCourse.toString());
        }*/
		
		/*CourseSessionController courseSessionController = new CourseSessionController();
		String date = "2017-05-25";
		//System.out.println(date);
		List<CourseSession> myList = new ArrayList<CourseSession>();
		try {
			myList = courseSessionController.getCourseSessionByDate(new SimpleDateFormat("yyyy-MM-dd").parse(date));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(CourseSession myCourseSession: myList) {
            System.out.println(myCourseSession.toString());
        }*/
		
		/*List<String> myCourses = new ArrayList<String>();
		myCourses.add("LO54");
		myCourses.add("BD50");
		CourseController courseController = new CourseController();
		List<Course> myList = courseController.getGroupCoursesByCode(myCourses);
		for(Course myCourse: myList) {
            System.out.println(myCourse.toString());
        }*/
		
		/*CourseController courseController = new CourseController ();
		String date = "2017-05-25";
		//List<Course> myList = new ArrayList<Course>();
		try {
			//myList = courseController.getCoursesByDateLocationTitleFragment(new SimpleDateFormat("yyyy-MM-dd").parse(date), 1, "Java");
			//courseController.getCoursesByDateLocationTitleFragment(new SimpleDateFormat("yyyy-MM-dd").parse(date), 1, "Java");
			courseController.getCoursesByDateLocationTitleFragment(new SimpleDateFormat("yyyy-MM-dd").parse(date), null, null);
		} catch (java.text.ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		/*for(Course myCourseSession: myList) {
			System.out.println(myCourseSession.toString());
		}*/
	}
}
