

<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>


<sec:authorize access="hasRole('MOD_SEG_LOG_EVENTO_DETALLE')">
    <div id="ModificarCursoEspecifico" class="container-fluid fondoGris">
        <div class="row-fluid">
            <a href="listar-log.html" class="btn btn-info fa-input">Volver a Listado</a>       
        </div>
        <div class="row-fluid">        
            <h3>Ver Detalle Log</h3>
        </div>
        <div class="row-fluid formulario form-horizontal">

            <fieldset>
                <legend>Datos Log</legend> 
                <div class="row-fluid">
                    <div class="span12">
                        <div class="control-group">
                            <label class="control-label" for="idLog"><spring:message code="lbl.log.idLog"/></label>
                            <div class="controls">
                                <input  class="input-xxlarge" disabled value="${log.idLog}"/>
                            </div>
                        </div>
                        <div class="control-group">
                            <label class="control-label" for="usuario"><spring:message code="lbl.log.usuario"/></label>
                            <div class="controls">
                                <input  class="input-xlarge" disabled value="${log.usuario}"/>
                            </div>
                        </div>
                        <div class="control-group">
                            <label class="control-label" for="accion"><spring:message code="lbl.log.accion"/></label>
                            <div class="controls">
                                <input  class="input-xlarge" disabled  value="${log.accion}"/>
                            </div>
                        </div>
                        <div class="control-group">
                            <label class="control-label" for="entidad"><spring:message code="lbl.log.entidad"/></label>
                            <div class="controls">
                                <input  class="input-xxlarge" disabled value="${log.entidad}"/>
                            </div>
                        </div>
                        <div class="control-group">
                            <label class="control-label" for="ubicacion">Ubicacion</label>
                            <div class="controls">
                                <input  class="input-xxlarge" disabled value="${log.ubicacion}"/>
                            </div>
                        </div>
                        <div class="control-group">
                            <label class="control-label" for="idLog"><spring:message code="lbl.log.fecha"/></label>
                            <div class="controls">
                                <input  class="input-xxlarge" disabled value="${log.fecha}"/>
                            </div>
                        </div>

                    </div>
                </div>
                <div>
                    <table id="listado" class="table table-bordered table-hover table-striped">
                        <caption class="caption"> Listado </caption>
                        <thead>
                            <tr>

                                <th >Nombre de Propiedad</th>
                                <th>Tipo</th>                    
                                <th >Estado Inicial</th>                    
                                <th >Estado Final</th>                    

                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="detalle" items="${log.detalles}" varStatus="status">
                                <tr id="${status.index}">
                                    <td>${detalle.nombrePropiedad}</td>
                                    <td>${detalle.tipo}</td>
                                    <td class="span4">${detalle.estadoFinal}</td>
                                    <td class="span4">${detalle.estadoInicial}</td>  
                                </tr>   
                            </c:forEach>
                        </tbody>                            
                    </table>
                </div>
            </fieldset>

        </div>
    </div>
</sec:authorize>