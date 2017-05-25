package fr.utbm.jaxb.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

/**
 * [Entité] - Client
 */
@Entity
public class Client implements Serializable{
	
	
	// --------- DEFINITION DES VARIABLES ---------
	
	private static final long serialVersionUID = 1L;
	
	@Id // Identifiant en BDD
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-increment en BDD
	@Column(name="ID") // Nom de la colonne en BDD
	private Integer id;
	
	@Column(name="LASTNAME") // Nom de la colonne en BDD
	private String lastname;
	
	@Column(name="FIRSTNAME") // Nom de la colonne en BDD
	private String firstname;
	
	@Column(name="ADRESS") // Nom de la colonne en BDD
	private String adress;
	
	@Column(name="PHONE") // Nom de la colonne en BDD
	private String phone;
	
	@Column(name="EMAIL") // Nom de la colonne en BDD
	private String email;
	
	/*@Column(name="COURSE_SESSION_ID")
	private Integer courseSessionId;*/
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="COURSE_SESSION_ID")
	private CourseSession courseSessionId;
	
	/*@OneToMany
    @JoinColumn(name="CLIENTS", referencedColumnName="id")
    private Collection<CourseSession> courseSession;*/
	
	/*@Transient
	private Integer courseSessionId;*/

	
	
	// --------- CONSTRUCTEURS ---------
	
	/**
	 * Constructeur par défaut
	 */
	public Client() {
		
	}
	
	/**
	 * Constructeur complet
	 * @param lastname
	 * @param firstname
	 * @param adress
	 * @param phone
	 * @param email
	 */
	public Client(String lastname, String firstname, String adress, String phone, String email) {
		this.lastname = lastname;
		this.firstname = firstname;
		this.adress = adress;
		this.phone = phone;
		this.email = email;
	}
	
	
	// --------- GETTERS & SETTERS, toString ---------
	
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

	public CourseSession getCourseSessionId() {
		return courseSessionId;
	}

	public void setCourseSessionId(CourseSession courseSessionId) {
		this.courseSessionId = courseSessionId;
	}

	@Override
	public String toString() {
		return "Client [id=" + id + ", lastname=" + lastname + ", firstname=" + firstname + ", adress=" + adress
				+ ", phone=" + phone + ", email=" + email + ", courseSession=" + courseSessionId + "]";
	}	

	/*public Integer getCourseSessionId() {
		return courseSession.getId();
	}

	public void setCourseSessionId(Integer courseSessionId) {
		this.courseSessionId = courseSessionId;
	}*/
}
