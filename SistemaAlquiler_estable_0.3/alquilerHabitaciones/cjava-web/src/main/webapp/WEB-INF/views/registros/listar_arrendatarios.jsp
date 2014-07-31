<%-- 

    Author     : MELImeli
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<sec:authorize access="hasRole('MOD_ADM_LISTAR_INSTRUCTOR')">
    <link el="stylesheet" type="text/css" href="<c:url value="/css/paging.css"/>"/>  
    <script src="<c:url value='/js/jquery.paging.js'/>" type="text/javascript"></script> 
    <script src="<c:url value='/js/registro/instructor/listar_ins.js'/>" type="text/javascript"></script> 


    <div class="fondoGris container-fluid"> 
        <div class="row-fluid  div-titulo">
            <h3>Registrar Instructor </h3>
        </div>

        <div class="row-fluid div-filtros" >  
            <c:url var="url" value="/listarInstructores.html" /> 
            <form:form id="frmFiltro" modelAttribute="busquedaDTO" action="${url}"  >
                <fieldset> 
                    <form:hidden path="inicio"   id="inicio" /> 
                    <form:hidden path="cantidad"   id="cantidad" />                     
                    <form:input path="condiciones[0].field" value="buscarNombre" cssStyle="display: none" /> 
                    <form:input path="condiciones[1].field" value="buscarNroDoc" cssStyle="display: none"/> 
                    <input name="buscar" type="hidden">
                    <div class="row-fluid">
                        <div class="span2"> 
                            <label for="condicion0">Nombre</label>   
                            <form:input id="condicion0" path="condiciones[0].data" type="text" cssClass="input-limpiar" placeholder="Nombre" />  
                        </div>
                        <div class="span2">
                            <label for="condicion1">Nro Documento</label>  
                            <form:input id="condicion1" path="condiciones[1].data" type="text" cssClass="input-limpiar"   placeholder="Nro Documento" />   
                        </div> 
                    </div> 
                    <div class="row-fluid  div-filtros-accion">  
                        <input type="button" id="btnBuscar" onclick="fnBuscar()" class="btn btn-info fa-input" value="<spring:message code="btn.buscar"/>">       
                        <input type="button" onclick="fnLimpiarBusqueda();" class="btn btn-info fa-input" value="<spring:message code="btn.limpiar"/>"  >
                        <sec:authorize access="hasRole('MOD_ADM_CREAR_INSTRUCTOR')">
                            <a href="./registrarInstructores.html" id="btnRegistrar"   class="btn btn-info fa-input" > <spring:message code="btn.nuevoInstructor"/></a> 
                        </sec:authorize>
                    </div>
                </fieldset>
            </form:form>
        </div>
        <div class="row-fluid">
            <input id="total" type="hidden" value="${grilla.total}"/>        
            <div id="div-error" class="message-box info">                
                <strong><spring:message code="msg.busqueda.sin_resultados"/></strong>
            </div>   

            <c:if test="${grilla.total gt 0}">
                <div id="id-table">   
                    <table id ="listado" class="table table-bordered table-hover table-striped">

                        <caption class="caption" > Listado</caption>
                        <thead> 
                            <tr style="background-color:#422CB3" > 
                                <th>Nro</th> 
                                <th>Nombre Instructor</th>                             
                                <th class="hidden-phone">DNI</th>  
                                <th class="hidden-phone">Cursos Activos</th>
                                <th>Editar</th>
                                <th>Borrar</th>
                                <th>Historial</th>
                            </tr>  
                        </thead>
                        <tbody>

                            <c:forEach var="instructor" items="${grilla.rows}"  varStatus="status">
                                <tr id="${status.index}" >
                                    <td>${(grilla.page - 1) * grilla.pagination + status.index +1}</td>
                                    <td>${instructor.nombreCompleto}</td>
                                    <td class="hidden-phone">${instructor.documento}</td> 
                                    <td class="hidden-phone">${instructor.documento}</td>
                                    <td>
                                        <sec:authorize access="hasRole('MOD_ADM_MODIFICAR_INSTRUCTOR')">
                                            <a class="btn btn-link"  href="modificarInstructores.html?idInstructor=${instructor.idInstructor}" >
                                                <i class="icon-pencil"></i>
                                            </a>
                                        </sec:authorize>
                                    </td>  
                                    <td>
                                        <sec:authorize access="hasRole('MOD_ADM_ELIMINAR_asdasINSTRUCTOR')">
                                            <a class="btn btn-link" onclick="eliminarRow(this,${instructor.idInstructor});"  >
                                                <i class="icon-trash"></i>
                                            </a>
                                        </sec:authorize>
                                    </td>                                      
                                    <td>
                                        <sec:authorize access="hasRole('MOD_ADM_HISTORIAL_INSTRUCTOR')">
                                            <a class="btn btn-link"  href="mantenimiento.html" >
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
                </div><!--/row-->
            </c:if>      

        </div> 
    </div> 
</sec:authorize>
