

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<sec:authorize access="hasRole('MOD_OPE_LISTAR_ARCHIVO')">
    <div class="fondoGris container-fluid"> 
        <div class="row-fluid  div-titulo">
            <h3>Listado de Archivos</h3>
        </div>
        <sec:authorize access="hasRole('MOD_OPE_CREAR_ARCHIVO')">
            <div class="row-fluid formulario">

                <form:form id="frmRegAveria" modelAttribute="archivo" method="post" action="${url}" cssClass="form-horizontal" enctype="multipart/form-data">     
                    <fieldset> 
                        <legend><h4>Ingresar Archivo </h4></legend>   
                        <div class="row-fluid">
                            <div class="control-group">
                                <label   class="control-label" for="rutaArchivo" >Nombre</label> 
                                <div class="controls"> 
                                    <form:input class="span-10" path="rutaArchivo"  cssClass="input-xlarge"  id="rutaArchivo"/>  
                                    <form:errors  cssClass="help-block" path="rutaArchivo"/>
                                </div>

                            </div>
                            <div class="control-group">
                                <label   class="control-label" for="archivo" >Adjuntar Archivo</label> 
                                <div class="controls"> 
                                    <form:input class="span-10" path="archivo"  cssClass="input-xlarge" type="file" id="archivo"/>  
                                    <form:errors  cssClass="help-block" path="archivo"/>
                                </div>

                            </div>
                            <div class="row-fluid">
                                <div class="form-actions">
                                    <input type="submit" id="btnBuscar" class="btn btn-info fa-input" name="cerrar" value="Guardar Archivo">  
                                </div>
                            </div>     
                        </div> 

                    </fieldset> 

                </form:form>
            </div>
        </sec:authorize>
        <div  class="row-fluid formulario">    
            <h4>Listado de Archivos </h4>
            <table id="listado" class="table table-bordered table-hover table-striped" >

                <thead>
                    <tr > 

                        <th>Nro</th>                             
                        <th>Archivo</th>     
                        <th>Extension</th>
                        <th>Fec. Creacion</th>
                        <th>Ver</th>
                            <sec:authorize access="hasRole('MOD_OPE_ELIMINAR_ARCHIVO')"> 
                            <th>Eliminar</th>
                            </sec:authorize>
                    </tr>  
                </thead>
                <tbody>
                    <c:forEach var="archivo" items="${archivos}" varStatus="status">
                        <tr id="${status.index}" >  
                            <td>${status.index+1}</td>
                            <td>${archivo.nomArchivo}</td> 
                            <td>${archivo.extension}</td> 
                            <td>${archivo.fecCreacion}</td> 
                            <td><a href="descargar_archivo.html?idArchivo=${archivo.idArchivo}">${archivo.rutaArchivo}</a>  </td>
                            <sec:authorize access="hasRole('MOD_OPE_ELIMINAR_ARCHIVO')"> 
                                <td><a href="eliminar_archivo.html?idArchivo=${archivo.idArchivo}" onclick="return confirm('¿Desea Eliminar Archivo ${archivo.rutaArchivo}?')" ><i class="icon-trash"></i> ${archivo.rutaArchivo}</a>  </td> 
                            </sec:authorize>
                        </tr>
                    </c:forEach>
                </tbody>                            
            </table>
            <div class="pagination pagination-centered">        
                <ul id="pagination"> </ul>
            </div>
        </div>


    </div>
</sec:authorize>