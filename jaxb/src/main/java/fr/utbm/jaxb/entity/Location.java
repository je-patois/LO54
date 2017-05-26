package fr.utbm.jaxb.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

/** 
 * [Entité] - Location
 */
@Entity
public class Location implements Serializable {
	
	// --------- DEFINITION DES VARIABLES ---------
	private static final long serialVersionUID = 1L;
	
	@Id // Identifiant en BDD
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-increment en BDD
	@Column(name="ID") // Nom de colonne en BDD
	private Integer id;
	
	@Column(name="CITY") // Nom de colonne en BDD
	private String city;
	
	/*@ManyToMany
	  @JoinTable(
	      name="CourseSession",
	      joinColumns=@JoinColumn(name="LOCATION_ID", referencedColumnName="id"), inverseJoinColumns=@JoinColumn(name="COURSE_CODE", referencedColumnName="code"))
	  private List<Course> courses;*/
	
	/*@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="ID")
	private Set<CourseSession> courseSessions;*/

	
	// --------- CONSTRUCTEURS ---------
	
	/**
	 * Constructeur par défaut
	 */
	public Location() {
		
	}
	
	/**
	 * Constructeur complet
	 * @return
	 */
	public Location(int id, String city) {
		this.id = id;
		this.city = city;
	}
	
	
	// --------- GETTERS & SETTERS, toString ---------
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "Location [id=" + id + ", city=" + city + "]";
	}	
}
