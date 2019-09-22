<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.ArrayList"%>
<%@page import="com.gotaski.business.Customer" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Sistema de Controle de Empréstimo: Cliente</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<body>
	<%
	List<Customer> list = (List<Customer>)request.getAttribute("list");
	 %>
	
<div class="container">
<div class="panel-group">
<div class="panel panel-default">
	<c:import url="nav.jsp"/>
   
   <div class="panel-body">
	<form action="customerDetails.jsp">
		<input type="hidden" name="screen" value="Customer">
		<button type="submit" class="btn btn-default">Novo Cliente</button>
		<hr>
	</form>
		<%if(list != null){%>
		<table class="table table-striped">
	    	<thead>
	      	<tr>
	        <th>Clientes</th>
	        <th></th>
	      	</tr>
	    	</thead>
	    	<tbody>
	    	<%for(Customer item : list){%>
	    	<form action="CustomerController" method="post">
	    		<input type="hidden" name="idCustomer" value="<%=item.getId()%>">
		      	<tr>
		        	<td><%=item%></td>
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