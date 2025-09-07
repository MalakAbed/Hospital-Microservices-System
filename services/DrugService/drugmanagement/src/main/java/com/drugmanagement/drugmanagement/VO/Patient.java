/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.drugmanagement.drugmanagement.VO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Patient {
    private Integer id;
    private String name;
    private String email;
    private String password;
    private Integer age;
    private String gender;
    private String problem;        
    private String entranceDate;
    private String phoneNumber;
}
