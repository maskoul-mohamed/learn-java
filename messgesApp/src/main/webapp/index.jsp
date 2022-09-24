<%@ page errorPage = "/WEB-INF/jspf/error.jspf" import="bd.*" %>
<%@ include file="/WEB-INF/jspf/nav.jspf"%>

<font face="Arial">

	<table border="1" cellpadding="3" cellspacing="2" width="90%" 	align="center">
		<tr>
			<th>Tittle
			</th>
			<th>Message
			</th>
		</tr>
		<%
		ListMessages listMessages = new ListMessages(1);
			int ligme = 0;
			while(listMessages.suivant()) {
		%>
		<tr bgcolor="<%= ligme++ % 2 == 0 ? "#FFFF66" : "#CCFF00" %>">
			<td><b><%= listMessages.title() %></b></td>
			<td><%= listMessages.text() %></td>
		</tr>

		<%
			}
			listMessages.arrêt();
			
		%>
	</table>


</font>
<%@include file="/WEB-INF/jspf/footer.jspf"%>

