package fr.utbm.jaxb.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * [Entité] - CourseSession
 */
@Entity
public class CourseSession implements Serializable{

	// --------- DEFINTIION DES VARIABLES ---------
	
	private static final long serialVersionUID = 1L;
	
	@Id // Identifiant en BDD
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-increment en BDD
	@Column(name="ID") // Nom de colonne en BDD
	private Integer id;
	
	@Column(name="START_DATE") // Nom de colonne en BDD
	private Date startDate;
	
	@Column(name="END_DATE") // Nom de colonne en BDD
	private Date endDate;
	
	/*@Column(name="COURSE_CODE")
	private String courseCode;
	
	@Column(name="LOCATION_ID")
	private Integer locationId;*/
	
	/*@Column(name="COURSE_CODE")
	//@OneToOne
	//@JoinColumn(name="COURSE", referencedColumnName="code")
	private String courseCode;
	//private Course courseCode;
	
	@Column(name="LOCATION_ID")
	//@OneToOne
    //@JoinColumn(name="LOCATION", referencedColumnName="id")
	private Integer locationId;
	//private Location location;
	
	@OneToMany(mappedBy="courseSessionId")
	private List<Client> clients;*/
	
	@ManyToOne(cascade = CascadeType.MERGE) // Relationnel
	//@Column(name="COURSE_CODE")
	private Course course;
	
	@ManyToOne(cascade = CascadeType.MERGE) // Relationnel
	//@Column(name="LOCATION_ID")
	private Location location;

	
	// --------- CONSTRUCTEURS ---------
	
	/**
	 * Constructeur par défaut
	 */
	public CourseSession() {
		
	}
	
	/** 
	 * Constructeur complet
	 * @param startDate
	 * @param endDate
	 */
	public CourseSession(Date startDate, Date endDate) {
		this.startDate = startDate;
		this.endDate = endDate;
	}
	
	
	// --------- GETTERS & SETTERS, toString ---------
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return "CourseSession [id=" + id + ", startDate=" + startDate + ", endDate=" + endDate + ", course=" + course
				+ ", location=" + location + "]";
	}

	/*public String getCourseCode() {
		return courseCode;
	}

	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}

	public Integer getLocationId() {
		return locationId;
	}

	public void setLocationId(Integer locationId) {
		this.locationId = locationId;
	}*/	
}
