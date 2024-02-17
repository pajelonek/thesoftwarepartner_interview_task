package org.github.pajelonek.softwarepartner.schoolbiilingapi.model.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
public class ParentBillingDTO {
    private Long parentId;
    private String parentFirstName;
    private String parentLastName;
    private BigDecimal totalPayment;
    private List<ChildBillingDTO> childrenBilling;
}