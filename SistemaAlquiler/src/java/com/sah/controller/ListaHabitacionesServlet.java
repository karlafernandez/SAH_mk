/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sah.controller;

import com.sah.controller.*;
import com.sah.business.bo.HabitacionBO;
import com.sah.business.dto.HabitacionDTO;
import com.sah.model.dao.HabitacionDAOHibernate;
import com.sah.model.entities.Cuarto;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
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
@WebServlet(description="Simple servlet", urlPatterns={"/listaHabitaciones"})
public class ListaHabitacionesServlet extends HttpServlet {
    Logger logger=Logger.getLogger(RegistroHabitacionServlet.class.getName());

    HabitacionDAOHibernate habitacion;

    @Override
     protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      habitacion = new HabitacionDAOHibernate();
      habitacion.init();

         List<Cuarto> listaHabita = habitacion.obtenerListaHabitaciones();
         RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/listahabitaciones.jsp");
         req.setAttribute("listaHabita", listaHabita);
       
         dispatcher.forward(req,resp);

    }



    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String ubicacion = (String) req.getParameter("detalleUbicacion");
            String detalle = (String) req.getParameter("detalle");
            String direccion = (String) req.getParameter("direccion");
            String telefonoContacto = (String) req.getParameter("telefonoContacto");

            HabitacionBO habitacionBO = new HabitacionBO();
            HabitacionDTO habitacionDTO = new HabitacionDTO();
            habitacionDTO.setCaracteristicas(detalle);
//            habitacionDTO.setIdUbicacion(1);
            habitacionDTO.setDetalleUbicacion(ubicacion);
            habitacionDTO.setIdArrendatario(1);
            habitacionDTO.setDireccion(direccion);
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
