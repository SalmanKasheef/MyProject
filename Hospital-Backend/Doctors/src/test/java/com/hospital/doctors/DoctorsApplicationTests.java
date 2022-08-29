package com.hospital.doctors;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hospital.doctors.Model.Doctors;
import com.hospital.doctors.Repository.DoctorsRepository;


@SpringBootTest
class DoctorsApplicationTests {

	@Autowired
	private DoctorsRepository docRepo;
	
	@Test
	public void testReadAll () {
		List<Doctors> list = docRepo.findAll();
		assertThat(list).size().isGreaterThan(0);
	}
	
	//For Deleting the Data
	@Test
	public void testDelete () {
		docRepo.deleteById(2132);
		assertThat(docRepo.existsById(2132)).isFalse();
	}
}
