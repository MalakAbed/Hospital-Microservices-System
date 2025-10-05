package com.druginteractionchecker.druginteractioncheckerservice.kafka;

import com.druginteractionchecker.druginteractioncheckerservice.models.DrugAssignedEvent;
import com.druginteractionchecker.druginteractioncheckerservice.services.DrugInteractionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class DrugAssignedConsumer {

    @Autowired
    private DrugInteractionService drugInteractionService;

    @KafkaListener(topics = "drug-assigned-events", groupId = "drug-interaction-group")
    public void listen(DrugAssignedEvent event) {
        System.out.println("Received DrugAssignedEvent: " + event);
        drugInteractionService.checkDrugInteraction(event.getPatientId(), event.getDrugId());
    }
}