package fr.utbm.jaxb.controller;

import java.io.Serializable;
import java.util.List;

import fr.utbm.jaxb.entity.Location;
import fr.utbm.jaxb.service.LocationService;

/**
 * [Couche: Controller] - Entité Location
 */
public class LocationController implements Serializable {

	// --------- DEFINITION DES VARIABLES ---------
	
	private static final long serialVersionUID = 1L;
	private LocationService locationService;
	
	
	// --------- CONSTRUCTEURS ---------
	
	public LocationController() {
		locationService = new LocationService();
	}

	
	// --------- GETTERS & SETTERS ---------
	
	public LocationService getLocationService() {
		return locationService;
	}

	public void setLocationService(LocationService locationService) {
		this.locationService = locationService;
	}
	
	
	// --------- METHODES ---------
	
	/** 
	 * Récupère et renvoie toutes les villes
	 * @return
	 */
	public List<Location> getAllLocations() {
		List<Location> allLocations = locationService.getAllLocations();
		return allLocations;
	}
	
	/** 
	 * Récupère et renvoie une ville dont l'ID est donné en paramètre
	 * @param id
	 * @return
	 */
	public Location getLocationById(int id) {
		Location location = locationService.getLocationById(id);
		return location;
	}
}
