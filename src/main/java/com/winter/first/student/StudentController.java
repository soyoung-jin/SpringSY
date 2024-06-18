package com.winter.first.student;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller // 해당 클래스의 객체를 생성하라는 의미(Spring한테 지시)
public class StudentController {

	@Autowired
	private StudentService studentService;

	@RequestMapping("/student/list")
	public String getList(HttpServletRequest request) {
		request.getParameter("");
		System.out.println("list 가져오기");
		List<StudentDTO> ar = studentService.getList();

		StudentDTO student = new StudentDTO();
		request.setAttribute("list", ar);

		return "/student/list";
	}

	@RequestMapping("/student/detail")
	public String getDetail() {

		return "student/detail";
	}

	// 메서드 형식이 get일 때 실행
	@RequestMapping(value = "/student/add", method = RequestMethod.GET)
	public void add() {

	}

	// 메서드 형식이 post일때 실행
	@RequestMapping(value = "/student/add", method = RequestMethod.POST)
	public void add2() {

	}

}
