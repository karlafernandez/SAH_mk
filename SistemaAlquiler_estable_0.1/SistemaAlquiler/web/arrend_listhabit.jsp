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
        <!-- link href="font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css" -->
        <link href='http://fonts.googleapis.com/css?family=Montserrat:400,700' rel='stylesheet' type='text/css'>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- Bootstrap -->
        <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.4.2/jquery.min.js"></script>
        <script src="js/jquery-ui.js" type="text/javascript"></script>
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <script type="text/javascript" src="js/jquery.pajinate.js"></script>
        <script >
            $(document).ready(function(){
               /* $('#id-table').pajinate({
                    items_per_page : 5,
                    item_container_id : '.alt_content',
                    nav_panel_id : '.alt_page_navigation'
                    
                });*/
                totales();
            });
            function totales(){
//                $.ajax({
//                    url : 'Totales.jsp',
//                    data : { search: 'test' },
//                    dataType: 'json',
//                    success : function(json) {
//                        alert(json.title);
//                    }
//                });
            }
        </script>

    </head>
    <body>
        <div class="container-fluid">
            <div class="row-fluid">
                <div class=" span2">
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

                    <h2>Lista de mis habitaciones</h2>

                    <hr>
                    <!--<input type="submit" href="registro_cuartos.jsp" value="Agregar cuarto" class="btn btn-success btn-large" >-->
                    <a role="button" href="faces/regstroHabitacionesFaces.jsp" class="btn btn-primary">Agregar cuartos +</a>

                    <fieldset>

                        <div id="id-table">                               
                            <table id="listado" class="table table-bordered table-hover table-striped" >
                                <thead>
                                    <tr > 
                                        <th>Nro</th> 
                                        <th>Dirección</th>                             
                                        <th>Características</th>  
                                        <th>Restricciones</th> 
                                        <th>Editar</th> 
                                        <th>Solicitudes</th> 


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
                                        
                                        <td>
                                           <a class="btn btn-primary btn-lg" href="faces/editarHabitacionesFaces.jsp">Editar</a>  
                                        </td>
                                        <td>
                                            <a class="btn btn-primary btn-lg" href="faces/listaSolicitudesFaces.jsp">Solicitudes</a>  
                                        </td>

                                    </tr>
                                    <%
                                            status++;
                                        }

                                    %>
                                </tbody>                            
                            </table>
                            <div class="page_navigation"></div>
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
                    <!-- Button trigger modal -->


                    <!-- Modal -->
                    <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                        <!--                        <div class="modal-dialog">
                                                    <div class="modal-content">
                                                        <div class="modal-header">
                                                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                                            <h4 class="modal-title" id="myModalLabel">Modal title</h4>
                                                        </div>
                                                        <div class="modal-body">
                                                            ...
                                                        </div>
                                                        <div class="modal-footer">
                                                            <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                                                            <button type="button" class="btn btn-primary">Save changes</button>
                                                        </div>
                                                    </div>
                                                </div>-->

                        <body>
                            <div class="container-fluid">
                                <div class="row-fluid">
                                    <div class=" span2">
                                    </div>
                                    <div class=" span10">
                                        <h2 class="text-center">SAH</h2>

                                        <h3>Detalle Habitación</h3>

                                        <hr>


                                        <div class="row-fluid">
                                            <div class="span12">
                                                <div>
                                                    <h1> Cuarto </h1>
                                                </div>

                                            </div>
                                        </div>
                                        <div class="row-fluid span10">
                                            <div class="span6">
                                                <img src="img/curso.jpg"alt="Curso" class="img-rounded">

                                            </div>

                                         
                                                <div class="span4">
                                                    <textarea>Ubicación</textarea>

                                                </div>

                                            <div class="span4">
                                                <textarea> Detalle</textarea>

                                            </div> 

                                        </div>







                                        <!-- Portfolio Modals -->



                                        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
                                        <!-- Include all compiled plugins (below), or include individual files as needed -->
                                        <script src="js/bootstrap.min.js"></script>
                                    </div>
                                </div>
                            </div>
                            <!--<fieldset>-->
                        <legend></legend>    

                        <div class="row-fluid "> 
                            <div class="span12 form-actions">
                                <div class="control-group">
                                    <div class="controls">
                                        <div class="text-center">
                                            <!--<input id="btnGuardar" type="submit" class="btn btn-info fa-input" name="guardar" value="Alquilar"> &nbsp;-->                                                                                                               
                                            <a class="btn btn-info fa-input right" href="alquilado.jsp">Alquilar</a>
                                            <!--<a class="btn btn-info fa-input right" href="listahabitaciones.jsp">Regresar a lista</a>-->  
                                            <button type="button" class="btn btn-info fa-input right" data-dismiss="modal">Cerrar</button>
                                        </div>
                                    </div> 
                                </div>

                            </div> 
                        </div>
                        <!--</div>-->
                        <!--</fieldset>--> 
                        </body>
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
