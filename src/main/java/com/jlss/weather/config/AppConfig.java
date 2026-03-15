package com.jlss.weather.config;

import org.springframework.web.client.RestTemplate;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;

@Configuration
public class AppConfig {
	//todo cors settings
	@Bean
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}
}