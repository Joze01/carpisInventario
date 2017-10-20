/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.dkcapris.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sv.com.dkcapris.beans.EntradaBean;
import sv.com.dkcapris.beans.FabricanteBean;
import sv.com.dkcarpis.model.Conexion;
import sv.com.dkcarpis.model.EntradaModel;
/**
 *
 * @author Jose-PC
 */
@WebServlet(name = "entradaController", urlPatterns = {"/entradaController"})
public class EntradaController extends HttpServlet {

        EntradaModel entrModel = new EntradaModel();
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
            throws ServletException, IOException, SQLException, ParseException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            
            String metodo = request.getParameter("metodo");
            
            if(metodo.equals("insertar")){
            EntradaBean entBean = new EntradaBean();
            entBean.setId_producto(Integer.parseInt(request.getParameter("productoId")));
            entBean.setId_usuario(Integer.parseInt(request.getParameter("usuarioId")));
            entBean.setEntrada_cantidad(Integer.parseInt(request.getParameter("cantidad")));
            entBean.setEntrada_precio(Float.parseFloat(request.getParameter("precio")));
            entBean.setEntrada_fecha(request.getParameter("fecha"));
            if(entrModel.nuevaEntrada(entBean)){
             response.sendRedirect("view/producto/lista.jsp?exito=1&mensaje=Entrada Registrada Correctamente");
            }else{
                 response.sendRedirect("view/producto/lista.jsp?exito=2&mensaje=Error al registar ");
                }
            
            
            }
            if(metodo.equals("modificar")){
               EntradaBean entBean = new EntradaBean();

                if(entrModel.modificarEntrada(entBean)){
                 response.sendRedirect("view/producto/lista.jsp?exito=1&mensaje=Entrada Modificada Correctamente");
                }else{
                 response.sendRedirect("view/producto/lista.jsp?exito=2&mensaje=Error al modificar ");
                }
            }
            if(metodo.equals("eliminar")){
                  EntradaBean entBean = new EntradaBean();
                            entBean.setId(Integer.parseInt(request.getParameter("id")));
                if(entrModel.EliminarEntrada(entBean)){
                 response.sendRedirect("view/producto/entrada/lista.jsp?exito=1&mensaje=Entrada Eliminada Correctamente");
                }else{
                 response.sendRedirect("view/producto/entrada/lista.jsp?exito=2&mensaje=Error al eliminar ");
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
                Logger.getLogger(EntradaController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ParseException ex) {
                Logger.getLogger(EntradaController.class.getName()).log(Level.SEVERE, null, ex);
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
                Logger.getLogger(EntradaController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ParseException ex) {
                Logger.getLogger(EntradaController.class.getName()).log(Level.SEVERE, null, ex);
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
