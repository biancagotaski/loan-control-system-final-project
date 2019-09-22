<%@page import="java.util.ArrayList"%>
<%@page import="com.gotaski.business.Projector"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Sistema de Controle de Empréstimo: projetor</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<body>
	<%
	List<Projector> list = (List<Projector>)request.getAttribute("list");
	 %>
	
<div class="container">
<div class="panel-group">
<div class="panel panel-default">
	<c:import url="nav.jsp"/>
   
   <div class="panel-body">
	<form action="projectorDetails.jsp">
		<input type="hidden" name="screen" value="Projector">
		<button type="submit" class="btn btn-default">Novo Projetor</button>
		<hr>
	</form>
		<h4>Projetores</h4>
		<br/>
		<br/>
		<%if(list != null){%>
		<table class="table table-striped">
	    	<thead>
		      	<tr>
			        <th>Id do produto</th>
			        <th>Nome do Produto</th>
			        <th>Preço</th>
			        <th>Número serial</th>
			        <th>Marca</th>
			        <th>Resolução em Pixels</th>
			        <th>Possui LCD?</th>
			        <th>Possui Laser?</th>
		      	</tr>
	    	</thead>
	    	<tbody>
	    	<%for(Projector item : list){%>
	    	<form action="ProjectorController" method="post">
	    		<input type="hidden" name="idProjector" value="<%=item.getId()%>">
		      	<tr>
		        	<td><%=item.getId()%></td>
		        	<td><%=item.getName()%></td>
		        	<td><%=item.getValue()%></td>
		        	<td><%=item.getSerialNumber()%></td>
		        	<td><%=item.getBrand()%></td>
		        	<td><%=item.getResolution()%></td>
		        	<td><%=item.isHasLCD()%></td>
		        	<td><%=item.isHasLaser()%></td>
		        	<td><button type="submit" class="btn btn-default">Excluir</button></td>
		      	</tr>
	      	</form>
	      	<%}%>
	    	</tbody>
		</table>
		<%}%>		
</div>
</div>
</div>
</div>

</body>
</html>