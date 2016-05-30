<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Register here.</title>
</head>
<body>
	<h3>Please register here!</h3>
	<hr>
	
	<!-- when after register, system will check if the username is exist, if it is, it will jump back to the 
	register page and the below code will display-->
 	<s:property value="result"/>
	<s:if test="result=='FAILREGISTER'" >
		The user name you input is already existed, please input another one.
	</s:if>
	
	<s:if test="result=='INPUTNULLVALUE'" >
		The input can not be null.
	</s:if>
	
	
	<form action="registerAction" method="post" >
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
	<h4>If you have already registered, please login in!</h4>
	<a href="index.jsp">Login</a>

</body>
</html>