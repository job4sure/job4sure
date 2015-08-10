<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body>
<c:out value="${invalid}"></c:out>
	<form:form modelAttribute="login" action="signIn" method="post">
		<table>
			<tr>
				<td>User Name</td>
				<td><form:input path="userName" /> <form:errors path="userName" /></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><form:password path="password" /> <form:errors path="password" /></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit"	value="Login"></td>
			</tr>
		</table>
	</form:form>
</body>
</html>