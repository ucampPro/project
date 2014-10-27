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
<h3>전체 일정 리스트</h3>
<table border="1">
	<tr>
		<th>NO</th>
		<th>일시</th>
		<th>경기</th>
		<th>결과</th>
	</tr>
<c:forEach items="${requestScope.list}" var="list" varStatus="num">
	<tr>
		<td>
			${num.count}
		</td>
		<td>
			${list.year}년 ${list.month}월 ${list.day}일 ${list.hour}시
		</td>
		<td>
			<a href="sController?action=selectOne&code=${list.code}">${list.firstTeam} VS ${list.secondTeam}</a>
		</td>
		<td>
			<c:if test="${list.firstScore!=-1}">
				${list.firstScore} VS ${list.secondScore}
			</c:if>
			<c:if test="${list.firstScore==-1}">
				아직 경기 전입니다.
			</c:if>
		</td>
	</tr>
</c:forEach>
</table>
<a href="index.jsp">일정관리</a>
</body>
</html>