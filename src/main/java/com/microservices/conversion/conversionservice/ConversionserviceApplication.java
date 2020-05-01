package com.microservices.conversion.conversionservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
// @EnableFeignClients("com.microservices.conversion.conversionservice")
@EnableDiscoveryClient
public class ConversionserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConversionserviceApplication.class, args);

	}

	@Bean
	@LoadBalanced
	public WebClient.Builder loadBalancedWebClientBuilder() {
		return WebClient.builder();
	}
}
