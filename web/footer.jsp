<%@ page import="javax.xml.crypto.Data" %>
<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: hansaanuradha
  Date: 2019-07-27
  Time: 16:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Footer</title>
</head>
<body>
    <%
        Date date = new Date();
    %>
    <h2>Status On <%=date.toString()%></h2>
</body>
</html>
