<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Export XML</title>
		<link rel="stylesheet" type="text/css" href="././style.css">
	</head>
	<body>
	
		<h1>Export du fichier XML</h1>
		<% String cours = request.getParameter("course"); %>
		<% String filename = ""+ request.getAttribute("filename"); %>
		<% String path = ""+ request.getAttribute("path"); %>
		<div id="menubar">
			<ul id="menu">
				<li><a href="http://localhost:8080/jaxb">Accueil </a></li>
				<li><a href= <%="http://localhost:8080/jaxb/listcoursesession?course=" + cours%>>Liste des sessions</a></li>
			</ul>
		</div>
		<div class="corps">
			<p><%="Le fichier <strong>" + filename + ".xml </strong> a été enregistré dans <strong>" + path + "</strong>."%><br/><br/></p>
		</div>
		<div class = "basDePage">
	       		<p class="texteBasDePage"> Projet réalisé dans le cadre de l'UV <strong>LO54</strong> par <strong>Jean-Eudes Patois</strong> et <strong>Mickaël Constanzer</strong> </p>
	    </div>
	</body>
</html>