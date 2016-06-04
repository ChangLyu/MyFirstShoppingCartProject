<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>My shopping cart</title>
</head>
<body>
<table border="1">
		<thead>
			<tr><th colspan="8">This is your shopping cart!</th></tr>
			<tr>
				<th>User Id</th>
				<th>Item Id</th>	
				<th>Item Number</th>
				<th colspan="2">Operations</th>
				
			</tr>
		</thead>
		<tbody>
		<s:iterator value="shoppingcart" >
			<tr>
				<td><s:property value="itemId"/></td>
				<td><img style="width: 200px;" src="<s:property value="itemPictureLink"/>"/></td>
				<td><s:property value="itemName"/></td>
				<td><s:property value="itemPrice"/></td>
				<td><s:property value="itemQuantity"/></td>
				<td style="max-width: 10px; white-space: nowrap;overflow: hidden; text-overflow: ellipsis;"><s:property value="itemDescription"/></td>

               <td><a href="<s:url  action="showdetailAction"> <s:param name="itemId" value="%{itemId}" /></s:url>">more details</a></td>
               <td><a href="<s:url  action="addtocartAction"> <s:param name="itemId" value="%{itemId}" /></s:url>">add to cart</a></td>
               
			</tr>
		</s:iterator> 	
		</tbody>
	</table>

</body>
</html>