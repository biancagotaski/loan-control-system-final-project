<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Sistema de Controle de Empréstimo: Empréstimo</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container">
<div class="panel-group">
<div class="panel panel-default">
	<c:import url="nav.jsp"/>
	
	<form action="LoanController">
		<button type="submit" class="btn btn-link">Voltar</button>
	</form>

   <div class="panel-body">
	<form action="LoanController" method="post">

	<div class="form-group">
      <label for="name">Data de início do Empréstimo</label>
      <input type="text" class="form-control" id="startDate" name="startDate">
    </div>
    
   	<div class="form-group">
      <label for="name">Data final do Empréstimo</label>
      <input type="text" class="form-control" id="endDate" name="endDate">
    </div>

	<div class="form-group">
      <label for="name">Cliente</label>
      <input type="text" class="form-control" id="customer" name="customer">
    </div>
    
    <div class="form-group">
      <label for="name">CPF do Cliente</label>
      <input type="text" class="form-control" id="CPFCustomer" name="CPFCustomer">
    </div>
    
    <!--  <div class="form-group">
      <label for="name">Produto</label>
      <input type="text" class="form-control" id="product" name="product">
    </div> -->

	<!-- COLOCAR RELACIONAMENTO DE OUTRAS ENTIDADES AQUI TAMBÉM PARA SER EXIBIDO -->
	<!-- CLIENTE E PRODUTO -->

    </div>
    
    <button type="submit" class="btn btn-default">Cadastrar</button>
  </form>
</div>
</div>
</div>
</div>
</body>
</html>