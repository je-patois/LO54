<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add a new course</title>
</head>
	<body>
		<h1>Add a ew course</h1>
		<form action="addcourse" method="post">
	       	Code: <input type="text" name="code"/><br/>
	       	Title: <input type="text" name="title"/><br/>
       		<input type="submit" value="Create"/>
       	</form>
	</body>
</html>