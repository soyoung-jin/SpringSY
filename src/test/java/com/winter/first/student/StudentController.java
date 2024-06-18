package com.winter.first.student;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StudentController {

	@RequestMapping("/student/list")
	public String getList() {
		System.out.println("list 가져오기");

		return "student/detail";
	}
}
