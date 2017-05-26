<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ajout de cours</title>
</head>
	<body>
		<h1>Ajouter un nouveau cours</h1>
		<form action="addcourse" method="post">
	       	Code de cours*: <input type="text" name="code" required/><br/>
	       	Intitulé*: <input type="text" name="title" required/><br/>
       		<input type="submit" value="Ajouter le cours"/>
       	</form>
	</body>
</html>