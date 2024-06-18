package com.winter.first.student;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service // 객체 생성+ service 역할
public class StudentService {

	@Autowired
	public StudentDAO studentDAO;

	public List<StudentDTO> getList() {
		System.out.println("service list");
		studentDAO = new StudentDAO();

		List<StudentDTO> ar = null;
		try {
			ar = studentDAO.getList();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return ar;

	}

}
