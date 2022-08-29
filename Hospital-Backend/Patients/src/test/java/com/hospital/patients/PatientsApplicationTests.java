package com.hospital.patients;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hospital.patients.Model.Patients;
import com.hospital.patients.Repository.PatientRepository;

@SpringBootTest
class PatientsApplicationTests {

	@Autowired
	private PatientRepository patientRepo;

	
	// For Reading All Data
	@Test
	public void testReadAll () {
		List<Patients> list = patientRepo.findAll();
		assertThat(list).size().isGreaterThan(0);
	}
	
	//For Deleting the Data
	@Test
	public void testDelete () {
		patientRepo.deleteById(58);
		assertThat(patientRepo.existsById(58)).isFalse();
	}
}
