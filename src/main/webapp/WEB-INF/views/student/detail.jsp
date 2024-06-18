<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>Student Detail</h1>
	
	<table border="1" class="tbl">
		<thead>
			<th>NUM</th>
			<th>NAME</th>
			<th>KOR</th>
			<th>ENG</th>
			<th>MATH</th>
			<th>TOTAL</th>
			<th>AVG</th>

		</thead>
		<tbody>
			<c:forEach items="${reqeustScope.student}" var="student">
			<tr>
				<td>${requestScope.student.num}</td>
				<td>${requestScope.student.name}</td>
				<td>${requestScope.student.kor}</td>
				<td>${requestScope.student.eng}</td>
				<td>${requestScope.student.math}</td>
				<td>${requestScope.student.total}</td>
				<td>${requestScope.student.avg}</td>
				
			</tr>
			</c:forEach>
		</tbody>
	
	
	</table>
</body>
</html>