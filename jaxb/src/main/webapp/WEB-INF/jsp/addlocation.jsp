<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<link rel="stylesheet" type="text/css" href="././style.css">
		<title>Ajout de lieu</title>
	</head>
	<body>
		<h1>Ajouter un nouveau lieu</h1>
		<div id="menubar">
			<ul id="menu">
				<li><a href="http://localhost:8080/jaxb">Accueil </a></li>
				<li><a href="http://localhost:8080/jaxb/addcoursesession?course=<%= request.getParameter("course") %>">Ajouter une session de cours</a></li>
			</ul>
		</div>
		<div class= "corps">
		<form action="addlocation" method="post" id="formAddLocation">
	       	<div class= "intFormAddLocation">Ville*: </div><input type="text" name="city" required/><br/>
	       	<input type="hidden" name="course" value='<%=request.getParameter("course") %>' readonly%>
       		<input type="submit" value="Ajouter le lieu"/>
       	</form>
       	</div>
       	<div class = "basDePage">
	    	<p class="texteBasDePage"> Projet réalisé dans le cadre de l'UV <strong>LO54</strong> par <strong>Jean-Eudes Patois</strong> et <strong>Mickaël Constanzer</strong> </p>
	    </div>
	</body>
</html>