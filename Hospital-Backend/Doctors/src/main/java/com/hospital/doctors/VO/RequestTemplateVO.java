package com.hospital.doctors.VO;

import java.util.ArrayList;
import java.util.List;

import com.hospital.doctors.Model.Doctors;

public class RequestTemplateVO {

	private Doctors doctor;
	private List<Patients>patients =new ArrayList<Patients>();
	
	public Doctors getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctors doctor) {
		this.doctor = doctor;
	}

	public List<Patients> getPatients() {
		return patients;
	}

	public void setPatients(List<Patients> patients) {
		this.patients = patients;
	}

	public RequestTemplateVO(Doctors doctor, List<Patients> patients) {
		super();
		this.doctor = doctor;
		this.patients = patients;
	}

	public RequestTemplateVO() {
		super();
		// TODO Auto-generated constructor stub
	}
}
