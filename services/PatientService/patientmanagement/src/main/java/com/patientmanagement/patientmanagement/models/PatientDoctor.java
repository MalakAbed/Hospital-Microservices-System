package com.patientmanagement.patientmanagement.models;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "patientdoctor")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PatientDoctor {
    @EmbeddedId
    private PatientDoctorId id;
}
