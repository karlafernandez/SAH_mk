/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Registro_usuarios;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author jorge
 */
@WebServlet(name = "Mostrar", urlPatterns = {"/Mostrar"})
public class Mostrar extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        EntityManager em = Persistence.createEntityManagerFactory("SistemaAlquilerPU").createEntityManager();
        List datos = em.createNamedQuery("Usuario.findAll").getResultList();
        request.setAttribute("datos", datos);
        RequestDispatcher rd = request.getRequestDispatcher("Mostrar.jsp");
        rd.forward(request, response);  
        
        
        }
    }