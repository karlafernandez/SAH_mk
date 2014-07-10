<%-- 
    Document   : listahabitaciones
    Created on : 03-jun-2014, 23:23:24
    Author     : Meli
--%>
<%@page import="com.sah.model.entities.Cuarto"%>
<%@page import="java.util.List"%>
<%@page import="com.sah.model.dao.HabitacionDAOHibernate"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- Bootstrap -->
        <link href="css/bootstrap.min.css" rel="stylesheet">

    </head>
    <body>
        <div class="container-fluid">
            <div class="row-fluid">
                <div class=" span2">
                </div>
                    <% out.print(request.getAttribute("msg"));%>
                </div>
                <div class=" span10">
                    <div class="span12">
                    <div class="span5">
                        <h1>SAH</h1>
                        <label>Usuario:</label>
                        <input type="text" value="<%out.print(request.getParameter("user"));%>" name="val"/>
                   
                    </div>


                    <div class="span7 right">
                        <a href="inicio.jsp" class="navbar-brand">Inicio</a>
                    </div>
                     </div>
                        
                         <h2>Lista de habitaciones en Arequipa</h2>
                   
                    <hr>
                    <!--<input type="submit" href="registro_cuartos.jsp" value="Agregar cuarto" class="btn btn-success btn-large" >-->
                    <a role="button" href="registro_cuartos.jsp" class="btn btn-primary">Agregar cuartos +</a>
                    <fieldset>
                        <div id="id-table">                        
                            <table id="listado" class="table table-bordered table-hover table-striped" >
                                <thead>
                                    <tr > 
                                        <th>Nro</th> 
                                        <th>Dirección</th>                             
                                        <th>Características</th>  
                                        <th>Restricciones</th> 
                                        <th>Teléfono contacto</th> 
                                        <th>Ver</th> 
                                    </tr>  
                                </thead>
                                <tbody>
                                    <%
                                        HabitacionDAOHibernate habitacion;
                                        habitacion = new HabitacionDAOHibernate();
                                        habitacion.init();

                                        List<Cuarto> listaHabita = habitacion.obtenerListaHabitaciones();
                                        System.out.println("safas " + listaHabita.size());
                                        int status = 0;
                                        for (Cuarto alumno : listaHabita) {

                                    %>     

                                    <tr id="<%=status%>" >
                                        <td><%=status + 1%></td>
                                        <td><%=alumno.getDireccion()%></td>
                                        <td><%=alumno.getCaracteristicas()%></td>  
                                        <td><%=alumno.getRestricciones()%></td>
                                        <td><%=alumno.getTelefonoContacto()%></td>

                                        <td> <a role="button" href="detalle_habitacion.jsp" class="btn btn-primary">Ver detalles »</a></td> 
                                    </tr>
                                    <%
                                            status++;
                                        }
                                    %>
                                </tbody>                            
                            </table>
                            <div class="pagination pagination-centered">        
                                <ul id="pagination"> </ul>
                            </div>
                        </div>
                    </fieldset>      
                    <!--                    <form action="detalle_habitacion.jsp" method="get">
                                            <p><a role="button" class="btn btn-primary">Ver detalles »</a></p>
                                        </form>-->
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

                    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
                    <!-- Include all compiled plugins (below), or include individual files as needed -->
                    <script src="js/bootstrap.min.js"></script>
                </div>
            </div>
        </div>  
    </body>
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
</html>
