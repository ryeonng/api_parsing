package ch02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

public class MyHttpCommentsClient {

	public static void main(String[] args) {

		try {
			URL url = new URL("https://jsonplaceholder.typicode.com/comments/1");
			HttpURLConnection conn = (HttpURLConnection)url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Content-type", "application/json");
			
			// 응답 코드 확인
			int responseCode = conn.getResponseCode();
			System.out.println("response code : " + responseCode);
			
			// HTTP 응답 메세지에 데이터 추출
			BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String inputLine;
			StringBuffer buffer = new StringBuffer();
			while( (inputLine = in.readLine()) != null ) {
				buffer.append(inputLine);
			}
			in.close();
			
			System.out.println(buffer.toString());
			
			// gson lib 활용
			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			
			// 
			Type albumType = new TypeToken<List<Album>>(){}.getType();
			List<Album> albumList = gson.fromJson(buffer.toString(), albumType);
			
			System.out.println();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	} // end of main
	
} // end of class
