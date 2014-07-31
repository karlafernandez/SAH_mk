

<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<sec:authorize access="hasRole('MOD_SEG_LISTA_ACCESO')">
    <link el="stylesheet" type="text/css" href="<c:url value="/css/paging.css"/>"/>  
    <script src="<c:url value='/js/jquery.paging.js'/>" type="text/javascript"></script> 
    <script src="<c:url value='/js/accesos/listar_adm_instructor.js'/>" type="text/javascript"></script> 


    <div class="fondoGris container-fluid"> 
        <div class="row-fluid  div-titulo">
            <h3>Administracion de Accesos - Instructores</h3>
        </div>

        <div class="row-fluid div-filtros" >  
            <c:url var="url" value="/listar_adm_instructor.html" /> 
            <form:form id="frmFiltro" modelAttribute="busquedaDTO" action="${url}" method="post"  >
                <fieldset> 
                    <form:hidden path="inicio"   id="inicio" /> 
                    <form:hidden path="cantidad"   id="cantidad" /> 
                    <form:input  path="condiciones[0].field" value="buscarNombre" cssStyle="display: none" /> 
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
                        <input type="submit" id="btnBuscar"  name="buscar" class="btn btn-info fa-input" value="<spring:message code="btn.buscar"/>">       
                        <input type="button" onclick="fnLimpiarBusqueda();" class="btn btn-info fa-input" value="<spring:message code="btn.limpiar"/>"  > 
                    </div>
                </fieldset>
            </form:form>
        </div>
        <div class="row-fluid">

            <input id="total" type="hidden" value="${grilla.total}"/>   
            <c:if test="${grilla.total eq 0}">
                <div id="div-error" class="message-box info">
                    <strong><spring:message code="msg.busqueda.sin_resultados"/></strong>
                </div>   
            </c:if>


            <c:if test="${grilla.total gt 0}">

                <div id="id-table">   
                    <table id ="listado" class="table table-bordered table-hover table-striped">

                        <caption class="caption" > Listado</caption>
                        <thead> 
                            <tr style="background-color:#422CB3" > 
                                <th>Nro</th> 
                                <th>Nombre Instructor</th>                             
                                <th class="hidden-phone">DNI</th>  

                                <th>Accesos</th> 
                            </tr>  
                        </thead>
                        <tbody>

                            <c:forEach var="instructor" items="${grilla.rows}"  varStatus="status">
                                <tr id="${status.index}" >
                                    <td>${(grilla.page - 1) * grilla.pagination + status.index +1}</td>
                                    <td>${instructor.nombreCompleto}</td>
                                    <td class="hidden-phone">${instructor.documento}</td> 
                                    <td><a class="btn btn-link"  href="asignar_acceso.html?idUsuario=${instructor.idPersona}&direccion=listar_adm_instructor" ><i class="icon-pencil"></i></a></td>  
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