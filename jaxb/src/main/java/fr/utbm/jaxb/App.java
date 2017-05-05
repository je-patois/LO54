package fr.utbm.jaxb;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import fr.utbm.jaxb.entity.Client;
import fr.utbm.jaxb.repository.ClientDao;
import fr.utbm.jaxb.util.HibernateUtil;

public class App 
{
	public static void main( String[] args ) {
		// Session session = HibernateUtil.getSessionFactory().openSession();
		ClientDao myClientDao = new ClientDao();
		List<Client> myList = myClientDao.getClient();
		for(Client myClient: myList) {
            System.out.println(myClient.toString());
        }
	}
}
