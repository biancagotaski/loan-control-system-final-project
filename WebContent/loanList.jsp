<%@page import="java.util.ArrayList"%>
<%@page import="com.gotaski.business.Loan"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Sistema de Controle de Empréstimo: empréstimo</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<body>
	<%
	List<Loan> list = (List<Loan>)request.getAttribute("list");
	 %>
	
<div class="container">
<div class="panel-group">
<div class="panel panel-default">
	<c:import url="nav.jsp"/>
	
	<!-- NÃO COLOQUEI O FORM DE VOLTAR, PORQUE TEORICAMENTE ESSE DAQUI JÁ SERÁ O MAIN.JSP -->
   
   <div class="panel-body">
	<form action="loanDetails.jsp">
		<input type="hidden" name="screen" value="Loan">
		<button type="submit" class="btn btn-default">Novo Empréstimo</button>
		<hr>
	</form>
		<h4>Empréstimos</h4>
		<br/>
		<br/>
		<%if(list != null){%>
		<table class="table table-striped">
	    	<thead>
	      	<tr>
	        <th>Id do Produto</th>
	        <th>Nome do Produto</th>
	        <th></th>       
	      	</tr>
	    	</thead>
	    	<tbody>
	    	<%for(Loan item : list){%>
	    	<form action="LoanController" method="post">
	    		<input type="hidden" name="idLoan" value="<%=%>">
		      	<tr>
		      		<td><%=%></td>
		        	<td><%=%></td>
		        	<td></td>
		        	<form action="LoanController" method="get">
			        	<input type="hidden" name="idLoan" value="<%=%>">
			        	<td><button type="submit" class="btn btn-default">Excluir</button></td>
		        	</form>
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