<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib uri="/struts-tags" prefix="s" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <s:form action="product">  
    <s:textfield name="id" label="Product Id"></s:textfield>  
    <s:textfield name="name" label="Product Name"></s:textfield>  
    <s:textfield name="price" label="Product Price"></s:textfield>  
    <s:submit value="save"></s:submit>  
    </s:form>  
</body>
</html>