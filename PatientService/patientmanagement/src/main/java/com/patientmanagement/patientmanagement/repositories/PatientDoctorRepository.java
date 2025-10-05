
package com.patientmanagement.patientmanagement.repositories;

import com.patientmanagement.patientmanagement.models.PatientDoctor;
import com.patientmanagement.patientmanagement.models.PatientDoctorId;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientDoctorRepository extends JpaRepository<PatientDoctor, PatientDoctorId> {
    List<PatientDoctor> findByIdPatId(Long patId);
    List<PatientDoctor> findByIdDocId(Long doctorId);
}
