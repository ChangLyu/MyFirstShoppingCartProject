<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link type="text/css" rel="stylesheet" href="css/stylesheet.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Item details</title>
</head>
<body>
	<h1>Item details</h1>
	<hr>
	Welcome, ${sessionScope.username}!<br>
	<table border="1">
		<thead>
			<tr>
				<th> This is a cute teemo!</th>			
			</tr>
		</thead>
		<tbody>
		<s:iterator value="itemList">
				<tr><th>Id:<s:property value="itemId"/></th></tr>
				<tr><th><img style="width: 200px;" src="<s:property value="itemPictureLink"/>"/></th></tr>
				<tr><th>Name:<s:property value="itemName"/></th></tr>
				<tr><th>Price:<s:property value="itemPrice"/></th></tr>
				<tr><th>Quantity:<s:property value="itemQuantity"/></th></tr>
				<tr><th style="width: 500px;">Story:<s:property value="itemDescription"/></th></tr>
		</s:iterator> 	
		</tbody>
	</table>
	<a class="click" href="welcome.jsp">back to item list.</a>
	

</body>
</html>