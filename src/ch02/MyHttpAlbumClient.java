package ch02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class MyHttpAlbumClient {

	public static void main(String[] args) {

		// 순수 자바 코드에서 HTTP 통신의 순서
		// 1. 서버 주소의 경로 필요
		// 2. 경로를 통해 URL 클래스 필요
		// 3. URL 안의 openConnection 객체를 받아내서 스트림을 활용해 I/O 작업 진행 ( url.openConnection )
		
		try {
			URL url = new URL("https://jsonplaceholder.typicode.com/albums/1");
			HttpURLConnection conn = (HttpURLConnection)url.openConnection(); // 다운캐스팅
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Content-type", "application/json");
			
			// 응답 코드 확인
			int responseCode = conn.getResponseCode();
			System.out.println("response code : " + responseCode);
			
			// HTTP 응답 메세지에 데이터를 추출해보자.  []  --- Stream ---  []
			BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String inputLine;
			StringBuffer buffer = new StringBuffer();
			while( (inputLine = in.readLine()) != null ) {
				buffer.append(inputLine);
			}
			in.close();
			
			System.out.println(buffer.toString());
			System.out.println("---------------------------------");
			// gson lib를 활용
			//Gson gson = new Gson();
			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			Album albumDTO = gson.fromJson(buffer.toString(), Album.class); // buffer.toString() : 파싱 할 대상
			
			System.out.println(albumDTO.getId());
			System.out.println(albumDTO.getUserId());
			System.out.println(albumDTO.getTitle());
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	} // end of main

} // end of class
