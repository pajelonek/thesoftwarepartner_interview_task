package org.github.pajelonek.softwarepartner.schoolbiilingapi.service;

import lombok.AllArgsConstructor;
import org.github.pajelonek.softwarepartner.schoolbiilingapi.model.dao.Parent;
import org.github.pajelonek.softwarepartner.schoolbiilingapi.model.dao.School;
import org.github.pajelonek.softwarepartner.schoolbiilingapi.model.dto.ParentBillingDTO;
import org.github.pajelonek.softwarepartner.schoolbiilingapi.model.dto.SchoolBillingDTO;
import org.github.pajelonek.softwarepartner.schoolbiilingapi.repository.ParentRepository;
import org.github.pajelonek.softwarepartner.schoolbiilingapi.repository.SchoolRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class SchoolService {

    private final ParentRepository parentRepository;
    private final SchoolRepository schoolRepository;
    private final ParentService parentService;

    public SchoolBillingDTO calculateSchoolBilling(Long id, Integer month, Integer year) {
        School school = schoolRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("School not found")); // todo fix

        List<Parent> parents = parentRepository.findParentsBySchoolIdAndChildrenAttendanceByMonth(school.getId(), year, month);
        List<ParentBillingDTO> parentBillingDTOs = new ArrayList<>();

        for (Parent parent : parents) {
            parentBillingDTOs.add(parentService.calculateParentBilling(parent.getId(), month, year));
        }

        return SchoolBillingDTO.builder()
                .schoolId(school.getId())
                .schoolName(school.getName())
                .parentBillingDTOs(parentBillingDTOs)
                .totalPayment(parentBillingDTOs.stream()
                        .map(ParentBillingDTO::getTotalPayment)
                        .reduce(BigDecimal.ZERO, BigDecimal::add))
                .build();
    }
}
