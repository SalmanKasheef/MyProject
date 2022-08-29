package com.hospital.doctors.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hospital.doctors.Model.Doctors;

@Repository
public interface DoctorsRepository extends JpaRepository<Doctors,Integer>{

	

	

}
