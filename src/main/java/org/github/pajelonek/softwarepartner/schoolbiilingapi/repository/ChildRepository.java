package org.github.pajelonek.softwarepartner.schoolbiilingapi.repository;

import org.github.pajelonek.softwarepartner.schoolbiilingapi.model.dao.Child;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChildRepository extends JpaRepository<Child, Long> {

    List<Child> findByParentId(Long parentId);
}