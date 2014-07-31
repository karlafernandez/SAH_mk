

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<style type="text/css">
      body {
        padding-top: 60px;
        padding-bottom: 40px;
      }
      .sidebar-nav {
        padding: 9px 0;
      }
 
      @media (max-width: 980px) {
        /* Enable use of floated navbar text */
        .navbar-text.pull-right {
          float: none;
          padding-left: 5px;
          padding-right: 5px;
        }
      }
    </style>
<div class="container-fluid">
    <div class="row-fluid">
        <a href="registrar-usuario.html">Registrar</a>
    </div> 
        
    
    <div class="row-fluid"> 
        <div class="span12"> 
                <table id ="listado" class="table table-hover">
                    <thead> 
                        <tr > 
                            <th>N°</th> 
                            <th>Nombre</th> 
                            <th>Apellido Paterno</th>
                            <th>Apellido Materno</th>     
                        </tr>  
                    </thead>
                    <tbody>
                    <c:forEach var="paciente" items="${lstPacientes}"  varStatus="status">
                        <tr id="${status.index}" >
                            <td>${paciente.idPaciente}</td> 
                            <td>${paciente.nombre}</td> 
                            <td>${paciente.apePaterno}</td>  
                            <td>${paciente.apeMaterno}</td>   
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div><!--/row-->

        </div><!--/span-->
    



</div><!--/.fluid-container-->