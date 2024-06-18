package com.winter.first.weather;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WeatherController {

	@RequestMapping("/weather/list")
	public String getList() {
		System.out.println("WeatherController : weatherList로 이동");
		return "weather/list";
	}
}
