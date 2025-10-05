package com.patientmanagement.patientmanagement.models;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import lombok.*;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class PatientDoctorId implements Serializable {
    private Long patId;
    private Long docId;
}