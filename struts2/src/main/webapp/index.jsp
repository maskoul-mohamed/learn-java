<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="S" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<S:form action="register">
		<S:textfield name="name" label="Name"></S:textfield>
		<S:submit value="register"></S:submit>
	</S:form>
</body>
</html>