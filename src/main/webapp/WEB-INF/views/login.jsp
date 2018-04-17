<%--
  Created by IntelliJ IDEA.
  User: savchenkoto
  Date: 17.04.18
  Time: 14:51
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://www.rapid-framework.org.cn/rapid" prefix="rapid" %>

<rapid:override name="slider">
  <br>
</rapid:override>

<rapid:override name="content">
  <br>

  <div class="row">
    <div class="col"></div>
    <div class="col"></div>
    <div class="col">
      <div class="container">
        <form class="form-signin">
          <h2 class="form-signin-heading">Please sign in</h2>
          <label for="inputEmail" class="sr-only">Email address</label>
          <input type="email" id="inputEmail" class="form-control" placeholder="Email address" required autofocus>
          <label for="inputPassword" class="sr-only">Password</label>
          <input type="password" id="inputPassword" class="form-control" placeholder="Password" required>
          <div class="checkbox">
            <label>
              <input type="checkbox" value="remember-me"> Remember me
            </label>
          </div>
          <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
        </form>

      </div> <!-- /container -->
    </div>
    <div class="col"></div>
    <div class="col"></div>
  </div>

</rapid:override>

<%@ include file="home.jsp" %>
