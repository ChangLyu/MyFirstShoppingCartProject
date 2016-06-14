<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Items list</title>
</head>
<body>
	<h1>welcome to the online shop market!</h1>
	<hr>
	Welcome, ${sessionScope.managername}!<br>

	<s:if test="result=='FAILADD'" >
		The quantity of items you want to put in your shopping cart is beyond the left quantity of items!
	</s:if>
		<s:if test="result=='SUCCESSDECREASE'" >
		You have added the item to your shopping cart successfully!
	</s:if>
	<s:action name="managerlistallAction" namespace="/" executeResult="true" />
	

</body>
</html>