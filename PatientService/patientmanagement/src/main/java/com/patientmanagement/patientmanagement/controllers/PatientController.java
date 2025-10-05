/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.patientmanagement.patientmanagement.controllers;

import com.patientmanagement.patientmanagement.models.Patient;
import com.patientmanagement.patientmanagement.models.PatientDoctor;
import com.patientmanagement.patientmanagement.services.PatientService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/patients")
public class PatientController {
    
    @Autowired
    private PatientService patientService;
    
    @GetMapping("/")
    public ResponseEntity<List<Patient>> showAllPatients() {
        List<Patient> patients = this.patientService.getAllPatients();
        return new ResponseEntity(patients, HttpStatus.OK);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Patient> getPatientById(@PathVariable Long id) {
        Patient retrievedPatient = this.patientService.getPatientById(id);
        return new ResponseEntity<>(retrievedPatient, HttpStatus.OK);
    }
    
    @PostMapping("/add")
    public ResponseEntity<Patient> addPatient(@RequestBody Patient patient){
        Patient newPatient = this.patientService.addPatient(patient);
        return new ResponseEntity<>(newPatient, HttpStatus.CREATED);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Patient> updatePatient(@PathVariable Long id, @RequestBody Patient patient) {
        Patient updated = this.patientService.updatePatient(id, patient);
        return new ResponseEntity<>(updated, HttpStatus.OK);      
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePatient(@PathVariable Long id) {
        this.patientService.deletePatient(id);
        return ResponseEntity.noContent().build();
    }
    
    @PostMapping("/{pid}/assign/{did}")
    public ResponseEntity<Patient> assignToDoctor(@PathVariable Long pid, @PathVariable Long did) {
        Patient assigned = this.patientService.assignPatientToDoctor(pid, did);
        return new ResponseEntity<>(assigned, HttpStatus.OK);
    }

    @GetMapping("/doctor/{doctorId}")
    public ResponseEntity<List<Patient>> patientsForDoctor(@PathVariable Long doctorId) {
        List<Patient> patients = this.patientService.getPatientsForDoctor(doctorId);
        return new ResponseEntity<>(patients, HttpStatus.OK);
    }
    
     // Unassign doctor from patient
    @DeleteMapping("/{patientId}/unassign/{doctorId}")
    public ResponseEntity<Void> unassignDoctor(@PathVariable Long patientId, @PathVariable Long doctorId) {
        this.patientService.unassignDoctorFromPatient(patientId, doctorId);
        return ResponseEntity.noContent().build();
   
    }

    // Get all doctors for a patient
    @GetMapping("/{patientId}/doctors")
    public ResponseEntity<List<PatientDoctor>> getDoctorsForPatient(@PathVariable Long patientId) {
        List<PatientDoctor> doctors = this.patientService.getDoctorsForPatient(patientId);
        return ResponseEntity.ok(doctors);
    }

    @GetMapping("/drug/{drugId}")
    public ResponseEntity<List<Patient>> getPatientsByDrugId(@PathVariable Long drugId) {
        List<Patient> patients = this.patientService.getPatientsByDrugId(drugId);
        return new ResponseEntity<>(patients, HttpStatus.OK);
    }
}
