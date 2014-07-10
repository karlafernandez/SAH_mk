<%-- 
    Document   : index
    Created on : 31-may-2014, 7:12:37
    Author     : Meli
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>  
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>  
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<!DOCTYPE html>
<html>
    <head>
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
    </head>
    <body>
   
   <nav class="navbar navbar-default navbar-fixed-top">
            <div class="container">
                <!-- Brand and toggle get grouped for better mobile display -->
                <div class="navbar-header page-scroll">

                    <a href="#page-top" class="navbar-brand">BUSCAR</a>
                </div>

                <!-- Collect the nav links, forms, and other content for toggling -->
                <div id="bs-example-navbar-collapse-1" class="collapse navbar-collapse">
                    <ul class="nav navbar-nav navbar-right">
                        <li class="hidden active">
                            <a href="#page-top"></a>
                        </li>
                        <li class="page-scroll">
                            <a href="registrate.jsp">Regístrate</a>
                        </li>
                        <li class="page-scroll">
                            <a href="sobre_nosotros.jsp" method="get">Sobre nosotros </a>
                        </li>
                        <li class="page-scroll">
                            <a href="contactenos.jsp" method="get">Contactános</a>

                        <li class="page-scroll">
                            <!--<form action="views/listahabitaciones.jsp" method="get">-->
                                
                            <tr>
                            <!--<form action="listahabitaciones.jsp" method="get">-->
                                <html:form action="login">
                                <form name="logueo" action="login">
                                    Usuario:<html:text property="Usuario"></html:text><br />
                                <html:errors property="usu"/><br />
                                    Clave:<html:text property="pwd"></html:text><br/>
                                <html:errors property="pwd"/><br />
                                <html:errors property="no_existe"/><br />
                                <html:submit value="confirmar"></html:submit>
                                </form>
                                </html:form>
<!--                                <label>Ususario</label>
                                <input type="text" id="user" name="user"/>
                                <label>Password</label>
                                <input type="text" id="pass" name="pass"/>
                                <input type="submit" value="enviar"/>-->
                            <!--</form>-->

                        </li>
                    </ul>
                </div>
                <!-- /.navbar-collapse -->
            </div>
            <!-- /.container-fluid -->
        </nav>
          <header>  
   </nav>
        
        <header>
            <div class="container">
                <div class="row">
                    <div class="col-lg-12">

                        <img class="img-responsive" src="img/profile_1.png" alt="">
                        <div class="intro-text">
                            <span class="name">SAH</span>
                            <hr class="star-light">
                            <span class="skills">Localización de habitaciones para estudiantes</span>
                        </div>
                    </div>
                </div>
            </div>
        </header>

        <footer class="text-center">
            <div class="footer-below">
                <div class="container">
                    <div class="row">
                        <div class="col-lg-12">
                            Copyright &copy; 2014 - @Karla @Meli
                        </div>
                    </div>
                </div>
            </div>
        </footer>

        <div class="scroll-top page-scroll visible-xs visble-sm">
            <a class="btn btn-primary" href="#page-top">
                <i class="fa fa-chevron-up"></i>
            </a>
        </div>

        <!-- Portfolio Modals -->

        <div class="portfolio-modal modal fade" id="portfolioModal2" tabindex="-1" role="dialog" aria-hidden="true">
            <div class="modal-content">
                <div class="close-modal" data-dismiss="modal">
                    <div class="lr">
                        <div class="rl">
                        </div>
                    </div>
                </div>
                <div class="container">
                    <div class="row">
                        <div class="col-lg-8 col-lg-offset-2">
                            <div class="modal-body">
                                <h2>Project Title</h2>
                                <hr class="star-primary">
                                <img src="img/portfolio/cake.png" class="img-responsive img-centered" alt="">
                                <p>Use this area of the page to describe your project. The icon above is part of a free icon set by <a href="https://sellfy.com/p/8Q9P/jV3VZ/">Flat Icons</a>. On their website, you can download their free set with 16 icons, or you can purchase the entire set with 146 icons for only $12!</p>
                                <ul class="list-inline item-details">
                                    <li>Client: <strong><a href="http://startbootstrap.com">Start Bootstrap</a></strong>
                                    </li>
                                    <li>Date: <strong><a href="http://startbootstrap.com">Julio 2014</a></strong>
                                    </li>
                                    <li>Service: <strong><a href="http://startbootstrap.com">Web Development</a></strong>
                                    </li>
                                </ul>
                                <button type="button" class="btn btn-default" data-dismiss="modal"><i class="fa fa-times"></i> Close</button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="portfolio-modal modal fade" id="portfolioModal3" tabindex="-1" role="dialog" aria-hidden="true">
            <div class="modal-content">
                <div class="close-modal" data-dismiss="modal">
                    <div class="lr">
                        <div class="rl">
                        </div>
                    </div>
                </div>

            </div>
        </div>

        <div class="portfolio-modal modal fade" id="portfolioModal5" tabindex="-1" role="dialog" aria-hidden="true">
            <div class="modal-content">
                <div class="close-modal" data-dismiss="modal">
                    <div class="lr">
                        <div class="rl">
                        </div>
                    </div>
                </div>

            </div>
        </div>
        <div class="portfolio-modal modal fade" id="portfolioModal6" tabindex="-1" role="dialog" aria-hidden="true">
            <div class="modal-content">
                <div class="close-modal" data-dismiss="modal">
                    <div class="lr">
                        <div class="rl">
                        </div>
                    </div>
                </div>
                <div class="container">
                    <div class="row">
                        <div class="col-lg-8 col-lg-offset-2">
                            <div class="modal-body">
                                <h2>Project Title</h2>
                                <hr class="star-primary">
                                <img src="img/portfolio/submarine.png" class="img-responsive img-centered" alt="">
                                <p>Use this area of the page to describe your project. The icon above is part of a free icon set by <a href="https://sellfy.com/p/8Q9P/jV3VZ/">Flat Icons</a>. On their website, you can download their free set with 16 icons, or you can purchase the entire set with 146 icons for only $12!</p>

                                <button type="button" class="btn btn-default" data-dismiss="modal"><i class="fa fa-times"></i> Close</button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <script src="js/jquery-1.10.2.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="http://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.3/jquery.easing.min.js"></script>
        <script src="js/classie.js"></script>
        <script src="js/cbpAnimatedHeader.js"></script>
        <script src="js/freelancer.js"></script>

    </body>
</html>