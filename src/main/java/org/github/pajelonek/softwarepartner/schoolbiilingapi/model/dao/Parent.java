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

    @OneToMany(mappedBy = "parent", fetch = FetchType.EAGER)
    private List<Child> children;

    @Override
    public String toString() {
        return "Parent{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                '}';
    }
}