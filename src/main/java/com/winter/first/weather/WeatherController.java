package com.winter.first.weather;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WeatherController {
	@Autowired
	private WeatherService weatherService;

	@RequestMapping("/weather/list")
	public String getList() {
		System.out.println("WeatherController : weatherList로 이동");
		weatherService.getList();
		return "weather/list";
	}

	@RequestMapping("/weather/detail")
	public String getDetatl() {
		return "weather/detail";

	}
}
