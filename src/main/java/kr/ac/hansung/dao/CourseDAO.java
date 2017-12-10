package kr.ac.hansung.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import kr.ac.hansung.model.Course;
import kr.ac.hansung.model.CourseCompleteCredit;
import kr.ac.hansung.model.CourseCreditSum;
import kr.ac.hansung.model.CourseYear;

@Repository
public class CourseDAO {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public int getRowCount() {
		String sqlStatement = "select count(*) from course";
		return jdbcTemplate.queryForObject(sqlStatement, Integer.class);
	}

	public Course getCourse(String name) {

		String sqlStatement = "select * from course where name=?";

		return jdbcTemplate.queryForObject(sqlStatement, new Object[]{name}, new RowMapper<Course>(){

			@Override
			public Course mapRow(ResultSet rs, int rowNum) throws SQLException {

				Course course = new Course();

				course.setNumber(rs.getInt("number"));
				course.setYear(rs.getInt("year"));
				course.setSemester(rs.getInt("semester"));
				course.setCode(rs.getString("code"));
				course.setSubject(rs.getString("subject"));
				course.setDivision(rs.getString("division"));
				course.setCredit(rs.getInt("credit"));
				
				return course;

			}
		});
		
	}
	
	public List<Course> getCourses() {
		String sqlStatement = "select * from course";
		
		return jdbcTemplate.query(sqlStatement,
				new RowMapper<Course>(){
					@Override
					public Course mapRow(ResultSet rs, int rowNum) throws SQLException {
						Course course = new Course();
						course.setNumber(rs.getInt("number"));
						course.setYear(rs.getInt("year"));
						course.setSemester(rs.getInt("semester"));
						course.setCode(rs.getString("code"));
						course.setSubject(rs.getString("subject"));
						course.setDivision(rs.getString("division"));
						course.setCredit(rs.getInt("credit"));
						return course;		
					}
			}
		);
	}

	public List<CourseCreditSum> getCoursesSum() {

		String sqlStatement = "select year,semester, sum(credit) from course group by year,semester";

		return jdbcTemplate.query(sqlStatement, new RowMapper<CourseCreditSum>() {

			@Override
			public CourseCreditSum mapRow(ResultSet rs, int rowNum) throws SQLException {

				CourseCreditSum courseSum = new CourseCreditSum();

				courseSum.setYear(rs.getInt("year"));
				courseSum.setSemester(rs.getInt("semester"));
				courseSum.setCredit(rs.getInt("sum(credit)"));				
				
				return courseSum;
			}
		});
	}

	public List<CourseYear> getCourseYear() {

		String sqlStatment="select year,semester,code,subject,division,credit from course where year='2018';";
		return jdbcTemplate.query(sqlStatment,
				new RowMapper<CourseYear>() {
				@Override
				public CourseYear mapRow(ResultSet rs,int rowNum) throws SQLException{
					CourseYear courseYear = new CourseYear();
					courseYear.setYear(rs.getInt("year"));
					courseYear.setSemester(rs.getInt("semester"));
					courseYear.setCode(rs.getString("code"));
					courseYear.setSubject(rs.getString("subject"));
					courseYear.setDivision(rs.getString("division"));
					courseYear.setCredit(rs.getInt("credit"));
					return courseYear;
				}
		});
		
	}
	
	public List<CourseCompleteCredit> getCourseCompleteCredit() {
		String sqlStatment="select division,sum(credit) from course group by division;";
		List<CourseCompleteCredit> list = jdbcTemplate.query(sqlStatment,
				new RowMapper<CourseCompleteCredit>() {
				@Override
				public CourseCompleteCredit mapRow(ResultSet rs,int rowNum) throws SQLException{
					CourseCompleteCredit courseCompleteCredit = new CourseCompleteCredit();
					courseCompleteCredit.setDivision(rs.getString("division"));
					courseCompleteCredit.setCredit(rs.getInt("sum(credit)"));
					return courseCompleteCredit;
				}
		});
		int sum=0;
		for(int i=0;i<list.size();i++) {
			sum+=list.get(i).getCredit();
		}
		list.add(new CourseCompleteCredit("총학점",sum));
		return list;
	}
	
	public boolean insert(Course course) {
		int number = course.getNumber();
		int year = course.getYear();
		int semester = course.getSemester();
		String code = course.getCode();
		String subject = course.getSubject();
		String division = course.getDivision();
		int credit = course.getCredit();
		String sqlStatement = "insert into course (number,year,semester,code,subject,division,credit) values(?,?,?,?,?,?,?)";
		
		return (jdbcTemplate.update(sqlStatement, new Object[] {number, year, semester, code, subject, division, credit}) == 1);		
	}
	
	public List<Course> getLink(int year, int semester) {
	      String sqlStatement = "select * from course WHERE year=? AND semester=?";

	      return jdbcTemplate.query(sqlStatement,new Object[] {year, semester}, new RowMapper<Course>() {

	         @Override
	         public Course mapRow(ResultSet rs, int rowNum) throws SQLException {
	        	 
	        	 Course course = new Course();
	        	 
	        	 course.setNumber(rs.getInt("number"));
	        	 course.setYear(rs.getInt("year"));
	        	 course.setSemester(rs.getInt("semester"));
	        	 course.setCode(rs.getString("code"));
	        	 course.setSubject(rs.getString("subject"));
	        	 course.setDivision(rs.getString("division"));
	        	 course.setCredit(rs.getInt("credit"));
	        	 
	        	 return course;		
	         }

	      });
	   }

}

