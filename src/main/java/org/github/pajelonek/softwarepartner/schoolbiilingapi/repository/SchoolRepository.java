package org.github.pajelonek.softwarepartner.schoolbiilingapi.repository;

import org.github.pajelonek.softwarepartner.schoolbiilingapi.model.dao.School;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SchoolRepository extends JpaRepository<School, Long> {
    List<School> findByName(String name);
}