package com.winter.first.student;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller // 해당 클래스의 객체를 생성하라는 의미(Spring한테 지시)
public class StudentController {

	@Autowired
	private StudentService studentService;

	@RequestMapping("/student/list")
	public String getList(HttpServletRequest request) {
		request.getParameter("");
		System.out.println("list 가져오기");
		studentService.getList();

		return "student/list";
	}

	@RequestMapping("/student/detail")
	public String getDetail() {

		return "student/detail";
	}

}
