package com.jlss.weather.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.cache.CacheManager;
import org.springframework.cache.Cache;

import java.util.Map;
import java.util.HashMap;
@RestController
public class CacheController{
	private final CacheManager cacheManager;
	public CacheController(CacheManager cacheManager){
		this.cacheManager=cacheManager;
	}
	@GetMapping("/api/cache/stats")
	public Map<String,Object> getStats(){
		Map<String,Object> stats = new HashMap<>();

		Cache cache = cacheManager.getCache("weather");
		if(cache!=null){
			Object nativeCache = cache.getNativeCache();
		if (nativeCache instanceof com.github.benmanes.caffeine.cache.Cache){
			com.github.benmanes.caffeine.cache.Cache<?,?> caffeine = (com.github.benmanes.caffeine.cache.Cache<?,?>) nativeCache;
			stats.put("Size",caffeine.estimatedSize());
			stats.put("Stats",caffeine.stats().toString());

		} 
	}
		return stats;
	}
}