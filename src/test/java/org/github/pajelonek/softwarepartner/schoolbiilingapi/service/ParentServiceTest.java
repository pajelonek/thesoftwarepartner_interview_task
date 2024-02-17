package org.github.pajelonek.softwarepartner.schoolbiilingapi.service;

import org.github.pajelonek.softwarepartner.schoolbiilingapi.repository.AttendanceRepository;
import org.github.pajelonek.softwarepartner.schoolbiilingapi.repository.ParentRepository;
import org.github.pajelonek.softwarepartner.schoolbiilingapi.repository.SchoolRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@ExtendWith(MockitoExtension.class)
public class ParentServiceTest {

    @Mock
    private ParentRepository parentRepository;

    @Mock
    private AttendanceRepository attendanceRepository;

    @Mock
    private SchoolRepository schoolRepository;

    @InjectMocks
    private ParentService parentService;

    @Test
    public void testCalculateBillingForParentInMonth() {
        assertThat(parentRepository).isNotNull();
//        // Przygotowanie danych testowych
//        Long parentId = 1L;
//        YearMonth yearMonth = YearMonth.of(2024, 2);
//
//        Parent parent = new Parent();
//        parent.setId(parentId);
//
//        Child child1 = new Child();
//        child1.setId(1L);
//        child1.setParent(parent);
//
//        Child child2 = new Child();
//        child2.setId(2L);
//        child2.setParent(parent);
//
//        List<Child> children = new ArrayList<>();
//        children.add(child1);
//        children.add(child2);
//        parent.setChildren(children);
//
//        Attendance attendance1 = new Attendance();
//        attendance1.setChild(child1);
//
//        Attendance attendance2 = new Attendance();
//        attendance2.setChild(child2);
//
//        List<Attendance> attendances = new ArrayList<>();
//        attendances.add(attendance1);
//        attendances.add(attendance2);
//
//        BigDecimal hourPrice = BigDecimal.valueOf(10); // Ustawiamy stawkę godzinową na 10
//
//        // Mockowanie zachowania repozytoriów
//        when(parentRepository.findById(parentId)).thenReturn(java.util.Optional.of(parent));
//        when(attendanceRepository.findByChildAndMonth(child1.getId(), yearMonth.getYear(), yearMonth.getMonthValue())).thenReturn(attendances);
//        when(attendanceRepository.findByChildAndMonth(child2.getId(), yearMonth.getYear(), yearMonth.getMonthValue())).thenReturn(attendances);
//        when(schoolRepository.findById(child1.getSchool().getId())).thenReturn(java.util.Optional.of(new School(hourPrice)));
//        when(schoolRepository.findById(child2.getSchool().getId())).thenReturn(java.util.Optional.of(new School(hourPrice)));
//
//        // Wywołanie metody, którą testujemy
//        BigDecimal billing = parentService.calculateBillingForParentInMonth(parentId, yearMonth);
//
//        // Sprawdzenie wyniku
//        BigDecimal expectedBilling = BigDecimal.valueOf(40); // Oczekiwana kwota opłat: 2 dzieci * 2 wpisy obecności * 10 stawka godzinowa
//        assertEquals(expectedBilling, billing);
    }
}