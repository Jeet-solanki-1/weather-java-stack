package com.jlss.weather.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.CacheManager;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import com.github.benmanes.caffeine.cache.*;
import java.util.concurrent.TimeUnit;
@EnableCaching
@Configuration
public class CacheConfig{
	@Bean
	public CacheManager getCacheManager(){
		CaffeineCacheManager caffeineCacheManager = new CaffeineCacheManager("weather");
		caffeineCacheManager.setCaffeine(
			Caffeine.newBuilder()
			.initialCapacity(100)
			.maximumSize(500)
			.expireAfterWrite(1,TimeUnit.HOURS)
			.recordStats()
		);
		return caffeineCacheManager;
	}
}