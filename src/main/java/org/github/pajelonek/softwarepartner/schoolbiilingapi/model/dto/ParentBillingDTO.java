package org.github.pajelonek.softwarepartner.schoolbiilingapi.model.dto;

import java.math.BigDecimal;
import java.util.List;

public record ParentBillingDTO(
        Long parentId,
        String parentFirstName,
        String parentLastName,
        BigDecimal totalPayment,
        List<ChildBillingDTO> childrenBilling
) {}