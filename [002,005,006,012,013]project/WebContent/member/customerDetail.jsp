<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<center>
<h2>회원 상세 보기</h2>
<table border="1" width="500px">
	<tr>
		<td width="200px">아이디</td>
		<td>${requestScope.cust.custId }</td>
	</tr>
	<tr>
		<td>이름</td>
		<td>${requestScope.cust.custName }</td>
	</tr>
	<tr>
		<td>주소</td>
		<td>${requestScope.cust.address }</td>
	</tr>
</table>
</center>
</body>
</html>