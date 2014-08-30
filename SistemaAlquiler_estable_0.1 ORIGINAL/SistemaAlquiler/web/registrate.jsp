<%-- 
    Document   : registrate
    Created on : 23/06/2014, 08:38:13 PM
    Author     : Karla
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <style type="text/css">
            
            #aid{
                width:150px;
                height:50px;
            }

        </style>
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
        <div class="container-fluid fondoGris">
            <div class="row-fluid  div-titulo">
                <h3 class="span6">Registrar nuevo usuario </h3>
  </div> 
            </div>

                <h4 class="span6">Escoja el tipo de usuario que es: </h4>
                <br><br>
            <div class="row-fluid formulario">
                <c:url var="url" value="/registrate.html" />
                <form:form id="frmDatosAlumno" modelAttribute="tipo_cliente"   method="post"  action="${url}"  cssClass="form-horizontal">
                    <fieldset>
                        <legend></legend>
                                                        <table border="2">
                                    <thead>
                                        <tr>
                                            <th>Cliente</th>
                                            <th>Arrendatario</th>
                                            
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <tr>
                                            <td><br>Usuario que busca una habitación para alquilar <br><br><img src="img/cliente.jpg" width="329" height="209" alt="arrendatario"/>
                                            </td>
                                            <td><br>Es aquel usuario que alquila habitaciones<br><br><img src="img/arrendatario.jpg" width="329" height="209" alt="arrendatario"/>
                                            </td>
                                        

                                        <tr>
                                            <td></td>
                                            <td></td>
                                        </tr>
                                    </tbody>
                                </table>
                        <div class="row-fluid "> 
                            <div class="span12 form-actions">   
                                <div class="control-group">
                                    <div class="controls">
                                        <!--<inpiente"> &;-->
                                        &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp;
                                        <a class="btn btn-info fa-input right" href="registrar_cliente.jsp" id="aid" text-align:center> Cliente </a> &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp;
                                        <a class="btn btn-info fa-input right" href="registro_arrendatario.jsp" id="aid" text-align:center> Arrendatario </a> <td>&nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp;
                                        <a class="btn btn-info fa-input right" href="inicio.jsp"> Regresar al inicio </a>  
                                    </div> 
                                </div>

                            </div>
                        </div>
                    </fieldset> 
                </form:form>

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
