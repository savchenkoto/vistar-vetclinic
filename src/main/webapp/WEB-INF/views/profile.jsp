<%--
  Created by IntelliJ IDEA.
  User: savchenkoto
  Date: 23.04.18
  Time: 15:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<head>
  <title>Profile</title>
  <link href="<c:url value="/webjars/bootstrap/4.0.0-2/css/bootstrap.min.css" />" rel="stylesheet">
  <link rel="stylesheet" href="<c:url value="/resources/css/mine.css"/>">
</head>
<body>

<div class="container">
  <div class="row">
    <div class="col-md-4 block">
      <div>
        <c:choose>
          <c:when test="${user.role.role == 'CLIENT'}">
            <img class="img-fluid" src="<c:url value="/images/nouser.png"/>" alt="image">
          </c:when>
          <c:when test="${user.role.role == 'DOCTOR'}">
            <img class="img-fluid" src="<c:url value="/images/nodoctor.jpg"/>" alt="image">
          </c:when>
        </c:choose>
      </div>
      <div>
        <h1>${user.name}</h1>
        <h2>${user.email}</h2>
      </div>
    </div>
    <div class="col-md-8 block">
      <div>

      </div>
    </div>
  </div>
</div>

</body>

</html>