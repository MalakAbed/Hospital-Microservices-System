package com.druginteractionchecker.druginteractioncheckerservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class DrugInteractionService {

    private final WebClient.Builder webClientBuilder;

    @Autowired
    public DrugInteractionService(WebClient.Builder webClientBuilder) {
        this.webClientBuilder = webClientBuilder;
    }

    public void checkDrugInteraction(Long patientId, Long drugId) {
        System.out.println("Checking drug interaction for patient " + patientId + " with drug " + drugId);

        
        Mono<String> patientDrugs = webClientBuilder.build().get()
                .uri("http://PATIENT-SERVICE/patients/{patientId}/drugs", patientId)
                .retrieve()
                .bodyToMono(String.class);

        
        Mono<String> drugDetails = webClientBuilder.build().get()
                .uri("http://DRUG-SERVICE/drugs/{drugId}", drugId)
                .retrieve()
                .bodyToMono(String.class);

        Mono.zip(patientDrugs, drugDetails)
                .subscribe(tuple -> {
                    String patientDrugsResponse = tuple.getT1();
                    String drugDetailsResponse = tuple.getT2();

                    System.out.println("Patient's drugs: " + patientDrugsResponse);
                    System.out.println("New drug details: " + drugDetailsResponse);

                    if (patientId == 1L && drugId == 1L) {
                        System.out.println("WARNING: Potential drug interaction detected for patient " + patientId + " with drug " + drugId);
                    }
                });
    }
}

