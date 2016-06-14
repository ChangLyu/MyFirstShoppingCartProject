<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>add item</title>
</head>
<body>
	<h1>Edit Items</h1>
	<hr>
	Welcome, ${sessionScope.managername}!<br>

		<form action="itemaddAction" method="post" >
	<table border="1">
		<thead>
			<tr>
				<th> Add items below!</th>			
			</tr>
		</thead>
		<tbody>

				<tr><th>ImageLink:<input type="text" name="itemPictureLink" /></th>
				</tr>
				<tr><th>Name:<input type="text" name="itemName" /></th></tr>
				<tr><th>Price:<input type="text" name="itemPrice" /></th></tr>
				<tr><th>Quantity:<input type="text" name="itemQuantity" /></th></tr>
				<tr><th>Story:<input style="width: 300px; height:300px" type="text" name="itemDescription"/></th></tr>
		        <tr> <td><input type="submit"  value="add"/></td></tr>

		</tbody>
	</table>
	</form>
	<a class="click" href="managerwelcome.jsp">back to item list.</a>
	


</body>
</html>