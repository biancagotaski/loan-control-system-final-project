<%@page import="java.util.ArrayList"%>
<%@page import="com.gotaski.business.Printer"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Sistema de Controle de Empréstimo: impressora</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<body>
	<%
	List<Printer> list = (List<Printer>)request.getAttribute("list");
	 %>
	
<div class="container">
<div class="panel-group">
<div class="panel panel-default">
	<c:import url="nav.jsp"/>
   
   <div class="panel-body">
	<form action="printerDetails.jsp">
		<input type="hidden" name="screen" value="Printer">
		<button type="submit" class="btn btn-default">Nova Impressora</button>
		<hr>
	</form>
		<h4>Impressoras</h4>
		<br/>
		<br/>
		<%if(list != null){%>
		<table class="table table-striped">
	    	<thead>
	      	<tr>
	        <th>Id do Produto</th>
	        <th>Nome do Produto</th>
	        <th>Preço</th>
	        <th>Número Serial</th>
	        <th>Marca</th>
	        <th>Possui Laser?</th>
	        <th>Máximo de folhas para impressão</th>
	        <th>Possui Wi-Fi?</th>	        
	      	</tr>
	    	</thead>
	    	<tbody>
	    	<%for(Printer item : list){%>
	    	<form action="PrinterController" method="post">
	    		<input type="hidden" name="idPrinter" value="<%=item.getId()%>">
		      	<tr>
		      		<td><%=item.getId()%></td>
		        	<td><%=item.getName()%></td>
		        	<td><%=item.getValue()%></td>
		        	<td><%=item.getSerialNumber()%></td>
		        	<td><%=item.getBrand()%></td>
		        	<td><%=item.isLaser()%></td>
		        	<td><%=item.getMaxLeaf()%></td>
		        	<td><%=item.isHasWifi()%></td>
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