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
<h2>ȸ�� �α���</h2>
<form action="controller?action=login" method="post" name="loginForm">
	<table>
		<tr>
			<td>���̵�</td>
			<td><input type="text" name="custId">
		</tr>
		<tr>
			<td>��й�ȣ</td>
			<td><input type="password" name="custPwd">
		</tr>
	</table>
	<input type="submit" value="�α���">
</form>
</center>
</body>
</html>