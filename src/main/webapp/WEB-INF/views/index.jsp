<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>        

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<table>
<tr>
<td><a href="createEventPage">Create New Event</a></td>
<td><a href="createPersonPage">Register in a Event</a></td>
<td><a href="PersonEventPage">Unregister Persons Event</a></td>
</tr>

</table>

<table>
<thead>
<tr>
<th>Person ID</th>
<th>Person Name</th>
<th>Events</th>
</tr>
</thead>

<c:forEach var="s" items="${list}">
<tbody>
<tr>
<td>${s.pid}</td>
<td>${s.pname}</td>
<td>${s.events}</td>
</tr>
</tbody>

</c:forEach>

</table>

</body>
</html>