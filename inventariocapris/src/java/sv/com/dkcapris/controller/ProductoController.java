/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.dkcapris.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;


import sv.com.dkcapris.beans.ProductoBean;
import sv.com.dkcarpis.model.ProductoModel;

/**
 *
 * @author Jose-PC
 */
@WebServlet(name = "productoController", urlPatterns = {"/productoController"})
public class ProductoController extends HttpServlet {

    
        
        private boolean isMultipart;
        private String filePath;
        private int maxFileSize = 50 * 1024;
        private int maxMemSize = 4 * 1024;
        private File file ;

        
      public void init( ){
      // Get the file location where it would be stored.
      filePath = getServletContext().getInitParameter("file-upload"); 
   }
   
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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {


              
            /*
            if(metodo.equals("modificar")){
                if(false){
                 response.sendRedirect("view/producto/lista.jsp?exito=1&mensaje=Producto Modificado Correctamente");
                }else{
                 response.sendRedirect("view/producto/lista.jsp?exito=2&mensaje=Error Al modificar ");
                }
            }
            if(metodo.equals("eliminar")){     
                if(false){
                 response.sendRedirect("view/producto/lista.jsp?exito=1&mensaje=Producto Eliminado Correctamente");
                }else{
                 response.sendRedirect("view/producto/lista.jsp?exito=2&mensaje=Error Al eliminar ");
                }
            
            }
            */
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
        processRequest(request, response);
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
        processRequest(request, response);
        
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
