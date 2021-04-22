<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type = "text/css" href="css/dateTime.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript" src= "/scripts/dateScript.js">

<script type="text/javascript" src="js/date.js"></script>
<title>Data and time</title>
</head>
<body >
	<a href="/">Back</a>
    <h1 class=<c:out value="${dt}"/>><c:out value="${ dtFormat }" /></h1>

    
</body>
</html>