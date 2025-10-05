package com.patientmanagement.patientmanagement.services;

import com.patientmanagement.patientmanagement.models.Doctor;
import com.patientmanagement.patientmanagement.repositories.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }

    public Doctor getDoctorById(Long id) {
        return doctorRepository.findById(id).orElseThrow();
    }

    public Doctor addDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    public Doctor updateDoctor(Long id, Doctor update) {
        Doctor doctor = getDoctorById(id);
        doctor.setName(update.getName());
        doctor.setEmail(update.getEmail());
        doctor.setPassword(update.getPassword());
        doctor.setPhoneNumber(update.getPhoneNumber());
        return doctorRepository.save(doctor);
    }

    public void deleteDoctor(Long id) {
        doctorRepository.deleteById(id);
    }
}
