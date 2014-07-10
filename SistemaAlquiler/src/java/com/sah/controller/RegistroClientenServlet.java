/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sah.controller;

import com.sah.business.bo.HabitacionBO;
import com.sah.business.dto.HabitacionDTO;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Meli
 */
@WebServlet(description="Simple servlet", urlPatterns={"/registroHabitacion"})
public class RegistroClientenServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
         try {
            String ubiacion = (String) req.getParameter("ubicacion");
            String detalle = (String) req.getParameter("detalle");
            String direccion = (String) req.getParameter("direccion");
            HabitacionBO habitacionBO = new HabitacionBO();
            HabitacionDTO habitacionDTO = new HabitacionDTO();
            habitacionDTO.setCaracteristicas(detalle);
            habitacionDTO.setIdUbicacion(1);
            habitacionDTO.setIdArrendatario(1);

            habitacionBO.insertHabitacion(habitacionDTO);
            req.setAttribute("msg", "registro exitoso");
            RequestDispatcher dispatcher=getServletContext().getRequestDispatcher("listahabitaciones.jsp");
            dispatcher.forward(req, resp);

        } catch (Exception e) {
            req.setAttribute("msg", "error en resgistro");
            RequestDispatcher dispatcher=getServletContext().getRequestDispatcher("listahabitaciones.jsp");
            dispatcher.forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String ubiacion = (String) req.getAttribute("ubicacion");
            String detalle = (String) req.getAttribute("detalle");
            String direccion = (String) req.getAttribute("direccion");
            HabitacionBO habitacionBO = new HabitacionBO();
            HabitacionDTO habitacionDTO = new HabitacionDTO();
            habitacionDTO.setCaracteristicas(detalle);
            habitacionDTO.setIdUbicacion(1);
            habitacionDTO.setIdArrendatario(1);

            habitacionBO.insertHabitacion(habitacionDTO);
            req.setAttribute("msg", "registro exitoso");
            resp.sendRedirect("listahabitaciones.jsp");

        } catch (Exception e) {
            req.setAttribute("msg", "error en resgistro");
            resp.sendRedirect("listahabitaciones.jsp");
        }

    }
    
    
}
