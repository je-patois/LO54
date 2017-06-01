<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Ajout d'une session de cours</title>
		<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
		<link rel="stylesheet" href="/resources/demos/style.css">
		<link rel="stylesheet" type="text/css" href="././style.css">
		 <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
		 <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
		 <script>
		 $( function() {
		   $( "#startDatePicker" ).datepicker({dateFormat: 'yy-mm-dd'}); //Format BDD
		   $( "#endDatePicker" ).datepicker({dateFormat: 'yy-mm-dd'});
		 } );
		 </script>
	</head>
	<body>
		<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
		<h1>Ajouter une nouvelle session de cours</h1>
		<div id="menubar">
			<ul id="menu">
				<li><a href="http://localhost:8080/jaxb">Accueil </a></li>
				<li class = "selection"><a href="http://localhost:8080/jaxb/addcoursesession?course=<%= request.getParameter("course") %>">Ajouter une session de cours</a></li>
			</ul>
		</div>
		<div class= "corps">
			<form action="addcoursesession" method="post" id="formAddSession">
		       	<!-- Start date: <input type="date" name="startDate"/><br/>
		       	End date: <input type="date" name="endDate"/><br/> --> <!-- Problème de compatibilité Firefox -->
		       	<div class="intFormAddSession">Date de début*: </div><input type="text" id="startDatePicker" name="startDate" required />
		       	<div class="intFormAddSession">Date de fin*: </div><input type="text" id="endDatePicker" name="endDate" required /><br/>
		       	<div class="intFormAddSession">Cours: </div><input type="text" name="course" value='<%=request.getParameter("course")%>' readonly/><br/>
		       	<div class="intFormAddSession">Lieu: </div><select name="location">
		       		<c:forEach var="location" items="${locations}">
		       			<option value="${location.getId()}">${location.getCity()}</option> 
					</c:forEach>
				</select>
				<div class="intFormAddSession"><a href="http://localhost:8080/jaxb/addlocation?course=<%= request.getParameter("course") %>">Le lieu n'est pas dans la liste ?</a></div>
				<br/>
	       		<input type="submit" value="Ajouter la session"/>
	       	</form>
	    </div>
	    <div class = "basDePage">
	    	<p class="texteBasDePage"> Projet réalisé dans le cadre de l'UV <strong>LO54</strong> par <strong>Jean-Eudes Patois</strong> et <strong>Mickaël Constanzer</strong> </p>
	    </div>
	</body>
</html>