package com.winter.first.student;

import org.springframework.stereotype.Repository;

@Repository // 객체 생성 + DAO 역할
public class StudentDAO {
	public void getList() {
		System.out.println("DAO List");
	}

}
