<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ajout d'une session de cours</title>
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
 <link rel="stylesheet" href="/resources/demos/style.css">
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
		<form action="addcoursesession" method="post">
	       	<!-- Start date: <input type="date" name="startDate"/><br/>
	       	End date: <input type="date" name="endDate"/><br/> --> <!-- Problème de compatibilité Firefox -->
	       	Date de début*: <input type="text" id="startDatePicker" name="startDate" required/>
	       	Date de fin*: <input type="text" id="endDatePicker" name="endDate" required/><br/>
	       	Cours: <input type="text" name="course" value='<%=request.getParameter("course")%>' readonly/><br/>
	       	Lieu: <select name="location">
	       		<c:forEach var="location" items="${locations}">
	       			<option value="${location.getId()}">${location.getCity()}</option> 
				</c:forEach>
			</select><br/>
       		<input type="submit" value="Create"/>
       	</form>
	</body>
</html>