package fr.utbm.jaxb.service;

import java.io.Serializable;
import java.util.List;

import fr.utbm.jaxb.entity.Location;
import fr.utbm.jaxb.repository.LocationDAO;

/**
 * [Couche - Service] - Entité Location
 */
public class LocationService implements Serializable {

	// --------- DEFINITION DES VARIABLES ---------
	
	private static final long serialVersionUID = 1L;
	private LocationDAO locationDao;
	
	
	// --------- CONSTRUCTEURS ---------
	
	/**
	 * Constructeur par défaut
	 */
	public LocationService() {
		locationDao = new LocationDAO();
	}

	
	// --------- GETTERS & SETTERS ---------
	
	public LocationDAO getLocationDao() {
		return locationDao;
	}

	public void setLocationDao(LocationDAO locationDao) {
		this.locationDao = locationDao;
	}
	
	
	// --------- METHODES ---------
	
	/**
	 * Récupère et renvoie toutes les villes
	 * @return
	 */
	public List<Location> getAllLocations() {
		List<Location> allLocations = locationDao.getLocation();
		return allLocations;
	}
	
	/**
	 * Récupère et renvoie la ville dont l'ID est donné en paramètre
	 * @param id
	 * @return
	 */
	public Location getLocationById(int id) {
		Location location = locationDao.getLocationById(id);
		return location;
	}
	
	/**
	 * Ajoute une ville passée en paramètre en base de données en avertissant de la réussite ou non de l'opération
	 */
	public boolean addLocation(Location location) {
		boolean success = locationDao.addLocation(location);
		return success;
	}
}
