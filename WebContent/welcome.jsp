<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>online shop market</title>
</head>
<body>
	<h1>welcome to the online shop market!</h1>
	<hr>
	Welcome, ${sessionScope.username}!<br>
	<a href="checkshoppingcart.jsp">check my shopping cart.</a><br>
	<table border="1">
		<thead>
			<tr><th colspan="8">Look what we have!</th></tr>
			<tr>
				<th>Id</th>
				<th>Picture</th>	
				<th>Name</th>
				<th>Price</th>
				<th>Quantity</th>
				<th>Description</th>
				<th colspan="2">Operations</th>
				
			</tr>
		</thead>
		<tbody>
		<s:iterator value="itemList">
			<tr>
				<td style="width: 10px;"><s:property value="itemId"/></td>
				<td><img style="width: 200px;" src="<s:property value="itemPictureLink"/>"/></td>
				<td><s:property value="itemName"/></td>
				<td><s:property value="itemPrice"/></td>
				<td><s:property value="itemQuantity"/></td>
				<td style="max-width: 10px; white-space: nowrap;overflow: hidden; text-overflow: ellipsis;"><s:property value="itemDescription"/></td>
                <td><a href="details.jsp"/>detail</td>
                <td><a href="addtocart.jsp"/>add to shopping cart</td>
			</tr>
		</s:iterator> 	
		</tbody>
	</table>
	

</body>
</html>