<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>학생 목록</h1>
	
	<table class="tbl" border = "1">
		<thead>
			
				<th>NUM</th>
				<th>NAME</th>
				<th>AVG</th>
			
		</thead>	
		<tbody>
			<c:forEach items="${requestScope.list}" var ="student">
				<tr>
					<td>${pageScope.student.num} </td>
					<td>${pageScope.student.name}</td>
					<td>${pageScope.student.avg}</td>
				<tr>
			</c:forEach>
		</tbody>
	</table>

	
	
</body>
</html>