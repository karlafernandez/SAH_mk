<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<%--<sec:authorize access="hasRole('MOD_ADM_CREAR_ALUMNOS')">--%>
<%--<sec:authorize access="isAnonymous()">--%> 
    <script src="<c:url value='/js/registro/alumno/registrar_alu.js'/>" type="text/javascript"></script>
    <script src="<c:url value='/js/validaciones.js'/>" type="text/javascript"></script>


    <div class="container-fluid fondoGris">
        <div class="row-fluid  div-titulo">
            <h3 class="span6">Registrar Clientes </h3>
            <div class="span6"> <a  href="listarAlumnos.html" class=" btn btn-info fa-input pull-right">Volver a Listado</a>   </div> 
        </div>
        <div class="row-fluid formulario">
            <c:url var="url" value="/registrarAlumnos.html" />
            <form:form id="frmDatosAlumno" modelAttribute="registro"   method="post"  action="${url}"  cssClass="form-horizontal">

                <fieldset >
                    <legend><h4>Datos Cliente </h4></legend>
                    <div class="row-fluid">

                        <div class="span6">

                            <div class="control-group">
                                <label   class="control-label" for="nombre">Nombres *</label>                
                                <div class="controls">
                                    <form:input id="nombre" path="nombre" cssClass="input-xlarge"  onkeypress="return valSoloLetras(event);" onchange="javascript:this.value=this.value.toUpperCase();llenarUsuario();" type="text"/>
                                    <form:errors  path="nombre"  cssClass="help-block"/>   
                                </div>  
                            </div>  
                            <div class="control-group">
                                <label  class="control-label"    for="primerApellido">Apellido Paterno * </label>                            
                                <div class="controls">
                                    <form:input id="primerApellido" path="primerApellido" cssClass="input-xlarge" onkeypress="return valSoloLetras(event);"  onchange="javascript:this.value=this.value.toUpperCase();llenarUsuario();"  type="text"  />
                                    <form:errors  path="primerApellido" cssClass="help-block"/>                      
                                </div>  
                            </div>   
                            <div class="control-group">
                                <label   class="control-label"   for="segundoApellido">Apellido Materno * </label>                           
                                <div class="controls">
                                    <form:input id="segundoApellido" path="segundoApellido" cssClass="input-xlarge" onkeypress="return valSoloLetras(event);"  onchange="javascript:this.value=this.value.toUpperCase();llenarUsuario();" type="text"  />
                                    <form:errors path="segundoApellido" cssClass="help-block"/>    
                                </div>
                            </div> 

                            <div class="control-group">
                                <label  class="control-label"   for="fechaNacimiento">Fecha Nacimiento * </label>      
                                <div class="controls">
                                    <form:input id="fechaNacimiento" path="fechaNacimiento" cssClass="input-small" type="text" />
                                    <form:errors  path="fechaNacimiento" cssClass="help-block"/>
                                </div>
                            </div>
                            <div class="control-group">
                                <label  class="control-label"   for="documento">Tipo de documento * </label>                            
                                <div class="controls">
                                    <form:select id="idTipdocumento" path="idTipdocumento" cssClass="input-large"  >
                                        <form:option value="0" label="Seleccione"/>
                                        <form:options items="${lstTipoDocumento}" itemValue="idSubTipo" itemLabel="nomSubtipo"/>
                                    </form:select>  
                                    <form:errors path="idTipdocumento" cssClass="help-block"/>
                                </div> 
                            </div> 


                            <div class="control-group">
                                <label  class="control-label" for="documento">N° de documento * </label>        
                                <div class="controls">
                                    <form:input id="documento" path="documento" cssClass="input-large"   onkeypress="return valSoloDigitos(event);" maxlength="11" type="text"  />
                                    <form:errors path="documento" cssClass="help-block"/>    
                                </div>  
                            </div> 


                            
                        </div>


                        <div class="span6">

                           <div class="control-group">
                                <label class="control-label" for="telefono">Teléfono/Móvil </label>                            
                                <div class="controls"> 
                                    <form:input id="telefono" path="telefono" cssClass="input-large"  type="text"  />
                                    <form:errors  path="telefono" cssClass="help-block"/>      
                                </div>
                            </div>  

                     
                            <div class="control-group">
                                <label class="control-label" for="correoPersonal">Correo Personal * </label>                            
                                <div class="controls">
                                    <form:input id="correoPersonal" path="correoPersonal" cssClass="input-large"  type="text"  />
                                    <form:errors path="correoPersonal" cssClass="help-block"/>  
                                </div>       
                            </div> 
                            <div class="control-group">
                                <label class="control-label" for="correoFace">Correo Facebook</label>                            
                                <div class="controls">
                                    <form:input id="correoFace" path="correoFace" cssClass="input-large"   type="text"  />
                                    <form:errors  path="correoFace" cssClass="help-block"/>      
                                </div> 
                            </div>  


                        </div>
                    </div>  
                </fieldset>


                <fieldset>
                    <legend><h4>Datos Ubicación </h4></legend>                        
                    <div class="row-fluid"> 

                        <div class="span6"> 
                            <div class="control-group">
                                <label class="control-label" for="pais"> País * </label>                            
                                <div class="controls">
                                    <form:select id="pais" path="pais" cssClass="input-large" >
                                        <form:option value="" label="Seleccione"/> 
                                    </form:select> 
                                    <form:errors  path="pais" cssClass="help-block"/> 
                                </div>
                            </div>

                            <div class="control-group">
                                <label class="control-label" for="departamento"> Departamento * </label>                            
                                <div class="controls">
                                    <form:select id="departamento" path="departamento"  cssClass="input-large">
                                        <form:option value="" label="Seleccione"/> 
                                    </form:select>  
                                    <form:errors  path="departamento" cssClass="help-block"/>
                                </div>
                            </div>


                            <div class="control-group">
                                <label class="control-label" for="provincia"> Provincia * </label>                            
                                <div class="controls">
                                    <form:select id="provincia" path="provincia"  cssClass="input-large" >
                                        <form:option value="" label="Seleccione"/> 
                                    </form:select> 
                                    <form:errors path="provincia" cssClass="help-block"/>
                                </div>
                            </div>

                            <div class="control-group"><label class="control-label" for="distrito"> Distrito * </label>                            
                                <div class="controls">
                                    <form:select id="distrito" path="distrito"  cssClass="input-large"  >
                                        <form:option value="" label="Seleccione"/> 
                                    </form:select>  
                                    <form:errors path="distrito" cssClass="help-block"/>
                                </div>
                            </div> 
                        </div> 

                        <div class="span6">  
                            <div class="control-group">
                                <label class="control-label" for="direccion"> Dirección * </label>                            
                                <div class="controls">
                                    <form:textarea id="direccion" path="direccion"  cssClass="input-large"  type="text" />
                                    <form:errors  path="direccion" cssClass="help-block"/>
                                </div> 
                            </div>

                        </div>

                    </div>
                </fieldset>

                <fieldset>
                    <legend>Acceso generado</legend>    
                    <div class="row-fluid">
                        <div class="span12">
                            <div class="control-group">
                                <label class="control-label" for="usuario">Usuario</label>                           
                                <div class="controls"> 
                                    <form:input id="usuario" path="usuario" type="text" cssClass="input-medium"/>
                                    <form:errors path="usuario" cssClass="help-block"/>  
                                </div>
                            </div>
                        </div>  
                    </div> 
                    <div class="row-fluid">
                        <div class="span12" style="min-height: 50px">
                            <span>(*) Todos los campos son obligatorios</span>
                        </div> 
                    </div> 
                    <div class="row-fluid "> 
                        <div class="span12 form-actions">
                            <div class="control-group">
                                <div class="controls">
                                    <input id="btnGuardar" type="submit" class="btn btn-info fa-input" name="guardar" value="<spring:message code="btn.guardar"/>"> &nbsp;                                                                                                               
                                    <a class="btn btn-info fa-input right" href="listarAlumnos.html"><spring:message code="btn.cancelar"/></a>  
                                </div> 
                            </div>

                        </div> 
                    </div>
                </fieldset> 

            </form:form>

        </div>
    </div>
<%--</sec:authorize>--%>

<%--
<sec:authorize access="isAuthenticated()">  
    <c:redirect url="http://www.google.com"/>
</sec:authorize>   --%>