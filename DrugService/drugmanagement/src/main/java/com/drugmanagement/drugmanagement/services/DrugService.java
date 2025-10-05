
package com.drugmanagement.drugmanagement.services;

import com.drugmanagement.drugmanagement.VO.Patient;
import com.drugmanagement.drugmanagement.VO.ResponseTemplateVO;
import com.drugmanagement.drugmanagement.models.Drug;
import com.drugmanagement.drugmanagement.models.DrugAssignedEvent;
import com.drugmanagement.drugmanagement.repositories.DrugRepository;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class DrugService {
    
    @Autowired
    private DrugRepository drugRepository;
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private KafkaProducerService kafkaProducerService;
    
    public List<Drug> getAllDrugs(){
        return this.drugRepository.findAll();
    }
    
    public Drug getDrugById(Long id){
        return this.drugRepository.findById(id).get();
    }
    
    public Drug addDrug(Drug drug){
        return this.drugRepository.save(drug);
    }
    
    public Drug updateDrug(Long id, Drug update) {
        Drug drug = this.drugRepository.findById(id).orElseThrow();
        drug.setName(update.getName());
        drug.setDosage(update.getDosage());
        drug.setProductionDate(update.getProductionDate());
        drug.setExpiryDate(update.getExpiryDate());
        return drugRepository.save(drug);
    }

    public void deleteDrug(Long id) {
        this.drugRepository.deleteById(id);
    }

    public ResponseTemplateVO getDrugWithPatientByDrugId(Long drugId) {
        Drug drug = this.getDrugById(drugId);
        
        Patient[] patients = this.restTemplate.getForObject("http://PATIENT-SERVICE:9001/patients/drug/"+drugId, Patient[].class);
               
        ResponseTemplateVO vo = new ResponseTemplateVO();
        
        vo.setDrug(drug);
        vo.setPatients(Arrays.asList(patients));
        return vo;
    }
     public void assignDrugToPatient(Long drugId, Long patientId) {
        log.info("Assigning drug {} to patient {}", drugId, patientId);
        Optional<Drug> drugOptional = drugRepository.findById(drugId);
        if (drugOptional.isPresent()) {
            Drug drug = drugOptional.get();
            DrugAssignedEvent event = new DrugAssignedEvent(patientId, drugId, drug.getName());
            kafkaProducerService.sendDrugAssignedEvent(event);
        } else {
            log.warn("Drug with ID {} not found, cannot assign to patient {}", drugId, patientId);
        }
    }
}

