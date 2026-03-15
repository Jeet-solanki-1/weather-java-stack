package com.jlss.weather.service;
import com.jlss.weather.model.CurrentWeather;
import com.jlss.weather.service.WeatherClient;

import org.springframework.stereotype.Service;

@Service
public class WeatherService{
	private  WeatherClient client;
	public WeatherService(WeatherClient client){
		this.client=client;
	}
	public CurrentWeather getWeather(String city){
		return client.fetchWeather(city);
	}
}