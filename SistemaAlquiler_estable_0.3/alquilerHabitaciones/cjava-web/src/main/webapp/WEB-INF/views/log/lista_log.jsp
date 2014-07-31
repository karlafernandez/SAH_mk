
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<sec:authorize access="hasRole('MOD_SEG_LOG_LISTA_EVENTO')">
    <link el="stylesheet" type="text/css" href="<c:url value="/css/paging.css"/>"/>
    <script src="<c:url value='/js/jquery.paging.js'/>" type="text/javascript"></script>
    <script src="<c:url value='/js/log/listar.js'/>" type="text/javascript"></script>

    <div class="fondoGris container-fluid">
        <div class="row-fluid div-titulo">
            <h3>Registro de Log </h3>
        </div>
        <div class="row-fluid div-filtros">                         
            <c:url var="url" value="/lista-log.html" />
            <form:form id="frmFiltro" modelAttribute="busquedaDTO" method="post" action="${url}">
                <fieldset>
                    <form:hidden path="inicio" id="inicio"/>
                    <form:hidden path="cantidad" id="cantidad"/>
                    <form:input  path="condiciones[0].field" value="usuario" cssStyle="display: none" /> 
                    <form:input path="condiciones[1].field" value="accion" cssStyle="display: none"/> 
                    <form:input path="condiciones[2].field" value="entidad" cssStyle="display: none"/> 
                    <form:input path="condiciones[3].field" value="ubicacion" cssStyle="display: none"/> 
                    <input name="buscar" type="hidden">
                    <div class="row-fluid">
                        <div class="span3"> 
                            <label for="condicion0">Usuario</label>   
                            <form:input id="condicion0" path="condiciones[0].data" type="text" cssClass="input-limpiar"  placeholder="Usuario" />  
                        </div>
                        <div class="span3">
                            <label for="condicion1">Accion</label>  
                            <form:input id="condicion1" path="condiciones[1].data" type="text" cssClass="input-limpiar"   placeholder="Accion" />   
                        </div> 
                        <div class="span3">
                            <label for="condicion2">Entidad</label>  
                            <form:input id="condicion2" path="condiciones[2].data" type="text" cssClass="input-limpiar"   placeholder="Entidad" />   
                        </div> 
                        <div class="span3">
                            <label for="condicion3">Ubicacion</label>  
                            <form:input id="condicion3" path="condiciones[3].data" type="text" cssClass="input-limpiar"   placeholder="Ubicacion" />   
                        </div> 
                    </div> 
                    <div class="row-fluid  div-filtros-accion">  
                        <input type="button" onclick="fnBuscar();" id="btnBuscar"  name="buscar" class="btn btn-info fa-input" value="<spring:message code="btn.buscar"/>">       
                        <input type="button" onclick="fnLimpiarBusqueda();" class="btn btn-info fa-input" value="<spring:message code="btn.limpiar"/>"  > 
                    </div>
                </fieldset>
            </form:form>
        </div>
        <div class="row-fluid">
            <input id="total" type="hidden" value="${grilla.total}"/>

            <div id="div-error" class="message-box info">
                <strong><spring:message code="msg.busqueda.sin_resultados"/></strong>
            </div>    

            <div id="id-table">                        
                <table id="listado" class="table table-bordered table-hover table-striped">
                    <caption class="caption"> Listado </caption>
                    <thead>
                        <tr>
                            <th>ID</th>     
                            <th >Ubicacion</th> 
                            <th >Usuario</th>
                            <th>Accion</th>                    
                            <th >Entidad</th>  
                            <th >Fecha</th>                    
                            <th>Ver Detalle</th>     
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="inc" items="${grilla.rows}" varStatus="status">
                            <tr id="${status.index}">
                                <td>${inc.idLog}</td>
                                <td>${inc.ubicacion}</td>
                                <td>${inc.usuario}</td>
                                <td>${inc.accion}</td>
                                <td>${inc.entidad}</td>
                                <td>${inc.fecha}</td> 
                                <td>
                                    <sec:authorize access="hasRole('MOD_SEG_LOG_EVENTO_DETALLE')">
                                        <a class="btn btn-link" href="ver-detalle-log.html?idLog=${inc.idLog}" >
                                            <i class="icon-eye-open"></i>
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

        </div>
    </div>                                             
</sec:authorize>