/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.patientmanagement.patientmanagement.repositories;

import com.patientmanagement.patientmanagement.models.PatientDrug;
import com.patientmanagement.patientmanagement.models.PatientDrugId;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PatientDrugRepository extends JpaRepository<PatientDrug, PatientDrugId> {
    List<PatientDrug> findByIdPatId(Long doctorId);

}
