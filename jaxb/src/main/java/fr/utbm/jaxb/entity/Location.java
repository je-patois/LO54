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

@Entity
public class Location implements Serializable {
	
	private static final long serialVersionUID = 1L;

	public Location() {
		
	}
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	private Integer id;
	
	@Column(name="CITY")
	private String city;
	
	/*@ManyToMany
	  @JoinTable(
	      name="CourseSession",
	      joinColumns=@JoinColumn(name="LOCATION_ID", referencedColumnName="id"), inverseJoinColumns=@JoinColumn(name="COURSE_CODE", referencedColumnName="code"))
	  private List<Course> courses;*/
	
	/*@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="ID")
	private Set<CourseSession> courseSessions;*/

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
