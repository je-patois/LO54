<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Insert title here</title>
		<link rel="stylesheet" type="text/css" href="././style.css">
	</head>
	<body>
	
		<% String cours = request.getParameter("course"); %>
		<%String clientId = "" + request.getAttribute("clientId"); %>
		<h1>Ajout du cours en base de données</h1>
		<div id="menubar">
			<ul id="menu">
				<li><a href="http://localhost:8080/jaxb">Accueil </a></li>
				<li><a href= <%="\"http://localhost:8080/jaxb/listcoursesession?course=" + cours + "\""%>>Liste des sessions</a></li>
			</ul>
		</div>
		<div class="corps">
		
		
			<h2>Ajout du profil en base de données</h2>
			<p>Adress: <%=request.getParameter("adress")%><br/>
			Email: <%=request.getParameter("email")%><br/>
			Firstname: <%=request.getParameter("firstname")%><br/>
			Lastname: <%=request.getParameter("lastname")%><br/>
			Phone: <%=request.getParameter("phone")%><br/>
			Cours: <%=cours%><br/>
			Session: <%=request.getParameter("session")%></p>
	
			<% 	boolean success = Boolean.parseBoolean(""+request.getAttribute("success"));
				if(success) {%>
				<p><strong>Ajout réussi.</strong></p>
			<% } else { %>
				<p><strong>Echec de l'ajout.</strong></p>
			<% } %>
			
			<a href=<%="\"http://localhost:8080/jaxb/exportxmlfile?clientID=" + clientId + "&course=" + cours + "\"" %> >Récupérer le XML associé</a>
		</div>
		<div class = "basDePage">
	       	<p class="texteBasDePage"> Projet réalisé dans le cadre de l'UV <strong>LO54</strong> par <strong>Jean-Eudes Patois</strong> et <strong>Mickaël Constanzer</strong> </p>
	    </div>
	</body>
</html>