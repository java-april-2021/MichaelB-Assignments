<%@ page language="java" contentType="text/html; charset=ISO-8859-1"    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Insert title here</title>
		<link rel="stylesheet" type = "text/css" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
		<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
		<link rel="stylesheet" type="text/css" href="/css/licStyle.css">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
	</head>
	<body>
		<h1>New License</h1>
		<a href="/">Main Page</a>
		<div class = "addLic">
			<form:form method="POST" action="/license/new" modelAttribute="license">
	    		<div class ="form-group">
			        <form:label path="person">Person</form:label>
			        <form:errors path="person"/>
			        <form:select  class = "form-control" path="person">
				        <c:forEach items="${persons}" var="person">
				        	<form:option value="${person.id}">${person.firstName} ${person.lastName}</form:option>
				        </c:forEach>	
			         </form:select>
		   		</div>
		   		<div class = "form-group">
			        <form:label path="state" >State</form:label>
			        <form:errors path="state"/>
			        <form:select class ="form-control" path="state">
			      		<form:option value="AL">AL</form:option>
			      		<form:option value="Ak">AK</form:option>
			      		<form:option value="AS">AS</form:option>
			      		<form:option value="AZ">AZ</form:option>
			      		<form:option value="CA">CA</form:option>
			      		<form:option value="CO">CO</form:option>
			      		<form:option value="CT">CT</form:option>
			      		<form:option value="DE">DE</form:option>
			      		<form:option value="DC">DC</form:option>
			      		<form:option value="FL">FL</form:option>
			      		<form:option value="GA">GA</form:option>
			      		<form:option value="GU">GU</form:option>
			      		<form:option value="HI">HI</form:option>
			      		<form:option value="ID">ID</form:option>
			      		<form:option value="IL">IL</form:option>
			      		<form:option value="IN">IN</form:option>
			      		<form:option value="IA">IA</form:option>
			      		<form:option value="KS">KS</form:option>
			      		<form:option value="KY">KY</form:option>
			      		<form:option value="LA">LA</form:option>
			      		<form:option value="ME">ME</form:option>
			      		<form:option value="MD">MD</form:option>
			      		<form:option value="MA">MA</form:option>
			      		<form:option value="MI">MI</form:option>
			      		<form:option value="MN">MN</form:option>
			      		<form:option value="MS">MS</form:option>
			      		<form:option value="MO">MO</form:option>
			      		<form:option value="MT">MT</form:option>
			      		<form:option value="NE">NE</form:option>
			      		<form:option value="NV">NV</form:option>
			      		<form:option value="NH">NH</form:option>
			      		<form:option value="NJ">NJ</form:option>
			      		<form:option value="NM">NM</form:option>
			      		<form:option value="NY">NY</form:option>
			      		<form:option value="NC">NC</form:option>
			      		<form:option value="ND">ND</form:option>
			      		<form:option value="MP">MP</form:option>
			      		<form:option value="OH">OH</form:option>
			      		<form:option value="OK">OK</form:option>
			      		<form:option value="OR">OR</form:option>
			      		<form:option value="PA">PA</form:option>
			      		<form:option value="PR">PR</form:option>
			      		<form:option value="RI">RI</form:option>
			      		<form:option value="SC">SC</form:option>
			      		<form:option value="SD">SD</form:option>
			      		<form:option value="TN">TN</form:option>
			      		<form:option value="TX">TX</form:option>
			      		<form:option value="UT">UT</form:option>
			      		<form:option value="VT">VT</form:option>
			      		<form:option value="VA">VA</form:option>
			      		<form:option value="VI">VI</form:option>
			      		<form:option value="WA">WA</form:option>
			      		<form:option value="WV">WV</form:option>
			      		<form:option value="WI">WI</form:option>
			      		<form:option value="WY">WY</form:option>
			        </form:select>
		   		</div>
		   		<div class = "form-group">
			        <form:label path="exirationDate">Expiration Date</form:label>
		        	<form:errors path="exirationDate"/>
		        	<form:input type="date" class="form-control" path="exirationDate"/>
		   		</div>
		    	<input type="submit" value="Add License"/> 
			</form:form>
		</div>
	</body>
</html>