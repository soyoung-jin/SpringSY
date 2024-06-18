package com.winter.first.student;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository // 객체 생성 + DAO 역할
public class StudentDAO {
	public List<StudentDTO> getList() throws Exception {
		System.out.println("DAO List");

		File file = new File("C:\\Study\\student.txt");

		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);

		ArrayList<StudentDTO> list = new ArrayList<StudentDTO>();

		while (true) {
			String s = br.readLine();
			if (s == null) {
				break;
			}
			StudentDTO sdto = new StudentDTO();

			String[] ar = s.split("-");

			sdto.setNum(Integer.parseInt(ar[0].trim()));
			sdto.setName(ar[1].trim());
			sdto.setKor(Integer.parseInt(ar[2].trim()));
			sdto.setEng(Integer.parseInt(ar[3].trim()));
			sdto.setMath(Integer.parseInt(ar[4].trim()));
			sdto.setTotal(Integer.parseInt(ar[5].trim()));
			sdto.setAvg(Double.parseDouble(ar[6].trim()));

			list.add(sdto);
		}
		br.close();
		fr.close();// 자원 종료

		return list;
	}

}
