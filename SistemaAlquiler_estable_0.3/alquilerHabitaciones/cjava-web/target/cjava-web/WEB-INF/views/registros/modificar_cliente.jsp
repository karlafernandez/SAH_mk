<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<sec:authorize access="hasRole('MOD_ADM_MODIFICAR_ALUMNOS')">
    <script src="<c:url value='/js/registro/alumno/modificar_alu.js'/>" type="text/javascript"></script>
    <script src="<c:url value='/js/validaciones.js'/>" type="text/javascript"></script>



    <div class="container-fluid fondoGris">
        <div class="row-fluid  div-titulo">
            <h3 class="span6">Modificar datos alumno </h3>
            <div class="span6"> <a  href="listarAlumnos.html" class=" btn btn-info fa-input pull-right">Volver a Listado</a>   </div> 
        </div>
        <div class="row-fluid formulario">
            <c:url var="url" value="/modificarAlumno.html" />
            <form:form id="frmDatosGenerales" modelAttribute="alumno"   method="post"  action="${url}" cssClass="form-horizontal">
                <form:hidden id="idAlumno" path="idAlumno" />  
                <form:hidden id="idPersona" path="idPersona" />                  
                <fieldset >
                    <legend><h4>Datos Alumno </h4></legend>

                    <div class="span7 text-center">
                        <div class="span7 right text-right"><label for="Codigo">Código Alumno:</label></div>
                        <input type="text" class="span2 text-center"  value="${alumno.codigo}" id="idAlumno" readonly="readonly" />

                    </div>
                    <legend><h4> </h4></legend>

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


                            <div class="control-group">
                                <label class="control-label" for="telefono">Teléfono fijo </label>                            
                                <div class="controls"> 
                                    <form:input id="telefono" path="telefono" cssClass="input-large"  type="text"  />
                                    <form:errors  path="telefono" cssClass="help-block"/>      
                                </div>
                            </div>  

                            <div class="control-group">
                                <label class="control-label" for="celular">Celular </label>                            
                                <div class="controls">
                                    <form:input id="celular" path="celular" cssClass="input-large"   type="text"  />
                                    <form:errors  path="celular" cssClass="help-block"/>      
                                </div> 
                            </div>  

                            <div class="control-group">
                                <label class="control-label" for="correoPersonal">Correo Personal * </label>                            
                                <div class="controls">
                                    <form:input id="correoPersonal" path="correoPersonal" cssClass="input-large"  type="text"  />
                                    <form:errors path="correoPersonal" cssClass="help-block"/>  
                                </div>       
                            </div> 


                        </div>


                        <div class="span6">

                            <div class="control-group">
                                <label class="control-label" for="correoCoorporativo">Correo Corporativo</label>                            
                                <div class="controls">
                                    <form:input id="correoCoorporativo" path="correoCoorporativo" cssClass="input-large"  type="text"  />
                                    <form:errors path="correoCoorporativo" cssClass="help-block"/>  
                                </div>       
                            </div> 

                            <div class="control-group">
                                <label  class="control-label"   for="NivelEstudio">Nivel de Estudios </label>                            
                                <div class="controls">
                                    <form:select id="idNivelEstudio" path="idNivelEstudio" cssClass="input-large"  >
                                        <form:option value="0" label="Seleccione"/>
                                        <form:options items="${lstTipoNivelEstudio}" itemValue="idSubTipo" itemLabel="nomSubtipo"/>
                                    </form:select>  
                                    <form:errors path="idNivelEstudio" cssClass="help-block"/>
                                </div> 
                            </div> 


                            <div class="control-group">
                                <label  class="control-label"   for="TipoCentroEducativo">Tipo de Institución </label>                            
                                <div class="controls">
                                    <form:select id="IdCentroEdu" path="IdCentroEdu" cssClass="input-large"  >
                                        <form:option value="0" label="Seleccione"/>
                                        <form:options items="${lstTipoCentroEducativo}" itemValue="idSubTipo" itemLabel="nomSubtipo"/>
                                    </form:select>  
                                    <form:errors path="IdCentroEdu" cssClass="help-block"/>
                                </div> 
                            </div> 

                            <div class="control-group">
                                <label  class="control-label"   for="Ocupacion">Ocupación * </label>                            
                                <div class="controls">
                                    <form:select id="idOcupacion" path="idOcupacion" cssClass="input-large"  >
                                        <form:option value="0" label="Seleccione"/>
                                        <form:options items="${lstOcupacion}" itemValue="idSubTipo" itemLabel="nomSubtipo"/>
                                    </form:select>  
                                    <form:errors path="idOcupacion" cssClass="help-block"/>
                                </div> 
                            </div> 



                            <div class="control-group">
                                <label class="control-label" for="institucion">Institución </label>                            
                                <div class="controls">
                                    <form:input id="institucion" path="institucion" cssClass="input-large"   type="text"  />
                                    <form:errors  path="institucion" cssClass="help-block"/>      
                                </div> 
                            </div>  

                            <div class="control-group">
                                <label class="control-label" for="centroTrabajo">Centro deTrabajo</label>                            
                                <div class="controls">
                                    <form:input id="centroTrabajo" path="centroTrabajo" cssClass="input-large"   type="text"  />
                                    <form:errors  path="centroTrabajo" cssClass="help-block"/>      
                                </div> 
                            </div>  

                            <div class="control-group">
                                <label class="control-label" for="correoFace">Correo Facebook</label>                            
                                <div class="controls">
                                    <form:input id="correoFace" path="correoFace" cssClass="input-large"   type="text"  />
                                    <form:errors  path="correoFace" cssClass="help-block"/>      
                                </div> 
                            </div>  

                            <div class="control-group">
                                <label class="control-label" for="correoLinke">Correo LinkedIn</label>                            
                                <div class="controls">
                                    <form:input id="correoLinke" path="correoLinke" cssClass="input-large"   type="text"  />
                                    <form:errors  path="correoLinke" cssClass="help-block"/>      
                                </div> 
                            </div> 




                        </div>
                    </div>  
                </fieldset>


                <fieldset>
                    <legend><h4>Datos Ubicación </h4></legend>                        
                    <div id="subcuerpo3" class="span12">

                        <div class="span6">


                            <div class="control-group">
                                <input id="idPais" type="hidden" value="${alumno.pais}"> 
                                <label class="control-label" for="pais"> País * </label>                            
                                <div class="controls">
                                    <form:select id="pais" path="pais" cssClass="input-large" >
                                        <form:option value="0" label="Seleccione"/> 
                                    </form:select> 
                                    <form:errors  path="pais" cssClass="help-block"/> 
                                </div>
                            </div>

                            <div class="control-group">
                                <input id="idDepartamento" type="hidden" value="${alumno.departamento}"> 
                                <label class="control-label" for="departamento"> Departamento * </label>                            
                                <div class="controls">
                                    <form:select id="departamento" path="departamento"  cssClass="input-large">
                                        <form:option value="0" label="Seleccione"/> 
                                    </form:select>  
                                    <form:errors  path="departamento" cssClass="help-block"/>
                                </div>
                            </div>

                            <div class="control-group">
                                <input id="idProvincia" type="hidden" value="${alumno.provincia}"> 
                                <label class="control-label" for="provincia"> Provincia * </label>                            
                                <div class="controls">
                                    <form:select id="provincia" path="provincia"  cssClass="input-large" >
                                        <form:option value="0" label="Seleccione"/> 
                                    </form:select> 
                                    <form:errors path="provincia" cssClass="help-block"/>
                                </div>
                            </div>


                            <div class="control-group">
                                <input id="idDistrito" type="hidden" value="${alumno.distrito}"> 
                                <label class="control-label" for="distrito"> Distrito * </label>                            
                                <div class="controls">
                                    <form:select id="distrito" path="distrito"  cssClass="input-large"  >
                                        <form:option value="0" label="Seleccione"/> 
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

                            <div class="control-group">
                                <label class="control-label" for="urbPer"> Urbanización </label>                            
                                <div class="controls">
                                    <form:input id="urbPer" path="urbPer" cssClass="input-large"  type="text" />
                                    <form:errors   path="urbPer" cssClass="help-block"/>
                                </div> 
                            </div>
                            <div class="control-group">
                                <label class="control-label" for="referenciaDir"> Referencia </label>                            
                                <div class="controls"> 
                                    <form:input id="referenciaDir" path="referenciaDir" cssClass="input-large" type="text" />
                                    <form:errors  path="referenciaDir" cssClass="help-block"/>
                                </div>
                            </div> 

                        </div> 




                    </div>
                </fieldset>

                <%--      <fieldset>
                          <legend><h4>Acceso generado</h4></legend>   
                          <div id="subcuerpo2" class="span5">

                            <div class="span4"><label for="usuario">Usuario *</label></div>
                            <form:input id="usuario" path="usuario" type="text" cssClass="span6" />
                            <div><form:errors id="usuario" path="usuario" cssClass="text-error"/></div>


                        </div>
                    </fieldset> --%>

            </div>

            <div class="span12" style="text-align: right; min-height: 50px">                                                                                             
                <input id="btnGuardar" type="submit" class="btn btn-info fa-input" name="guardar" value="<spring:message code="btn.guardar"/>"> &nbsp;                                                                                                               
                <a class="btn btn-info fa-input right" href="listarAlumnos.html"><spring:message code="btn.cancelar"/></a>                        
            </div> 
        </form:form>
    </div>
</sec:authorize>


