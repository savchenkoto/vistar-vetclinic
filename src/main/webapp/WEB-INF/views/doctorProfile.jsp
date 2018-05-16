<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>

<jsp:include page="fragments/head.jsp"/>

<body>

<jsp:include page="fragments/header.jsp"/><br>

<div class="container">
  <div class="row">
    <div class="col-4 block">
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
        <h1>${profile.firstName} ${profile.lastName}</h1>
        <h2>${profile.email}</h2>
      </div>
    </div>
    <div class="col-8 block">
      <div>
        <c:choose>
          <c:when test="${profile.lastVisit == null}">
            <p>You haven't come to us yet!</p>
          </c:when>
          <c:otherwise>
            <p>Last visit: ${profile.lastVisit.date} [${profile.lastVisit.petName}]</p>
          </c:otherwise>
        </c:choose>
      </div>
      <c:choose>
        <c:when test="${profile.pets == null || empty profile.pets}">
          <p>You have no pets...</p>
        </c:when>
        <c:otherwise>
          <h2>My pets</h2>
          <ul>
            <c:forEach items="${profile.pets}" var="pet">
              <li>
                <p>${pet.name} the ${pet.animal.type} </p>
              </li>
            </c:forEach>
          </ul>
        </c:otherwise>
      </c:choose>
    </div>
  </div>
</div>

</body>
</html>
