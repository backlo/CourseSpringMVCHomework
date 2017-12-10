package kr.ac.hansung.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class CourseCompleteCredit {
	
	private String division;
	private int credit;
	
	public CourseCompleteCredit(String division, int credit) {
		super();
		this.division = division;
		this.credit = credit;
	}
}
