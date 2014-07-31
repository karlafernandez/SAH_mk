<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<link rel="stylesheet"  media="screen, projection" type="text/css" href="<c:url value="/css/blueprint/screen.css"/>" />
<link rel="stylesheet"  media="print" type="text/css" href="<c:url value="/css/blueprint/print.css"/>" />
<link rel="stylesheet" type="text/css" href="<c:url value="/css/smoothness/jquery-ui-1.8.24.custom.css"/>" />
<link rel="stylesheet" type="text/css" href="<c:url value="/css/global.css"/>" />

<script src="<c:url value='/js/jquery.js'/>" type="text/javascript"></script>
<script src="<c:url value='/js/jquery-ui.js'/>" type="text/javascript"></script>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title></title>
    </head>
    <body>
        <div class="container">
            <fieldset class="mediah">
             

                <div><tiles:insertAttribute name="indexHeader" /></div>
                <div><tiles:insertAttribute name="indexContent" /></div>

            </fieldset>
            <div><tiles:insertAttribute name="indexFooter" /></div>
        </div>
    </body>
</html>