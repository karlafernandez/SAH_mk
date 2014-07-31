<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<sec:authorize access="hasRole('MOD_SEG_ASIGNAR_ACCESO')">
    <link href="css/easytabs.css" media="screen" rel="stylesheet" type="text/css" />
    <script src="<c:url value='/js/jquery.hashchange.min.js'/>" type="text/javascript"></script> 
    <script src="<c:url value='/js/jquery.easytabs.min.js'/>" type="text/javascript"></script> 
    <script src="<c:url value='/js/accesos/asignar_acceso.js'/>" type="text/javascript"></script> 

    <div class="fondoGris container-fluid"> 
        <div class="row-fluid  div-titulo">

            <c:if test="${asignarAcceso.direccionRetorno eq 'listar_adm_instructor'}"> 
                <h3>Asignar Accesos Por Usuario - Instructor</h3>
            </c:if> 


        </div>
        <div class="row-fluid formulario" > 
            <fieldset>
                <c:url var="url" value="/asignar_acceso.html" /> 
                <form:form id="frmAsignarAcceso" modelAttribute="asignarAcceso" method="post" action="${url}" cssClass="form-horizontal" >
                    <form:hidden id="hidIdUsuario" path="idUsuario"/>
                    <form:hidden id="direccionRetorno" path="direccionRetorno"/>
                    <form:hidden id="hidLstAccesos" path="lstAccesos"/> 
                    <div class="control-group ">
                        <label class="control-label" for="nomUsuario">Usuario :</label>
                        <div class="controls">
                            <form:input id="nomUsuario" path="usuarioDTO.nomUsuario" type="text" readonly="true"/>  
                        </div>
                    </div>    
                    <div class="control-group ">
                        <label class="control-label" for="nomNombre">Nombre :</label>
                        <div class="controls">
                            <form:input path="usuarioDTO.nomNombre" type="text" readonly="true" id="nomNombre" /> 
                        </div>
                    </div>    
                    <div class="control-group ">
                        <label class="control-label" for="nomApellido">Apellido Paterno:</label>
                        <div class="controls">
                            <form:input path="usuarioDTO.nomApePaterno" type="text" readonly="true" id="nomApellido"/> 
                        </div>
                    </div>    
                    <div class="control-group ">
                        <label class="control-label" for="nomApellidoM">Apellido Materno :</label>
                        <div class="controls">
                            <form:input path="usuarioDTO.nomApeMaterno" type="text" readonly="true" id="nomApellidoM"/> 
                        </div>
                    </div>    


                    <div class="row-fluid">
                        <div class="span12 form-actions">
                            <div class="control-group">                            
                                <div class="controls">                                                                                             
                                    <input id="btnAsignar" class="btn btn-info fa-input" type="button" value="Asignar">  
                                    <a   class="btn btn-info fa-input" href="${asignarAcceso.direccionRetorno}.html" >Regresar a Listado</a>  
                                </div> 
                            </div>
                        </div>
                    </div>


                </form:form>
            </fieldset>


        </div>  
        <div class="row-fluid" >

            <div id="divAccesos"  class='tab-container span12' >
                <ul class='tabs'>
                    <c:if test="${not empty modulos}"> 
                        <c:forEach var="modulo" items="${modulos}"> 
                            <c:if test="${not empty modulo.listado}">  
                                <li class='tab' >
                                    <a href="#tabs-${modulo.idAcceso}">${modulo.nomAcceso}</a>
                                </li>
                            </c:if> 
                        </c:forEach> 
                    </c:if>

                </ul>
                <div class='panel-container span12' style="margin-left: 0; min-height: 400px">
                    <c:forEach var="modulo" items="${modulos}">  
                        <div id="tabs-${modulo.idAcceso}"  > 
                            <c:if test="${not empty modulo.listado}"> 
                                <c:forEach var="grupo" items="${modulo.listado}"  varStatus="loopStatus">
                                    <c:if test="${not empty grupo.listado}"> 
                                        <div   id="grupo_${grupo.idAcceso}" class="span4" style="margin-left: 0" >
                                            <input  type="checkbox" class="modulo"><strong>&nbsp; ${grupo.nomAcceso}</strong>
                                            <ul>

                                                <c:forEach var="acceso" items="${grupo.listado}">
                                                    <li>
                                                        <input id="check_${acceso.idAcceso}" type="checkbox" value="${acceso.idAcceso}" class="opcion">&nbsp; ${acceso.nomAcceso}
                                                    </li>                     
                                                </c:forEach>

                                            </ul>
                                        </div>  
                                    </c:if> 
                                </c:forEach> 
                            </c:if> 
                        </div>
                    </c:forEach> 
                </div>
            </div>
        </div>

    </div>
</sec:authorize>
