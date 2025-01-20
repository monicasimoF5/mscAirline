package org.msc.mscAirline;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication
public class MscAirlineApplication {

	public static void main(String[] args) {
		SpringApplication.run(MscAirlineApplication.class, args);
		System.out.println("Welcome to MSC Airline...");
	}
}
