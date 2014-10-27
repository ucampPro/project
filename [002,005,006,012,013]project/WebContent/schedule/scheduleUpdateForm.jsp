<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h3>일정수정</h3>
<form name="sUpdateForm" action="sController?action=update&code=${requestScope.schedule.code}" method="post">
	<table border="2">
		<tr>
			<td>일시</td>
			<td>
				<input type="date" name="date"> &nbsp; <input type="time" name="hour">
			</td>
		</tr>
		<tr>
			<td>홈팀</td>
			<td>
				<select name="firstTeam">
					<option>LG</option>
					<option>SAMSUNG</option>
					<option>NC</option>
					<option>NEXEN</option>
				</select>
			</td>
		</tr>
		<tr>
			<td>어웨이팁</td>
			<td>
				<select name="secondTeam">
					<option>LG</option>
					<option>SAMSUNG</option>
					<option>NC</option>
					<option>NEXEN</option>
				</select>
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="submit" value="등록">
				<input type="reset" value="취소">
			</td>
		</tr>
	</table>
</form>
</body>
</html>