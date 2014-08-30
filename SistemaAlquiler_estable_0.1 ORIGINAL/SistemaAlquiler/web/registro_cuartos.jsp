<%-- 
    Document   : listahabitaciones
    Created on : 03-jun-2014, 23:23:24
    Author     : Meli
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!DOCTYPE html>

<html lang="en"
      xmlns="http://www.w3.org/1999/xhtml"     
      xmlns:h="http://java.sun.com/jsf/html"
      xmlns:ui="http://java.sun.com/jsf/facelets"
      xmlns:p="http://primefaces.org/ui"
      xmlns:f="http://java.sun.com/jsf/core"
      xmlns:c="http://java.sun.com/jsp/jstl/core">
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
                <h3 class="span6">Registrar Habitación </h3>
                <div class="span6"> <a  href="listarAlumnos.html" class=" btn btn-info fa-input pull-right">Volver a Listado</a>   </div> 
            </div>
            <div class="row-fluid formulario">
                <form id="frmReghab" method="GET"  action="registroHabitacion"  class="form-horizontal">
                    <fieldset >
                        <legend><h4>Datos Habitación</h4></legend>
                        <div class="row-fluid">

                            <div class="span6">

                                <!--                                <div class="control-group">
                                                                    <label   class="control-label" for="departamento">Departamento</label>                
                                                                    <div class="controls">
                                                                        <input id="departamento" path="nombre" class="input-xlarge"  onkeypress="return valSoloLetras(event);" onchange="javascript:this.value=this.value.toUpperCase();" type="text"/>
                                                                        <form:errors  path="nombre"  cssClass="help-block"/>   
                                                                    </div>
                                                                </div>
                                                                <div class="control-group">
                                                                    <label   class="control-label" for="provincia">Provincia</label>
                                                                    <div class="controls">
                                                                        <input id="nombre" path="provincia" class="input-xlarge" type="text"/>
                                                                        <form:errors  path="nombre"  cssClass="help-block"/>   
                                                                    </div>
                                                                </div>  
                                                                <div class="control-group">
                                                                    <label   class="control-label" for="distrito">Distrito</label>                
                                                                    <div class="controls">
                                                                        <input id="nombre" path="distrito" class="input-xlarge"  type="text"/>
                                                                        <form:errors  path="nombre"  cssClass="help-block"/>   
                                                                    </div>  
                                                                </div>  -->
                                <!--                                <div class="control-group">
                                                                    <label   class="control-label" for="detalleUbicacion">Ubicación</label>                
                                                                    <div class="controls">
                                                                        <input id="ubicacion" name="detalleUbicacion" path="detalleUbicacion" class="input-xlarge"  type="text"/>
                                                                        <form:errors  path="nombre"  cssClass="help-block"/>   
                                                                    </div>  
                                                                </div>  -->


                                <div class="control-group">
                                    <label  class="control-label"    for="direccion">Dirección </label>                            
                                    <div class="controls">
                                        <input id="direccion" name="direccion" path="direccion" class="input-xlarge" type="text"  />
                                        <!--<form:errors  path="direccion" cssClass="help-block"/>-->                      
                                    </div>  
                                </div>   
                                <div class="control-group">
                                    <label class="control-label" for="detalle">Características</label>                           
                                    <div class="controls">
                                        <input id="detalle" name="detalle" class="input-xlarge"  type="text"  />
                                        <!--<form:errors path="detalle" cssClass="help-block"/>-->    
                                    </div>
                                </div> 
                                <div class="control-group">
                                    <label class="control-label" for="restricciones">Restricciones</label>                           
                                    <div class="controls">
                                        <!--<input id="restricciones" name="restricciones" class="input-xlarge"  type="text"  />-->
                                        <h:inputText id="inputText" size="20" maxlength="30" />
                                        <!--<form:errors path="detalle" cssClass="help-block"/>-->    
                                    </div>
                                </div> 

                            </div>


                            <div class="span6">

                                <div class="control-group">
                                    <label class="control-label" for="telefonoContacto">Teléfono contacto </label>                            
                                    <div class="controls">
                                        <input id="telefonoContacto" path="telefonoContacto" class="input-large"   type="text"  />
                                        <!--<form:errors  path="celular" cssClass="help-block"/>-->      
                                    </div> 
                                </div>
                                <div class="control-group">
                                    <label  class="control-label"   for="foto">Agregar foto</label>      
                                    <div class="controls">
                                        <input id="fechaNacimiento" path="foto" class="input-small" type="text" />
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
                                        <a class="btn btn-info fa-input right" href="listahabitaciones.jsp">Regresar a lista</a>  
                                    </div> 
                                </div>

                            </div> 
                        </div>
                    </fieldset> 
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
