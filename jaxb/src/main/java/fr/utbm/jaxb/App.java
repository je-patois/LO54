package fr.utbm.jaxb;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import fr.utbm.jaxb.util.HibernateUtil;

public class App 
{
	public static void main( String[] args ) {
		System.out.println("Bonjour");
		System.out.println("Ca va ?");
		Session session = HibernateUtil.getSessionFactory().openSession();
		System.out.println("aaa");
		/*try { 
			System.out.println("3");
			session.close(); 
		} catch(Exception e) {
			System.out.println("Fail : " + e);
		}*/
		
    /* public static void main( String[] args )
    {
    	Session session = HibernateUtil.getSessionFactory().openSession();
    try {
        session.beginTransaction();
        
        session.getTransaction().commit();
	}
	catch (HibernateException he) {
        he.printStackTrace();
        if(session.getTransaction() != null) {
            try {
                session.getTransaction().rollback();
            }catch(HibernateException he2) {he2.printStackTrace(); }
        }
	}
	finally {
        if(session != null) {
            try { session.close(); } catch(Exception e) { System.out.println(e); }
            }
        }
        
    } */
	System.out.println("Au revoir");	
	}
}
