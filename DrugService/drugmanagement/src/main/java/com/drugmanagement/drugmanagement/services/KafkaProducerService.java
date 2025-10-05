package com.drugmanagement.drugmanagement.services;

import com.drugmanagement.drugmanagement.models.DrugAssignedEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerService {

    private static final String TOPIC = "drug-assigned-events";

    @Autowired
    private KafkaTemplate<String, DrugAssignedEvent> kafkaTemplate;

    public void sendDrugAssignedEvent(DrugAssignedEvent event) {
        kafkaTemplate.send(TOPIC, event);
        System.out.println("Produced DrugAssignedEvent: " + event);
    }
}

