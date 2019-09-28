<%@page import="java.util.Set"%>
<%@page import="com.gotaski.business.Product"%>
<%@page import="com.gotaski.business.Loan"%>
<%@page import="com.gotaski.business.Customer"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Sistema de Controle de Empréstimo: empréstimo</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<body>
	<% 
	Loan loan = (Loan)request.getAttribute("loan");
	%> 

<div class="container">
<div class="panel-group">
<div class="panel panel-default">
	<c:import url="main.jsp"/>
	
   <div class="panel-body">
    <div class="btn-group btn-group-justified">
	    <div class="btn-group">
	    </div>
	    
	    <div class="btn-group">
	    </div>

	    <div class="btn-group">
	    </div>

	    <div class="btn-group">
			<form action="LoanController" method="get">
				<button type="submit" class="btn btn-link">Voltar</button>
			</form>
	    </div>
    </div>
    
    <form action="" method="get">
	   <div class="form-group">
	     <label for="startDate">Data de início do Empréstimo</label>
	     <input type="text" class="form-control" id="startDate" name="startDate" readonly="readonly" value="<%=loan.getStartDate()%>">
	   </div>
	   
	  	<div class="form-group">
	     <label for="endDate">Data final do Empréstimo</label>
	     <input type="text" class="form-control" id="endDate" name="endDate" readonly="readonly" value="<%=loan.getEndDate()%>">
	   </div>
	   
	   <div class="form-group">
	     <label for="CPFCustomer">CPF do Cliente</label>
	     <input type="text" class="form-control" id="CPFCustomer" name="CPFCustomer" readonly="readonly" value="<%=loan.getCPFCustomer()%>">
	   </div>
	   
	   <!-- 
	   <div class="form-group">
	     <label for="product">Produtos</label>
	     <input type="text" class="form-control" id="product" name="product" readonly="readonly" value="<%=loan.getProducts()%>">
	   </div>
	   
	   <div class="form-group">
	     <label for="customer">Clientes</label>
	     <input type="text" class="form-control" id="customer" name="customer" readonly="readonly" value="<%=loan.getCustomer().getName()%>">
	   </div>  -->
	   
	   
		<div class="form-group">
		<%if(loan.getProducts() != null ? loan.getProducts().size() > 0 : false) {%>
	  		  <label>Produtos:</label>		  
	    	<%for(Product item : loan.getProducts()){%>
			  <div class="container">
	    		<input type="checkbox" disabled checked name="products"> <%=item%>
	  		  </div>
	   		 <%}
	       } else {%>
	       		<label>Nenhum produto disponível para empréstimo!</label>
	       <%} %>
		</div>
  	</form>
</div>
</div>
</div>
</div>
</body>
</html>