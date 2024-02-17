package org.github.pajelonek.softwarepartner.schoolbiilingapi.repository;

import org.github.pajelonek.softwarepartner.schoolbiilingapi.model.dao.Parent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ParentRepository extends JpaRepository<Parent, Long> {
    @Query("SELECT DISTINCT p FROM Parent p JOIN FETCH p.children c JOIN c.school s JOIN c.attendances a WHERE s.id = :schoolId AND FUNCTION('YEAR', a.entryDate) = :year AND FUNCTION('MONTH', a.entryDate) = :month")
    List<Parent> findParentsBySchoolIdAndChildrenAttendanceByMonth(@Param("schoolId") Long schoolId, @Param("year") int year, @Param("month") int month);
}