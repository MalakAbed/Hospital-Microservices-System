
package com.patientmanagement.patientmanagement.services;

import com.patientmanagement.patientmanagement.models.Patient;
import com.patientmanagement.patientmanagement.models.PatientDoctor;
import com.patientmanagement.patientmanagement.models.PatientDoctorId;
import com.patientmanagement.patientmanagement.models.PatientDrug;
import com.patientmanagement.patientmanagement.repositories.PatientDoctorRepository;
import com.patientmanagement.patientmanagement.repositories.PatientDrugRepository;
import com.patientmanagement.patientmanagement.repositories.PatientRepository;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientService {
    
    @Autowired
    private PatientRepository patientRepository;
    @Autowired
    private PatientDoctorRepository patientDoctorRepository;
    @Autowired
    private PatientDrugRepository patientDrugRepository;
    
    public List<Patient> getAllPatients(){
        return this.patientRepository.findAll();
    }
    
    public Patient getPatientById(Long id){
        return this.patientRepository.findById(id).get();
    }
    
    public Patient addPatient(Patient patient){
        return this.patientRepository.save(patient);
    }
    
    public Patient updatePatient(Long id, Patient update) {
        Patient patient = getPatientById(id);
        patient.setName(update.getName()); 
        patient.setPassword(update.getPassword());
        patient.setAge(update.getAge());
        patient.setEmail(update.getEmail());
        patient.setGender(update.getGender());
        patient.setPhoneNumber(update.getPhoneNumber());
        patient.setEntranceDate(update.getEntranceDate());
        patient.setProblem(update.getProblem()); 
        
        return patientRepository.save(patient);
    }

    public void deletePatient(Long id) {
        patientRepository.deleteById(id);
    }

    // return all patients assigned to a doctor
    public List<Patient> getPatientsForDoctor(Long doctorId) {
        List<PatientDoctor> links = patientDoctorRepository.findByIdDocId(doctorId);
        List<Long> patIds = links.stream().map(l -> l.getId().getPatId()).toList();
        return patientRepository.findAllById(patIds);
    }
    
    public Patient assignPatientToDoctor(Long patId, Long docId) {
        PatientDoctorId id = new PatientDoctorId(patId, docId);
        if(!patientDoctorRepository.existsById(id)) {
            patientDoctorRepository.save(new PatientDoctor(id));
        }
        return getPatientById(patId);
    }
    
     // Unassign doctor from patient
    public void unassignDoctorFromPatient(Long patientId, Long doctorId) {
        PatientDoctorId id = new PatientDoctorId(patientId, doctorId);
        if(patientDoctorRepository.existsById(id)) {
            patientDoctorRepository.deleteById(id);
        }
    }
    
    // Get all doctors for a patient
    public List<PatientDoctor> getDoctorsForPatient(Long patientId) {
        return patientDoctorRepository.findByIdPatId(patientId);
    }

    public List<Patient> getPatientsByDrugId(Long drugId) {
        return patientRepository.findByDrugId(drugId);
    }
    

}
