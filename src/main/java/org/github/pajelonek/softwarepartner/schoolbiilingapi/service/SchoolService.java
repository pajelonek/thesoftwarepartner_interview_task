package org.github.pajelonek.softwarepartner.schoolbiilingapi.service;

import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class SchoolService {

    public void billing(Integer month, Integer year) {
        if (year == null) {
            year = LocalDate.now().getYear();
        }
        LocalDate date = LocalDate.of(year, month, LocalDate.now().getDayOfMonth());

    }
}
