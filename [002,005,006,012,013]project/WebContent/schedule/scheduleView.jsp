<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h3>�����󼼺���</h3>
	<table border="1">
		<tr>
			<td>Ȩ��</td>
			<td>
				${requestScope.schedule.firstTeam}
			</td>
		</tr>
		<tr>
			<td>�������</td>
			<td>
				${requestScope.schedule.secondTeam}
			</td>
		</tr>
		<tr>
			<td>�ñ�</td>
			<td>
				${requestScope.schedule.year}��${requestScope.schedule.month}��${requestScope.schedule.day}��${requestScope.schedule.hour}��
			</td>
		</tr>
	</table>
	<a href="sController?action=updateForm&code=${requestScope.schedule.code}">�������� </a><br>
	<a href="sController?action=delete&code=${requestScope.schedule.code}">�������� </a><br>
	<a href="index.jsp">����</a>
</body>
</html>