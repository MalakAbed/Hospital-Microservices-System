
package com.patientmanagement.patientmanagement.repositories;

import com.patientmanagement.patientmanagement.models.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;


public interface DoctorRepository extends JpaRepository<Doctor, Long> {
    
}
