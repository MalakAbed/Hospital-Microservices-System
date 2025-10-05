package com.patientmanagement.patientmanagement.models;

import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class PatientDrugId implements Serializable {
    private Integer patId;
    private Long drugId;
}
