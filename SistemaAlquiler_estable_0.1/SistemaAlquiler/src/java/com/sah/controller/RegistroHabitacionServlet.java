/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sah.controller;

import com.sah.business.bo.HabitacionBO;
import com.sah.business.dto.HabitacionDTO;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class RegistroHabitacionServlet extends HttpServlet {
    Logger logger=Logger.getLogger(RegistroHabitacionServlet.class.getName());
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
         try {
            String ubicacion = (String) req.getParameter("detalleUbicacion");
            String detalle = (String) req.getParameter("detalle");
            String direccion = (String) req.getParameter("direccion");
            String restriccion = (String) req.getParameter("restricciones");
            String telefonoContacto = (String) req.getParameter("telefonoContacto");
            
            HabitacionBO habitacionBO = new HabitacionBO();
            HabitacionDTO habitacionDTO = new HabitacionDTO();
            habitacionDTO.setCaracteristicas(detalle);
//            habitacionDTO.setIdUbicacion(1);
            habitacionDTO.setDetalleUbicacion(ubicacion);
            habitacionDTO.setIdArrendatario(1);
            habitacionDTO.setDireccion(direccion);
            habitacionDTO.setRestricciones(restriccion);
            habitacionDTO.setTelefonoContacto(telefonoContacto);

            habitacionBO.insertHabitacion(habitacionDTO);
            req.setAttribute("msg", "registro exitoso");
            RequestDispatcher dispatcher=getServletContext().getRequestDispatcher("listahabitaciones.jsp");
            dispatcher.forward(req, resp);

        } catch (Exception e) {
            logger.log(Level.SEVERE, null, e);
            req.setAttribute("msg", "error en resgistro");
            resp.sendRedirect("listahabitaciones.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String ubicacion = (String) req.getParameter("detalleUbicacion");
            String detalle = (String) req.getParameter("detalle");
            String direccion = (String) req.getParameter("direccion");
            String restriccion = (String) req.getParameter("restricciones");
            String telefonoContacto = (String) req.getParameter("telefonoContacto");
            
            HabitacionBO habitacionBO = new HabitacionBO();
            HabitacionDTO habitacionDTO = new HabitacionDTO();
            habitacionDTO.setCaracteristicas(detalle);
//            habitacionDTO.setIdUbicacion(1);
            habitacionDTO.setDetalleUbicacion(ubicacion);
            habitacionDTO.setIdArrendatario(1);
            habitacionDTO.setDireccion(direccion);
            habitacionDTO.setRestricciones(restriccion);
            habitacionDTO.setTelefonoContacto(telefonoContacto);

            habitacionBO.insertHabitacion(habitacionDTO);
            req.setAttribute("msg", "registro exitoso");
            resp.sendRedirect("listahabitaciones.jsp");

        } catch (Exception e) {
            req.setAttribute("msg", "error en resgistro");
            resp.sendRedirect("listahabitaciones.jsp");
        }

    }
    
    
}
