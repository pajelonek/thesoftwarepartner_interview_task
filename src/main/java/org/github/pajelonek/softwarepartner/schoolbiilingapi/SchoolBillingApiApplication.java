package org.github.pajelonek.softwarepartner.schoolbiilingapi;

import org.github.pajelonek.softwarepartner.schoolbiilingapi.config.BillingPeriodsProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(BillingPeriodsProperties.class)
public class SchoolBillingApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SchoolBillingApiApplication.class, args);
	}

}
