<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ajout de lieu</title>
</head>
	<body>
		<h1>Ajouter un nouveau lieu</h1>
		<form action="addlocation" method="post">
	       	Ville*: <input type="text" name="city" required/><br/>
	       	<input type="hidden" name="course" value='<%=request.getParameter("course") %>' readonly%>
       		<input type="submit" value="Ajouter le lieu"/>
       	</form>
	</body>
</html>