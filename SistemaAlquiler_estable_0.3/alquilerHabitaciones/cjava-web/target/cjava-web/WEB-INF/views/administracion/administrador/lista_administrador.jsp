

<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>


<sec:authorize access="hasRole('MOD_ADM_LISTAR_ADMINISTRADORES')">
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link el="stylesheet" type="text/css" href="<c:url value="/css/paging.css"/>"/>
    <script src="<c:url value='/js/jquery.paging.js'/>" type="text/javascript"></script>
    <script src="<c:url value='/js/administracion/administrador/administrador.listar.js'/>" type="text/javascript"></script>
    <script src="<c:url value='/js/validaciones.js'/>" type="text/javascript"></script>

    <div class="fondoGris container-fluid">
        <div class="row-fluid">
            <h3>Registro de Administradores</h3>
        </div>

        <div class="row-fluid div-filtros" >                          
            <c:url var="url" value="/listar-administrador.html" />
            <form:form id="frmFiltro" modelAttribute="busquedaDTO" method="post" action="${url}">
                <fieldset>
                    <form:hidden path="inicio" id="inicio"/>
                    <form:hidden path="cantidad" id="cantidad"/>
                    <form:input path="condiciones[0].field" value="buscarNombre" cssStyle="display: none"/>  
                    <form:input path="condiciones[1].field" value="buscarUser" cssStyle="display: none"/>  
                    <input name="buscar" type="hidden">
                    <div class="row-fluid div-nombres">
                        <div class="span5">
                            <label for="condicion0">Nombre</label>
                            <form:input id="condicion0" path="condiciones[0].data" type="text" maxlength="45" cssClass="input-limpiar input-xxlarge" onchange="javascript:this.value=this.value.toUpperCase();" placeholder="Nombre Administrador"/> 
                        </div>
                        <div class="span3">
                            <label for="condicion1">User</label>
                            <form:input id="condicion1" path="condiciones[1].data" type="text" maxlength="11" cssClass="input-limpiar" placeholder="User" onkeypress="return valSoloAlfanumerico(event)"/> 
                        </div>
                    </div>                
                    <div class="row-fluid div-filtros-accion">
                        <input type="button" id="btnBuscar" onclick="fnBuscar();" class="btn btn-info fa-input" value="<spring:message code="btn.buscar"/>">       
                        <input type="button" onclick="fnLimpiarBusqueda();" class="btn btn-info fa-input" value="<spring:message code="btn.limpiar"/>"  >
                        <sec:authorize access="hasRole('MOD_ADM_REGISTRAR_ADMINISTRADOR')">
                            <a href="./registrar-administrador.html" id="btnRegistrar"   class="btn btn-info fa-input pull-right" > <spring:message code="btn.nuevoAdmin"/></a> 
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
                    <table id="listado" class="table table-bordered table-hover table-striped">
                        <caption class="caption"> Listado </caption>
                        <thead>
                            <tr>
                                <th>N°</th> 
                                <th>Nombre del administrador</th>                    
                                <th class="hidden-phone">User</th>                                
                                <th><spring:message code="tbl.admin.editar"/></th>
                                <th><spring:message code="tbl.admin.eliminar"/></th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="inc" items="${grilla.rows}" varStatus="status">
                                <tr id="${status.index}">
                                    <td> ${(grilla.page - 1) * grilla.pagination + status.index +1}</td>
                                    <td> ${inc.nomAdmin}</td>
                                    <td class="hidden-phone"> ${inc.nomUser}</td>                                       
                                    <td>
                                        <sec:authorize access="hasRole('MOD_ADM_MODIFICAR_ADMINISTRADOR')">
                                            <a class="btn btn-link"  href="modificar-administrador.html?idAdmin=${inc.idAdmin}" >
                                                <i class="icon-pencil"></i>
                                            </a>
                                        </sec:authorize>
                                    </td>                                      
                                    <td>
                                        <sec:authorize access="hasRole('MOD_ADM_ELIMINAR_ADMINISTRADOR')">
                                            <a class="btn btn-link" onclick="eliminarRow(this,${inc.idAdmin});"  >
                                                <i class="icon-trash"></i>
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
        </div>
    </div>

</sec:authorize>