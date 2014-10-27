<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>DIV 태그 연습 결과물</title>
<style type="text/css">
th{
	text-align: center;
}
td{
	text-align: center;
}
.hh{
	width: 60px;
	height: 60px;
	color: white;
	font-weight: bold;
	font-size: 20px;
}
#result{
	font-weight: bold;
	color: red;
}
</style>
</head>

<link rel="stylesheet" type="text/css" href="css/style.css" />
<script type="text/javascript" src="js/httpRequest.js"></script>
<script type="text/javascript">
	var first ="first";
	var second = "second";
	var num1 = 1;
	var num2 = 1;
	var timer = 4 * 1000;
	
	function change(code, ft, st){
		sendRequest("Recordcontroller", "action=gameStart&code=" + code + "&ft=" + ft + "&st=" + st, viewData, "post");
	}
	function viewData(){
		var fir = null;
		var sec = null;
		
		if(httpRequest.readyState == 4 && httpRequest.status == 200){
			var data = httpRequest.responseText;
			var sendData1 = data.split("/")[0].trim();
			var sendData2 = data.split("/")[1].trim();
			var result = data.split("/")[2].trim();
			
			var total1 = document.getElementById("total1");
			var total2 = document.getElementById("total2");
			
			var t1 = document.getElementById("t1");
			var t2 = document.getElementById("t2");
			
			for(var i = 0; i < 9; i++){
				var id1 = setTimeout(function(){
					fir = first + num1;
					var a = parseInt(sendData1.split(",")[num1 - 1], 10);
					var data = parseInt(total1.firstChild.nodeValue, 10) + a;
					document.getElementById(fir).innerHTML = a;
					total1.innerHTML = data;
					t1.innerHTML = data;
					num1++;
				}, 2 * 1000 + timer * i);
			}
			
			var id2 = setInterval(function(){
				sec = second + num2;
				
				var a = parseInt(sendData2.split(",")[num2 - 1], 10);
				var data = parseInt(total2.firstChild.nodeValue, 10) + a;
				document.getElementById(sec).innerHTML = a;
				total2.innerHTML = data;
				t2.innerHTML = data;
				num2++;
			}, timer);
			
			var res = setTimeout(function(){
				document.getElementById("result").innerHTML = result;
			}, 38 * 1000);
			
			setTimeout(function(){
				clearTimeout(id1);
				clearInterval(id2);
			}, 38 * 1000);
			
			setTimeout(function(){
				clearTimeout(res);
			}, 42 * 1000);
		}
	}
</script>
</head>
<body onload="change('${requestScope.code}','${requestScope.ft}','${requestScope.st}')">
	<div id="container">
		<%--<jsp:include page="sidecontent.jsp"></jsp:include>--%>
		<div id="header">GAME</div>
		<div id="content" style="text-align: center; font-size: 20px;">
			<div style="color: white; font-weight: bold;font-size: 40px;">UCAMP SPORTS</div>
			<div style="background-color: #5050FF;">
				<table align="center" cellpadding="0" cellspacing="0">
					<tr style="background-color: #0064FF;">
						<td class="hh" style="background-image: url('image/${requestScope.imgft}.jpg'); background-color: white;"></td>
						<td id="t1" class="hh" >0</td><td class="hh" >vs</td><td id="t2" class="hh" >0</td>
						<td class="hh" style="background-image: url('image/${requestScope.imgst}.jpg'); background-color: white;"></td>
					</tr>
				</table><br>
				<table align="center" cellpadding="0" cellspacing="0">
					<tr style="background-color: #3232FF;">
						<th>팀명</th><th>1회</th><th>2회</th><th>3회</th><th>4회</th><th>5회</th>
						<th>6회</th><th>7회</th><th>8회</th><th>9회</th><th style="width:80px;">SCORE</th>
					</tr>
					<tr style="background-color: #00008C; color: #E0EBFF; font-weight: bold;">
						<td id="team1" style="background-color: #00008C; color: black; font-weight: bold;">${requestScope.ft}</td><td id="first1"></td><td id="first2"></td><td id="first3"></td>
						<td id="first4"></td><td id="first5"></td><td id="first6"></td><td id="first7"></td>
						<td id="first8"></td><td id="first9"></td><td id="total1">0</td>
					</tr>
					<tr style="background-color: #00008C; color: #E0EBFF; font-weight: bold;">
						<td id="team2" style="background-color: #00008C; color: black; font-weight: bold;">${requestScope.st}</td><td id="second1"></td><td id="second2"></td><td id="second3"></td>
						<td id="second4"></td><td id="second5"></td><td id="second6"></td><td id="second7"></td>
						<td id="second8"></td><td id="second9"></td><td id="total2">0</td>
					</tr>
				</table><br>
					<div id="result"></div>
				</div>
	</div>
</div>
</body>
</html>
