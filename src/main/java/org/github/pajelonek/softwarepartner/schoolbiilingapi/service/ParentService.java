package org.github.pajelonek.softwarepartner.schoolbiilingapi.service;

import lombok.AllArgsConstructor;
import org.github.pajelonek.softwarepartner.schoolbiilingapi.model.dao.Attendance;
import org.github.pajelonek.softwarepartner.schoolbiilingapi.model.dao.Child;
import org.github.pajelonek.softwarepartner.schoolbiilingapi.repository.AttendanceRepository;
import org.github.pajelonek.softwarepartner.schoolbiilingapi.repository.ChildRepository;
import org.github.pajelonek.softwarepartner.schoolbiilingapi.repository.ParentRepository;
import org.github.pajelonek.softwarepartner.schoolbiilingapi.repository.SchoolRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
public class ParentService {

    private ParentRepository parentRepository;
    private AttendanceRepository attendanceRepository;
    private SchoolRepository schoolRepository;
    private ChildRepository childRepository;

    public void billing(Long id, Integer month, Integer year) {
        if (year == null) {
            year = LocalDate.now().getYear();
        }
        LocalDate date = LocalDate.of(year, month, LocalDate.now().getDayOfMonth());

        parentRepository.findById(id).orElseThrow(() -> new RuntimeException("Parent not found"));

        List<Child> children = childRepository.findByParentId(id);

        BigDecimal totalBilling = BigDecimal.ZERO;

        for (Child child : children) {
            List<Attendance> attendances = attendanceRepository.findByChildAndMonth(child.getId(), year, month);
// pseudokod
//            long totalHoursInSchool = 0;
//            for (Attendance attendance : attendances) {
//                totalHoursInSchool += calculateHoursInSchool(attendance.getEntryDate(), attendance.getExitDate());
//            }
//
//            BigDecimal hourPrice = child.getSchool().getHourPrice();
//
//            BigDecimal childBilling = calculateChildBilling(hourPrice, totalHoursInSchool);
//
//            totalBilling = totalBilling.add(childBilling);
        }
    }
}
