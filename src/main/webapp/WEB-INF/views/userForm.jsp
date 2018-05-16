<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:include page="fragments/head.jsp"/>
<body>

<jsp:include page="fragments/header.jsp"/>
<br>

<div class="container">
  <form:form method="post" modelAttribute="user">
    <table>
      <tr>
        <td><form:label path="firstName">First name</form:label></td>
        <td><form:input path="firstName"/></td>
        <td><form:errors path="firstName"/></td>
      </tr>
      <tr>
        <td><form:label path="lastName">Last name</form:label></td>
        <td><form:input path="lastName"/></td>
        <td><form:errors path="lastName"/></td>
      </tr>
      <tr>
        <td><form:label path="email">Email</form:label></td>
        <td><form:input path="email"/></td>
        <%--<td><form:errors path="email" cssClass="error"/></td>--%>
      </tr>
      <tr>
        <td><form:label path="password">Password</form:label></td>
        <td><form:password path="password"/></td>
        <td><form:errors path="password" cssClass="error"/></td>
      </tr>
      <tr>
        <td><form:label path="matchingPassword">Confirm password</form:label></td>
        <td><form:password path="matchingPassword"/></td>
        <td><form:errors path="matchingPassword"/></td>
      </tr>
      <tr>
        <td><form:label path="role">Role</form:label></td>
        <td>
          <form:select path="role">
            <form:options items="${roles}" itemValue="id" itemLabel="type"/>
          </form:select>
        </td>
        <td><form:errors path="role"/></td>
      </tr>
      <tr>
        <td><input type="submit" value="Add"></td>
      </tr>
    </table>
  </form:form>
</div>

</body>
</html>
