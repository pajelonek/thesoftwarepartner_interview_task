package org.github.pajelonek.softwarepartner.schoolbiilingapi.web;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.github.pajelonek.softwarepartner.schoolbiilingapi.model.dto.ParentBillingDTO;
import org.github.pajelonek.softwarepartner.schoolbiilingapi.model.dto.SchoolBillingDTO;
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
    public ResponseEntity<SchoolBillingDTO> getMonthlySchoolBilling(@RequestParam @NotNull Long id, @RequestParam @NotNull Integer month, @RequestParam(required = false) Integer year) { //todo test
        log.trace("Incoming GET request to getMonthlySchoolBilling for id: {}, month: {}, year: {}", id, month, year);
        SchoolBillingDTO response = schoolService.calculateSchoolBilling(id, month, year);
        log.trace("Returning calculated getMonthlySchoolBilling for id: {}, month: {}, year: {}", id, month, year);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/parent")
    @Operation(summary = "", description = "")
    public ResponseEntity<ParentBillingDTO> getMonthlyParentBilling(@RequestParam @NotNull Long id, @RequestParam @NotNull @Min(1) @Max(12) Integer month, @RequestParam @NotNull Integer year) { //todo change min max to badrequestexception
        log.trace("Incoming GET request to getMonthlyParentBilling for id: {}, month: {}, year: {}", id, month, year);
        ParentBillingDTO response = parentService.calculateParentBilling(id, month, year);
        log.trace("Returning calculated getMonthlyParentBilling for id: {}, month: {}, year: {}", id, month, year);
        return ResponseEntity.ok(response);
    }
}
