### 2. Weather Dashboard ☀️
Goal: Fetch and serve weather data for a given city using OpenWeatherMap or similar.

Features:

GET /api/weather?city=London – returns current weather (temp, humidity, description).

In-memory cache with expiry (e.g., Caffeine) to reduce external calls.

Option to get 5-day forecast.

Learn: Caching strategies, JSON parsing, environment variables for API keys.

Frontend: Input city, display weather cards
