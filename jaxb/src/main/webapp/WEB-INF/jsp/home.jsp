<%@page import="fr.utbm.jaxb.servlet.ListCourse"%>
<%@page import="fr.utbm.jaxb.entity.Course"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>JAXB</title>
	<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
	<link rel="stylesheet" href="/resources/demos/style.css">
	<link rel="stylesheet" type="text/css" href="././style.css">
	 <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
	 <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
	 <script>
	 $( function() {
	   $( "#datePicker" ).datepicker({dateFormat: 'yy-mm-dd'});
	 } );
	 </script>
	</head>
    <body>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <h1>Bienvenue dans JAXB</h1>
        <div id="menubar">
			<ul id="menu">
				<li class="selection"><a href="http://localhost:8080/jaxb">Accueil </a></li>
				<li><a href="http://localhost:8080/jaxb/addcourse">Ajouter un cours</a></li>
			</ul>
		</div>
		<div class = "corps">
	        <h2>Liste des cours disponibles</h2>
	        <!-- <form action="" method="post">
				<input type="search" placeholder="Entrez un mot-clef" name="titleFragment">
		        <input type="submit" value="Rechercher"/>
	     	</form>
	        <form action="" method="post">
	        	Rechercher une session en cours à la date: <input type="text" id="datePicker" name="date" />
	        	<input type="submit" value="Rechercher"/>
	        </form>
	        <form action="" method="post">
	        	Rechercher une session par lieu: <select name="location">
		       		<c:forEach var="location" items="${locations}">
		       			<option value="${location.getId()}">${location.getCity()}</option> 
					</c:forEach>
				</select>
	        	<input type="submit" value="Rechercher"/>
	        </form> -->
        
        
	        <form action="" method="post" id ="formRecherche">
	        	Intitulé: <input type="search" placeholder="Entrez un mot-clef" name="titleFragment" value="${previousSearch}">
	        	Date: <input type="text" id="datePicker" name="date" value="${previousDate}"/>
	        	Lieu: <select name="location">
	        		<option value="null">Choisir un lieu...</option>
		       		<c:forEach var="location" items="${locations}">
		       			<option value="${location.getId()}" ${location.getId() == previousLocation ? 'selected="selected"' : ''}>${location.getCity()}</option> 
					</c:forEach>
				</select>
				
	        	<input type="submit" value="Rechercher"/>
	        </form>
	        
	        <table>
	        	<tr><th>Code</th><th>Titre</th><th>Session</th></tr>
	        	<c:forEach var="course" items="${courses}">
				   <tr><td> <c:out value="${course.getCode()}"/></td><td> <c:out value="${course.getTitle()}"/></td><td><a href="http://localhost:8080/jaxb/listcoursesession?course=${course.getCode()}">Voir les sessions</a></td></tr>
				</c:forEach>
	        </table>
       	</div>
       	<div class = "basDePage">
       			<p class="texteBasDePage"> Projet réalisé dans le cadre de l'UV <strong>LO54</strong> par <strong>Jean-Eudes Patois</strong> et <strong>Mickaël Constanzer</strong> </p>
       	</div>
    </body>
</html>