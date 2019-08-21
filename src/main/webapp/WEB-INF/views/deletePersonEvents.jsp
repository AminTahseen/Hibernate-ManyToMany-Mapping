<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>        
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="EventList">
<table>

<tr>
<td>Person Name</td>
<td><input type="text" name="pname"></td>
</tr>

<tr>
<td><input type="submit" value="find"></td>
</tr>

</table>
</form>

<!--Person Data-->

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

<h4>Un Register An Event</h4>
<br/>
<form action="DeletePersonEvent">
<table>

<tr>
<td>Person Name</td>
<td><input type="text" name="pname"></td>
</tr>

<tr>
<td>Event Name</td>
<td><input type="text" name="ename"></td>
</tr>


<tr>
<td><input type="submit" value="delete"></td>
</tr>

</table>
</form>
</body>
</html>