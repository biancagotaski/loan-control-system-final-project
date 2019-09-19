<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Sistema de Controle de Empr�stimo: Impressora</title>
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
	<form action="PrinterController" method="post">

	<div class="form-group">
      <label for="isLaser">Possui Laser?</label>
      <input type="checkbox" class="form-control" id="isLaser" name="isLaser">
    </div>

	<div class="form-group">
      <label for="hasWifi">Possui Wifi?</label>
      <input type="checkbox" class="form-control" id="hasWifi" name="hasWifi">
    </div>

    <div class="form-group">
      <label for="maxLeaf">Quantidade m�xima de folhas para impress�o:</label>
      <input type="text" class="form-control" id="maxLeaf" name="maxLeaf">
    </div>
    
        
    <!-- COLOCAR RELACIONAMENTO DE HERAN�A (IMPRESSORA HERDA DE PRODUTO) -->

    <button type="submit" class="btn btn-default">Cadastrar</button>
  </form>
</div>
</div>
</div>
</div>
</body>
</html>