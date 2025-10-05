
package com.drugmanagement.drugmanagement.controllers;

import com.drugmanagement.drugmanagement.VO.ResponseTemplateVO;
import com.drugmanagement.drugmanagement.models.Drug;
import com.drugmanagement.drugmanagement.services.DrugService;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
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
@RequestMapping("/drugs")
@Slf4j
public class DrugController {
    
    @Autowired
    private DrugService drugService;
    
    @GetMapping("/")
    public ResponseEntity<List<Drug>> getAllDrugs() {
        List<Drug> drugs = this.drugService.getAllDrugs();
        return new ResponseEntity<>(drugs, HttpStatus.OK);
    }
    
//    @GetMapping("/{id}")
//    public ResponseEntity<Drug> getDrugById(@PathVariable Long id) {
//        Drug drug = this.drugService.getDrugById(id);
//        return new ResponseEntity<>(drug, HttpStatus.OK);
//    }
    
    @PostMapping("/add")
    public ResponseEntity<Drug> addDrug(@RequestBody Drug drug) {
        return new ResponseEntity<>(this.drugService.addDrug(drug), HttpStatus.CREATED);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Drug> updateDrug(@PathVariable Long id, @RequestBody Drug drug) {
        return new ResponseEntity<>(drugService.updateDrug(id, drug), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDrug(@PathVariable Long id) {
        drugService.deleteDrug(id);
        return ResponseEntity.noContent().build();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<ResponseTemplateVO> getDrugWithPatient(@PathVariable("id") Long drugId) {
        this.drugService.getDrugById(drugId);
        ResponseTemplateVO vo = this.drugService.getDrugWithPatientByDrugId(drugId);
        return new ResponseEntity<>(vo, HttpStatus.OK);
    }
    
    @GetMapping("/{id}/with-patients")
    public ResponseEntity<ResponseTemplateVO> getDrugWithPatientByDrugId(@PathVariable("id") Long drugId) {
    ResponseTemplateVO vo = this.drugService.getDrugWithPatientByDrugId(drugId);
    return new ResponseEntity<>(vo, HttpStatus.OK);
}
    @PostMapping("/{drugId}/assignToPatient/{patientId}")
    public ResponseEntity<String> assignDrugToPatient(@PathVariable("drugId") Long drugId, @PathVariable("patientId") Long patientId) {
        log.info("Inside assignDrugToPatient of DrugController");
        drugService.assignDrugToPatient(drugId, patientId);
        return new ResponseEntity<>("Drug assignment event published", HttpStatus.OK);
    }
}
