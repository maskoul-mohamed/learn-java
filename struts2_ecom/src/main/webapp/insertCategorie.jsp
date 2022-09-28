<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
		<h2 align="center">Ajouter categorie</h2>
		<table align="center">
			<tr>
				<td>
					<s:form action="enregistrer">
						<s:textfield name="nomCategorie" label="Nom categorie"/>
						<s:textfield name="description" label="Description"/>
						<s:submit value="enregistrer" />
					</s:form>
				</td>
			</tr>
		</table>
	</div>
</body>
</html>