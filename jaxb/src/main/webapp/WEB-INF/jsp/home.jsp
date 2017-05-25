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
        <h1>Bienvenue dans JAXB</h1><br/>
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
        
        
        <!-- <br/><br/><br/><h2>TEST</h2> -->
        <form action="" method="post">
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
        
        
        <ul>
			<c:forEach var="course" items="${courses}">
			    <c:out value="${course.getCode()}"/> - <c:out value="${course.getTitle()}"/>     <a href="http://localhost:8080/jaxb/listcoursesession?course=${course.getCode()}">S'inscrire au cours</a><br/>
			</c:forEach>
		</ul>
       	<a href="addclient.html">Ajouter un nouveau client (A enlever ?)</a><br/>
       	<a href="http://localhost:8080/jaxb/addcourse">Ajouter un nouveau cours</a>
    </body>
</html>