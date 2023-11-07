package com.example.kafkaproducertemplate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class KafkaProducerTemplateApplication {

	public static void main(String[] args) {
		SpringApplication.run(KafkaProducerTemplateApplication.class, args);
	}

}
