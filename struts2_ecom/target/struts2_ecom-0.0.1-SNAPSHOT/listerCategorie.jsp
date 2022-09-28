<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<s:head />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Liste des Contacts</title>
</head>
<body>
	<center>

		<s:form action="search">
			<table>
				<tr>
					<td><s:textfield name="keyword" label="Chercher une catégorie"/>
					<s:submit value="Chercher" /></td>
				</tr>
			</table>

		</s:form>
		<div>
			<center>
				<h2>Liste des Contacts sur Annuaire.com</h2>
			</center>
			<s:if test="%{listCategories.size()>0}">
				<table border="1">
					<tr>
						<td>Id</td>
						<td>Nom categorie</td>
						<td>Description</td>

					</tr>
					<s:iterator value="listCategories">
						<tr>
							<td><s:property value="idCategorie" /></td>
							<td><s:property value="nomCategorie" /></td>
							<td><s:property value="description" /></td>

						</tr>
					</s:iterator>
				</table>
			</s:if>
			<s:else>
                    Aucun Contact dans la liste
                </s:else>
		</div>
		<p></p>
		<a href="saisirContact.action">Ajouter un Contact</a><br />
	</center>

</body>
</html>