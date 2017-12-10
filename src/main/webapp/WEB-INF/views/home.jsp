<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>Courses_Menu</title>
</head>
<body>

	<p> <a href="${pageContext.request.contextPath}/show_courses">모든 내역 보기</a> </p>
	<p>	<a href="${pageContext.request.contextPath}/semester_credit"> 학기별 이수 학점 조회 </a> </p>
	<p> <a href="${pageContext.request.contextPath}/complete_credit"> 이수 구분별 학점 조회 </a> </p>
	<p> <a href="${pageContext.request.contextPath}/register_course"> 수강 신청하기</a> </p>
	<p> <a href="${pageContext.request.contextPath}/check_course"> 수강 신청 조회 </a> </p>	

</body>
</html>
