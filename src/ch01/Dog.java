package ch01;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class Dog {

	private String species;
	private String name;
	private int age;
	
	public static void main(String[] args) {
		
		Dog dog1 = new Dog("말티즈", "티쥬", 5);
		Dog dog2 = new Dog("웰시코기", "꼬기", 2);
		
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		
		String dog1Str = gson.toJson(dog1);
		System.out.println(dog1Str);
		
		Gson gson2 = new Gson();
		String dog2Str = gson.toJson(dog2);
		System.out.println(dog2Str);
		
		Dog dogObject1 = gson.fromJson(dog1Str, Dog.class);
		System.out.println(dogObject1.getName());
		
		Dog dogObject2 = gson.fromJson(dog2Str, Dog.class);
		System.out.println(dogObject2.getName());
	}
	
}
