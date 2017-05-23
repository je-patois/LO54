<%@page import="fr.utbm.jaxb.servlet.ListCourseSession"%>
<%@page import="fr.utbm.jaxb.entity.CourseSession"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Course sessions</title>
</head>
<body>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<h1>Sessions disponibles pour <% out.print(request.getParameter("course")); %></h1>
	<c:forEach var="courseSession" items="${sessions}">
		<c:out value="${courseSession.getId()}"/> (<c:out value="${courseSession.course.getCode()}"/>) - <c:out value="${courseSession.getStartDate()}"/> -> <c:out value="${courseSession.getEndDate()}"/> à <c:out value="${courseSession.location.getCity()}"/>     <a href="http://localhost:8080/jaxb/sessioninscription?course=<c:out value="${courseSession.course.getCode()}"/>&session=<c:out value="${courseSession.getId()}"/>">S'inscrire à la session</a><br/>
	</c:forEach>
	
	<br/><br/>
	<a href="http://localhost:8080/jaxb/addcoursesession?course=<%= request.getParameter("course") %>">Add a course session</a>
</body>
</html>