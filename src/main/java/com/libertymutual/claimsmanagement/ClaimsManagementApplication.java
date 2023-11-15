package com.libertymutual.claimsmanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class ClaimsManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClaimsManagementApplication.class, args);
	}

}
