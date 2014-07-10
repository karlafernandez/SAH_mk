<%-- 
    Document   : listahabitaciones
    Created on : 03-jun-2014, 23:23:24
    Author     : Meli
--%>
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
                <div class=" span10">
                    <h1>SAH</h1>
                    <label>Usuario:</label>
                    <input type="text" value="<%out.print(request.getParameter("user"));%>" name="val"/>
                    <h3>Detalle Habitación</h3>
                    <hr>

                    <div class="row-fluid">
                        <div class="span12">
                            <div>
                                <h4> Cuarto </h4>

                            </div>

                        </div>
                    </div>
                    <div class="row-fluid">
                        <div class="span4">
                            <img src="img/cuarto.jpg"alt="Curso" class="img-rounded">
                        </div>

                        <div class="span6">
                            <div class="span6">
                                <textarea>Ubicación</textarea>

                            </div>
                            <div class="span6">
                                <textarea> Detalle</textarea>

                            </div>    
                        </div>
                    </div>

                    <!-- Portfolio Modals -->
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
                        <a class="btn btn-info fa-input right" href="listahabitaciones.jsp">Regresar a lista</a>   

                    </div>
                </div> 
            </div>
        </div>
    </div>
    <!--</div>-->
    <!--</fieldset>--> 
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
