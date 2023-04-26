<%@page import="model.Os"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
	<!DOCTYPE html>
	<html lang="en">
	<head>
		<meta charset="UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>Os per Id</title>
		<link rel="stylesheet" href="style.css">
	</head>
<body>
	<h2>Sistema Operativo</h2>
	<%
   		Os os = (Os)request.getAttribute("os");
    	if (os!=null){
    
    %>
	<table>
	<tr>
        <th>Id</th>
        <th>Descrizione</th>
        <th>Company</th>
        <th>Open_source</th>
	</tr>
    
	<tr>
		<td><%=os.getId() %></td>
		<td><%=os.getDescrizione() %></td>
		<td><%=os.getCompany() %></td>
		<td><%=os.getOpenSource() %></td>
	</tr>
	
	
	<br>
	
	</table>
	
	<% }else{ %>
	<h3>Nessun Os con questo ID</h3>
	<% } %>
	<a href="index.html">Trona all'indice</a>
</body>
</html>