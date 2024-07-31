package ch01;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor // 기본생성자
@AllArgsConstructor
@Builder // builder 패턴으로 객체 생성 
public class Student {

	private String name;
	private int age;
	private String major;
	
}
