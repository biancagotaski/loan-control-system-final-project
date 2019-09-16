<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.gotaski.business.User"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<title>Insert title here</title>
</head>
<body>
<%
	List<User> userList = (List<User>)request.getAttribute("users");
	String login = (String)request.getAttribute("userLogged");
	%>
	
<div class="container">
  <h2>Olá, <%=login%></h2>
  <form action="AccessController" method="get">  
	<button type="submit" class="btn btn-default">Novo</button>
  </form>
  <hr>
              
  <%if(userList != null){%>
	  <table class="table table-striped">
	    <thead>
	      <tr>
	      	<th>Id</th>
	        <th>Nome</th>
	        <th>Email</th>
	        <th>Tipo</th>
	        <th></th>
	      </tr>
	    </thead>
	    <tbody>
	    	<%for(User item : userList){%>
	      <tr>
	      	<td><%=item.getId() %></td>
	        <td><%=item.getName()%></td>
	        <td><%=item.getEmail()%></td>
	        <td><%=item.getType()%></td>
	        <form action="UserController" method="get">
		        <input type="hidden" name="idUser" value="<%=item.getId()%>">
		        <td><button type="submit" class="btn btn-default">Excluir</button></td>
	        </form>
	      </tr>
	      	<%}%>
	    </tbody>
	  </table>
  <%}else{%>
  	<p>Nenhum usuário cadastrado!!!</p>	
  <%}%>
</div>
</body>
</html>