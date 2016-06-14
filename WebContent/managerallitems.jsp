<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>all items</title>
</head>
<body>
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
		<s:iterator value="itemList" >
			<tr>
				<td><s:property value="itemId"/></td>
				<td><img style="width: 200px;" src="<s:property value="itemPictureLink"/>"/></td>
				<td><s:property value="itemName"/></td>
				<td><s:property value="itemPrice"/></td>
				<td><s:property value="itemQuantity"/></td>
				<td style="max-width: 10px; white-space: nowrap;overflow: hidden; text-overflow: ellipsis;"><s:property value="itemDescription"/></td>
                 
               <td><a class="click" href="<s:url  action="jumptoeditAction"> <s:param name="itemId" value="%{itemId}" /></s:url>">edit</a></td>
               <td><a class="click" href="<s:url  action="itemdeleteAction"> <s:param name="itemId" value="%{itemId}" /></s:url>">delete</a></td>
			</tr>
		</s:iterator> 	
		     <tr ><td colspan="3"><a class="click" href="additem.jsp">add</a></td></tr>
		</tbody>
	</table>

</body>
</html>