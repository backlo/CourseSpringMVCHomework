package kr.ac.hansung.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class Course {
	
	private int number;
	private String code;
	private int year;
	private int semester;
	private String subject;
	private String division;
	private int credit;
	
}

