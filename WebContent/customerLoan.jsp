<%@page import="com.gotaski.business.Loan" %>
<%@page import="com.gotaski.business.Customer" %>
<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
  <title>Sistema de Controle de Empréstimo</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<body>
	<%
		Loan loan = (Loan)request.getAttribute("loan");
		List<Customer> list = (List<Customer>)request.getAttribute("customers");
		
		int idCustomer = loan.getCustomer() != null ? loan.getCustomer().getId() : 0;
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
					</div>
					
					<div class="form-group">
						<label for="startDate">Data de Contratação do Empréstimo</label>
						<input type="text" class="form-control" id="startDate" name="startDate" readonly="readonly" value="<%=loan.getStartDate() %>" />
					</div>
					
					<div class="form-group">
						<label for="endDate">Data da Finalização do Empréstimo</label>
						<input type="text" class="form-control" id="endDate" name="endDate" readonly="readonly" value="<%=loan.getEndDate() %>" />
					</div>
					
					<div class="form-group">
						<label for="CPFCustomer">CPF do Cliente</label>
						<input type="text" class="form-control" id="CPFCustomer" name="CPFCustomer" readonly="readonly" value="<%=loan.getCPFCustomer() %>" />
					</div>
					
					<form action="CustomerLoanController" method="post">
						<div class="form-group">
							<%if(list.size() > 0){ %>
								<label for="customer">Cliente:</label>
								<select class="form-control" name="idCustomer">
									<%for(Customer item : list){ %>
										<option <%=idCustomer == item.getId() ? "selected" : "" %> value="<%=item.getId()%>" ><%=item%></option>
									<%} %>
								</select>
							<%} else {%>
								<label>Nenhum cliente solicitou empréstimo ainda...</label>
							<%} %>
						</div>
						
						<button type="submit" class="btn btn-default"  <%=list.size() == 0 ? "disabled" : "" %>>Cadastrar</button>
					</form>
				</div>
				
			</div>
		</div>
	</div>
</body>
</html>