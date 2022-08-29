package com.hospital.patients.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.hospital.patients.Model.Patients;

import com.hospital.patients.Repository.PatientRepository;
import com.hospital.patients.VO.Doctors;
import com.hospital.patients.VO.ResponseTemplateVO;

@RestController
@RequestMapping("/hospital")
@CrossOrigin(origins="http://localhost:4200")
public class PatientController {

	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private PatientRepository patientRepository;
	
	//get all patients
	@GetMapping("/patients")
	public List<Patients> getAll(){
		return patientRepository.findAll();
	}
	
	//add the patients
	@PostMapping("/patients")
	public Patients addPatient(@RequestBody Patients patient) {
		return patientRepository.save(patient);
	}
	
	// get the patient by id
	@GetMapping("/patients/{id}")
	public ResponseEntity<Patients>getById(@PathVariable int id){
		Patients patient=patientRepository.findById(id);
				
		return ResponseEntity.ok(patient);
	}
	//updating patient information
	@PutMapping("/patients/{id}")
	public ResponseEntity<Patients>Update(@PathVariable int id,@RequestBody Patients patientdetails ){
		Patients patient=patientRepository.findById(id);
				
//		patient.setId(patientdetails.getId());
		patient.setName(patientdetails.getName());
		patient.setVisitedDoctors(patientdetails.getVisitedDoctors());
		patient.setDateOfVisit(patientdetails.getDateOfVisit());
		
		Patients updatedPatient=patientRepository.save(patient);
		return ResponseEntity.ok(updatedPatient);
	}
	
	@DeleteMapping("/patients/{id}")
	public ResponseEntity<Map<String,Boolean>>Delete(@PathVariable int id ){
		Patients patient=patientRepository.findById(id)
			;
		patientRepository.delete(patient);
		
		Map<String,Boolean>response=new HashMap<>();
		response.put("Deleted",Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	
	@GetMapping("/patients/patient-with-doctor/{id}")
	public ResponseTemplateVO patientWithDoctor(@PathVariable int id) {
		ResponseTemplateVO res=new ResponseTemplateVO();
		Patients patient=patientRepository.findById(id);
		
		long pat=patient.getId();
		Doctors doc=restTemplate.getForObject("http://DOCTORS/hospital/doctors/"+pat, Doctors.class);
		res.setDoctor(doc);
		res.setPatients(patient);
		return res;
	}

	@GetMapping("/getById/{doc_id}")
	public List<Patients> getByDocId(@PathVariable int id){
		return patientRepository.getByDocId(id);
	}
	
}
