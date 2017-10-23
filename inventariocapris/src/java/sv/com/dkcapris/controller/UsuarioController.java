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
import javax.servlet.http.HttpSession;
import sv.com.dkcapris.beans.FabricanteBean;
import sv.com.dkcapris.beans.UsuarioBean;
import sv.com.dkcarpis.model.UsuarioModel;

/**
 *
 * @author Jose-PC
 */
@WebServlet(name = "usuarioController", urlPatterns = {"/usuarioController"})
public class UsuarioController extends HttpServlet {
        
        UsuarioBean usr = new UsuarioBean();
        UsuarioModel usrModel = new  UsuarioModel();
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
            UsuarioBean usr = new UsuarioBean();
            usr.setUsuario_Nombre(request.getParameter("nombre"));
            usr.setId_tipo(Integer.parseInt(request.getParameter("tipo")));
            usr.setUsuario_user(request.getParameter("usuario"));
            usr.setUsuario_password(request.getParameter("password"));
            
            
            if(usrModel.nuevoUsuario(usr)){
             response.sendRedirect("view/usuario/lista.jsp?exito=1&mensaje=Usuario Registrado Correctamente");
            }else{
                 response.sendRedirect("view/usuario/lista.jsp?exito=2&mensaje=Error al registar ");
            }
            
            
            }
            if(metodo.equals("modificar")){
               UsuarioBean usr = new UsuarioBean();
            
            if(usrModel.updateUsuario(usr)){
                 response.sendRedirect("view/usuario/lista.jsp?exito=1&mensaje=Usuario Modificado Correctamente");
                }else{
                 response.sendRedirect("view/usuario/lista.jsp?exito=2&mensaje=Error Al modificar ");
                }
            }
            if(metodo.equals("eliminar")){
              UsuarioBean usr = new UsuarioBean();
              usr.setUsuario_id(Integer.parseInt(request.getParameter("id")));
            if(usrModel.deleteUsuario(usr)){
                 response.sendRedirect("view/usuario/lista.jsp?exito=1&mensaje=Usuario Eliminado Correctamente");
                }else{
                 response.sendRedirect("view/usuario/lista.jsp?exito=2&mensaje=Error Al eliminar ");
                }
            
            }
            
            if(metodo.equals("login")){
                UsuarioBean usrData = new UsuarioBean();
                usrData.setUsuario_user(request.getParameter("username"));
                usrData.setUsuario_password(request.getParameter("password"));
                
                usrData=usrModel.login(usrData);
                
                if(usrData.isLoggeado()){
                HttpSession sesion = request.getSession();
                    sesion.setAttribute("id", usrData.getUsuario_id());
                    sesion.setAttribute("nombre", usrData.getUsuario_Nombre());
                    sesion.setAttribute("tipo", usrData.getId_tipo());
                 if(usrData.getId_tipo()!=3){
                    response.sendRedirect("view/indexadmin.jsp?exito=1&mensaje=Bienvenido");
                 }else{
                    response.sendRedirect("view/indexing.jsp?exito=1&mensaje=Bienvenido "); 
                 }
                 
                }else{
                 response.sendRedirect("index.jsp?exito=2&mensaje=No se ha iniciado session ");
                }
                
            }
            
            if(metodo.equals("logout")){
            
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
                Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE, null, ex);
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
                Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE, null, ex);
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
