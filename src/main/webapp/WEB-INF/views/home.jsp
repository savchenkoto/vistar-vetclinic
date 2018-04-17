<%--
  Created by IntelliJ IDEA.
  User: savchenkoto
  Date: 11.04.18
  Time: 13:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://www.rapid-framework.org.cn/rapid" prefix="rapid" %>
<html>
<head>

  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>Paw Clinic</title>

  <!-- Bootstrap core CSS -->
  <link href="webjars/bootstrap/4.0.0-2/css/bootstrap.min.css" rel="stylesheet">

  <link href="../../resources/css/logo-nav.css" rel="stylesheet">
  <link href="../../resources/css/half-slider.css" rel="stylesheet">
  <link href="../../resources/css/business-frontpage.css" rel="stylesheet">

</head>
<body>

<!-- Navigation -->
<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
  <div class="container">
    <a class="navbar-brand" href="/">
      <img src="../../resources/images/logo.png" width="50" height="46" alt="">
      <span style="display: inline-block;">Paw Clinic</span>
    </a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarResponsive">
      <ul class="navbar-nav ml-auto">
        <li class="nav-item active">
          <a class="nav-link" href="/">Home
            <span class="sr-only">(current)</span>
          </a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="login">Sing In</a>
        </li>
      </ul>
    </div>
  </div>
</nav>

<rapid:block name="slider">
  <header>
    <div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
      <ol class="carousel-indicators">
        <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
        <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
        <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
      </ol>
      <div class="carousel-inner" role="listbox">
        <!-- Slide One - Set the background image for this slide in the line below -->
        <div class="carousel-item active" style="background-image: url(../../resources/images/home1.jpg)">
          <div class="carousel-caption d-none d-md-block">
              <%--<h3>First Slide</h3>--%>
              <%--<p>This is a description for the first slide.</p>--%>
          </div>
        </div>
        <!-- Slide Two - Set the background image for this slide in the line below -->
        <div class="carousel-item" style="background-image: url(../../resources/images/home2.jpg)">
          <div class="carousel-caption d-none d-md-block">
              <%--<h3>Second Slide</h3>--%>
              <%--<p>This is a description for the second slide.</p>--%>
          </div>
        </div>
        <!-- Slide Three - Set the background image for this slide in the line below -->
        <div class="carousel-item" style="background-image: url(../../resources/images/home3.jpg)">
          <div class="carousel-caption d-none d-md-block">
              <%--<h3>Third Slide</h3>--%>
              <%--<p>This is a description for the third slide.</p>--%>
          </div>
        </div>
      </div>
      <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
        <span class="sr-only">Previous</span>
      </a>
      <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
        <span class="carousel-control-next-icon" aria-hidden="true"></span>
        <span class="sr-only">Next</span>
      </a>
    </div>
  </header>
</rapid:block>

<rapid:block name="content">
  <!-- Page Content -->
  <div class="container">

    <div class="row">
      <div class="col-sm-8">
        <h2 class="mt-4">What We Do</h2>
        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. A deserunt neque tempore recusandae animi soluta quasi? Asperiores rem dolore eaque vel, porro, soluta unde debitis aliquam laboriosam. Repellat explicabo, maiores!</p>
        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Omnis optio neque consectetur consequatur magni in nisi, natus beatae quidem quam odit commodi ducimus totam eum, alias, adipisci nesciunt voluptate. Voluptatum.</p>
      </div>
      <div class="col-sm-4">
        <h2 class="mt-4">Contact Us</h2>
        <address>
          <strong>Start Bootstrap</strong>
          <br>3481 Melrose Place
          <br>Beverly Hills, CA 90210
          <br>
        </address>
        <address>
          <abbr title="Phone">P:</abbr>
          (123) 456-7890
          <br>
          <abbr title="Email">E:</abbr>
          <a href="mailto:#">name@example.com</a>
        </address>
      </div>
    </div>

      <%--Map--%>
    <div class="container">
      <script src='https://maps.googleapis.com/maps/api/js?v=3.exp'></script>
      <div style='overflow:hidden;width:900px;height:500px;'>
        <div id='gmap_canvas' style='width:900px;height:480px;'></div>
        <style>#gmap_canvas img{max-width:none!important;background:none!important}</style>
      </div>
      <script type='text/javascript'>
          function init_map(){
              var myOptions = {
                  zoom:10,center:new google.maps.LatLng(51.67097089453824,39.19394051291192),
                  mapTypeId: google.maps.MapTypeId.ROADMAP};
              map = new google.maps.Map(document.getElementById('gmap_canvas'), myOptions);
              marker = new google.maps.Marker({map: map,position: new google.maps.LatLng(51.67097089453824,39.19394051291192)});
              infowindow = new google.maps.InfoWindow({content:'<strong>Название</strong><br>ул. Среднемосковская 54<br>'});
              google.maps.event.addListener(marker, 'click', function(){infowindow.open(map,marker);});
              infowindow.open(map,marker);}google.maps.event.addDomListener(window, 'load', init_map);
      </script>
    </div>

  </div>

  <!-- Footer -->
  <footer class="py-3 bg-dark">
    <div class="container">
      <p class="m-0 text-center text-white">Copyright &copy; Your Website 2018</p>
    </div>
    <!-- /.container -->
  </footer>
</rapid:block>


<!-- Bootstrap core JavaScript -->
<script src="webjars/jquery/2.1.1/jquery.min.js"></script>
<script src="webjars/bootstrap/4.0.0-2/js/bootstrap.bundle.min.js"></script>



</body>
</html>
