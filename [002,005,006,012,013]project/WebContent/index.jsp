<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/stylemenu.css" />
</head>
<body>
<div id="indexcontainer">
	<div id="indexcontent"><jsp:include page="sideMenu.jsp"/></div>
	<div id="indexsideinfo">
		<c:if test="${not empty param.action }">
			<jsp:include page="${param.action }"/>
		</c:if>
		<c:if test="${empty param.action }">
			<jsp:include page="info.jsp"/>
		</c:if>		
	</div>
</div>
</body>
</html>