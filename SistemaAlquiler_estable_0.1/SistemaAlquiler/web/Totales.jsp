<%-- 
    Document   : Totales
    Created on : 25-jun-2014, 21:13:20
    Author     : Meli
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@page import="org.codehaus.jettison.json.JSONObject"%>
<%
    JSONObject json = new JSONObject();
    json.put("title", "TITLE_TEST");
    json.put("link", "LINK_TEST");
    System.out.print(json);
    System.out.flush();
%>
