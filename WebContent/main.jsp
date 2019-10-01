<%@page import="com.gotaski.business.Loan"%>
<%@page import="java.util.List"%>
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
	
	<div class="panel-body">
		<div class="btn-group">
			<form action="LoanController" method="get">
				<button type="submit" class="btn btn-link" name="screen" value="loanDetails">Solicitar Empréstimo</button>
			</form>
			<!--<a href="JustTest">JustTest</a>-->
		</div>
		
		<%if(list.size() > 0){ %>
			<table class="table table-striped">
				<thead>
					<tr>
						<th>Empréstimos</th>
						<th>Total</th>
						<th></th>
						<th></th>
						<th></th>
						<th></th>
					</tr>				
				</thead>
				<tbody>
					<%for(Loan item : list){ %>
						<tr>
							<td><%=item.getProducts() == null ? 0 : item.getProducts().size()%></td>
							<td>
								<form action="CustomerLoanController" method="get">
									<input type="hidden" name="id" value="<%=item.getId()%>">
									<button type="submit" class="btn btn-link">Cliente</button>
								</form>
							</td>
							<!--
							<td>
								<form action="ProductLoanController" method="get">
									<input type="hidden" name="id" value="<%=item.getId()%>">
									<button type="submit" class="btn btn-link">Produtos</button>
								</form>
							</td>
							<td>
								<form action="InformationLoanController" method="get">
									<input type="hidden" name="id" value="<%=item.getId()%>">
									<button type="submit" class="btn btn-link">Mais informações</button>
								</form>
							</td>
							<td>
								<form action="DeleteLoanController" method="post">
									<input type="hidden" name="id" value="<%=item.getId()%>">
									<button type="submit" class="btn btn-link">Excluir</button>
								</form>
							</td>
							-->
						</tr>
					<%} %>
				</tbody>
			</table>
		<%} %>
	</div>
</div>
</div>
</div>
</body>
</html>