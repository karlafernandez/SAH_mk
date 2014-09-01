<html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<link href="\bootstrap.css" rel="stylesheet">
<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.3/css/bootstrap.min.css">
<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.3/css/bootstrap-theme.min.css">
<script src="//netdna.bootstrapcdn.com/bootstrap/3.0.3/js/bootstrap.min.js"></script>
<script src="<c:url value='/js/maps/mapeo.js'/>" type="text/javascript"></script>

<div class="container-fluid">
    <div class="row-fluid">
        <div class="span3">
            <div class="well sidebar-nav">
                <ul class="nav nav-list">
                    <li class="nav-header">Sidebar</li>
                    <li class="active"><a href="#">Link</a></li>
                    <li><a href="registrar-usuario.html">Link</a></li>
                    <li><a href="#">Link</a></li>
                    <li><a href="#">Link</a></li>
                   
                </ul>
            </div><!--/.well -->
        </div><!--/span-->
       
        <div class="span9">

<h3>Selecciona alguna habitación <span class="label label-default">New</span></h3>
<div class="well">

MAPA GOOGLE MAPS
SA


</div>

<span class="glyphicon glyphicon-globe"></span>
<div class="main-area span12">
    <div class="row">
       <div class="span6">
            //Maybe some description text
            
           
       <body>

    <div class="navbar navbar-fixed span9">
      <div class="navbar-inner">
        <div class="container">
          <a class="brand" href="#">Project name</a>
          
             <div id="map-canvas" style="height:500px; width:900px"></div>
          
         
        </div>
      </div>
    </div>
           <div class="navbar navbar-fixed span4">
      <div class="navbar-inner">
        <div class="container">
          <a class="brand" href="#">Project name</a>
          
             <div id="map-canvas" style="height:500px; width:900px"></div>
          
         
        </div>
      </div>
    </div>

       </div>
    </div>
</div>           
   <!DOCTYPE html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script type="text/javascript"
      src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBjmOpq9IZux6XgTd25iETQeqNb0pr3Sss&sensor=true">
    </script>
    <script>
        
      function initialize() {
        // Create an array of styles.
            var styles = [
              {
                stylers: [
                  { hue: "#00d4ff" },
                  { saturation: -20 }
                ]
              },{
                featureType: "road",
                elementType: "geometry",
                stylers: [
                  { lightness: 100 },
                  { visibility: "simplified" }
                ]
              },{
                featureType: "road",
                elementType: "labels",
                stylers: [
                  { visibility: "off" }
                ]
              }
            ];

            // Create a new StyledMapType object, passing it the array of styles,
            // as well as the name to be displayed on the map type control.
            var styledMap = new google.maps.StyledMapType(styles,
              {name: "Styled Map"});

            // Create a map object, and include the MapTypeId to add
            // to the map type control.
            var mapOptions = {
              zoom: 15,
              center: new google.maps.LatLng(-16.3989, -71.535),
              mapTypeControlOptions: {
                mapTypeIds: [google.maps.MapTypeId.ROADMAP, 'map_style']
              }
            };
            var map = new google.maps.Map(document.getElementById('map-canvas'),
              mapOptions);

            //Associate the styled map with the MapTypeId and set it to display.
            map.mapTypes.set('map_style', styledMap);
            map.setMapTypeId('map_style');
            for(i=0.0;i<0.01;i=i+0.002){
                punto = new google.maps.Marker({
                    position: new google.maps.LatLng(-16.3989+i, -71.535+i),
                    icon: '../images/panel.jpg',
                    map: map,    
                    title: 'Publicidad!!'              
                });
            }
           
            google.maps.event.addListener(map, 'click', function(event) {
                alert( 'Lat: ' + event.latLng.lat() + ' and Longitude is: ' + event.latLng.lng() );
             });
      }
      
      google.maps.event.addDomListener(window, 'load', initialize);
           
           
           
           <%--    fddfsfsdf --%>
  </body> 
        
    </table>
       </div>
       <div class="span3">
            //Maybe a button or something
       </div>
    </div>
 </div>
            
<div class="jumbotron"   >
<h2>
 Selecciona tu punto
</h2>
    
    
    </div>
           
        </div><!--/row-->

    </div><!--/span-->

    <div class="span-11" style="text-align: right">                                                                 
        <button  id="btnGuardar2" class="btn btn-primary" type="submit" name="variables"><i class="icon-ok icon-white"></i>Registrar</button>                           
    </div> 


</div>

<!--/.fluid-container-->



<!DOCTYPE html>

  <head>
    <meta charset="utf-8">
    <title>Bootstrap, from Twitter</title>
    <meta name="description" content="">
    <meta name="author" content="">

    <!-- Le HTML5 shim, for IE6-8 support of HTML elements -->
    <!--[if lt IE 9]>
<script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
<![endif]-->

    <!-- Le styles -->
    <link href="?/bootstrap.css" rel="stylesheet">
    <style type="text/css">
      /* Override some defaults */
      html, body {
        background-color: #eee;
      }
      body {
        padding-top: 40px; /* 40px to make the container go all the way to the bottom of the topbar */
      }
     
      

      /* The white background content wrapper */
      .content {
        background-color: #fff;
        padding: 20px;
        margin: 0 -20px; /* negative indent the amount of the padding to maintain the grid system */
        -webkit-border-radius: 0 0 6px 6px;
           -moz-border-radius: 0 0 6px 6px;
                border-radius: 0 0 6px 6px;
        -webkit-box-shadow: 0 1px 2px rgba(0,0,0,.15);
           -moz-box-shadow: 0 1px 2px rgba(0,0,0,.15);
                box-shadow: 0 1px 2px rgba(0,0,0,.15);
      }

      /* Page header tweaks */
      .page-header {
        background-color: #f5f5f5;
        padding: 20px 20px 10px;
        margin: -20px -20px 20px;
      }

      /* Styles you shouldn't keep as they are for displaying this base example only */
      .content .span10,
      .content .span4 {
        min-height: 500px;
      }
      /* Give a quick and non-cross-browser friendly divider */
      .content .span4 {
        margin-left: 0;
        padding-left: 19px;
        border-left: 1px solid #eee;
      }

      .topbar .btn {
        border: 0;
      }

    </style>

    <!-- Le fav and touch icons -->
    <link rel="shortcut icon" href="images/favicon.ico">
    <link rel="apple-touch-icon" href="images/apple-touch-icon.png">
    <link rel="apple-touch-icon" sizes="72x72" href="images/apple-touch-icon-72x72.png">
    <link rel="apple-touch-icon" sizes="114x114" href="images/apple-touch-icon-114x114.png">
  </head>

  
  
</html>

