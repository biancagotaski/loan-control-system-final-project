<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<title>Loan Control System</title>
</head>
<body>
	<div class="container">
	  <h2>Login</h2>
	  
	  <form action="AccessController" method="post">
	    <div class="form-group">
	      <label for="email">Email:</label>
	      <input type="email" class="form-control" id="email" placeholder="Entre com o seu e-mail" name="email">
	    </div>
	    
	    <div class="form-group">
	      <label for="pwd">Senha:</label>
	      <input type="password" class="form-control" id="pwd" placeholder="Entre com a sua senha" name="password">
	    </div>
	    
	    <button type="submit" class="btn btn-default">Acessar</button>
	  </form>
	</div>
</body>
</html>