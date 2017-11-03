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
import sv.com.dkcapris.beans.ProductoBean;
import sv.com.dkcarpis.model.ProductoModel;
/**
 *
 * @author Jose-PC
 */
@WebServlet(name = "ProductoControllerMod", urlPatterns = {"/ProductoControllerMod"})
public class ProductoControllerMod extends HttpServlet {

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
        String metodo= request.getParameter("metodo").toString();
        ProductoBean prdData = new ProductoBean();
        ProductoModel pdModel = new ProductoModel();
        
                   prdData.setProducto_id(Integer.parseInt(request.getParameter("prodModId")));
                   prdData.setId_fabricante(Integer.parseInt(request.getParameter("fabricante")));
                   prdData.setId_categoria(Integer.parseInt(request.getParameter("categoria")));
                   prdData.setId_tipoproducto(Integer.parseInt(request.getParameter("tipo")));
                   prdData.setProducto_serie(request.getParameter("serie"));
                   prdData.setProducto_nombre(request.getParameter("nombre"));
                   prdData.setProducto_descripcion(request.getParameter("descripcion"));
                   prdData.setProducto_ubicacion(request.getParameter("ubicacion"));
       
                        
           if(metodo.equals("modificar")){
               System.out.println("Modificar");
                if(pdModel.modificarProducto(prdData)){
                 response.sendRedirect("view/producto/lista.jsp?exito=1&mensaje=Producto Modificado Correctamente");
                }else{
                 response.sendRedirect("view/producto/lista.jsp?exito=2&mensaje=Error Al modificar ");
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
            Logger.getLogger(ProductoControllerMod.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ProductoControllerMod.class.getName()).log(Level.SEVERE, null, ex);
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
