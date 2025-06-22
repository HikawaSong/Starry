package com.star.starry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class StarryApplication {

	public static void main(String[] args) {
		SpringApplication.run(StarryApplication.class, args);
	}

}
