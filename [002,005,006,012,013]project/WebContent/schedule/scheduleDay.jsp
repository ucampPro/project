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
<h3>������������</h3>
<table border="1">
	<tr>
		<th>NO</th>
		<th>�Ͻ�</th>
		<th>���</th>
		<th>���</th>
	</tr>
<c:forEach items="${requestScope.list}" var="list" varStatus="num">
	<tr>
		<td>
			${num.count}
		</td>
		<td>
			${list.year}�� ${list.month}�� ${list.day}�� ${list.hour}��
		</td>
		<td>
			${list.code}">${list.firstTeam} VS ${list.secondTeam}
		</td>
		<td>
			<c:if test="${list.firstScore!=-1}">
				${list.firstScore} VS ${list.secondScore}
			</c:if>
			<c:if test="${list.firstScore==-1}">
				���� ��� ���Դϴ�.
			</c:if>
		</td>
	</tr>
</c:forEach>
</table>
</center>
</body>
</html>