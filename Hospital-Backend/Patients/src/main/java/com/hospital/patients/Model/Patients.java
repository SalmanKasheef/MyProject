package com.hospital.patients.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="patients")
public class Patients {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="DoctorsVisited")
	private String visitedDoctors;
	
	@Column(name="DateOfVisit")
	private String dateOfVisit;
	
	public Patients() {
		
	}
	
	public Patients(int id, String name, String visitedDoctors, String dateOfVisit) {
		super();
		this.id = id;
		this.name = name;
		this.visitedDoctors = visitedDoctors;
		this.dateOfVisit = dateOfVisit;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getVisitedDoctors() {
		return visitedDoctors;
	}

	public void setVisitedDoctors(String visitedDoctors) {
		this.visitedDoctors = visitedDoctors;
	}

	public String getDateOfVisit() {
		return dateOfVisit;
	}

	public void setDateOfVisit(String dateOfVisit) {
		this.dateOfVisit = dateOfVisit;
	}

	@Override
	public String toString() {
		return "Patients [id=" + id + ", name=" + name + ", visitedDoctors=" + visitedDoctors + ", dateOfVisit="
				+ dateOfVisit + "]";
	}

	
	
	
}
