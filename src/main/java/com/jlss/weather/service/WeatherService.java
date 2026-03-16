package com.jlss.weather.service;
import com.jlss.weather.model.CurrentWeather;
import com.jlss.weather.service.WeatherClient;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class WeatherService{
	private  WeatherClient client;
	public WeatherService(WeatherClient client){
		this.client=client;
	}

	@Cacheable(value="weather",key="#city")
	public CurrentWeather getWeather(String city){
		System.out.println("cahcee miss for: "+city);
		return client.fetchWeather(city);
	}
}