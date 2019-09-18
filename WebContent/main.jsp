<%@page import="com.gotaski.business.Loan"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
  <title>AppMyEmprestimo</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<body>
	<%
	List<Loan> list = (List<Loan>)request.getAttribute("loans");
	%>

<div class="container">
<div class="panel-group">
<div class="panel panel-default">
	<c:import url="nav.jsp"/>
   
   	<div class="panel-body">
	  <div class="btn-group btn-group-justified">
	    <div class="btn-group">
			<form action="ProjectorController">
				<button type="submit" class="btn btn-default">Projetor</button>
			</form>
	    </div>
	    <div class="btn-group">
			<form action="PrinterController">
				<button type="submit" class="btn btn-default">Impressora</button>
			</form>
	    </div>
	    <div class="btn-group">
			<form action="ComputerController">
				<button type="submit" class="btn btn-default">Computador</button>
			</form>
	    </div>
	    <div class="btn-group">
			<form action="CustomerController">
				<button type="submit" class="btn btn-default">Cliente</button>
			</form> 
	    </div>
	  </div>
	</div>
</div>
</div>
</div>
</body>
</html>