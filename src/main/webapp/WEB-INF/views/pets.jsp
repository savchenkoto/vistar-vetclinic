<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<jsp:include page="fragments/head.jsp"/>

<body>

<jsp:include page="fragments/header.jsp"/>
<br>

<div class="container">

  <div class="list-group">
    <c:forEach items="${pets}" var="pet">
      <button type="button" class="list-group-item list-group-item-action">
        <b>${pet.name} the ${pet.animal.type}</b> ${pet.owner.firstName} ${pet.owner.lastName}
      </button>
    </c:forEach>
  </div>

</div>


</body>
</html>
