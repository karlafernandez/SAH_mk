<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="container-fluid banner">
    <div class="row-fluid">
        <div class="span2" ><img src="<c:url value='/images/logo_SistemaAlquiler.png'/>"></div> 
        <div class="span6" style="text-align: center">
            <h2 style="color: #333333">SISTEMA DE ALQUILER DE HABITACIONES</h2>
        </div> 
        <div class="span4 div-header">
            <span> Bienvenido(a)</span> <a href="#" class="navbar-link">${userDetails.nomUsuario}</a>&nbsp;&nbsp; 
            <a class="redlnk" href="<c:url value="/logout"/>"><i class="icon-off"></i><span class="logoutlnk">&nbsp;Cerrar Sesión </span></a> 
        </div>
    </div> 
</div>
