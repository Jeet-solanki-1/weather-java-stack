package com.jlss.weather.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.cache.CacheManager;

import java.util.HashMap;
import java.util.Map;

@RestController
public class CacheController{
	private final CacheManager cacheManager;
	public CacheController(CacheManager cacheManager){
		this.cacheManager=cacheManager;
	}
	@GetMapping("/api/cache/stats")
	public Map<String,Object> getCacheStats(){
		Map<String,Object> stats = new HashMap<>();
		var cache = cacheManager.getCache("weather");
		var nativeCache = cache.getNativeCache();
		if (nativeCache instanceof com.github.benmanes.caffeine.cache.Cache){
			var caffeine = (com.github.benmanes.caffeine.cache.Cache) nativeCache;
			stats.put("size",caffeine.estimatedSize());
			stats.put("stats",caffeine.stats().toString());

		}
		return stats;
	}
	
}
