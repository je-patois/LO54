package fr.utbm.jaxb.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class CourseSession implements Serializable{

	public CourseSession() {
		
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	private Integer id;
	
	@Column(name="START_DATE")
	private Date startDate;
	
	@Column(name="END_DATE")
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
	
	@ManyToOne(cascade = CascadeType.ALL)
	//@Column(name="COURSE_CODE")
	private Course course;
	
	@ManyToOne(cascade = CascadeType.ALL)
	//@Column(name="LOCATION_ID")
	private Location location;

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



	/*@Override
	public String toString() {
		return "CourseSession [id=" + id + ", startDate=" + startDate + ", endDate=" + endDate + ", courseCode="
				+ courseCode + ", locationId=" + locationId + "]";
	}

	public String getCourseCode() {
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
