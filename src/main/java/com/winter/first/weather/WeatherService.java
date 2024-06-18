package com.winter.first.weather;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class WeatherService {
	private WeatherDAO weatherDAO;

	public WeatherService() {
		weatherDAO = new WeatherDAO();
	}

	public List<WeatherDTO> getList() {
		System.out.println("WeatherService : service getList 실행");
		List<WeatherDTO> list = null;

		try {
			list = weatherDAO.getList();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}

	public WeatherDTO getDetail(WeatherDTO weatherDTO) {
		System.out.println("WeatherService : service getDetail 실행");
		try {
			weatherDTO = weatherDAO.getDetail(weatherDTO);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return weatherDTO;

	}

	public WeatherDTO add(WeatherDTO weatherDTO) {// 매개변수로 받음
		try {
			weatherDTO = weatherDAO.add(weatherDTO);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return weatherDTO;

	}

	public WeatherDTO delete(WeatherDTO weatherDTO) {
		try {
			weatherDTO = weatherDAO.delete(weatherDTO);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return weatherDTO;
	}

	public WeatherDTO update(WeatherDTO weatherDTO) {
		try {
			weatherDTO = weatherDAO.update(weatherDTO);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return weatherDTO;
	}
}
