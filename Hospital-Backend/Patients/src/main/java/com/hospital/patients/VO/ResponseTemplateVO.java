package com.hospital.patients.VO;

import com.hospital.patients.Model.Patients;

public class ResponseTemplateVO {

	private Patients patients;
	private Doctors doctor;
	
	public Patients getPatients() {
		return patients;
	}
	public void setPatients(Patients patients) {
		this.patients = patients;
	}
	public Doctors getDoctor() {
		return doctor;
	}
	public void setDoctor(Doctors doctor) {
		this.doctor = doctor;
	}
	public ResponseTemplateVO(Patients patients, Doctors doctor) {
		super();
		this.patients = patients;
		this.doctor = doctor;
	}
	public ResponseTemplateVO() {
		super();
		// TODO Auto-generated constructor stub
	}
}
