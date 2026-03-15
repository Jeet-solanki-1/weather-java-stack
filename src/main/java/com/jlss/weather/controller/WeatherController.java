package com.jlss.weather.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.jlss.weather.model.CurrentWeather;
import com.jlss.weather.service.WeatherService;

@RestController
public class WeatherController{
	private WeatherService service;
	public WeatherController(WeatherService service){
		this.service=service;
	}
	@GetMapping("/api")
	public ResponseEntity<CurrentWeather> getWeather(@RequestParam String city){
		CurrentWeather response = service.getWeather(city);
		return ResponseEntity.ok().body(response);
	}
}
