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
	%>
	
<div class="container">
  <h2>Cadastro de Usuários</h2>
  
  <form action="userRegister.jsp">  
	<button type="submit" class="btn btn-default">Novo</button>
  </form>
              
  <p>Usuários:</p>
  <%if(userList != null){%>
	  <table class="table table-striped">
	    <thead>
	      <tr>
	        <th>Nome</th>
	        <th>Email</th>
	        <th>Senha</th>
	      </tr>
	    </thead>
	    <tbody>
	    	<%for(User item : userList){%>
	      <tr>
	        <td><%=item.getName()%></td>
	        <td><%=item.getEmail()%></td>
	        <td><%=item.getPassword()%></td>
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