<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>        

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action="SavePersonEvent">

<table>

<tr>
<td>Person Name</td>
<td><input type="text" name="pname"></td>
</tr>

<tr>
<td>Event</td>
<td>

<select name="ename">

<c:forEach var="s" items="${ename}">

<option value="${s}">${s}</option>

</c:forEach>

</select>

</td>
</tr>

<tr>
<td><input type="submit" value="Register"></td>
</tr>

</table>

</form>

</body>
</html>