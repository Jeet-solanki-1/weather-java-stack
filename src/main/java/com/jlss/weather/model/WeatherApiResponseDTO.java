package com.jlss.weather.model;

public class WeatherApiResponseDTO{
	
	public Weather[] weather;
	public Main main;
	public Sys sys;
	public static class Weather{
		public String description;
	}
	public static class Main{
		public double temp;
		public int humidity;
	}
	public static class Sys{
		public String country;
	}
}