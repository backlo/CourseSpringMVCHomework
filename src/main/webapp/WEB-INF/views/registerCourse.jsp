<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<sf:form method="post"
		action="${pageContext.request.contextPath}/regist"
		modelAttribute="course">

		<table border="1" cellpadding="10"
			style="border-collapse: collapse; text-align: center;">

			<caption>이수 구분별 학점내역</caption>

			<tbody>
				<tr>
					<td>수강년도:</td>
					<td>${course.year}</td>
				</tr>
				<tr>
					<td>학기:</td>
					<td>${course.semester}</td>
				</tr>
				<tr>
					<td>교과코드:</td>
					<td><sf:input type="text" path="code" /><br /> <sf:errors
							path="code" /></td>
				</tr>
				<tr>
					<td>교과목명:</td>
					<td><sf:input type="text" path="subject" /><br /> <sf:errors
							path="subject" /></td>
				</tr>
				<tr>
					<td>구분:</td>
					<td><sf:input type="text" path="division" /><br /> <sf:errors
							path="division" /></td>
				</tr>
				<tr>
					<td>학점:</td>
					<td><sf:input type="text" path="credit" /><br /> <sf:errors
							path="credit" /></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" value="등록하기"></td>
				</tr>
			</tbody>
		</table>

	</sf:form>
</body>
</html>