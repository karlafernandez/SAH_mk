<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>


<sec:authorize access="isAnonymous()"> 
    <head>

        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">

        <!-- Optional theme -->
        <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap-theme.min.css">

        <!-- Latest compiled and minified JavaScript -->
        <script src="//netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=no">
        <meta name="description" content="">
        <meta name="author" content="">

        <!-- Bootstrap Core CSS -->
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css">
        <link href="css/freelancer.css" rel="stylesheet" type="text/css">

        <!-- Fonts -->
        <link href="font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
        <link href='http://fonts.googleapis.com/css?family=Montserrat:400,700' rel='stylesheet' type='text/css'>

    </head>

    <body>


        <nav class="navbar navbar-default navbar-fixed-top">
            <div class="container span12">
                <!-- Brand and toggle get grouped for better mobile display -->
                <div class="navbar-header page-scroll span2">

                    <a href="#page-top" class="navbar-brand">BUSCAR</a>
                </div>

                <!-- Collect the nav links, forms, and other content for toggling -->
                <div id="bs-example-navbar-collapse-1" class="collapse navbar-collapse">
                    <ul class="nav navbar-nav navbar-right">
                        <li class="hidden active">
                            <a href="#page-top"></a>
                        </li>
                        <li class="page-scroll">
                            <a href="registrarClientes.html">Regístrate</a>
                            <!--<div class="span6"> <a  href="registrarClientes.html" class=" btn btn-info fa-input pull-right">Volver a Listado</a>   </div>--> 
                        </li>
                        <li class="page-scroll">
                            <a href="sobre_nosotros.jsp">Sobre nosotras</a>
                        </li>
                        <li class="page-scroll">
                            <a href="contactenos.jsp">Contáctanos</a>
                        </li>
                        <li class="page-scroll">
                            <!--<form action="views/listahabitaciones.jsp" method="get">-->
                            <div class="clearfix"  style=" margin-left: 18%;  margin-top: 5% ;" >

                            </div>

                        </li>

                    </ul>
                </div>


                <!-- /.navbar-collapse -->
            </div>
            <!-- /.container-fluid -->

        </nav>


        <header>
            <div class="container">
                w
            </div>
        </header>

        <div class="span7 text-center" style="background-color: white;    padding-top: 10px;padding-bottom: 10px ;">
            <form id="LoginForm" action="<c:url value='/'/>j_spring_security_check" method="post" > 
                <div class="span7" style="padding-top: 30px  ">
                    <img width="200px" src="<c:url value='/images/profile_1.png'/>"  style="text-align: right">

                </div>

                <div class="intro-text">
                    <h2> SAHÚ </h2>
                    <h3>  Localización de habitaciones para estudiantes </h3>
                </div>

                <div  class="span7" > 
                    <div style="padding-top: 5px">
                        <label  for="username" style="color: #6D648D">Nombre de usuario</label>
                        <input  type="text" style="height: 29px" id="username" name="j_username"/>
                    </div> 
                    <div style="padding-top: 5px"  >   
                        <label  for="password" style="color: #6D648D">Contraseña</label>
                        <input   type="password" style="height: 29px" id="password" name="j_password"/> 
                    </div>
                    <div style="padding-top: 5px" >  
                        <span class="text-error"><c:out value="${msgErrorAuthentication}"/></span>
                    </div> 
                    <div style="padding-top: 5px" >
                        <input id="LoginButton" class="btn btn-info fa-input right" name="submit" type="submit" value="Ingresar">  
                    </div>
                    <div style="padding-top: 5px" >
                        <a href="restaurar-contrasenia.html">Restaurar Contraseña</a>
                    </div>  

                </div> 
            </form>
        </div>



        <!-- Portfolio Modals -->


        <script src="js/jquery-1.10.2.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="http://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.3/jquery.easing.min.js"></script>
        <script src="js/classie.js"></script>
        <script src="js/cbpAnimatedHeader.js"></script>
        <script src="js/freelancer.js"></script>


    </body>



</sec:authorize> 
<sec:authorize access="isAuthenticated()">  
    <c:redirect url="http://www.google.com"/>
</sec:authorize>  