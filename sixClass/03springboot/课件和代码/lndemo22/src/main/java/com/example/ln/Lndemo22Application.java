package com.example.ln;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class Lndemo22Application {

	public static void main(String[] args) {
		SpringApplication.run(Lndemo22Application.class, args);
	}
}
