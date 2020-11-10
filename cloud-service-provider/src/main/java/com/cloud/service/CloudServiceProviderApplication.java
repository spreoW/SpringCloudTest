package com.cloud.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("com.cloud.service.mapper")
@EnableDiscoveryClient
public class CloudServiceProviderApplication {

	public static void main(String[] args) {
		SpringApplication.run(CloudServiceProviderApplication.class, args);
	}

}
