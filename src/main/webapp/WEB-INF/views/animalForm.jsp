<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:include page="fragments/head.jsp"/>
<body>

<jsp:include page="fragments/header.jsp"/>
<br>

<div class="container">

  <spring:url value="/admin/animals/save" var="save"/>
  <form:form method="post" modelAttribute="animal" action="${save}">
    <table>
      <tr>
        <td><form:hidden path="id" /></td>
      </tr>
      <tr>
        <td><form:label path="type">Animal type</form:label></td>
        <td><form:input path="type" /></td>
        <%--<td><form:errors path="type"/></td>--%>
      </tr>
      <tr>
        <td><input type="submit" value="Submit"></td>
      </tr>
    </table>
  </form:form>

</div>

</body>
</html>
