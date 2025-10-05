package com.druginteractionchecker.druginteractioncheckerservice.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DrugAssignedEvent {
    private Long patientId;
    private Long drugId;
    private String drugName;
   
}

