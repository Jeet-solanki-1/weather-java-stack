package com.jlss.weather.service;
import com.jlss.weather.model.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.beans.factory.annotation.Value;
@Component
public class WeatherClient{
	@Value("${api.key}")// pick it from application.properties
	private final String apiKey;
	@Value("${api.url}")
	private  final String apiUrl;
	private final  RestTemplate restTemplate;
	public WeatherClient(   @Value("${api.key}") String apiKey,
            @Value("${api.url}") String apiUrl,RestTemplate restTemplate){
		 this.apiKey = apiKey;
        this.apiUrl = apiUrl;
		this.restTemplate = restTemplate;


	}
	/*
		i have to build this remaing part of url->
	 	weather?q=indore&appid=110b11b90fc641f68f495ea328ac9587
	*/
	public CurrentWeather fetchWeather(String city){
	
		String url = apiUrl+"/weather?q="+city+"&appid="+apiKey;
		try{
			WeatherApiResponseDTO response= restTemplate.getForObject(url,WeatherApiResponseDTO.class);
			return new CurrentWeather(
				response.weather[0].description,
				response.main.temp,
				response.main.humidity,
				response.sys.country
			);
		}
		catch(HttpClientErrorException  e){
			throw new RuntimeException("error: "+e.getStatusCode());
		}
		/*
			which_data_type = i dont know what will come here as datapye as the respoen 
			is big ai want tonly smal part of it i mean thre thign from it and the 
			respeon is big is hirarichical nad long mena one object is containg another obje like this 
		like this :
			{
			  "coord": {
			    "lon": 75.8333,
			    "lat": 22.7179
			  },
			  "weather": [
			    {
			      "id": 800,
			      "main": "Clear",
			      "description": "clear sky",
			      "icon": "01n"
			    }
			    ],
				  "base": "stations",
				  "main": {
				    "temp": 300.23,
				    "feels_like": 299.26,
				    "temp_min": 300.23,
				    "temp_max": 300.23,
				    "pressure": 1011,
				    "humidity": 19,
				    "sea_level": 1011,
				    "grnd_level": 948
				  },
		*/
		

	}


}