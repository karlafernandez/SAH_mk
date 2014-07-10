<%-- 
    Document   : listahabitaciones
    Created on : 03-jun-2014, 23:23:24
    Author     : Meli
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.sah.controller.Meli"%>

<!DOCTYPE html>
<html>

    <head>
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
        <h1>Alquiler de cuartos para estudiantes</h1>
        <label>Usuario:</label>
        <input type="text" value="<%out.print(request.getParameter("user"));%>" name="val"/>



        <div class="list-group">
            <a href="#" class="list-group-item active">
                Cras justo odee
            </a>
            <a href="#" class="list-group-item">Dapibus ac facilisis in</a>
            <a href="#" class="list-group-item">Morbi leo risus</a>
            <a href="#" class="list-group-item">Porta ac consectetur ac</a>
            <a href="#" class="list-group-item">Vestibulum at eros</a>
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
                                <h2>Lista de Habitaciones</h2>
                                <hr class="star-primary">
                                <img src="img/profile2.png" class="img-responsive img-centered" alt="">

                                <div id="bs-example-navbar-collapse-1" class="collapse navbar-collapse">
                                    <ul class="nav navbar-nav navbar-right">
                                        <li class="hidden active">
                                            <a href="#page-top"></a>
                                        </li>
                                        <li class="page-scroll">
                                            
                                            <form action="detalleHabitacion.jsp" method="get">
                                                <!--<a href="#portfolio">Portfolio</a>-->
                                                <label>Portafolio</label>>
                                                <input type="submit" value="enviar"/>
                                            </form>
                                        </li>
                                        <li class="page-scroll">
                                            <a href="#about">About</a>
                                        </li>
                                        <li class="page-scroll">
                                            <a href="#contact">Contact</a>

                                        </li>


                                    </ul>
                                </div>

                                <button type="button" class="btn btn-default" data-dismiss="modal"><i class="fa fa-times"></i> Close</button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>



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


        <script src="js/jquery-1.10.2.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="http://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.3/jquery.easing.min.js"></script>
        <script src="js/classie.js"></script>
        <script src="js/cbpAnimatedHeader.js"></script>
        <script src="js/freelancer.js"></script>

    </body>
</html>
