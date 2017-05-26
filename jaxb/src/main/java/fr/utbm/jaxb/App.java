package fr.utbm.jaxb;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import fr.utbm.jaxb.controller.ClientController;
import fr.utbm.jaxb.entity.Client;
import fr.utbm.jaxb.entity.Course;
import fr.utbm.jaxb.entity.CourseSession;
import fr.utbm.jaxb.entity.Location;

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
		
		/*JAXBContext context = null;
		Course course = new Course("IF10", "Informatique");
		Location location = new Location(1, "Sévenans");
		String startDate = "2017-05-26";
		String endDate = "2017-05-30";
		CourseSession courseSession = null;
		try {
			courseSession = new CourseSession(new SimpleDateFormat("yyyy-MM-dd").parse(startDate), new SimpleDateFormat("yyyy-MM-dd").parse(endDate));
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		courseSession.setLocation(location);
		courseSession.setCourse(course);
		Client client = new Client("Lastname", "Firstname", "Adress", "Phone", "Mail");
		client.setCourseSessionId(courseSession);
		try {
			context = JAXBContext.newInstance(Client.class);
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			Marshaller marshaller = context.createMarshaller();
			marshaller.marshal(client, new File("Client.xml"));
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			Unmarshaller unmarshaller = context.createUnmarshaller();
			Object myObject = unmarshaller.unmarshal(new File("Client.xml"));
			System.out.println("unmarshalled = " + myObject);
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	    
	    // Récupération du client en base de données
	    /*ClientController clientController = new ClientController();
	    Client client = clientController.getClientById(9);

	    try {
			clientController.fromClientToXML(client, "InscriptionDetails.xml");
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/		
	}
}
