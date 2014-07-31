<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 
    Document   : mensaje
    Created on : 8/03/2013, 05:45:24 PM
    Author     : Alejandra Gonzales
--%>

<c:if test="${ not empty mensaje}">
    <c:if test="${mensaje.messageType eq 'SUCCESS'}">
        <c:set var="msgStyle" value="success"/>
    </c:if>
    <c:if test="${mensaje.messageType eq 'WARNING'}">
        <c:set var="msgStyle" value="notice"/>
    </c:if>
    <c:if test="${mensaje.messageType eq 'ERROR'}">
        <c:set var="msgStyle" value="error"/>
    </c:if>
    <div class="${msgStyle} clearfix">
        <c:forEach items="${mensaje.messages}" var="message">
            <c:out value="${message}"/>
        </c:forEach>
    </div>
</c:if>