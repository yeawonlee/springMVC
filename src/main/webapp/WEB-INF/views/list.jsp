<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Member List</title>
</head>
<body>
	<h1>Member List</h1>
	<input type="button" value="회원 등록" onclick="location.href='${pageContext.request.contextPath}/members/form'">	
	<table border="1" width="600px">
		<tr>
			<th>No</th>
			<th>ID</th>
			<th>Name</th>
			<th>Email</th>
		</tr>

		<!-- MemberController에서 model을 통해 넘겨준 변수명(items)과 동일해야 함 -->
		<!-- items 리스트에서 하나씩. dto 값 출력 -->
		<c:forEach var="row" items="${items}">
		<tr>
			<td>${row.idx}</td>
			<td>${row.id}</td>
			<td><a href="${pageContext.request.contextPath}/members/${row.idx}">
					${row.name}</a></td>
			<td>${row.email}</td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>