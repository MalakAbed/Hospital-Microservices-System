package com.drugmanagement.drugmanagement.services;

import com.drugmanagement.drugmanagement.models.Pharmacist;
import com.drugmanagement.drugmanagement.repositories.PharmacistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PharmacistService {

    @Autowired
    private PharmacistRepository pharmacistRepository;

    public List<Pharmacist> getAllPharmacists() {
        return pharmacistRepository.findAll();
    }

    public Pharmacist getPharmacistById(Long id) {
        return pharmacistRepository.findById(id).orElseThrow();
    }

    public Pharmacist addPharmacist(Pharmacist pharmacist) {
        return pharmacistRepository.save(pharmacist);
    }

    public Pharmacist updatePharmacist(Long id, Pharmacist updated) {
        Pharmacist pharmacist = getPharmacistById(id);
        pharmacist.setName(updated.getName());
        pharmacist.setEmail(updated.getEmail());
        pharmacist.setPassword(updated.getPassword());
        pharmacist.setPhoneNumber(updated.getPhoneNumber());
        return pharmacistRepository.save(pharmacist);
    }

    public void deletePharmacist(Long id) {
        pharmacistRepository.deleteById(id);
    }
}
