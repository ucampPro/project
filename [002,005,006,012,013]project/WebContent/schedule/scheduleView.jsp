<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h3>일정상세보기</h3>
	<table border="1">
		<tr>
			<td>홈팀</td>
			<td>
				${requestScope.schedule.firstTeam}
			</td>
		</tr>
		<tr>
			<td>어웨이팀</td>
			<td>
				${requestScope.schedule.secondTeam}
			</td>
		</tr>
		<tr>
			<td>시기</td>
			<td>
				${requestScope.schedule.year}년${requestScope.schedule.month}월${requestScope.schedule.day}일${requestScope.schedule.hour}시
			</td>
		</tr>
	</table>
	<a href="sController?action=updateForm&code=${requestScope.schedule.code}">정보수정 </a><br>
	<a href="sController?action=delete&code=${requestScope.schedule.code}">일정삭제 </a><br>
	<a href="index.jsp">메인</a>
</body>
</html>