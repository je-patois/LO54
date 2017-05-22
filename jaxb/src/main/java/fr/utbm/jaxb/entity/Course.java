package fr.utbm.jaxb.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Course implements Serializable {
	
	private static final long serialVersionUID = 1L;

	public Course() {
		
	}
	
	public Course(String code, String title) {
		this.code = code;
		this.title = title;
	}
	
	@Id
	@Column(name="CODE")
	private String code;
	
	@Column(name="TITLE")
	private String title;

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
