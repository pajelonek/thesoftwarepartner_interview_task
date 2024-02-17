package org.github.pajelonek.softwarepartner.schoolbiilingapi.model.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class ChildBillingDTO {
    private Long childId;
    private String childFirstName;
    private String childLastName;
    private BigDecimal totalPayment;
    private BigDecimal hoursInSchool;
}