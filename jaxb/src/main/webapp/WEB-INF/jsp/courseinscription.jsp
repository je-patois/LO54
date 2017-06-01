<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Inscription au cours</title>
		<link rel="stylesheet" type="text/css" href="././style.css">
	</head>
	<body>
		<h1>Inscription à <% out.print(request.getParameter("course")); %></h1>
		<div id="menubar">
			<ul id="menu">
				<li><a href="http://localhost:8080/jaxb">Accueil </a></li>
				<li><a href="http://localhost:8080/jaxb/addcoursesession?course=<%= request.getParameter("course") %>">Ajouter une session de cours</a></li>
			</ul>
		</div>
		<div class= "corps">
		<h2>Inscription via formulaire</h2>
		<form action="sessioninscription" method="post" id = "formInscriptionWeb">
	       <span class="intFormWeb">Adresse*: </span><input type="text" name="adress" class="valFormWeb"  required/><br/>
	       <span class="intFormWeb">E-mail*: </span><input type="text" name="email" class="valFormWeb" required/><br/>
	       <span class="intFormWeb">Prénom*: </span><input type="text" name="firstname" class="valFormWeb" required/><br/>
	       <span class="intFormWeb">Nom*: </span><input type="text" name="lastname" class="valFormWeb" required/><br/>
	       <span class="intFormWeb">Téléphone*: </span><input type="text" name="phone" class="valFormWeb" required/><br/>
	       <span class="intFormWeb">N° de session: </span><input type="text" name="session" class="valFormWeb" value='<%=request.getParameter("session")%>' readonly/><br/>
	       <span class="intFormWeb">Cours: </span><input type="text" name="course" class="valFormWeb" value='<%=request.getParameter("course")%>' readonly/><br/>
	       <input type="submit" value="S'inscrire"/>
	     </form>
	     <br/><br/>
	     <h2>Inscription via fichier XML</h2>
	     <form action="importxmlfile" method="post" id = "formInscriptionXML">
	     	<input type="file" id="file" name="filepath">
	     	N° de session: <input type="text" name="session" value='<%=request.getParameter("session")%>' readonly/>
	     	<input type="submit" value="S'inscrire"/>
	     </form>
	     </div>
	     <div class = "basDePage">
	       	<p class="texteBasDePage"> Projet réalisé dans le cadre de l'UV <strong>LO54</strong> par <strong>Jean-Eudes Patois</strong> et <strong>Mickaël Constanzer</strong> </p>
	     </div>
	</body>
</html>