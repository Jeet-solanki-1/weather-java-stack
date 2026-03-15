package com.jlss.weather.model;

public class CurrentWeather{
	private  String description;
	private double temp;
	private int humidity;
	private String country;
	public CurrentWeather(String description, double temp, int humidity,String country){
		this.description=description;
		this.temp=temp;
		this.humidity=humidity;
		this.country=country;
	}
	public String getDescription(){
		return this.description;
	}
	public void setDescription(String description){
		 this.description=description;
	}
	public double getTemp(){
		return this.temp;
	}
	public void setTemp(double temp){
		this.temp=temp;
	}
	public int getHumidity(){
		return this.humidity;
	}
	public void setHumidity(int humidity){
		this.humidity=humidity;
	}
	public String getCountry(){
		return this.country;
	}
	public void setCountry(String country){
		this.country=country;
	}
}