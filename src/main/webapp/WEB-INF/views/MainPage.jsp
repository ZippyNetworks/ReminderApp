<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<%@ page session="false" %>
<html>
<head>
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<title>Reminder Page</title>
	
</head>
<body style="background: white">
<div class="well well-sm">
  <h2>Reminder Application </h2> 
 <a class="btn btn-success btn-md" href="<c:url value='/addNewReminder' />" >Add new</a>
</div>

<div class="well well-sm">
  <h4>Choose select filter </h4> 
  STATUS :: <select id="selectStatus" onchange="getSelectedStatus()">
  	  <option value="%"  <c:if test="${Selectlist == '%'}"> selected </c:if>>All</option>	
	  <option value="DONE"  <c:if test="${Selectlist == 'DONE'}"> selected </c:if>>DONE</option>
	  <option value="NOTDONE"  <c:if test="${Selectlist == 'NOTDONE'}"> selected </c:if>>NOTDONE</option>
	</select>
	
  DUE DATE(on & before) :: <select id="selectDueDate" onchange="getSelectedStatus()">
  <option value="2050-04-04" <c:if test="${Datelist == '2050-04-04'}"> selected </c:if>>All</option>	
  <c:forEach items="${listDueDate}" var="rm">
  	  <option value="${fn:substring(rm, 0, 10)}" <c:if test="${Datelist==fn:substring(rm, 0, 10)}"> selected </c:if>>${fn:substring(rm, 0, 10)}</option>	
  </c:forEach>	  
	</select>
 </div>

<c:if test="${!empty listReminder}">
	<table class="table table-condensed">
	<tr>
		<th width="60">Reminder Name</th>
		<th width="60">Reminder Description</th>
		<th width="60">Reminder Status</th>
		<th width="60"> Reminder Due Date</th>
   </tr>
	<c:forEach items="${listReminder}" var="rm">
		<tr>
		
			<td>${rm.name}</td>
			<td>${rm.description}</td>
			<td>${rm.status}</td>
			<td>${fn:substring(rm.duedate, 0, 10)}</td>
			<td> <a class="btn btn-success btn-md" href="<c:url value='/updateReminder/${rm.id}' />" >Update</a></td>
		</tr>
	</c:forEach>
	</table>
</c:if>
</body>
<script>
 function getSelectedStatus(){
	 var status = document.getElementById("selectStatus").value;
	 var duedate = document.getElementById("selectDueDate").value;
	 var date = duedate.substring(0,10).trim();
	 var url = "reminderApp"; 
	 var s = "?status="+status+"&duedate="+date;
	// if (url.indexOf('?') > -1){
	//    url += '&duedate='+date
	// }else{
	 //   url += '?status=' +status
	// }
	 window.location.href = url + s;
	// window.location = "rm?status="+status+"&duedate="+duedate; 
 }

</script>
</html>
