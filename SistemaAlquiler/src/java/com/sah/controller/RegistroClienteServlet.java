/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sah.controller;

import com.sah.business.bo.ClienteBO;
import com.sah.business.dto.ClienteDTO;
import com.sah.business.bo.HabitacionBO;
import com.sah.business.dto.ClienteDTO;
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
 * @author Karla
 */
@WebServlet(description="Simple servlet", urlPatterns={"/registroCliente"})
public class RegistroClienteServlet extends HttpServlet {
    Logger logger=Logger.getLogger(RegistroClienteServlet.class.getName());
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
         try {
            String nombre = (String) req.getParameter("nombre");
            String apellido = (String) req.getParameter("apellido");
            String ocupacion = (String) req.getParameter("ocupacion");
            String correo = (String) req.getParameter("correo");
            String telefono = (String) req.getParameter("telefono");
            String dni = (String) req.getParameter("dni");
            ClienteBO clienteBO = new ClienteBO();
            ClienteDTO clienteDTO = new ClienteDTO();
            clienteDTO.setNombre(nombre);
            clienteDTO.setApellido(apellido);
            clienteDTO.setOcupacion(ocupacion);
            clienteDTO.setCorreo(correo);
            clienteDTO.setTelefono(telefono);
            clienteDTO.setDni(dni);
            clienteBO.insertCliente(clienteDTO);
            clienteDTO.setCorreo(correo);
            clienteBO.insertHabitacion(clienteDTO);
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
            String nombre = (String) req.getParameter("nombre");
            String apellido = (String) req.getParameter("apellido");
            String ocupacion = (String) req.getParameter("ocupacion");
            String correo = (String) req.getParameter("correo");
            String telefono = (String) req.getParameter("telefono");
            String dni = (String) req.getParameter("dni");

            ClienteBO clienteBO = new ClienteBO();
            ClienteDTO clienteDTO = new ClienteDTO();
            clienteDTO.setNombre(nombre);
            clienteDTO.setApellido(apellido);
            clienteDTO.setOcupacion(ocupacion);
            clienteDTO.setCorreo(correo);
            clienteDTO.setTelefono(telefono);
            clienteDTO.setDni(dni);
            clienteDTO.setCorreo(correo);

            clienteBO.insertHabitacion(clienteDTO);
            req.setAttribute("msg", "registro exitoso");
            RequestDispatcher dispatcher=getServletContext().getRequestDispatcher("listahabitaciones.jsp");
            dispatcher.forward(req, resp);

        } catch (Exception e) {
            req.setAttribute("msg", "error en resgistro");
            resp.sendRedirect("listahabitaciones.jsp");
        }
    }
}
