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
import sv.com.dkcarpis.model.PedidoModel;
import sv.com.dkcapris.beans.PedidoBean;
import sv.com.dkcapris.beans.DetallePedidoBean;
import sv.com.dkcarpis.model.ProductoModel;
/**
 *
 * @author Jose-PC
 */
@WebServlet(name = "PedidoController", urlPatterns = {"/PedidoController"})
public class PedidoController extends HttpServlet {

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
            
            
            PedidoModel pedidoModel = new PedidoModel();
            String metodo = request.getParameter("metodo");
            
            
            
            if(metodo.equals("insertar")){
            PedidoBean pedidoData = new PedidoBean();
            pedidoData.setPedido_descripcion(request.getParameter("descripcion"));
            pedidoData.setPedido_fechaFinal(request.getParameter("fechafin"));
                System.out.println(pedidoData.getPedido_fechaFinal());
            Integer idz = pedidoModel.getLastPedido();
                    if(pedidoModel.newPedido(pedidoData)){
                        response.sendRedirect("view/pedido/newpedidoDetalle.jsp?id="+idz+"&exito=1&mensaje=Pedido Registrado");
                    }else{
                         response.sendRedirect("view/pedido/newpedidoDetalle.jsp?id="+idz+"&exito=2&mensaje=Error al registar ");
                    }
            
            
            }
            
            if(metodo.equals("modificar")){
            
            
            }
            
            if(metodo.equals("eliminar")){
            
            
            }
            
            if(metodo.equals("setdetalle")){
                ProductoModel pdmodel = new ProductoModel();
                System.out.println("Eqipo:");
                System.out.println("Pedido:");
                System.out.println("cantidad:");
 
            }
            
            if(metodo.equals("deletedetalle")){
            
            
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
            Logger.getLogger(PedidoController.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(PedidoController.class.getName()).log(Level.SEVERE, null, ex);
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
