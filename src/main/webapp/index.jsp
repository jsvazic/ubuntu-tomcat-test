<%@page import="java.util.List"%>
<%@page import="com.example.MessageUtil"%>
<%@page import="com.example.model.Message"%>
<html>
<body>
<h2>Message Test</h2>
<ul>
<%
    List<Message> msgs = MessageUtil.getMessages();
	for (Message msg : msgs) {
%>
		<li><%= msg.getMessage() %></li>
<%
	}
%>
</ul>
</body>
</html>
