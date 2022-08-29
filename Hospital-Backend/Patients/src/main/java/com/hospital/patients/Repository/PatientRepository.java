package com.hospital.patients.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.query.Param;

import com.hospital.patients.Model.Patients;

@Repository
public interface PatientRepository extends JpaRepository<Patients,Integer> {
	Patients findById(int id);

	@Query(value="SELECT * FROM patients WHERE id=:id ORDER BY age DESC",nativeQuery=true)
	List<Patients> getByDocId(@Param("id") int id);

	
	

	
}
