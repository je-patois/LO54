<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Import XML</title>
		<link rel="stylesheet" type="text/css" href="././style.css">
	</head>
	<body>
	
		<h1>Ajout de lieu</h1>
		<% String cours = "" + request.getParameter("course"); %>
		<% String city = request.getParameter("city");%>
		<div id="menubar">
			<ul id="menu">
				<li><a href="http://localhost:8080/jaxb">Accueil </a></li>
				<li><a href= <%="http://localhost:8080/jaxb/listcoursesession?course=" + cours %>>Retourner à la liste des sessions de cours</a></li>
			</ul>
		</div>
		<div class="corps">
		
			<h2>Ajout de la ville en base de données</h2>
			<p><%= "City :" + city%></p>
			
			<% 	boolean success = Boolean.parseBoolean(""+request.getAttribute("success"));
				if(success) {%>
				<p><strong>Le lieu a été ajouté avec succcès</strong></p>
			<% } else { %>
				<p><strong>Une erreur est survenue durant l'ajout en base de données. Veuillez réessayer plus tard.</strong></p>
			<% } %>
			
		</div>
		<div class = "basDePage">
	       		<p class="texteBasDePage"> Projet réalisé dans le cadre de l'UV <strong>LO54</strong> par <strong>Jean-Eudes Patois</strong> et <strong>Mickaël Constanzer</strong> </p>
	    </div>
	</body>
</html>