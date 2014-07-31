<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>


<%--<sec:authorize access="hasRole('ADMIN')">--%>
<div class="container-fluid" style="background-color: #6694C8">
    <div class="row-fluid">
        <div>
            <fieldset class="min-height">
                <p>
                <h2 style="text-align: center"><spring:message code="msg.inicio"/></h2>                    
                </p>
            </fieldset>
        </div>
    </div><!--/span-->
</div><!--/.fluid-container-->
<%--</sec:authorize>--%>
