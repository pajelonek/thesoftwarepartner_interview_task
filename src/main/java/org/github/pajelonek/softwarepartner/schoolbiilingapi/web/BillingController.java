package org.github.pajelonek.softwarepartner.schoolbiilingapi.web;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.github.pajelonek.softwarepartner.schoolbiilingapi.service.ParentService;
import org.github.pajelonek.softwarepartner.schoolbiilingapi.service.SchoolService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/billing")
@Validated
@Tag(name = "", description = "")
@AllArgsConstructor
public class BillingController {

    private SchoolService schoolService;
    private ParentService parentService;

    @GetMapping("/school")
    @Operation(summary = "", description = "")
    public ResponseEntity<Void> getMonthlySchoolBilling(@RequestParam @NotEmpty Integer month, @RequestParam(required = false) Integer year) {
        schoolService.billing(month, year);
        return null;
    }

    @GetMapping("/parent")
    @Operation(summary = "", description = "")
    public ResponseEntity<Void> getMonthlyParentBilling(@RequestParam @NotEmpty Long id, @RequestParam @NotEmpty Integer month, @RequestParam(required = false) Integer year) {
        parentService.billing(id, month, year);
        return null;
    }
}
