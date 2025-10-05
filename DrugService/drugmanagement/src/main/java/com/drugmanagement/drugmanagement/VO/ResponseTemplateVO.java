
package com.drugmanagement.drugmanagement.VO;

import com.drugmanagement.drugmanagement.models.Drug;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseTemplateVO {
    
    private Drug drug;
    private List<Patient> patients;
}
