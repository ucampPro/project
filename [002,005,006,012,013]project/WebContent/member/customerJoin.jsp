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
<h2>ȸ������</h2>
<form action="controller?action=joinCustomer" method="post" name="joinForm">
	<table>
		<tr>
			<td>���̵�</td>
			<td><input type="text" name="custId"></td>
		</tr>
		<tr>
			<td>�̸�</td>
			<td><input type="text" name="custName"></td>
		</tr>
		<tr>
			<td>��й�ȣ</td>
			<td><input type="password" name="custPwd"></td>
		</tr>
		<tr>
			<td>�ּ�</td>
			<td><input type="text" name="address"></td>
		</tr>						
	</table>
	<input type="submit" value="���"><input type="reset" value="���">
</form>
</center>
</body>
</html>