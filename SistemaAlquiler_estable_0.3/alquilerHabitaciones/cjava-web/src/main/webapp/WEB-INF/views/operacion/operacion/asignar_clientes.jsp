<%-- 

    Author     : MELImeli
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<sec:authorize access="hasRole('MOD_OPE_LISTAR_ALUMNO_OPERACION')">
    <link el="stylesheet" type="text/css" href="<c:url value="/css/paging.css"/>"/>
    <script src="<c:url value='/js/jquery.paging.js'/>" type="text/javascript"></script>
    <script src="<c:url value='/js/operacion/operacion/asignar_alumnos.js'/>" type="text/javascript"></script> 


    <div class="container-fluid fondoGris">
        <form:form id="frmIni" modelAttribute="idOperacion" action="${url}" cssStyle="margin:auto;">  
            <form:hidden id="idOperacion" path="idOperacion" /> 

            <div class="span4">
                <a href="detalle-curso-apertura.html?idOperacion=${idOperacion.idOperacion}" class="btn btn-info fa-input">Volver Requerimientos de Curso</a>                       
            </div>
        </form:form>
        <div>                                
            <div class="fondoGris">
                <div class="clearfix">
                    <div class="span-10">
                        <h3>ASIGNAR ALUMNOS </h3>                            
                    </div>   

                </div>  

                <div class="clearfix">
                    <fieldset >
                        <legend class="legendSmall" style="margin-left: 20px">INGRESE NOMBRE DEL ALUMNO</legend>

                        <div class="input-append clearfix" style="text-align: center;">                                       


                            <c:if test="${asignarAlumno.permisoFunc1}">

                                <form:form id="frmFiltro" modelAttribute="busquedaDTO" method="post" action="${url}" cssClass="form-search">
                                    <form:hidden id="inicio" path="inicio"/>

                                    <div id="msgBadFormat" class="message-box info" style="color: red" hidden="true">
                                        <strong><h4><spring:message code="msg.operacion.cierre_curso_1"/>${apertura.diasCierre}</h4></strong>
                                    </div>

                                    <input type="hidden" name="idOperacion" value="${operacionDTO.idOperacion}"/>
                                    <form:hidden id="cantidad" path="cantidad"/>   
                                    <input id="total" type="hidden" value="${grilla.total}"/> 

                                    <div class="clearfix div-nombres" style="margin-left: 1%">
                                        <div>
                                            <form:hidden path="condiciones[0].field" value="idOperacion"/>  
                                            <form:hidden path="condiciones[0].data" value="${operacionDTO.idOperacion}"/>  
                                            <form:hidden path="condiciones[1].field" value="nombreAlumno"/>  
                                            <form:hidden path="condiciones[2].field" value="primerApe"/>  
                                            <form:hidden path="condiciones[3].field" value="segundoApe"/>  
                                            <span class="busqueda-label"> Nombre del Alumno</span>
                                        </div>
                                        <div>
                                            <input type="text" class="input-limpiar span5"  id="nomAlumno" placeholder="Nombre Alumno" style="text-transform: uppercase;margin-top:3px;margin-left:1px; margin-right:20px;"/>
                                            <!--                                            &nbsp;
                                                                                        &nbsp;-->                                            
                                            <input type="text" class="input-limpiar span1"  id="cantFotos" placeholder="Fotos" style="text-transform: uppercase;margin-top:3px;margin-left:1px;margin-right:20px"/>

                                            <form:hidden path="condiciones[1].data" cssClass="input-limpiar span5"  id="nombreAlumno"/> 
                                            <form:hidden path="condiciones[2].data" cssClass="input-limpiar span5"  id="primerApe" /> 
                                            <form:hidden path="condiciones[3].data" cssClass="input-limpiar span5"  id="segundoApe"/> 
                                            <sec:authorize access="hasRole('MOD_OPE_REGISTRO_ALUMNO_OPERACION')">
                                                <input type="button" id="btnBuscar"  class="btn btn-info fa-input span2" onclick="agregarLista();"   value="<spring:message code="btn.agregar"/>">                                                                                                                     
                                            </sec:authorize>
                                        </div>
                                    </div>
                                </form:form>         
                            </c:if>

                            <input class="span2" id="idAlumno" type="hidden" />  
                        </div> 
                    </fieldset>  
                </div>

                <br>
                <c:url var="url" value="/asignar-alumno.html" />
                <form:form id="frm" modelAttribute="activarAlumno" action="${url}" cssStyle="margin:auto;">  
                    <form:hidden id="idOperacion" path="idOperacion" /> 

                    <div class="clearfix">
                        <fieldset>

                            <div id="id-table">                        
                                <table id="listado" class="table table-bordered table-hover table-striped" >
                                    <thead>
                                        <tr > 
                                            <th>Nro</th> 
                                            <th>Nombre Completo</th>                             
                                            <th>Nro Documento</th>  
                                            <th>#Fotos</th>
                                            <th>Borrar</th>
                                        </tr>  
                                    </thead>
                                    <tbody>
                                        <c:forEach var="alumno" items="${asignarAlumno.lstAlumnos}" varStatus="status">
                                            <tr id="${status.index}" >
                                                <td>${status.index+1}</td>
                                                <td>${alumno.nombreCompleto}</td>
                                                <td>${alumno.documento}</td> 
                                                <td>
                                                    <sec:authorize access="hasRole('MOD_OPE_ENTREGA_FOTO')">
                                                        <a class="btn btn-link" href="entrega-foto.html?idOpeAlum=${alumno.idOperacionAlumno}"   >
                                                           ${alumno.cantFotos}
                                                        </a>
                                                    </sec:authorize>
                                                </td> 
                                                <td>
                                                    <c:if test="${asignarAlumno.permisoFunc1}">
                                                        <sec:authorize access="hasRole('MOD_OPE_ELIMINAR_ALUMNO_OPERACION')">
                                                            <a class="btn btn-link" onclick="eliminarRow(this,${alumno.idOperacionAlumno},${alumno.idOperacion});"  >
                                                                <i class="icon-trash"></i>
                                                            </a>
                                                        </sec:authorize>
                                                    </c:if>
                                                </td>   
                                            </tr>
                                        </c:forEach>
                                    </tbody>                            
                                </table>
                                <div class="pagination pagination-centered">        
                                    <ul id="pagination"> </ul>
                                </div>
                            </div>


                        </fieldset>      

                    </div>
                </form:form>


            </div><!--/-->

        </div><!--/-->

    </div><!--/.row-container-->
</sec:authorize>