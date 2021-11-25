<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>회원 정보</title>
	
	<script src="http://code.jquery.com/jquery-3.4.1.min.js"></script>
	<script type="text/javascript">
		$(function() {
			// 수정 버튼 클릭
			$("#btnUpdate").click(function() {
				document.form1.action = "${pageContext.request.contextPath}/members/${dto.idx}";	// controller로 
				document.form1.submit();
			});
			// 삭제 버튼 클릭
			$("#btnDelete").click(function() {
				if(confirm("삭제하겠습니까?")) {
					document.form1.action = "${pageContext.request.contextPath}/members/${dto.idx}";
					document.form1.submit();
				}
			});
		});
	</script>
</head>
<body>
	<h1>회원 정보</h1>
	<p> 회원 정보를 수정하거나 삭제하려면 비밀번호를 입력하세요!</p>
	<!-- 회원 정보 수정했을 때, form의 method="post"로 하면 @PostMapping이 실행돼서 회원이 새로 생성됨 -->
	<!-- form의 method 속성을 지우면 수정된 값이 get 방식으로 url의 파라미터로 넘어감 -->
	<form name="form1" method="post">
		<table border="1" width="460px">
			<tr>
				<th>ID</th>
				<td><input name="id" value="${dto.id}" readonly></td>
			</tr>
			<tr>
				<th>Password</th>
				<td><input name="password" type="password"></td>
			</tr>
			<tr>
				<th>Name</th>
				<td><input name="name" value="${dto.name}"></td>
			</tr>
			<tr>
				<th>Email</th>
				<td><input name="email" value="${dto.email}"></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="button" value="수정" id="btnUpdate">
					<!-- form:form -->
					<!-- <input type="hidden" name="_method" value="patch"> -->
					<input type="button" value="삭제" id="btnDelete">
					<!-- <input type="hidden" name="_method" value="delete"> -->
					<div style="color:red">${message}</div>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>