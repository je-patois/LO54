package fr.utbm.jaxb.entity;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Client implements Serializable{

	private static final long serialVersionUID = 1L;

	public Client() {
		
	}
	
	public Client(String lastname, String firstname, String adress, String phone, String email) {
		this.lastname = lastname;
		this.firstname = firstname;
		this.adress = adress;
		this.phone = phone;
		this.email = email;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	private Integer id;
	
	@Column(name="LASTNAME")
	private String lastname;
	
	@Column(name="FIRSTNAME")
	private String firstname;
	
	@Column(name="ADRESS")
	private String adress;
	
	@Column(name="PHONE")
	private String phone;
	
	@Column(name="EMAIL")
	private String email;
	
	/*@Column(name="COURSE_SESSION_ID")
	private Integer courseSessionId;*/
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="COURSE_SESSION_ID")
	private CourseSession courseSessionId;
	
	/*@OneToMany
    @JoinColumn(name="CLIENTS", referencedColumnName="id")
    private Collection<CourseSession> courseSession;*/
	
	/*@Transient
	private Integer courseSessionId;*/

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}



	@Override
	public String toString() {
		return "Client [id=" + id + ", lastname=" + lastname + ", firstname=" + firstname + ", adress=" + adress
				+ ", phone=" + phone + ", email=" + email + ", courseSession=" + courseSessionId + "]";
	}

	public CourseSession getCourseSessionId() {
		return courseSessionId;
	}

	public void setCourseSessionId(CourseSession courseSessionId) {
		this.courseSessionId = courseSessionId;
	}
	
	

	/*public Integer getCourseSessionId() {
		return courseSession.getId();
	}

	public void setCourseSessionId(Integer courseSessionId) {
		this.courseSessionId = courseSessionId;
	}*/
	
	
	
}
