<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<jsp:include page="fragments/head.jsp"/>
<body>

<jsp:include page="fragments/header.jsp"/>

<jsp:include page="fragments/slider.jsp"/>

<div class="container">

  <div class="row">
    <div class="col-sm-8">
      <h2 class="mt-4">What We Do</h2>
      <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. A deserunt neque tempore recusandae animi soluta
        quasi? Asperiores rem dolore eaque vel, porro, soluta unde debitis aliquam laboriosam. Repellat explicabo,
        maiores!</p>
      <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Omnis optio neque consectetur consequatur magni in
        nisi, natus beatae quidem quam odit commodi ducimus totam eum, alias, adipisci nesciunt voluptate.
        Voluptatum.</p>
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

  <div class="container">
    <script src='https://maps.googleapis.com/maps/api/js?v=3.exp'></script>
    <div style='overflow:hidden;width:900px;height:500px;'>
      <div id='gmap_canvas' style='width:900px;height:480px;'></div>
      <style>#gmap_canvas img {
        max-width: none !important;
        background: none !important
      }</style>
    </div>
    <script type='text/javascript'>
        function init_map() {
            var myOptions = {
                zoom: 10, center: new google.maps.LatLng(51.67097089453824, 39.19394051291192),
                mapTypeId: google.maps.MapTypeId.ROADMAP
            };
            map = new google.maps.Map(document.getElementById('gmap_canvas'), myOptions);
            marker = new google.maps.Marker({
                map: map,
                position: new google.maps.LatLng(51.67097089453824, 39.19394051291192)
            });
            infowindow = new google.maps.InfoWindow({content: '<strong>Название</strong><br>ул. Среднемосковская 54<br>'});
            google.maps.event.addListener(marker, 'click', function () {
                infowindow.open(map, marker);
            });
            infowindow.open(map, marker);
        }

        google.maps.event.addDomListener(window, 'load', init_map);
    </script>
  </div>

</div>



<script src="webjars/jquery/2.1.1/jquery.min.js"></script>
<script src="webjars/bootstrap/4.0.0-2/js/bootstrap.bundle.min.js"></script>

</body>
</html>
