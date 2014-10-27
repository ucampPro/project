<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>DIV �±� ���� �����</title>
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
					<div class="div2">�α��� ���ּ���</div>
				</c:when>
				<c:otherwise>
					<div class="div2">����� : ${sessionScope.cust_id}</div>
				</c:otherwise>
			</c:choose>
			
			<div class="div1">&nbsp;</div>
			<div class="div3">ȸ����������</div>
			<c:choose>
				<c:when test="${sessionScope.cust_id == null}">
					<div class="div2" style="text-align: right;"><a href="memberjoin.jsp">ȸ������</a></div>
				</c:when>
				<c:otherwise>
					<div class="div2" style="text-align: right;"><a href="membercontroller?action=view">����������</a></div>
					<div class="div2" style="text-align: right;"><a href="membercontroller?action=update">ȸ�����������ϱ�</a></div>
					<div class="div2" style="text-align: right;"><a href="membercontroller?action=list">ȸ������Ʈ����</a></div>
					<div class="div2" style="text-align: right;"><a href="delete.jsp">ȸ��Ż���ϱ�</a></div>
				</c:otherwise>
			</c:choose>
			</div>
		</div>
</body>
</html>
