/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sah.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Meli
 */
@WebServlet(description="Simple servlet", urlPatterns={"/SimpleServlet"})
public class Login extends HttpServlet{
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html"); 
        PrintWriter out =resp.getWriter();
        String userName=req.getParameter("user");
        String pass=req.getParameter("pass");
        out.println("Usuario logueado: "+userName);
        
        // PrintWriter out=resp.getWriter();
         // out.println("<html><h1>Hola Meli Melosa</h1></html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html"); 
        PrintWriter out =resp.getWriter();
        String userName=req.getParameter("userName");
        String fullName=req.getParameter("fullName");
        out.println("heeelloo"+userName + "full name" + fullName);
        String prof= req.getParameter("prof");
        out.println("your are a "+ prof);
        
        // super.doPost(req, resp);
    }
    
  //   request.getRequestDispatcher("/file.jsp").forward(request, response);
  //req.getRequestDispatcher("./file.jsp").forward(req, resp);
    
    
}
