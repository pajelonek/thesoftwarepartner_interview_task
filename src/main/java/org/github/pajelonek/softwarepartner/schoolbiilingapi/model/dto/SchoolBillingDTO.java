package org.github.pajelonek.softwarepartner.schoolbiilingapi.model.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
public class SchoolBillingDTO {
    private Long schoolId;
    private String schoolName;
    private BigDecimal totalPayment;
    private List<ParentBillingDTO> parentBillingDTOs;
}
