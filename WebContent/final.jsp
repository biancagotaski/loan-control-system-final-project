<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Sistema de Controle de Empréstimo</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<body>
	<%
	String title = (String)request.getAttribute("title");
	String message = (String)request.getAttribute("message");
	String controller = (String)request.getAttribute("controller");
	%>
<div class="container">
<div class="panel-group">
<div class="panel panel-default">
<div class="panel-heading">
	<c:import url="nav.jsp"/>

  <h4>Finaliza</h4>
	<form action="<%=controller%>">
		<button type="submit" class="btn btn-link">Voltar</button>
	</form>
   </div>
   
   	<div class="panel-body">
	  <div class="btn-group btn-group-justified">
		  <h2><%=title%></h2>
		  <div class="alert alert-success">
		    <strong>Sucesso!</strong> <%=message%>
		  </div>
	  </div>
	</div>
</div>
</div>
</div>
</body>
</html>