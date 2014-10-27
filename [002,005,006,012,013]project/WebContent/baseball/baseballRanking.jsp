<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<style type="text/css">
</style>
</head>
<body>
<center>
<br><br><be>
<table border="1" width="500px">
	<tr>
		<th>순위</th>
		<th>구단</th>
		<th>경기</th>
		<th>승</th>
		<th>무</th>
		<th>패</th>
		<th>승률</th>
	</tr>
	<c:forEach items="${list }" var="rank" varStatus="status">
		<tr>
			<td>${status.count }</td>
			<td>${rank.teamname }</td>
			<td>${rank.gamecount }</td>
			<td>${rank.win }</td>
			<td>${rank.moo }</td>
			<td>${rank.lose }</td>
			<td>${rank.percent }</td>
		</tr>
	</c:forEach>
</table>
</center>
</body>
</html>