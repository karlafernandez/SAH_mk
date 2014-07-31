<%-- 

    Author     : MELImeli
--%>

<%--<%@page contentType="text/html" pageEncoding="UTF-8"%>--%>

<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<sec:authorize access="hasRole('MOD_ADM_LISTAR_ALUMNOS')">
    <link el="stylesheet" type="text/css" href="<c:url value="/css/paging.css"/>"/>
    <script src="<c:url value='/js/jquery.paging.js'/>" type="text/javascript"></script>
    <script src="<c:url value='/js/registro/alumno/listar_alu.js'/>" type="text/javascript"></script> 


    <div class="fondoGris container-fluid"> 
        <div class="row-fluid  div-titulo">
            <h3>Listado de Alumnos</h3>
        </div>

        <div class="row-fluid div-filtros" >  

            <c:url var="url" value="/listarAlumnos.html" />
            <form:form id="frmFiltro" modelAttribute="busquedaDTO" method="post" action="${url}">
                <fieldset> 
                    <form:hidden path="inicio" id="inicio"/>
                    <form:hidden path="cantidad" id="cantidad"/>

                    <input name="buscar" type="hidden">

                    <div class="clearfix div-nombres">
                        <form:input path="condiciones[0].field" value="buscarNombre" cssStyle="display: none" style="margin-left: 0"/>  
                        <form:input path="condiciones[1].field" value="buscarNroDoc" cssStyle="display: none"/>  
                        <span class="span2 busqueda-label">Nombre</span>
                        <span class="span2 busqueda-label">Nro Documento</span> 
                    </div>
                    <div class="clearfix div-campos"> 
                        <form:input path="condiciones[0].data" type="text" cssClass="input-limpiar span2"   placeholder="Nombre" style="margin-top:10px" /> 
                        <form:input path="condiciones[1].data" type="text" cssClass="input-limpiar span2"   placeholder="Nro Documento"  style="margin-top:10px" /> 
                        <input type="button" id="btnBuscar"  onclick="fnBuscar()" class="btn btn-info fa-input" value="<spring:message code="btn.buscar"/>">       
                        <input type="button" onclick="fnLimpiarBusqueda();" class="btn btn-info fa-input" value="<spring:message code="btn.limpiar"/>"  >
                        <sec:authorize access="hasRole('MOD_ADM_CREAR_ALUMNOS')">
                            <a href="./registrarAlumnos.html" id="btnRegistrar"   class="btn btn-info fa-input " > <spring:message code="btn.nuevoAlumno"/></a> 
                        </sec:authorize>
                    </div>
                </fieldset>
            </form:form>

            <fieldset>
                <input id="total" type="hidden" value="${grilla.total}"/>        
                <div id="div-error" class="message-box info">
                    <strong><spring:message code="msg.busqueda.sin_resultados"/></strong>
                </div>                
                <c:if test="${grilla.total gt 0}">
                    <div id="id-table">                        
                        <table id="listado" class="table table-bordered table-hover table-striped" >
                            <thead>
                                <tr > 
                                    <th>Nro</th> 
                                    <th>Nombres</th>                             
                                    <th>Nro Documento</th>                                      
                                    <th>Editar</th>
                                    <th>Borrar</th>
                                    <th>Historial</th>
                                </tr>  
                            </thead>
                            <tbody>
                                <c:forEach var="alumno" items="${grilla.rows}" varStatus="status">
                                    <tr id="${status.index}" >
                                        <td>${status.index+1}</td>
                                        <td>${alumno.nombreCompleto}</td>
                                        <td>${alumno.documento}</td>                                         
                                        <td>
                                            <sec:authorize access="hasRole('MOD_ADM_MODIFICAR_ALUMNOS')">
                                                <a class="btn btn-link"  href="modificarAlumno.html?idAlumno=${alumno.idAlumno}" >
                                                    <i class="icon-pencil"></i>
                                                </a>
                                            </sec:authorize>
                                        </td>                                      
                                        <td>
                                            <sec:authorize access="hasRole('MOD_ADM_ELasdIMINAR_ALUMNO')">
                                                <a class="btn btn-link" onclick="eliminarRow(this,${alumno.idAlumno});"  >
                                                    <i class="icon-trash"></i>
                                                </a>
                                            </sec:authorize>
                                        </td>                                      
                                        <td>
                                            <sec:authorize access="hasRole('MOD_ADM_HISTORIAL_ALUMNOS')">
                                                <a class="btn btn-link"  href="historial-cursos.html?idAlum=${alumno.idAlumno}&nomAlum=${alumno.nombreCompleto}" >
                                                    <i class="icon-th-list"></i>
                                                </a>
                                            </sec:authorize>
                                        </td>                                     
                                    </tr>
                                </c:forEach>
                            </tbody>                            
                        </table>
                        <div class="pagination pagination-centered">        
                            <ul id="pagination"> </ul>
                        </div>
                    </div>
                </c:if>        
            </fieldset>
        </div> 
    </div> 
</sec:authorize>