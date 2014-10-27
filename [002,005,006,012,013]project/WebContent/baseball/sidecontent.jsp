<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>DIV 태그 연습 결과물</title>
<link rel="stylesheet" type="text/css" href="css/style.css" />
<style type="text/css">
.div1 {
	background-color: gray;
	height: 20px;
	border-style: solid;
	padding: 2px;
}

.div2 {
	background-color: white;
	height: 40px;
	border-style: solid;
	padding: 2px;
	text-align: right;
}

.div3 {
	background-color: #d2d2d2;
	height: 20px;
	border-style: solid;
	padding: 2px;
}
</style>
</head>

<body>
	<div id="sideinfo">
		<div class="divs" style="margin-top: 100px; padding: 1px;">
			<div class="div1" style="text-align: center;">
				<a href="main.jsp">HOME</a>&nbsp;&nbsp;&nbsp;
				<c:choose>
					<c:when test="${sessionScope.cust_id == null}">
						<a href="login.jsp">LOGIN</a>
					</c:when>
					<c:otherwise>
						<a href="membercontroller?action=logout">LOGOUT</a>
					</c:otherwise>
				</c:choose>
			</div>
			
			<c:choose>
				<c:when test="${sessionScope.cust_id == null}">
					<div class="div2">로그인 해주세요</div>
				</c:when>
				<c:otherwise>
					<div class="div2">사용자 : ${sessionScope.cust_id}</div>
				</c:otherwise>
			</c:choose>
			
			<div class="div1">&nbsp;</div>
			<div class="div3">회원정보관리</div>
			<c:choose>
				<c:when test="${sessionScope.cust_id == null}">
					<div class="div2" style="text-align: right;"><a href="memberjoin.jsp">회원가입</a></div>
				</c:when>
				<c:otherwise>
					<div class="div2" style="text-align: right;"><a href="membercontroller?action=view">상세정보보기</a></div>
					<div class="div2" style="text-align: right;"><a href="membercontroller?action=update">회원정보변경하기</a></div>
					<div class="div2" style="text-align: right;"><a href="membercontroller?action=list">회원리스트보기</a></div>
					<div class="div2" style="text-align: right;"><a href="delete.jsp">회원탈퇴하기</a></div>
				</c:otherwise>
			</c:choose>
			</div>
		</div>
</body>
</html>
