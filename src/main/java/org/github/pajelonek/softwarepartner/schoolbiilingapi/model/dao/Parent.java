package org.github.pajelonek.softwarepartner.schoolbiilingapi.model.dao;


import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Parent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstname;
    private String lastname;

    @OneToMany(mappedBy = "parent")
    private List<Child> children;
}