package com.patientmanagement.patientmanagement.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "patientdrug")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PatientDrug {
    @EmbeddedId
    private PatientDrugId id;
    private Long assignedAt;
}
