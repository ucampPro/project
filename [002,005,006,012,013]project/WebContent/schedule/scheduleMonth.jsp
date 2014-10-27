<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<link rel='stylesheet' type='text/css' href='http://arshaw.com/css/main.css?6' />
<link rel='stylesheet' type='text/css' href='http://arshaw.com/css/fullcalendar.css?3' />
<link rel='stylesheet' type='text/css' href='http://arshaw.com/js/fullcalendar-1.6.3/fullcalendar/fullcalendar.css' />
<script type='text/javascript' src='http://arshaw.com/js/fullcalendar-1.6.3/jquery/jquery-1.10.2.min.js'></script>
<script type='text/javascript' src='http://arshaw.com/js/fullcalendar-1.6.3/jquery/jquery-ui-1.10.3.custom.min.js'></script>
<script type='text/javascript' src='http://arshaw.com/js/fullcalendar-1.6.3/fullcalendar/fullcalendar.min.js'></script>
<style type="text/css">
#show{
	cursor: pointer;
}
</style>
<script type="text/javascript">
	function showGame(code, ft, st){
		location.href = "Recordcontroller?action=setValue&code=" + code +
				"&ft=" + ft + "&st=" + st;
	}
</script>
</head>
<script type='text/javascript'>
	var firstTeam = '${firstTeam}';
	var firstTeams = firstTeam.split("[");
	firstTeams = firstTeams[1].split("]");
	firstTeams = firstTeams[0].split(",");
	
	var secondTeam = '${secondTeam}';
	var secondTeams = secondTeam.split("[");
	secondTeams = secondTeams[1].split("]");
	secondTeams = secondTeams[0].split(",");
	
	var year = '${year}';
	var years = year.split("[");
	years = years[1].split("]");
	years = years[0].split(",");
	
	var month = '${month}';
	var months = month.split("[");
	months = months[1].split("]");
	months = months[0].split(",");
	
	var day = '${day}';
	var days = day.split("[");
	days = days[1].split("]");
	days = days[0].split(",");
	
	var code = '${code}';
	var codes = code.split("[");
	codes = codes[1].split("]");
	codes = codes[0].split(",");
		
	var data="[{'title' : '${list[0].firstTeam} VS ${list[0].secondTeam}','start' : new Date(${list[0].year}, ${list[0].month-1}, ${list[0].day}), 'url' : 'Recordcontroller?action=setValue&code=${list[0].code}&ft=${list[0].firstTeam}&st=${list[0].secondTeam}'}";
	for(i=1; i<${size}; i++){
		data += ",{'title' : '"+firstTeams[i]+" VS "+secondTeams[i]+"','start' : new Date("+years[i]+", "+parseInt(months[i]-1)+", "+days[i]+"), 'url' : 'Recordcontroller?action=setValue&code="+codes[i]+"&ft="+firstTeams[i]+"&st="+secondTeams[i]+"'}";
	}
	data += "]";
	data = eval('(' + data + ')');
	$(document).ready(function() {
	
		$('#calendar').fullCalendar({
			header : {
				left : 'prev,next today',
				center : 'title',
				right : 'month,agendaWeek,agendaDay'
			},
			events : data
		});

	});
</script>
</head>
<body style="background-color:white;">
	<div id='calendar' style='margin: 3em 0; font-size: 13px'></div>
</body>
</html>