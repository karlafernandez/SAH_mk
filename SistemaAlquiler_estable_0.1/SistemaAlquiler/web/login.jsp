<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
	"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ejemplo de una aplicación de struts_2 </title>
</head>
<body>
	<center>
		<h2>Ingrese Datos</h2>
		<s:form action="login.jsp" method="get">
			<s:textfield name="usuario" size="8" label="DNI" />
			<s:textfield name="pass" size="10" label="Contraseña" type="password" />
			<s:submit value="login.jsp" />
		</s:form>
	</center>
</body>
</html>