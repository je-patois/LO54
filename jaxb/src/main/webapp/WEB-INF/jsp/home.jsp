<%@page import="fr.utbm.jaxb.servlet.ListCourse"%>
<%@page import="fr.utbm.jaxb.entity.Course"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
    <head>
        <title>JAXB</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <h1>Bienvenue dans JAXB</h1><br/>
        <h2>Liste des cours disponibles</h2>
        <ul>
			<c:forEach var="course" items="${courses}">
			    <c:out value="${course.getCode()}"/> - <c:out value="${course.getTitle()}"/>     <a href="http://localhost:8080/jaxb/listcoursesession?course=${course.getCode()}">S'inscrire au cours</a><br/>
			</c:forEach>
		</ul>
       	<a href="addclient.html">Add a new client</a>
    </body>
</html>