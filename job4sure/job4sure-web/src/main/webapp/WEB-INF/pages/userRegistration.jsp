<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Registration</title>
</head>
<body>
	
 <form:form action="userRegistration" modelAttribute="userRegistration">
		<table border="1" width="30%" cellpadding="5">
			<thead>
				<tr>
					<th colspan="2">User Registration Here</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>Email Id</td>
					<td><form:input path="emailId" /> <form:errors path="emailId" /></td>
					
				</tr>
				<tr>
					<td>User Name</td>
					<td><form:input path="userName" /> <form:errors path="userName" /></td>
				</tr>
				<tr>
					<td>Password</td>
					<td><form:password path="password" /> <form:errors path="password" /></td>
				</tr>
				<tr>
					<td>Address</td>
					<td><form:input path="address" /> <form:errors path="address" /></td>
				</tr>
				<tr>
					<td><input type="submit" value="Submit" /></td>
				</tr>
			</tbody>
		</table>
	</form:form>
</body>
</html>