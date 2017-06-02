package fr.utbm.jaxb.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * [Entité] - Course
 */
@Entity
public class Course implements Serializable {
	
	// --------- DEFINITION DES VARIABLES ---------
	
	private static final long serialVersionUID = 1L;
	
	@Id // Identifiant en BDD
	@Column(name="CODE") // Nom de la colonne en BDD
	private String code;
	
	@Column(name="TITLE") // Nom de la colonne en BDD
	private String title;

	
	// --------- CONSTRUCTEURS ---------
	
	/**
	 * Constructeur par défaut
	 */
	public Course() {
		
	}
	
	/**
	 * Constructeur complet
	 * @param code
	 * @param title
	 */
	public Course(String code, String title) {
		this.code = code;
		this.title = title;
	}
	
	
	// --------- GETTERS & SETTERS, toString ---------

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return "Course [code=" + code + ", title=" + title + "]";
	}	
}
