<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Inscription au cours</title>
</head>
<body>
	<h1>Inscription à <% out.print(request.getParameter("course")); %></h1><br/>
	
	<h2>Inscription via formulaire</h2>
	<form action="sessioninscription" method="post">
       Adresse*: <input type="text" name="adress" required/><br/>
       E-mail*: <input type="text" name="email" required/><br/>
       Prénom*: <input type="text" name="firstname" required/><br/>
       Nom*: <input type="text" name="lastname" required/><br/>
       Téléphone*: <input type="text" name="phone" required/><br/>
       N° de session: <input type="text" name="session" value='<%=request.getParameter("session")%>' readonly/><br/>
       Cours: <input type="text" name="course" value='<%=request.getParameter("course")%>' readonly/><br/>
       <input type="submit" value="S'inscrire"/>
     </form>
     <br/><br/>
     <h2>Inscription via fichier XML</h2>
     <form action="importxmlfile" method="post">
     	<input type="file" id="file" name="filepath">
     	N° de session: <input type="text" name="session" value='<%=request.getParameter("session")%>' readonly/>
     	<input type="submit" value="S'inscrire"/>
     </form>
</body>
</html>