<%@page import="java.util.List"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SGP - App</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/bootstrap-4.3.1-dist/css/bootstrap.css">
</head>
<body>
    <div class="jumbotron">
    	<h1 class="display-1">Les collaborateurs</h1>
    </div>
	<ul>
		<%
			List<String> listeNoms = (List<String>) request.getAttribute("listeNoms");
			for (String nom : listeNoms) {
		%>

		<li><%= nom %></li>

		<% } %>
	</ul>

</body>
</html>