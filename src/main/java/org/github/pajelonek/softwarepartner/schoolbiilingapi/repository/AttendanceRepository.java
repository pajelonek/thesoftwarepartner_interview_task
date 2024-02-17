package org.github.pajelonek.softwarepartner.schoolbiilingapi.repository;

import org.github.pajelonek.softwarepartner.schoolbiilingapi.model.dao.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AttendanceRepository extends JpaRepository<Attendance, Long> {

    @Query("SELECT a FROM Attendance a WHERE a.child.id = :childId AND FUNCTION('YEAR', a.entryDate) = :year AND FUNCTION('MONTH', a.entryDate) = :month")
    List<Attendance> findByChildAndDate(Long childId, int year, int month);
}