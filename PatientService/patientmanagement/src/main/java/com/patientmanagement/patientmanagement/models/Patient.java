
package com.patientmanagement.patientmanagement.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "patients")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Long drugId;
    private String name;
    private String email;
    private String password;
    private Integer age;
    private String gender;
    private String problem;        
    private String entranceDate;
    private String phoneNumber;
       
    
}
