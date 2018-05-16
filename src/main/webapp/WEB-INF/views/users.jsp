<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page pageEncoding="UTF-8" %>
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

      <a href="<c:url value="/admin/users/new"/>" class="btn btn-primary" role="button">New User</a>
      <br>

      <table class="table table-hover">
        <tr>
          <th scope="col">First Name</th>
          <th scope="col">Last Name</th>
          <th scope="col">Email</th>
          <th scope="col">Role</th>
        </tr>
        <c:forEach items="${users}" var="user">
          <tr>
            <td>${user.firstName}</td>
            <td>${user.lastName}</td>
            <td>${user.email}</td>
            <td>${user.role.type}</td>
          </tr>
        </c:forEach>
      </table>
    </div>
  </div>

</div>


</body>
</html>
