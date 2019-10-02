package com.edu.configclientapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients("com.edu.configclientapi")
@EnableDiscoveryClient
public class ConfigClientApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConfigClientApiApplication.class, args);
	}

}
