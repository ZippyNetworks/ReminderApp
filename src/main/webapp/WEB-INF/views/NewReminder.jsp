<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<title>Reminder</title>
	
</head>
<body style="background: white">
<div class="well well-sm">
  <h2>Add New Reminder</h2>
</div>

<c:url var="addAction" value="/reminder/add" ></c:url>

<form:form action="${addAction}" commandName="reminder">
<table class="table table-condensed">

	<tr>
		<td>
			<form:label path="id">
				<spring:message text="ID"/>
			</form:label>
		</td>
		<td>
			<form:input path="id" readonly="true" size="8"  disabled="true" />
		</td> 
		
	</tr>
	
	<tr>
		<td>
			<form:label path="name">
				<spring:message text="Name"/>
			</form:label>
		</td>
		<td>
			<form:input path="name" />
		</td> 
		
	</tr>
		<tr>
		<td>
			<form:label path="description">
				<spring:message text="Description"/>
			</form:label>
		</td>
		<td>
			<form:input path="description" />
		</td> 
		
	</tr>
	<tr>
		<td>
			<form:label path="status">
				<spring:message text="Status"/>
			</form:label>
		</td>
		<td>
			<form:input path="status" />
		</td>
	</tr>
	<tr>
		<td>
			<form:label path="duedate">
				<spring:message text="DueDate"/>
			</form:label>
		</td>
		<td>
			<form:input path="duedate"  />
		</td>
	</tr>
	
	<tr>
		<td colspan="2">
		<div class="well well-sm">
		
		<input type="submit"
					value="<spring:message text="Add Reminder"/>" />
		</div>
		</td>			
	</tr>
	
</table>	
</form:form>
<br>

</div>

</body>
</html>
