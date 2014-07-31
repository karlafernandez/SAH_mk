

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<sec:authorize access="hasRole('MOD_OPE_LISTAR_CURSO_ACTIVO_APERTURADO')">
    <link el="stylesheet" type="text/css" href="<c:url value="/css/paging.css"/>"/>
    <script src="<c:url value='/js/jquery.paging.js'/>" type="text/javascript"></script>
    <script src="<c:url value='/js/operacion/operacion/lista_operacion.js'/>" type="text/javascript"></script> 
    <div class="fondoGris container-fluid">
        <div class="row-fluid" style="background-color: #FFFFFF"></div>
        <div class="row-fluid">
            <h3>Listado de Cursos Activos</h3>
        </div>
        <c:url var="url" value="/lista-curso-operacion.html" />
        <form:form id="frmFiltro" modelAttribute="busquedaDTO" method="post" action="${url}" cssClass="form-search">
            <form:hidden path="inicio" id="inicio"/>
            <input type="hidden" name="buscar"/>
            <form:hidden path="cantidad" id="cantidad"/>
            <div class="clearfix div-nombres">
                <form:input path="condiciones[0].field" value="buscarNomCurAct" cssStyle="display: none" style="margin-left: 0"/>  
                <form:input path="condiciones[1].field" value="buscarNomenCurAct" cssStyle="display: none"/>  
                <form:input path="condiciones[2].field" value="estadoOperacion" cssStyle="display: none"/>  
                <span class="span2 busqueda-label">Nombre</span>
                <span class="span2 busqueda-label">Nomenclatura</span> 
            </div>
            <div class="clearfix div-campos"> 
                <form:input path="condiciones[0].data" type="text" cssClass="input-limpiar span2"   placeholder="Nombre" style="margin-top:5px" /> 
                <form:input path="condiciones[1].data" type="text" cssClass="input-limpiar span2"   placeholder="Nomenclatura"  style="margin-top: 5px" /> 
                <form:radiobutton id="idEstadoTodo" path="condiciones[2].data" value=" " label="TODOS" />                            
                <c:forEach var="estado" items="${lstEstadoOp}" varStatus="status" >
                    <form:radiobutton  path="condiciones[2].data" value="${estado.idSubTipo}" label="${estado.nomSubtipo}"  />        
                </c:forEach>   
                <input type="submit" id="btnBuscar" class="btn btn-info fa-input" value="<spring:message code="btn.buscar"/>">       
                <input type="button" onclick="fnLimpiarBusqueda();" name="buscar" class="btn btn-info fa-input" value="<spring:message code="btn.limpiar"/>"  >
                <sec:authorize access="hasRole('MOD_OPE_APERTURA_OPERACION')">
                    <a href="./activar-curso.html" id="btnRegistrar"   class="btn btn-info fa-input pull-right" > <spring:message code="btn.aperturar.curso"/></a> 
                </sec:authorize>
            </div>
        </form:form>
        <fieldset>
            <input id="total" type="hidden" value="${grilla.total}"/> 

            <div id="div-error" class="message-box info">
                <strong><spring:message code="msg.busqueda.sin_resultados"/></strong>
            </div>               
            <div>  
                <table id="listado" class="table table-bordered table-hover" > 
                    <thead> 
                        <tr > 
                            <th>N°</th> 
                            <th>Nomenclatura</th>                             
                            <th>Nombre del curso</th>  
                            <th>Fecha de inicio</th>
                            <th>Fecha fin</th>
                            <th>Estado</th>
                            <th>Eliminar</th>
                            <th>Detalle</th>
                        </tr>  
                    </thead>
                    <tbody>
                        <c:forEach var="activos" items="${grilla.rows}" varStatus="status">
                            <c:if test="${activos.idEstado eq 40}">
                                <tr id="${status.index}" style="background-color:#A5CDDE ">
                                    <td>${status.index+1}</td>
                                    <td>${activos.codigoOpe}</td>
                                    <td>${activos.nombreCurso}</td> 
                                    <td>${activos.fechaInicio}</td> 
                                    <td>${activos.fechaFin}</td> 
                                    <td>${activos.descripcionEstado}</td> 
                                    <td style="text-align: center;">
                                        <sec:authorize access="hasRole('MOD_OPE_ELIMINAR_CURSO_APERTURADO')">
                                            <a class="btn btn-link" onclick="eliminarRow(this,${activos.idOperacion});"  >
                                                <i class="icon-trash"></i>
                                            </a>
                                        </sec:authorize>
                                    </td>                                                                            
                                    <td style="text-align: center;">
                                        <sec:authorize access="hasRole('MOD_OPE_DETALLE_CURSO_ACTIVO_APERTURADO')">
                                            <a class="btn btn-link"  href="detalle-curso-apertura.html?idOperacion=${activos.idOperacion}" >
                                                <i class="icon-th-list"></i>
                                            </a>
                                        </sec:authorize>
                                    </td>                                      

                                </tr>
                            </c:if>
                            <c:if test="${activos.idEstado eq 39}">
                                <tr id="${status.index}" style="background-color:#E3D2E9">
                                    <td>${status.index+1}</td>
                                    <td>${activos.codigoOpe}</td>
                                    <td>${activos.nombreCurso}</td> 
                                    <td>${activos.fechaInicio}</td> 
                                    <td>${activos.fechaFin}</td> 
                                    <td>${activos.descripcionEstado}</td> 
                                    <td style="text-align: center;">
                                        <sec:authorize access="hasRole('MOD_OPE_ELIMINAR_CURSO_APERTURADO')">
                                            <a class="btn btn-link" onclick="eliminarRow(this,${activos.idOperacion});"  >
                                                <i class="icon-trash"></i>
                                            </a>
                                        </sec:authorize>
                                    </td>                                                                            
                                    <td style="text-align: center;">
                                        <sec:authorize access="hasRole('MOD_OPE_DETALLE_CURSO_ACTIVO_APERTURADO')">
                                            <a class="btn btn-link"  href="detalle-curso-apertura.html?idOperacion=${activos.idOperacion}" >
                                                <i class="icon-th-list"></i>
                                            </a>
                                        </sec:authorize>
                                    </td>     
                                </tr>
                            </c:if>
                            <c:if test="${activos.idEstado eq 41}">
                                <tr id="${status.index}" style="background-color:#D3ECDF">                                                                    
                                    <td>${status.index+1}</td>
                                    <td>${activos.codigoOpe}</td>
                                    <td>${activos.nombreCurso}</td> 
                                    <td>${activos.fechaInicio}</td> 
                                    <td>${activos.fechaFin}</td> 
                                    <td>${activos.descripcionEstado}</td> 
                                    <td style="text-align: center;">
                                        <sec:authorize access="hasRole('MOD_OPE_ELIMINAR_CURSO_APERTURADO')">
                                            <a class="btn btn-link" onclick="eliminarRow(this,${activos.idOperacion});"  >
                                                <i class="icon-trash"></i>
                                            </a>
                                        </sec:authorize>
                                    </td>                                                                            
                                    <td style="text-align: center;">
                                        <sec:authorize access="hasRole('MOD_OPE_DETALLE_CURSO_ACTIVO_APERTURADO')">
                                            <a class="btn btn-link"  href="detalle-curso-apertura.html?idOperacion=${activos.idOperacion}" >
                                                <i class="icon-th-list"></i>
                                            </a>
                                        </sec:authorize>
                                    </td>     
                                </tr>
                            </c:if>
                        </c:forEach>
                    </tbody>     
                </table>
                <div class="pagination pagination-centered">        
                    <ul id="pagination"> </ul>
                </div>
            </div>
        </fieldset>
    </div> 
</div> 
</sec:authorize>