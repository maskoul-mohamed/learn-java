<%@page import="model.Categorie"%>
<%@page import="view.CatalogueForm"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="css/bootstrap.min.css" rel="stylesheet">
<title>Gestion des Catégories</title>
<title>Insert title here</title>
</head>
<body>
	<%
	CatalogueForm cf = (CatalogueForm) session.getAttribute("catForm");
	%>
	<form method='post' action='catalogue'>
		<table border='1' align='center'>
			<tr>
				<td>Chercher une catégorie:<input type='text' name='motCle'
					value='<%=(cf != null) ? cf.getMotCle() : ""%>'></td>
				<td><input type='submit' name='chercheCat' value='Chercher'></td>
			</tr>
		</table>
	</form>
	<form method='post' action='catalogue'>
		<table class="table table-hover" align='center'>
			<thead class="thead-dark">
				<tr>
					<th>Id Catégorie</th>
					<th>Nom Catégorie</th>
					<th>Description</th>
				</tr>
			</thead>
			<tr>
				<td></td>
				<td><input type='text' name='nomCat'></td>
				<td><input type='text' name='description' size='40'></td>
				<td><input type='submit' name='addCat' value='Ajouter'></td>
			</tr>
			<%
			if (cf != null) {
				for (Categorie cat : cf.getLesCat()) {
			%>
			<tr>
				<td><%=cat.getIdCat()%></td>
				<td><%=cat.getTitre()%></td>
				<td><%=cat.getDescription()%></td>
				<td><a href='catalogue?idCat=<%=cat.getIdCat()%>'>Supprimer</a>
			</tr>
			<%
			}
			}
			%>
		</table>
	</form>
</body>
</html>