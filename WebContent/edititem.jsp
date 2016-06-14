<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>editItem</title>
</head>
<body>
	<h1>Edit Items</h1>
	<hr>
	Welcome, ${sessionScope.managername}!<br>
	<s:if test="result=='SUCCESSEDITITEM'">
	Edit successfully!
	</s:if>
		<form action="itemeditAction" method="post" >
	<table border="1">
		<thead>
			<tr>
				<th> Edit items below!</th>			
			</tr>
		</thead>
		<tbody>
		<s:iterator value="itemList">
				<tr><th>Id:<input type="text" name="itemId" value="<s:property value="itemId"/>"/></th></tr>
				<tr><th>Image:<img style="width: 200px;" src="<s:property value="itemPictureLink"/>"/>
				         ImageLink:<input type="text" name="itemPictureLink" value="<s:property value="itemPictureLink"/>"/></th>
				</tr>
				<tr><th>Name:<input type="text" name="itemName" value="<s:property value="itemName"/>"/></th></tr>
				<tr><th>Price:<input type="text" name="itemPrice" value="<s:property value="itemPrice"/>"/></th></tr>
				<tr><th>Quantity:<input type="text" name="itemQuantity" value="<s:property value="itemQuantity"/>"/></th></tr>
				<tr><th>Story:<input style="width: 300px; height:300px" type="text" name="itemDescription" value="<s:property value="itemDescription"/>"/></th></tr>
		        <tr> <td><input type="submit"  value="edit"/></td></tr>
		</s:iterator> 	
		</tbody>
	</table>
	</form>
	<a class="click" href="managerwelcome.jsp">back to item list.</a>
	


</body>
</html>