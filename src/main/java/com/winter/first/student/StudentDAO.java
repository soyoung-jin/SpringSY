package com.winter.first.student;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import org.springframework.stereotype.Repository;

import com.winter.first.weather.WeatherDTO;

@Repository // 객체 생성 + DAO 역할
public class StudentDAO {

	public List<WeatherDTO> getList() throws Exception {
		System.out.println("DAO getList");

		File file = new File("C:\\study", "weather.txt");
		FileReader fr = new FileReader(file);// 파일경로를 문자로
		BufferedReader br = new BufferedReader(fr);// 문자를 문자열로 스캐너랑 비슷

		ArrayList<WeatherDTO> ar = new ArrayList<WeatherDTO>();

		while (true) {
			// readLine의 리턴값은 무조건 string
			// 다른 타입으로 받을시엔 형변환 필요
			String s = br.readLine();
			if (s == null) {// readLine읽어들인게 없다면 while문 실행x
				break;
			}
			s = s.replace(",", "-");// 한줄 읽어온 s에다가 ,를 -로 바꿈
			StringTokenizer st = new StringTokenizer(s, "-");
			WeatherDTO wDTO = new WeatherDTO();
			while (st.hasMoreTokens()) {
				wDTO.setNum(Long.parseLong(st.nextToken().trim()));
				wDTO.setCity(st.nextToken().trim());
				wDTO.setGion(Double.parseDouble(st.nextToken().trim()));
				wDTO.setStatus(st.nextToken().trim());
				wDTO.setHuminity(Integer.parseInt(st.nextToken().trim()));
			}
			ar.add(wDTO);

		}
		br.close();
		fr.close();
		return ar;

	}

}
