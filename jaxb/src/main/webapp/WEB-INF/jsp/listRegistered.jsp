<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="fr.utbm.jaxb.entity.Client"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Liste des inscrits</title>
		<link rel="stylesheet" type="text/css" href="././style.css">
	</head>
	<body>
	
		<% String cours =  "" + request.getAttribute("course");%>
		<% String ses =  "" + request.getAttribute("session");%>
		
		<h1><%="Liste des inscrits à la session " + ses + " de " + cours%> </h1>
		<div id="menubar">
			<ul id="menu">
				<li><a href="http://localhost:8080/jaxb">Accueil </a></li>
				<li><a href= <%="\"http://localhost:8080/jaxb/listcoursesession?course=" + cours + "\""%>>Liste des sessions</a></li>
			</ul>
		</div>
		<div class = "corps">
			<c:forEach var = "client" items="${clients}">
				<p>Nom: <c:out value = "${client.getLastname()}"/><br/>Prénom:  <c:out value = "${client.getFirstname()}"/><br/>Adress: <c:out value = "${client.getAdress()}"/><br/>Phone: <c:out value ="${client.getPhone()}"/><br/>email: <c:out value = "${client.getEmail()}"/></p>
			</c:forEach>
	
		</div>
		<div class = "basDePage">
	       	<p class="texteBasDePage"> Projet réalisé dans le cadre de l'UV <strong>LO54</strong> par <strong>Jean-Eudes Patois</strong> et <strong>Mickaël Constanzer</strong> </p>
	    </div>
	</body>
</html>