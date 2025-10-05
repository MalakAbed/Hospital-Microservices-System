package com.drugmanagement.drugmanagement.controllers;

import com.drugmanagement.drugmanagement.models.Pharmacist;
import com.drugmanagement.drugmanagement.services.PharmacistService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
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
@RequestMapping("/pharmacists")
public class PharmacistController {

    @Autowired
    private PharmacistService pharmacistService;

    @GetMapping("/")
    public ResponseEntity<List<Pharmacist>> getAllPharmacists() {
        return new ResponseEntity<>(pharmacistService.getAllPharmacists(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pharmacist> getPharmacistById(@PathVariable Long id) {
        return new ResponseEntity<>(pharmacistService.getPharmacistById(id), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Pharmacist> addPharmacist(@RequestBody Pharmacist pharmacist) {
        return new ResponseEntity<>(pharmacistService.addPharmacist(pharmacist), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pharmacist> updatePharmacist(@PathVariable Long id, @RequestBody Pharmacist pharmacist) {
        return new ResponseEntity<>(pharmacistService.updatePharmacist(id, pharmacist), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePharmacist(@PathVariable Long id) {
        pharmacistService.deletePharmacist(id);
        return ResponseEntity.noContent().build();
    }
}
