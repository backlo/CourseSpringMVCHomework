package kr.ac.hansung.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.ac.hansung.model.Course;
import kr.ac.hansung.model.CourseCompleteCredit;
import kr.ac.hansung.model.CourseCreditSum;
import kr.ac.hansung.model.CourseYear;
import kr.ac.hansung.service.CourseService;

@Controller
public class CourseController {
	
	@Autowired
	private CourseService courseService;
	
	@RequestMapping("/show_courses")
	public String showCourses(Model model) {
		List<Course> courses = courseService.getCurrent();
		model.addAttribute("courses", courses);
		return "courses";
	}
	
	@RequestMapping("/semester_credit")
	public String createCourse(Model model) {
		List<CourseCreditSum> coursecreditsum = courseService.getCourseCreditSum();
		model.addAttribute("creditsum", coursecreditsum);
		return "creditsum";
	}
	
	@RequestMapping("/complete_credit")
	public String showDivider(Model model) {
		List<CourseCompleteCredit> courseCompleteCredit = courseService.getCourseCompleteCredit();
		model.addAttribute("completecredit", courseCompleteCredit);
		return "completecredit";
	}
	
	@RequestMapping("/register_course")
	public String registerCourse(Model model) {
		Course course = new Course();
		course.setYear(2018);
		course.setSemester(1);
		model.addAttribute("course",course);
		return "registerCourse";
	}
	
	@RequestMapping("/regist")
	public String incollege2(Model model,@Valid Course course,BindingResult result) {
		course.setYear(2018);
		course.setSemester(1);
		if(result.hasErrors()) {
			List<ObjectError> errors = result.getAllErrors();
			for(ObjectError error : errors)
				System.out.println(error.getDefaultMessage());
			return "home";
		}
		courseService.insert(course);
		return "home";
	}
	
	@RequestMapping("/check_course")
	public String showYear(Model model) {
		List<CourseYear> courseYear = courseService.getCourseYear();
		model.addAttribute("checkCourse", courseYear);
		return "checkCourse";
	}
	
	@RequestMapping("/link")
	public String showLink(@RequestParam("year") int year, @RequestParam("semester") int semester,Model model) {
		List<Course> link = courseService.getLink(year, semester);
		model.addAttribute("link", link);
		return "link";
	}
	
}
