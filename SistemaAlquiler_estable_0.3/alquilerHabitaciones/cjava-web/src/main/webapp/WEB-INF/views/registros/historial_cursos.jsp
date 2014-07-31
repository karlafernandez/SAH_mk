
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<sec:authorize access="hasRole('MOD_ADM_HISTORIAL_ALUMNOS')">
    <link el="stylesheet" type="text/css" href="<c:url value="/css/paging.css"/>"/>
    <script src="<c:url value='/js/jquery.paging.js'/>" type="text/javascript"></script>
    <script src="<c:url value='/js/administracion/curso/curso.especifico.lista.registro.js'/>" type="text/javascript"></script>
    <script src="<c:url value='/js/validaciones.js'/>" type="text/javascript"></script>

    <div class="fondoGris container-fluid">
        <div class="row-fluid">     
            <a href="listarAlumnos.html" class="btn btn-info fa-input">Volver a Listado</a>               
        </div>    
        <div class="row-fluid div-titulo">
            <h3>Historial de cursos</h3>
        </div>
        <div class="row-fluid">                         
            <c:url var="url" value="/historial-cursos.html" />
            <fieldset>
                <legend> Datos del Alumno </legend>
                <div class="row-fluid" >
                    <span class="span12"><strong><spring:message code="lbl.opealu.alumNombre"/></strong>&nbsp;${historial.nomAlumno}</span>                    
                </div>
                <div class="row-fluid">
                    <div id="id-table-finalizado">
                        <table id="table-finalizado" class="table table-bordered table-hover table-striped">
                            <caption class="caption"> <spring:message code="lbl.opealu.curso_llevado" /> </caption>
                            <thead>
                                <tr>
                                    <th>N°</th> 
                                    <th>Nombre del Curso</th>                    
                                    <th class="hidden-phone">Código</th>                    
                                    <th>Fecha Inicio</th>
                                    <th>Fecha Fin </th>                                    
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="inc" items="${historial.listCursoLlevado}" varStatus="status">
                                    <tr id="fina${status.index}">
                                        <td> ${statux.index + 1} </td>
                                        <td> ${inc.nomCurso}</td>
                                        <td> ${inc.codOperacion}</td>
                                        <td> ${inc.fecInicio}</td>
                                        <td> ${inc.fecFin}</td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>                

                <br><br>

                <div class="row-fluid">
                    <div id="id-table-llevando">
                        <table id="table-llevando" class="table table-bordered table-hover table-striped">
                            <caption class="caption"> <spring:message code="lbl.opealu.curso_cursando" /> </caption>
                            <thead>
                                <tr>
                                    <th>N°</th> 
                                    <th>Nombre del Curso</th>                    
                                    <th class="hidden-phone">Código</th>                    
                                    <th>Fecha Inicio</th>
                                    <th>Fecha Fin </th>                                    
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="inc" items="${historial.listCursoCursando}" varStatus="status">
                                    <tr id="fina${status.index}">
                                        <td> ${statux.index + 1} </td>
                                        <td> ${inc.nomCurso}</td>
                                        <td> ${inc.codOperacion}</td>
                                        <td> ${inc.fecInicio}</td>
                                        <td> ${inc.fecFin}</td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>      

            </fieldset>            
        </div>        
    </div>                                             
</sec:authorize>
