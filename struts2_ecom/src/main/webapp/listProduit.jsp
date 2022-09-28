<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
			<center>

			<s:form action="search">
			<table>
				<tr>
					<td><s:textfield name="keyword" label="Chercher un produit"/>
					<s:submit value="Chercher" /></td>
				</tr>
			</table>

		</s:form>
		<div>
				<h2>Liste des Produits sur Annuaire.com</h2>
			
			<s:if test="%{listProduits.size()>0}">
				<table border="1">
					<tr>
						<td>Id</td>
						<td>Designation</td>
						<td>Prix</td>
						<td>Quantite</td>
						<td>Categorie</td>

					</tr>
					<s:iterator value="listProduits">
						<tr>
							<td><s:property value="id" /></td>
							<td><s:property value="designation" /></td>
							<td><s:property value="prix" /></td>
							<td><s:property value="quantite" /></td>
							<td><s:property value="categorie.nomCategorie" /></td>

						</tr>
					</s:iterator>
				</table>
			</s:if>
			<s:else>
                    Aucun Produit dans la liste
                </s:else>
		</div>
		<a href="insertCategorie.jsp">Ajouter un Produit</a><br />
</center>
</body>
</html>