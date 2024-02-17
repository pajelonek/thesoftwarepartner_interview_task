package org.github.pajelonek.softwarepartner.schoolbiilingapi.model.dao;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Data
public class School {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private BigDecimal hourPrice;

    @OneToMany(mappedBy = "school", fetch = FetchType.LAZY)
    private List<Child> children;
}