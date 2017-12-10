package kr.ac.hansung.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.hansung.dao.CourseDAO;
import kr.ac.hansung.model.Course;
import kr.ac.hansung.model.CourseCompleteCredit;
import kr.ac.hansung.model.CourseCreditSum;
import kr.ac.hansung.model.CourseYear;

@Service
public class CourseService {

	@Autowired
	private CourseDAO courseDAO;
	
	public List<Course> getCurrent() {
		return courseDAO.getCourses();
	}

	public List<CourseCreditSum> getCourseCreditSum(){
		return courseDAO.getCoursesSum();
	}
	
	public List<CourseCompleteCredit> getCourseCompleteCredit(){
		return courseDAO.getCourseCompleteCredit();
	}
	
	public void insert(Course course) {
		courseDAO.insert(course);	
	}
	
	public List<CourseYear> getCourseYear(){
		return courseDAO.getCourseYear();
	}
	
	public List<Course> getLink(int year,int semester) {
		return courseDAO.getLink(year, semester);
	}
	
}
