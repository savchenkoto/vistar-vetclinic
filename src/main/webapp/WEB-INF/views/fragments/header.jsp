<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<header>

  <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
    <div class="container">
      <a class="navbar-brand" href="<c:url value="/"/>">
        <img src="<c:url value="/images/logo.png"/>" width="50" height="46" alt=""/>
        <span style="display: inline-block;">Paw Clinic</span>
      </a>
      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive"
              aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarResponsive">
        <ul class="navbar-nav ml-auto">
          <li class="nav-item">
            <a class="nav-link" href="<c:url value="/"/>">Home
              <span class="sr-only">(current)</span>
            </a>
          </li>
          <sec:authorize access="isAuthenticated()" var="isAuthenticated"/>
          <sec:authorize access="hasRole('ROLE_ADMIN')" var="isAdmin"/>
          <c:choose>
            <c:when test="${isAuthenticated}">
              <c:choose>
                <c:when test="${isAdmin}">
                  <li class="nav-item">
                    <a class="nav-link" href="<c:url value="/admin/users"/>">Admin</a>
                  </li>
                </c:when>
                <c:otherwise>
                  <li class="nav-item">
                    <a class="nav-link" href="<c:url value="/me"/>">Account</a>
                  </li>
                </c:otherwise>
              </c:choose>
              <li class="nav-item">
                <a class="nav-link" href="<c:url value="/logout"/>">Logout</a>
              </li>
            </c:when>
            <c:otherwise>
              <li class="nav-item">
                <a class="nav-link" href="<c:url value="/login"/>">Login</a>
              </li>
            </c:otherwise>
          </c:choose>
        </ul>
      </div>
    </div>
  </nav>

</header>
