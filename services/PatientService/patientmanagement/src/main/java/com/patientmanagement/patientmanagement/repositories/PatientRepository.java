
package com.patientmanagement.patientmanagement.repositories;

import com.patientmanagement.patientmanagement.models.Patient;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long>{
       List<Patient> findByDrugId(Long drugId);
}
