<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Sistema de Controle de Empréstimo: Computador</title>
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
	
	<div class="form-group">
      <label for="name">Nome do Produto:</label>
      <input type="text" class="form-control" id="name" name="name">
    </div>
    
    <div class="form-group">
      <label for="value">Valor do Produto:</label>
      <input type="text" class="form-control" id="value" name="value">
    </div>
    
    <div class="form-group">
      <label for="serialNumber">Número de Série do Produto:</label>
      <input type="text" class="form-control" id="serialNumber" name="serialNumber">
    </div>
    
    <div class="form-group">
      <label for="brand">Marca do Produto:</label>
      <input type="text" class="form-control" id="brand" name="brand">
    </div>

   <div class="panel-body">
	<form action="ComputerController" method="post">

    <div class="form-group">
      <label for="operationalSystem">Sistema Operacional:</label>
      <input type="text" class="form-control" id="operationalSystem" name="operationalSystem">
    </div>

	<div class="form-group">
      <label for="cores">Quantidade de Núcleos</label>
      <input type="text" class="form-control" id="cores" name="cores">
    </div>

	<div class="form-group">
      <label for="hasAccessories">Possui Acessórios? (Ex.: Mouse, teclado)</label>
      <input type="checkbox" class="form-control" id="hasAccessories" name="hasAccessories">
    </div>
	
	

    <button type="submit" class="btn btn-default">Cadastrar</button>
  </form>
</div>
</div>
</div>
</div>
</body>
</html>