<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<div class="container">
  <div style="padding-left: 40px">
        <p>Su sesi�n en el sistema se ha cerrado autom�ticamente por seguridad </p>
        <p>Si deseas volver a ingresar al sistema haz clic en iniciar sesi�n </p>
         <a href="<c:url value='/'/>">[Iniciar Sesi�n]</a> 
    </div> 
</div>