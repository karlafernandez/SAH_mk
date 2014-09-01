<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html>
<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link  rel="stylesheet" type="text/css"  href="<c:url value="/css/bootstrap.css"/>" media="screen" >

        <script src="<c:url value='/js/jquery.js'/>" type="text/javascript"></script>
        <script src="<c:url value='/js/bootstrap.js'/>" type="text/javascript"></script>

    </head>
    <body id="body" >
        <div class="container"> 
            <div><tiles:insertAttribute name="mainHeader" /></div> 
            <div><tiles:insertAttribute name="mainMenu" /></div>
            <div><tiles:insertAttribute name="mainMensaje" /></div> 
            <div><tiles:insertAttribute name="mainContent" /></div> 
            <div><tiles:insertAttribute name="mainFooter" /></div>

        </div>
        <div class="container">
            <sec:authorize access="isAnonymous()"> 
                <div><tiles:insertAttribute name="mainAccesoRestringido" /></div>  
            </sec:authorize>
        </div> 

    </body>

</html>