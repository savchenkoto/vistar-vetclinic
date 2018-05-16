<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<jsp:include page="fragments/head.jsp"/>

<body>

<jsp:include page="fragments/header.jsp"/>
<br>

<div class="container">
  <div class="row">
    <div class="col-3 block">
      <jsp:include page="fragments/adminSideBar.jsp"/>
    </div>
    <div class="col-9 block">
      <a href="<c:url value="/admin/animals/new"/>" class="btn btn-primary" role="button">New Animal</a>
      <br>
      <div class="list-group">
        <c:forEach items="${animals}" var="animal">
          <button type="button" class="list-group-item list-group-item-action">
            ${animal.type} <a class="text-muted" href="<c:url value="/admin/animals/${animal.id}/update"/>">update</a>
          </button>
        </c:forEach>
      </div>
    </div>
  </div>
</div>

</body>
</html>
