package com.crop.shennong;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import javax.annotation.PostConstruct;
import java.util.TimeZone;

@SpringBootApplication
@EnableJpaAuditing()
public class ShennongApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShennongApplication.class, args);
	}

	@PostConstruct
	public void setTimeZone(){
		// Setting Spring Boot SetTimeZone
		TimeZone.setDefault(TimeZone.getTimeZone("GMT+8"));
	}
}
