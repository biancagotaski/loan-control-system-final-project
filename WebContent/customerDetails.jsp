<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Sistema de Controle de Empréstimo: cliente</title>
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

	<div class="panel-body">
    <div class="btn-group btn-group-justified">
	    <div class="btn-group">
	    </div>
	    
	    <div class="btn-group">
	    </div>

	    <div class="btn-group">
	    </div>

	    <div class="btn-group">
		    <form action="CustomerController" method="get">
			    <button type="submit" class="btn btn-default">Voltar</button>
			</form>
	    </div>
    </div> 

   <div class="panel-body">
	<form action="CustomerController" method="post">

    <div class="form-group">
      <label for="name">Nome:</label>
      <input type="text" class="form-control" id="name" placeholder="Entre com o nome" name="name">
    </div>

    <div class="form-group">
      <label for="lastName">Sobrenome:</label>
      <input type="text" class="form-control" id="lastName" placeholder="Entre com o sobrenome" name="lastName">
    </div>
    
    <div class="form-group">
      <label for="email">E-mail:</label>
      <input type="text" class="form-control" id="email" placeholder="Entre com o e-mail" name="email">
    </div>
    
    <div class="form-group">
      <label for="birthday">Data de Nascimento:</label>
      <input type="text" class="form-control" id="birthday" placeholder="Entre com a data de nascimento" name="birthday">
    </div>
    
    <div class="form-group">
      <label for="CPF">CPF:</label>
      <input type="text" class="form-control" id="CPF" placeholder="Entre com o CPF" name="CPF">
    </div>
    
    <div class="form-group">
      <label for="street">Rua:</label>
      <input type="text" class="form-control" id="street" name="street">
    </div>
    
    <div class="form-group">
      <label for="number">Número:</label>
      <input type="text" class="form-control" id="number" name="number">
    </div>
    
    <div class="form-group">
      <label for="city">Cidade:</label>
      <input type="text" class="form-control" id="city" name="city">
    </div>
    
    <div class="form-group">
      <label for="state">Estado:</label>
      <input type="text" class="form-control" id="state" name="state">
    </div>

    <button type="submit" class="btn btn-default">Cadastrar</button>
  </form>
</div>
</div>
</div>
</div>
</body>
</html>