package org.github.pajelonek.softwarepartner.schoolbiilingapi.repository;

import org.github.pajelonek.softwarepartner.schoolbiilingapi.model.dao.Parent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParentRepository extends JpaRepository<Parent, Long> {
}