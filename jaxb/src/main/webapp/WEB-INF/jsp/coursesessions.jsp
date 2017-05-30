<%@page import="fr.utbm.jaxb.servlet.ListCourseSession"%>
<%@page import="fr.utbm.jaxb.entity.CourseSession"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sessions de cours</title>
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
    <%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
	<h1>Sessions disponibles pour <% out.print(request.getParameter("course")); %></h1>
	
	<form action="" method="post">
       	Date: <input type="text" id="datePicker" name="date" value="${previousDate}"/>
       	Lieu: <select name="location">
       		<option value="null">Choisir un lieu...</option>
       		<c:forEach var="location" items="${locations}">
       			<option value="${location.getId()}" ${location.getId() == previousLocation ? 'selected="selected"' : ''}>${location.getCity()}</option> 
			</c:forEach>
		</select>
		<input type="hidden" name="course" value='<%=request.getParameter("course") %>' readonly%>
       	<input type="submit" value="Rechercher"/>
       </form>
        
	<c:forEach var="courseSession" items="${sessions}">
		<c:out value="${courseSession.getId()}"/> (<c:out value="${courseSession.course.getCode()}"/>) - <fmt:formatDate pattern="yyyy-MM-dd" value="${courseSession.getStartDate()}"/> -> <fmt:formatDate pattern="yyyy-MM-dd" value="${courseSession.getEndDate()}"/> à <c:out value="${courseSession.location.getCity()}"/>     <a href="http://localhost:8080/jaxb/sessioninscription?course=<c:out value="${courseSession.course.getCode()}"/>&session=<c:out value="${courseSession.getId()}"/>">S'inscrire à la session</a> <a href="http://localhost:8080/jaxb/listregistered?course=<c:out value="${courseSession.course.getCode()}"/>&session=<c:out value="${courseSession.getId()}"/>">Voir les inscrits</a><br/>
	</c:forEach>	
	<br/><br/>
	<a href="http://localhost:8080/jaxb">Retourner à la page principale</a> <a href="http://localhost:8080/jaxb/addcoursesession?course=<%= request.getParameter("course") %>">Ajouter une session de cours</a>
</body>
</html>