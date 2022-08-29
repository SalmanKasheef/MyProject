package com.hospital.doctors.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.hospital.doctors.Exception.ResourceNotFoundException;
import com.hospital.doctors.Model.Doctors;

import com.hospital.doctors.Repository.DoctorsRepository;
import com.hospital.doctors.VO.Patients;
import com.hospital.doctors.VO.RequestTemplateVO;

@Service
public class DoctorService {

	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private DoctorsRepository doctorRepository;

	public List<Doctors> findDoctors() {
		return doctorRepository.findAll();
	}

	public Doctors saveDoctor(Doctors doctor) {	
		return doctorRepository.save(doctor);
	}

	public Doctors findById(int id) {
		Doctors doctor= doctorRepository.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException("Doctor ID does not exist"+id));
		return doctor;
	}

	public ResponseEntity<Doctors> UpdateById(int id, Doctors doctors) {
		Doctors doctor= doctorRepository.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException("Doctor ID does not exist"+id));
		doctor.setId(doctors.getId());
		doctor.setName(doctors.getName());
		doctor.setAge(doctors.getAge());
		doctor.setGender(doctors.getGender());
		doctor.setSpecialist(doctors.getSpecialist());
		
		Doctors updatedDoctor=doctorRepository.save(doctor);
		return ResponseEntity.ok(updatedDoctor);

	}

	public  ResponseEntity<Map<String,Boolean>> Delete(int id) {
		Doctors doctor= doctorRepository.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException("Doctor ID does not exist"+id));
		doctorRepository.delete(doctor);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}

	public List<RequestTemplateVO>allPatients(){
		List<RequestTemplateVO> list=new ArrayList <RequestTemplateVO>();
		List<Doctors> allDoctors=this.findDoctors();
		Iterator<Doctors> ir=allDoctors.iterator();
		while(ir.hasNext()) {
			Doctors dc=ir.next();
			ResponseEntity<Patients[]> response=
					restTemplate.getForEntity(
							"http://PATIENTS/hospital/patients/patient-with-doctor/"+dc.getId(),Patients[].class);
			Patients[] patients=response.getBody();
			List<Patients>pat=Arrays.asList(patients);
			RequestTemplateVO req=new RequestTemplateVO();
			req.setDoctor(dc);
			req.setPatients(pat);
			list.add(req);
		} 
		return list;
	}
	
	public RequestTemplateVO specificPatientDoc(int doc_id) {
		Doctors doctor =this.findById(doc_id);
		
		ResponseEntity<Patients[]>response=
				restTemplate.getForEntity("http://PATIENTS/hospital/patient/getById/"+doctor.getId(),
						Patients[].class
						);
		Patients[] patient=response.getBody();
		List<Patients> patients=Arrays.asList(patient);
		RequestTemplateVO request=new RequestTemplateVO();
		
		request.setDoctor(doctor);
		request.setPatients(patients);
		
		return request;
	}
}
