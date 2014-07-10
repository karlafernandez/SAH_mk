<%-- 
    Document   : Mostrar
    Created on : 10/06/2014, 11:23:33 PM
    Author     : jorge
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h2>Usuarios</h2>
        <c:forEach items="${datos}" var="dato">
            ${dato.nombre} ${dato.apellido}<br/>
        </c:forEach>
    </body>
</html>
