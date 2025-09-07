package com.drugmanagement.drugmanagement.repositories;

import com.drugmanagement.drugmanagement.models.Pharmacist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PharmacistRepository extends JpaRepository<Pharmacist, Long> {
}
