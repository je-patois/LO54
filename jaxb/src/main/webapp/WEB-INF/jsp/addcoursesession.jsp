<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add a new course session</title>
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css"> <!-- D'ici -->
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
		<h1>Add a new course session</h1>
		<form action="addcoursesession" method="post">
	       	<!-- Start date: <input type="date" name="startDate"/><br/>
	       	End date: <input type="date" name="endDate"/><br/> --> <!-- Problème de compatibilité Firefox -->
	       	Start date: <input type="text" id="startDatePicker" name="startDate" />
	       	End date: <input type="text" id="endDatePicker" name="endDate" />
       		<input type="submit" value="Create"/>
       	</form>
	</body>
</html>