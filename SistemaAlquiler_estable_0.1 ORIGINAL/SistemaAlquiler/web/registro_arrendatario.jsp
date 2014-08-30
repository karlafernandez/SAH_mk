<%-- 
    Document   : listahabitaciones
    Created on : 03-jun-2014, 23:23:24
    Author     : Karla
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
        <div class="container-fluid fondoGris">
            <div class="row-fluid  div-titulo">
                <h3 class="span6">Registrar Nuevo Arrendatario </h3>
                <!--<div class="span6"> <a  href="listarAlumnos.html" class=" btn btn-info fa-input pull-right">Volver a Listado</a>   </div>--> 
            </div>
            <div class="row-fluid formulario">
                <form id="frmReghab" method="GET"  action="registroArrendatario"  class="form-horizontal">
                    <form:form id="frmDatosAlumno" modelAttribute="registro_arrendatario"   method="post"  action="${url}"  cssClass="form-horizontal">

                    <fieldset >
                        <legend><h4>Complete sus datos</h4></legend>
                        <div class="row-fluid">

                            <div class="span6">

                                <div class="control-group">
                                    <label   class="control-label" for="nombres">Nombres</label>                
                                    <div class="controls">
                                        <input id="nombre" path="nombres" class="input-xlarge"  onkeypress="return valSoloLetras(event);" onchange="javascript:this.value=this.value.toUpperCase();llenarUsuario();" type="text"/>
                                        <!--<form:errors  path="nombre"  cssClass="help-block"/>-->   
                                    </div>  
                                </div>  
                                <div class="control-group">
                                    <label  class="control-label"    for="apellidos">Apellidos</label>                            
                                    <div class="controls">
                                        <input id="primerApellido" path="apellidos" class="input-xlarge" onkeypress="return valSoloLetras(event);"  onchange="javascript:this.value=this.value.toUpperCase();llenarUsuario();"  type="text"  />
                                        <!--<form:errors  path="direccion" cssClass="help-block"/>-->                      
                                    </div>  
                                </div>   
                                <div class="control-group">
                                    <label   class="control-label"   for="ocupacion">Ocupación</label>                           
                                    <div class="controls">
                                        <input id="segundoApellido" path="ocupacion" class="input-xlarge" onkeypress="return valSoloLetras(event);"  onchange="javascript:this.value=this.value.toUpperCase();llenarUsuario();" type="text"  />
                                        <!--<form:errors path="detalle" cssClass="help-block"/>-->    
                                    </div>
                                </div>
                                
                            </div>


                            <div class="span6">

                                <div class="control-group">
                                    <label class="control-label" for="correo">Correo electrónico </label>                            
                                    <div class="controls">
                                        <input id="celular" path="correo" class="input-large"   type="text"  />
                                        <!--<form:errors  path="celular" cssClass="help-block"/>-->      
                                    </div>
                                </div>
                                <div class="control-group">
                                    <label class="control-label" for="telefono">Teléfono </label>                            
                                    <div class="controls">
                                        <input id="celular" path="telefono" class="input-large"   type="text"  />
                                        <!--<form:errors  path="celular" cssClass="help-block"/>-->      
                                    </div>
                                </div>
                                <div class="control-group">
                                    <label  class="control-label"   for="dni">Número de DNI</label>      
                                    <div class="controls">
                                        <input id="fechaNacimiento" path="dni" class="input-small" type="text" />
                                        <!--<form:errors  path="foto" cssClass="help-block"/>-->
                                    </div>
                                </div>


                            </div>
                        </div>  
                    </fieldset>


                    <fieldset>
                        <legend></legend>    

                        <div class="row-fluid">
                            <div class="span12" style="min-height: 50px">
                                <span>(*) Todos los campos son obligatorios</span>
                            </div> 
                        </div> 
                        <div class="row-fluid "> 
                            <div class="span12 form-actions">
                                <div class="control-group">
                                    <div class="controls">
                                        <input id="btnGuardar" type="submit" class="btn btn-info fa-input" name="guardar" value="Guardar"> &nbsp;                                                                                                               
                                        <a class="btn btn-info fa-input right" href="registrate.jsp">Regresar al tipo de usuario</a>  
                                    </div> 
                                </div>

                            </div>
                        </div>
                    </fieldset>
                </form:form>
                </form>

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
