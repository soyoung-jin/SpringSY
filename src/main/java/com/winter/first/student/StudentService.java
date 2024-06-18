package com.winter.first.student;

import org.springframework.stereotype.Service;

@Service // 객체 생성+ service 역할
public class StudentService {

	public void getList() {
		System.out.println("service list");
	}

}
