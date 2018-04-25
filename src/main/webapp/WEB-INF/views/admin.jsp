<%--
  Created by IntelliJ IDEA.
  User: savchenkoto
  Date: 18.04.18
  Time: 15:05
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page pageEncoding="UTF-8"%>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  <title>Admin page</title>
</head>
<body>
<h1>Dear <strong>${user}</strong>, Welcome to Admin Page.</h1>
<a href="<c:url value="/logout" />">Logout</a>
</body>
</html>
