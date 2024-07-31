package ch01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.google.gson.Gson;

public class APIExploreclass {

   public static void main(String[] args) throws IOException {
      Gson gson = new Gson();
      
      URL url = new URL("https://jsonplaceholder.typicode.com/todos/1"); // < 주소 넣어보기 

      HttpURLConnection conn = (HttpURLConnection) url.openConnection();

      conn.setRequestMethod("GET"); // 서버에게 자원요청

      conn.setRequestProperty("Content-type", "application/json");
      // 성공 : 200 , 실패 : 404
      System.out.println("Response code: " + conn.getResponseCode());
      // 100~500 의미 
      BufferedReader rd;
      if (conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
         rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
      } else {
         rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
      }
      
      StringBuilder sb = new StringBuilder();
      String line;
      while ((line = rd.readLine()) != null) {
         sb.append(line);
      }
      rd.close();
      Test[] testObject = gson.fromJson(sb.toString(), Test[].class);
      for (Test test : testObject) {
    	  
	}
      
  
   }
   
}
