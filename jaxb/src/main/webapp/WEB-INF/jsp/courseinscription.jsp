<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Course inscription</title>
</head>
<body>
	<h1>Inscription � <% out.print(request.getParameter("course")); %></h1>
	<form action="sessioninscription" method="post">
       Adress: <input type="text" name="adress"/><br/>
       Email: <input type="text" name="email"/><br/>
       Firstname: <input type="text" name="firstname" /><br/>
       Lastname: <input type="text" name="lastname" /><br/>
       Phone: <input type="text" name="phone" /><br/>
       Session: <input type="text" name="session" value='<%=request.getParameter("session")%>' readonly/><br/>
       Cours: <input type="text" name="course" value='<%=request.getParameter("course")%>' readonly/><br/>
       <input type="submit" value="Create"/>
     </form>
</body>
</html>