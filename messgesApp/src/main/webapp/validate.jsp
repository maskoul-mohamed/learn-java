<%@ page errorPage="/WEB-INF/jspf/error.jspf" import="bd.*"%>
<%@ include file="/WEB-INF/jspf/nav.jspf"%>

<h3 align="center">Validate the registration</h3>

<jsp:useBean id="user" class="bd.Person">
	<jsp:setProperty name="user" property="*" />


	<table border="1" cellpadding="3" cellspacing="2" width="90%"
		align="center">

		<tr>
			<td bgcolor="#FF9900" width="100"><b>First name</b></td>
			<td><jsp:getProperty property="firstname" name="user" /></td>
		</tr>
		<tr>
			<td bgcolor="#FF9900" width="100"><b>Last name</b></td>
			<td><jsp:getProperty property="lastname" name="user" /></td>
		</tr>

		<tr>
			<td bgcolor="#FF9900" width="100"><b>Password</b></td>
			<td><jsp:getProperty property="password" name="user" /></td>
		</tr>

	</table>

	<div align="center">
		<%
		if (!user.save()) {
		%>

		<font color="red">Attention!!! The user exists already.</font>

		<%
		} else {
		%>
		<font color="green">the user registered successfully!</font>

		<%
		}
		user.arrêt();
		%>
		
	</div>

</jsp:useBean>
<%@include file="/WEB-INF/jspf/footer.jspf"%>
