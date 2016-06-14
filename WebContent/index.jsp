<%@page import="com.opensymphony.xwork2.Result"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ShoppingCartProject</title>
</head>
<body>
	<h1>Welcome to your shopping carting!</h1>
	<hr>
	<s:if test="result=='NOTEXIST'">
	The user name is not exist, make sure you input the right user name!
	</s:if>
	
	<s:if test="result=='FAILLOGIN'">
	The user name doesn't match the password, make sure you input the right password!
	</s:if>
	
	<s:if test="result=='INPUTNULLVALUE'">
		The input can not be null.
	</s:if>
	
	<s:if test="result=='SUCCESSREGISTER'">
		You have successfully registered, please use your register username and password login.
	</s:if>
	
	<h4>UserLogin:</h4>
	<div><a href="managerlogin.jsp">ManagerLogin</a></div>
	<form action="loginAction" method="post">
		<table>
			<tr>
				<td>UserName:</td>
				<td><input type="text" name="username"></td>
			</tr>
			<tr>
				<td>PassWord:</td>
				<td> <input type="password" name="password"></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="submit"></td>
			</tr>
	</table>
	</form>
	<h4>If you have registered already, please login. If not, please register.</h4>
	<a href="register.jsp">Register here!</a>

</body>
</html>