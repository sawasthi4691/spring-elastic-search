package com.elastic.group.manualsearch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableElasticsearchRepositories
@EnableScheduling
public class ManualsearchApplication {

	public static void main(String[] args) {
		SpringApplication.run(ManualsearchApplication.class, args);
	}

}
