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
import sv.com.dkcapris.beans.EntradaBean;
import sv.com.dkcapris.beans.SalidaBean;
import sv.com.dkcarpis.model.SalidaModel;

/**
 *
 * @author Jose-PC
 */
@WebServlet(name = "salidaController", urlPatterns = {"/salidaController"})
public class SalidaController extends HttpServlet {

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
            SalidaModel extModel = new SalidaModel();
            String metodo = request.getParameter("metodo");
            
            if(metodo.equals("insertar")){
            SalidaBean extB = new SalidaBean();
            extB.setId_producto(Integer.parseInt(request.getParameter("productoId")));
            extB.setSalidad_cantidad(Integer.parseInt(request.getParameter("cantidad")));
            extB.setId_usuario(Integer.parseInt(request.getParameter("usuarioId")));
            //System.out.println("HOSPITAL: "+request.getParameter("hospitalId"));
            extB.setSalida_fecha(request.getParameter("fecha"));
            extB.setId_hospital(Integer.parseInt(request.getParameter("hospitalId")));
            
            if(extModel.nuevaSalida(extB)){
             response.sendRedirect("view/producto/lista.jsp?exito=1&mensaje=Salida registrada Correctamente.");
            }else{
             response.sendRedirect("view/producto/lista.jsp?exito=2&mensaje=Error al registar salida.");
                }
            }
           if(metodo.equals("insertar2")){
            SalidaBean extB = new SalidaBean();
            extB.setId_producto(Integer.parseInt(request.getParameter("productoId")));
            extB.setSalidad_cantidad(Integer.parseInt(request.getParameter("cantidad")));
            extB.setId_usuario(Integer.parseInt(request.getParameter("usuarioId")));
            //System.out.println("HOSPITAL: "+request.getParameter("hospitalId"));
            extB.setSalida_fecha(request.getParameter("fecha"));
            extB.setId_hospital(Integer.parseInt(request.getParameter("hospitalId")));
            
            if(extModel.nuevaSalida(extB)){
             response.sendRedirect("view/productoIng/lista.jsp?exito=1&mensaje=Salida registrada Correctamente.");
            }else{
             response.sendRedirect("view/productoIng/lista.jsp?exito=2&mensaje=Error al registar salida.");
                }
            }

            
             if(metodo.equals("eliminar")){
                SalidaBean extB = new SalidaBean();
                extB.setId(Integer.parseInt(request.getParameter("id")));

                if(extModel.EliminarSalida(extB)){
                 response.sendRedirect("view/producto/salida/lista.jsp?exito=1&mensaje=Salida eliminada Correctamente.");
                }else{
                     response.sendRedirect("view/producto/salida/lista.jsp?exito=2&mensaje=Error al eliminar salida.");
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
            Logger.getLogger(SalidaController.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(SalidaController.class.getName()).log(Level.SEVERE, null, ex);
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
