<%-- 
    Document   : regstroHabitacionesFaces
    Created on : 01-jul-2014, 20:52:07
    Author     : Meli
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<f:view>
    <html>
        <head>

            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
            <meta charset="utf-8"/>
            <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=no"/>
            <meta name="description" content=""/>
            <meta name="author" content=""/>

            <!-- Bootstrap Core CSS -->
            <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
            <link href="css/freelancer.css" rel="stylesheet" type="text/css"/>

            <!-- Fonts -->
            <link href="font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css"/>
            <link href='http://fonts.googleapis.com/css?family=Montserrat:400,700' rel='stylesheet' type='text/css'/>
            <meta charset="utf-8"/>
            <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
            <meta name="viewport" content="width=device-width, initial-scale=1"/>
            <!-- Bootstrap -->
            <link href="css/bootstrap.min.css" rel="stylesheet"/>


            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
           
        </head>
        <body>
            <div class="container-fluid fondoGris">
                <div class="row-fluid  div-titulo">
                    <h3 class="span6">Editar Datos Habitación </h3>
                    <div class="span6"> <a  href="listarAlumnos.html" class=" btn btn-info fa-input pull-right">Volver a Listado</a>   </div> 
                </div>
                <div class="row-fluid formulario">


                    <h4>Datos Habitación</h4>
                    
                    <h:form id="frmRegistro">
                        
                        <div class="span12">
                            </br>
                            <div class="span4">
                                <div class="control-group">
                                    <h:message id="msgForm" for="btnEnviar" rendered="true"/>
                                    <div>
                                        <h:outputText value="Dirección"/>
                                    </div>
                                    <h:inputText id="direccion" value="#{registroHabitacionBean.habitacionDTO.direccion}" validatorMessage="Ingrese solo texto">
                                        <%--<f:validateRegex pattern="^[a-zA-Z]*"/>--%>
                                    </h:inputText>
                                    <h:message id="msg1" for="direccion" errorStyle="color: red" infoStyle="color: green" rendered="true"/>
                                </div>  

                                <div class="control-group">
                                    <div>
                                        <h:outputText value="Características"/>
                                    </div>
                                    <h:inputText id="caracteristicas" value="#{registroHabitacionBean.habitacionDTO.caracteristicas}" validatorMessage="Ingrese solo texto">
                                        <%--<f:validateRegex pattern="^[a-zA-Z]*"/>--%>
                                    </h:inputText>
                                    <h:message id="msg2" for="caracteristicas" errorStyle="color: red" infoStyle="color: green" rendered="true"/>
                                </div> 

                                <div class="control-group">                                
                                    <div>
                                        <h:outputText value="Restricción"/>
                                    </div>
                                    <h:inputText id="restriccion" value="#{registroHabitacionBean.habitacionDTO.restricciones}" validatorMessage="Ingrese solo texto">
                                        <f:validateRegex pattern="^[a-zA-Z]*"/>
                                    </h:inputText>
                                    <h:message id="msg3" for="restriccion" errorStyle="color: red" infoStyle="color: green" rendered="true"/>
                                </div> 

                            </div>
                            <div class="span6">
                                <div class="control-group">
                                    <div>
                                        <h:outputText value="Teléfono contacto"/>
                                    </div>
                                    <h:inputText id="telefonoContacto" value="#{registroHabitacionBean.habitacionDTO.caracteristicas}" validatorMessage="Ingrese solo números">
                                        <f:validateRegex pattern="number"/>
                                    </h:inputText>
                                    <h:message id="msg4" for="telefonoContacto" errorStyle="color: red" infoStyle="color: green" rendered="true"/>
                                </div> 

                                <div class="control-group">
                                    <div>
                                        <h:outputText value="Agregar Foto"/>
                                    </div>
                                    <h:inputText id="foto" value="#{registroHabitacionBean.habitacionDTO.caracteristicas}" validatorMessage="Ingrese solo texto">
                                        <f:validateRegex pattern="^[a-zA-Z]*"/>
                                    </h:inputText>
                                    <h:message id="msg5" for="foto" errorStyle="color: red" infoStyle="color: green" rendered="true"/>
                                </div> 


                            </div>
                        </div>

                        <!--                                <p:outputLabel value="Características"/>
                                                        <p:inputText id="txtNombre" />
                        
                                                        <p:outputLabel value="Sexo"/>
                                                        <p:selectOneMenu id="cmbText" >
                                                            
                                                        </p:selectOneMenu>-->



                       
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
                                            <!--<input id="btnGuardar" type="submit" class="btn btn-info fa-input" name="guardar" value="Guardar"> &nbsp;-->                                                                                                               

                                            <h:commandButton  id="btnEnviar" value="Guardar"  actionListener="#{registroHabitacionBean.enviarRegistro()}" >

                                            </h:commandButton>

                                            <a class="btn btn-info fa-input right" href="arrend_listhabit.jsp">Regresar a lista</a>  
                                        </div> 
                                    </div>

                                </div> 
                            </div>
                        

                    </h:form>



                </div>
            </div>
        </body>

        <footer class="text-center">
            <div class="footer-below">
                <div class="container">
                    <div class="row">
                        <div class="col-lg-12">
                            Copyright  2014 - @Karla @Meli
                        </div>
                    </div>
                </div>
            </div>
        </footer>
    </html>
</f:view>
