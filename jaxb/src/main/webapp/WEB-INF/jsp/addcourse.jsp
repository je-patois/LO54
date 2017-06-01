<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Ajout de cours</title>
	<link rel="stylesheet" type="text/css" href="././style.css">
	</head>
	<body>
		<h1>Ajouter un nouveau cours</h1>
        <div id="menubar">
			<ul id="menu">
				<li><a href="http://localhost:8080/jaxb">Accueil </a></li>
				<li class = "selection"><a href="http://localhost:8080/jaxb/addcourse">Ajouter un cours</a></li>
			</ul>
		</div>
		<div class = "corps">
			<form action="addcourse" method="post" id="formAddCourse">
		       	<div class="intFormAddCourse">Code de cours*:</div><input type="text" name="code" required/><br/>
		       	<div class="intFormAddCourse">Intitulé*: </div><input type="text" name="title" required/><br/>
	       		<input type="submit" value="Ajouter le cours"/>
	       	</form>
       	</div>
       	<div class = "basDePage">
       			<p class="texteBasDePage"> Projet réalisé dans le cadre de l'UV <strong>LO54</strong> par <strong>Jean-Eudes Patois</strong> et <strong>Mickaël Constanzer</strong> </p>
       	</div>
  
	</body>
</html>