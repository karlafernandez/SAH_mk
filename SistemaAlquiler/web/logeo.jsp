<%-- 
    Document   : logeo
    Created on : 2/07/2014, 11:01:24 PM
    Author     : jorge
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<f:view>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
            <title>JSP Page</title>
        </head>
        <body>
            <h:form>
                <h:outputLabel for="txtLogin" value="Usuario"/>
                <h:inputText id="txtLogin" value="#{loginBean.usuario}"/>
                <h:outputLabel for="txtPassword" value="Clave"/>
                <h:inputSecret id="txtPassword" value="#{loginBean.clave}"/>
                <h:commandButton id="btnLogueo" actionListener="#{loginBean.loguearse}" value="Enviar" >
                    
                </h:commandButton>
            </h:form>
        </body>
    </html>
</f:view>
