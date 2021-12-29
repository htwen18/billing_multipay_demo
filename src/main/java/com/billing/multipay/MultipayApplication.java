package com.billing.multipay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class MultipayApplication {

	public static void main(String[] args) {
		SpringApplication.run(MultipayApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate(){
		HttpComponentsClientHttpRequestFactory httpRequestFactory = new HttpComponentsClientHttpRequestFactory();
		httpRequestFactory.setConnectionRequestTimeout(5000);
		RestTemplate restTemplate = new RestTemplate(httpRequestFactory);
		return restTemplate;
	}

}
