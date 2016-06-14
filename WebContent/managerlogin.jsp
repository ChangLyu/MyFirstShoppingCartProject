<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Manager login page</title>
</head>
<body>
	<s:if test="result=='NOTEXIST'">
	The manager name is not exist, make sure you input the right manager name!
	</s:if>
	
	<s:if test="result=='FAILLOGIN'">
	The manager name doesn't match the password, make sure you input the right password!
	</s:if>
	
	<s:if test="result=='INPUTNULLVALUE'">
		The input can not be null.
	</s:if>
	
	<h4>ManagerLogin:</h4>
	<div><a href="index.jsp">UserLogin</a></div>
	<form action="managerloginAction" method="post">
		<table>
			<tr>
				<td>Manager Name:</td>
				<td><input type="text" name="managername"></td>
			</tr>
			<tr>
				<td>Manager PassWord:</td>
				<td> <input type="password" name="managerpassword"></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="submit"></td>
			</tr>
	</table>
	</form>
</body>
</html>