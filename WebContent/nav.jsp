<%@ page import="com.gotaski.business.User" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Sistema de Controle de Empréstimos</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<body>
	<%User user = (User)session.getAttribute("user");%>
	<div class="container">
	<div class="panel-heading">
	  <h2>Sistema de Controle de Empréstimos</h2>
	  <h3>Olá, <%=user.getName()%>!!!</h3>
		<form action="login.jsp">
	   		<button type="submit" class="btn btn-link">Sair</button>
		</form>
	</div>
	</div>
</body>
</html>
