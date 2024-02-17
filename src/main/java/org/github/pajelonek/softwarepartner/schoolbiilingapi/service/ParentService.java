package org.github.pajelonek.softwarepartner.schoolbiilingapi.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.github.pajelonek.softwarepartner.schoolbiilingapi.config.BillingPeriodsProperties;
import org.github.pajelonek.softwarepartner.schoolbiilingapi.model.dao.Attendance;
import org.github.pajelonek.softwarepartner.schoolbiilingapi.model.dao.Child;
import org.github.pajelonek.softwarepartner.schoolbiilingapi.model.dao.Parent;
import org.github.pajelonek.softwarepartner.schoolbiilingapi.model.dto.ChildBillingDTO;
import org.github.pajelonek.softwarepartner.schoolbiilingapi.model.dto.ParentBillingDTO;
import org.github.pajelonek.softwarepartner.schoolbiilingapi.repository.AttendanceRepository;
import org.github.pajelonek.softwarepartner.schoolbiilingapi.repository.ParentRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class ParentService {

    private final ParentRepository parentRepository;
    private final AttendanceRepository attendanceRepository;
    private final BillingPeriodsProperties billingPeriodsProperties;

    public ParentBillingDTO calculateParentBilling(Long id, Integer month, Integer year) {
        log.trace("Calculating parent billing for id: {}, month: {}, year: {}", id, month, year);

        Parent parent = parentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Parent not found"));

        List<Child> children = parent.getChildren();

        List<ChildBillingDTO> childBillingDTOs = new ArrayList<>();

        for (Child child : children) {
            BigDecimal totalHoursInSchool = calculateTotalHoursInSchool(child.getId(), year, month);

            BigDecimal hourPrice = child.getSchool().getHourPrice();

            BigDecimal childBilling = calculateChildBilling(hourPrice, totalHoursInSchool);

            childBillingDTOs.add(ChildBillingDTO.builder()
                    .childId(child.getId())
                    .childFirstName(child.getFirstname())
                    .childLastName(child.getLastname())
                    .hoursInSchool(totalHoursInSchool)
                    .totalPayment(childBilling)
                    .build());
        }

        log.trace("Returning calculated parent billing for id: {}, month: {}, year: {}", id, month, year);
        return ParentBillingDTO.builder()
                .parentId(parent.getId())
                .parentFirstName(parent.getFirstname())
                .parentLastName(parent.getLastname())
                .totalPayment(childBillingDTOs.stream()
                        .map(ChildBillingDTO::getTotalPayment)
                        .reduce(BigDecimal.ZERO, BigDecimal::add))
                .childrenBilling(childBillingDTOs)
                .build();
    }

    private BigDecimal calculateChildBilling(BigDecimal hourPrice, BigDecimal totalHoursInSchool) {
        return hourPrice.multiply(totalHoursInSchool).setScale(2, RoundingMode.HALF_UP);
    }

    private BigDecimal calculateTotalHoursInSchool(Long childId, Integer year, Integer month) {
        List<Attendance> attendances = attendanceRepository.findByChildAndDate(childId, year, month);
        BigDecimal totalHoursInSchool = BigDecimal.ZERO;
        for (Attendance attendance : attendances) {
            totalHoursInSchool = totalHoursInSchool.add(calculateExtraPaidHoursForDay(attendance.getEntryDate(), attendance.getExitDate()));
        }
        return totalHoursInSchool;
    }

    private BigDecimal calculateExtraPaidHoursForDay(LocalDateTime entryDate, LocalDateTime exitDate) {
        LocalTime freePeriodStart = billingPeriodsProperties.getFreeStartTime();
        LocalTime freePeriodEnd = billingPeriodsProperties.getFreeEndTime();

        LocalTime entryTime = entryDate.toLocalTime();
        LocalTime exitTime = exitDate.toLocalTime();

        BigDecimal extraPaidHours = BigDecimal.ZERO;

        if (entryTime.isBefore(freePeriodStart)) {
            extraPaidHours = extraPaidHours.add(calculateExtraPaidHoursBetweenDates(freePeriodStart, entryTime));
        }

        if (exitTime.isAfter(freePeriodEnd)) {
            extraPaidHours = extraPaidHours.add(calculateExtraPaidHoursBetweenDates(freePeriodEnd, exitTime));
        }

        return extraPaidHours;
    }

    private BigDecimal calculateExtraPaidHoursBetweenDates(LocalTime startTime, LocalTime endTime) {
        BigDecimal minutes = BigDecimal.valueOf(Math.abs(Duration.between(startTime, endTime).toMinutes()));
        BigDecimal hours = minutes.divide(BigDecimal.valueOf(60), 0, RoundingMode.DOWN);
        if (minutes.remainder(BigDecimal.valueOf(60)).compareTo(BigDecimal.ZERO) > 0) {
            hours = hours.add(BigDecimal.ONE);
        }
        return hours;
    }
}
