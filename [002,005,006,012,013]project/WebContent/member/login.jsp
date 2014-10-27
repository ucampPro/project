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
<h2>회원 로그인</h2>
<form action="controller?action=login" method="post" name="loginForm">
	<table>
		<tr>
			<td>아이디</td>
			<td><input type="text" name="custId">
		</tr>
		<tr>
			<td>비밀번호</td>
			<td><input type="password" name="custPwd">
		</tr>
	</table>
	<input type="submit" value="로그인">
</form>
</center>
</body>
</html>