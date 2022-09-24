<%@ page errorPage="/WEB-INF/jspf/error.jspf" import="bd.*"%>
<%@ include file="/WEB-INF/jspf/nav.jspf"%>

<h3 align="center">New inscription</h3>

<form action="validate.jsp" method="post">
	<table border="1" cellpadding="3" cellspacing="2" width="90%"
		align="center">

		<tr>
			<td bgcolor="#FF9900" width="100"><b>First name</b></td>
			<td><input type="text" name="firstname"></td>
		</tr>
		<tr>
			<td bgcolor="#FF9900" width="100"><b>Last name</b></td>
			<td><input type="text" name="lastname"></td>
		</tr>

		<tr>
			<td bgcolor="#FF9900" width="100"><b>Password</b></td>
			<td><input type="password" name="password"></td>
		</tr>

	</table>
	
	<div align="center">
		<input type="submit" value="New user">
	</div>
</form>


<%@include file="/WEB-INF/jspf/footer.jspf"%>
