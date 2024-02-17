package org.github.pajelonek.softwarepartner.schoolbiilingapi.model.dao;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class Attendance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "child_id")
    private Child child;

    private LocalDateTime entryDate;
    private LocalDateTime exitDate;
}