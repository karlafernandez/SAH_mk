<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<div id="divMensajes">
<c:if test="${ not empty mensaje}">
    <c:if test="${mensaje.messageType eq 'SUCCESS'}">
        <c:set var="msgStyle" value="alert alert-success"/>
    </c:if>
    <c:if test="${mensaje.messageType eq 'WARNING'}">
        <c:set var="msgStyle" value="alert alert"/>
    </c:if>
    <c:if test="${mensaje.messageType eq 'ERROR'}">
        <c:set var="msgStyle" value="alert alert-error"/>
    </c:if>
    <div class="${msgStyle}">
        <c:if test="${not empty  mensaje.messages}">
            <button type="button" class="close" data-dismiss="alert">&times;</button>
        </c:if> 
        <c:forEach items="${mensaje.messages}" var="message">
            <strong>  <c:out value="${message}"/></strong>
        </c:forEach>
    </div>
</c:if>


    <c:if test="${ not empty valMensaje}">

        <div class="alert alert">
            <c:if test="${not empty  valMensaje}">
                <button type="button" class="close" data-dismiss="alert">&times;</button>
            </c:if>  
            <strong>  <c:out value="${valMensaje}"/></strong>

        </div>
    </c:if>
</div>