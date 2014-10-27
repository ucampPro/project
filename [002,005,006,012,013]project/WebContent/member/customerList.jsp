<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<center>
<h2>회원리스트 보기</h2>
<table border="1" width="500px">
	<tr>
		<td>번호</td>
		<td>아이디</td>
		<td>이름</td>
		<td>주소</td>
	</tr>
	<c:forEach items="${list }" var="cust" varStatus="no">
		<tr>
			<td>${no.count }</td>
			<td>${cust.custId }</td>
			<td>${cust.custName }</td>
			<td>${cust.address }</td>
		</tr>
	</c:forEach>
</table>
</center>
</body>
</html>