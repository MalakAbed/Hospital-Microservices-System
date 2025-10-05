
package com.drugmanagement.drugmanagement.repositories;

import com.drugmanagement.drugmanagement.models.Drug;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DrugRepository extends JpaRepository<Drug, Long>{
    
}
