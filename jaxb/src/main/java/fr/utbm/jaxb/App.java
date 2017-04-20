package fr.utbm.jaxb;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import fr.utbm.jaxb.util.HibernateUtil;

public class App 
{
	public static void main( String[] args ) {
		Session session = HibernateUtil.getSessionFactory().openSession();
	}
}
