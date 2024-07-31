package ch01;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class JsonPlaceholder {

	public static void main(String[] args) {
		
		// 자바 기본 코드 > HTTP 요청
		// 서버 주소 (경로) 준비
		String urlString = "https://jsonplaceholder.typicode.com/todos/1";
		
		
		// URL클래스, Connection 객체 생성
		try {
			URL url = new URL(urlString);
			// url.openConnection() 연결 요청
			HttpURLConnection conn = (HttpURLConnection)url.openConnection();
			conn.setRequestMethod("GET");
			int responseCode = conn.getResponseCode();
			System.out.println("HTTP CODE : " + responseCode);
			
			BufferedReader brIn = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String inputLine;
			StringBuffer responseBuffer = new StringBuffer();
			while( (inputLine = brIn.readLine()) != null ) {
				responseBuffer.append(inputLine);
			}
			brIn.close();
			
			String[] strHtmls = responseBuffer.toString().split("\\s");
			System.out.println("index count : " + strHtmls.length);
		
			for(String word : strHtmls) {
				System.out.println(word);
			}
		} catch (Exception e) {
		}
		
	}
	
}
