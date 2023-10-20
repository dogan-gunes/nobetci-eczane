package com.dgn.resttemplateex;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class ResttemplateExApplication {

	public static void main(String[] args) {
		SpringApplication.run(ResttemplateExApplication.class, args);
	}
	@Scope("singleton")
	@Bean
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}

}
