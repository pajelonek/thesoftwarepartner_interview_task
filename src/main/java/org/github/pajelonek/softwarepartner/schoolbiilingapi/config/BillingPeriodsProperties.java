package org.github.pajelonek.softwarepartner.schoolbiilingapi.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.time.LocalTime;

@Data
@ConfigurationProperties(prefix = "billing.periods")
public class BillingPeriodsProperties {

    private LocalTime freeStartTime;
    private LocalTime freeEndTime;
}
