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
		
		Client myNewClient = new Client("Oui", "Aloïs", "1 rue de l'UTBM", "06.06.06.06.06", "alois.kende@utbm.fr");
		//myClientDao.addClient(myNewClient);
		myNewClient.setId(4);
		
		//myClientDao.updateClient(myNewClient);
		
		myClientDao.deleteClient(myNewClient);
		
		List<Client> myList = myClientDao.getClient();
		for(Client myClient: myList) {
            System.out.println(myClient.toString());
        }
	}
}
