package com.hospital.doctors.VO;

public class Patients {
	
	private int id;
	private String name;		
	private String visitedDoctors;
	private String dateOfVisit;
	
	public Patients() {
		super();
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
	
	
}
