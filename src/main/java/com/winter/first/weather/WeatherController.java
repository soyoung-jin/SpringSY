package com.winter.first.weather;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class WeatherController {
	@Autowired
	private WeatherService weatherService;

	@RequestMapping("/weather/list")
	public String getList(HttpServletRequest request) {
		request.getParameter("");
		System.out.println("WeatherController : weatherList");
		WeatherService weatherService = new WeatherService();
		List<WeatherDTO> list = weatherService.getList();
		request.setAttribute("list", list);
		return "weather/list";
		// redirect:url
	}

	@RequestMapping("/weather/detail")
	public String getDetatl(HttpServletRequest request) {

		String num = request.getParameter("num");

		WeatherDTO weatherDTO = new WeatherDTO();// num을 weatherDTO에 setNum에 넣으려는 목적
		weatherDTO.setNum(Long.parseLong(num));// service로 보내야함
		weatherDTO = weatherService.getDetail(weatherDTO);

		if (weatherDTO != null) {
			request.setAttribute("dto", weatherDTO);
			return "weather/detail";

		} else {
			request.setAttribute("message", "정보가 없습니다.");
			return "weather/message";

		}

	}

	@RequestMapping(value = "/weather/add", method = RequestMethod.POST)
	public String add(HttpServletRequest request) {

		String city = request.getParameter("city");
		Double gion = Double.parseDouble(request.getParameter("gion"));
		int huminity = Integer.parseInt(request.getParameter("huminity"));
		String status = request.getParameter("status");

		// 꺼낸 파라미터 dto에 넣음
		// 입력받은 데이터 dto에 넣어주기
		WeatherDTO wDTO = new WeatherDTO();

		wDTO.setCity(city);
		wDTO.setGion(gion);
		wDTO.setHuminity(huminity);
		wDTO.setStatus(status);

		System.out.println("WeatherController.start - add 시작");
		weatherService.add(wDTO);
		System.out.println("WeatherController.start - add 끝");

		return "redirect:/weather/list";

	}

	@RequestMapping(value = "/weather/add", method = RequestMethod.GET)
	public String add2() {
		return "weather/add";

	}

	@RequestMapping("/weather/delete")
	public String getDelete(HttpServletRequest request) {

		String num = request.getParameter("num");
		WeatherDTO wDTO = new WeatherDTO();
		wDTO.setNum(Long.parseLong(num));
		wDTO = weatherService.delete(wDTO);
		// System.out.println("delete 눌림");
		// 삭제할 게시물 번호 나옴
		System.out.println("WeatherController.start - result[delete] 삭제할 번호: " + wDTO.getNum() + 1);

		return "redirect:/weather/list";

	}

	@RequestMapping(value = "/weather/update", method = RequestMethod.POST)
	public String getUpdate(HttpServletRequest request) {

		Long num = Long.parseLong(request.getParameter("num"));
		String city = request.getParameter("city");
		Double gion = Double.parseDouble(request.getParameter("gion"));
		int huminity = Integer.parseInt(request.getParameter("huminity"));
		String status = request.getParameter("status");
		// jsp에서 입력 된 값 dto에 넣어줌
		WeatherDTO wDTO = new WeatherDTO();
		wDTO.setNum(num);
		wDTO.setCity(city);
		wDTO.setGion(gion);
		wDTO.setHuminity(huminity);
		wDTO.setStatus(status);

		weatherService.update(wDTO);

		return "redirect:/weather/list";
	}

	@RequestMapping(value = "/weather/update", method = RequestMethod.GET)
	public String getUpdate2(HttpServletRequest request) {
		WeatherDTO wDTO = new WeatherDTO();
		// weatherDTO 정보를 jsp로 보내야함
		// request
		wDTO.setNum(Long.parseLong(request.getParameter("num")));

		wDTO = weatherService.getDetail(wDTO);
		request.setAttribute("dto", wDTO);// jsp에 뿌려줌
		return "weather/update";

	}

}
