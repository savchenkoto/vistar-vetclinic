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
    <div class="col-md-4">
      <div>
        <c:choose>
          <c:when test="${profile.role == 'CLIENT'}">
            <img class="img-fluid" src="<c:url value="/images/nouser.png"/>" alt="image">
          </c:when>
          <c:when test="${profile.role == 'DOCTOR'}">
            <img class="img-fluid" src="<c:url value="/images/nodoctor.jpg"/>" alt="image">
          </c:when>
        </c:choose>
      </div>
      <div>
        <h1>${profile.name}</h1>
        <h2>${profile.email}</h2>
        <p></p>
      </div>
    </div>
    <div class="col-md-8 block">
      <div>
        <c:choose>
          <c:when test="${profile.lastVisit == null}">
            <p>You haven't come to us yet!</p>
          </c:when>
          <c:otherwise>
            <h2>Last visit: ${profile.lastVisit.date}</h2>
            <p>Updated at ${profile.lastVisit.updatedAt}</p>
            <p>${profile.lastVisit.petName}</p>
          </c:otherwise>
        </c:choose>
      </div>
      <div>
        <h2>My pets</h2>
        <c:choose>
          <c:when test="${profile.pets == null}">
            <p>You have no pets...</p>
          </c:when>
          <c:otherwise>
            <ul>
              <c:forEach items="${profile.pets}" var="pet">
                <li>
                  <p>${pet.animal.type} ${pet.name}</p>
                </li>
              </c:forEach>
            </ul>
          </c:otherwise>
        </c:choose>
      </div>
    </div>
  </div>
</div>

</body>

</html>