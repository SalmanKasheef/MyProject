package com.hospital.doctors.Controller;

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
import com.hospital.doctors.Model.Doctors;

import com.hospital.doctors.Service.DoctorService;
import com.hospital.doctors.VO.RequestTemplateVO;


@RestController
@RequestMapping("/hospital")
@CrossOrigin(origins="http://localhost:4200")
public class DoctorController {

	
	@Autowired
	private DoctorService doctorService;
	
	//get all doctors
	@GetMapping("/doctors")
	public List<Doctors> getAllDoctors(){
		return doctorService.findDoctors();
	}
	
	//create new doctor
	@PostMapping("/doctors")
	public Doctors createDoctor(@RequestBody Doctors doctor) {
		return doctorService.saveDoctor(doctor);
	}
	
	//get Doctor by id
	@GetMapping("/doctors/{id}")
	public Doctors getById(@PathVariable int id){
		return doctorService.findById(id);			
	}
	
	//Update doctors by Id
	@PutMapping("/doctors/{id}")
	public ResponseEntity<Doctors> UpdateById(@PathVariable int id,@RequestBody Doctors doctors){
		 return doctorService.UpdateById(id, doctors);
						
	}
	
	//Delete doctor by id
	@DeleteMapping("/doctors/{id}")
	public ResponseEntity<Map<String,Boolean>>deleteDoctor(@PathVariable int id){
		 return doctorService.Delete(id);
				
	}
	//restTemplate
	@GetMapping("/doctors/all-patients")
	public List<RequestTemplateVO> allPatient(){
		return doctorService.allPatients();
	}
	
	//restTemplate for getting by id
	@GetMapping("/doctors/getById/{id}")
	public RequestTemplateVO specificPatientDoc(@PathVariable int id) {
		return doctorService.specificPatientDoc(id);
	}
}
