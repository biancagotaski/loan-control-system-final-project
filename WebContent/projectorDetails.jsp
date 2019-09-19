<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Sistema de Controle de Empréstimo: Projetor</title>
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
	<c:import url="main.jsp"/>

   <div class="panel-body">
	<form action="ProjectorController" method="post">

    <div class="form-group">
      <label for="resolution">Resolução em Pixels:</label>
      <input type="text" class="form-control" id="resolution" name="resolution">
    </div>

    <div class="form-group">
      <label for="hasLCD">Possui LCD?:</label>
      <input type="checkbox" class="form-control" id="hasLCD" name="hasLCD">
    </div>
    
    <div class="form-group">
      <label for="hasLaser">Possui Laser?:</label>
      <input type="checkbox" class="form-control" id="hasLaser" name="hasLaser">
    </div>
    
        
    <!-- COLOCAR RELACIONAMENTO DE HERANÇA (PROJETOR HERDA DE PRODUTO) -->

    <button type="submit" class="btn btn-default">Cadastrar</button>
  </form>
</div>
</div>
</div>
</div>
</body>
</html>