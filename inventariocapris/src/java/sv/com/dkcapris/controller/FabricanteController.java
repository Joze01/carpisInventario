/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.dkcapris.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sv.com.dkcarpis.model.FabricanteModel;
import sv.com.dkcapris.beans.FabricanteBean;
/**
 *
 * @author Jose-PC
 */
@WebServlet(name = "fabricanteController", urlPatterns = {"/fabricanteController"})
public class FabricanteController extends HttpServlet {

    FabricanteModel modeloFabricante = new FabricanteModel();
    
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
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
           
            String metodo = request.getParameter("metodo");
            
            if(metodo.equals("insertar")){
            FabricanteBean fabean = new FabricanteBean();
            fabean.setFabricante_nombre(request.getParameter("nombre"));
            fabean.setFabricante_descripcion(request.getParameter("nombre"));
            if(modeloFabricante.nuevoFabricante(fabean)){
             response.sendRedirect("view/fabricante/lista.jsp?exito=1&mensaje=Fabricante Registrado Correctamente");
            }else{
                 response.sendRedirect("view/fabricante/lista.jsp?exito=2&mensaje=Error al registar ");
                }
            
            
            }
            if(metodo.equals("modificar")){
                FabricanteBean fabean = new FabricanteBean();
                fabean.setFabricante_id(Integer.parseInt(request.getParameter("id")));                   
                fabean.setFabricante_nombre(request.getParameter("nombre"));
                fabean.setFabricante_descripcion(request.getParameter("nombre"));
               
                if(modeloFabricante.modificarFabricante(fabean)){
                 response.sendRedirect("view/fabricante/lista.jsp?exito=1&mensaje=Fabricante Modificado Correctamente");
                }else{
                 response.sendRedirect("view/fabricante/lista.jsp?exito=2&mensaje=Error Al modificar ");
                }
            }
            if(metodo.equals("eliminar")){
                        FabricanteBean fabean = new FabricanteBean();
             fabean.setFabricante_id(Integer.parseInt(request.getParameter("id")));                   
            fabean.setFabricante_nombre(request.getParameter("nombre"));
            fabean.setFabricante_descripcion(request.getParameter("nombre"));
                if(modeloFabricante.eliminarFabricante(fabean)){
                 response.sendRedirect("view/fabricante/lista.jsp?exito=1&mensaje=Fabricante Eliminado Correctamente");
                }else{
                 response.sendRedirect("view/fabricante/lista.jsp?exito=2&mensaje=Error Al eliminar ");
                }
            
            }
            
           
            
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(FabricanteController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(FabricanteController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
