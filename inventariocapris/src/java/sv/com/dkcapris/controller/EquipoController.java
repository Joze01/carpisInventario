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
import sv.com.dkcapris.beans.EquipoBean;
import sv.com.dkcapris.beans.HospitalBean;
import sv.com.dkcarpis.model.EquipoModel;
import sv.com.dkcarpis.model.HospitalModel;
/**
 *
 * @author Jose
 */
@WebServlet(name = "EquipoController", urlPatterns = {"/EquipoController"})
public class EquipoController extends HttpServlet {

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
        final PrintWriter out = response.getWriter();
        /* TODO output your page here. You may use following sample code. */
        String metodo = request.getParameter("metodo");
        EquipoModel equiModel = new EquipoModel();
        EquipoBean equipoBean;
        equipoBean = new EquipoBean();
        if(metodo.equals("insertar")){
            equipoBean= new EquipoBean();
            equipoBean.setEquipo_serie(request.getParameter("serie"));
            equipoBean.setEquipo_nInventario(request.getParameter("nombre"));
            equipoBean.setEquipo_descripcion(request.getParameter("descripcion"));
            equipoBean.setEquipo_modelo(request.getParameter("modelo"));
            equipoBean.setEquipo_estado(Integer.parseInt(request.getParameter("estado")));
            equipoBean.setId_marca(Integer.parseInt(request.getParameter("fabricante")));
            if(equiModel.nuevoEquipo(equipoBean)){
                response.sendRedirect("view/equipo/lista.jsp?exito=1&mensaje=Equipo Registrado Correctamente");
            }else{
                response.sendRedirect("view/equipo/lista.jsp?exito=2&mensaje=Error al registar ");
            }
        }
        if(metodo.equals("modificar")){
            equipoBean= new EquipoBean();
            equipoBean.setEquipo_serie(request.getParameter("serie"));
            equipoBean.setEquipo_nInventario(request.getParameter("nombre"));
            equipoBean.setEquipo_descripcion(request.getParameter("descripcion"));
            equipoBean.setEquipo_modelo(request.getParameter("modelo"));
            equipoBean.setEquipo_estado(Integer.parseInt(request.getParameter("estado")));
            equipoBean.setId_marca(Integer.parseInt(request.getParameter("fabricante")));
            equipoBean.setEquipo_id(Integer.parseInt(request.getParameter("id")));
            if(equiModel.modificarEquipo(equipoBean)){
                response.sendRedirect("view/equipo/lista.jsp?exito=1&mensaje=Equipo Modificado Correctamente");
            }else{
                response.sendRedirect("view/equipo/lista.jsp?exito=2&mensaje=Error al modificar ");            
            }
        }
        if(metodo.equals("eliminar")){
            equipoBean= new EquipoBean();
            equipoBean.setEquipo_id(Integer.parseInt(request.getParameter("id")));
            if(equiModel.eliminarEquipo(equipoBean)){
                response.sendRedirect("view/equipo/lista.jsp?exito=1&mensaje=Equipo Eliminado Correctamente");
            }else{
                response.sendRedirect("view/equipo/lista.jsp?exito=2&mensaje=Error al Eliminar ");
            }
        }
        
        if(metodo.equals("asignar")){
            equipoBean= new EquipoBean();
           // System.out.println(request.getParameter("area") + " "+request.getParameter("hospital")+" "+ request.getParameter("tipo")+ " "+request.getParameter("equipoAsignar"));
            equipoBean.setId_area(Integer.parseInt(request.getParameter("area")));
            equipoBean.setId_hospital(Integer.parseInt(request.getParameter("hospital")));
            equipoBean.setHistorialChange(Integer.parseInt(request.getParameter("tipo")));
            equipoBean.setEquipo_id(Integer.parseInt(request.getParameter("equipoAsignar")));
            equipoBean.setEquipo_fecha(request.getParameter("fecha"));
           
            if(equiModel.asignarEquipo(equipoBean)){
                        response.sendRedirect("view/equipo/lista.jsp?exito=1&mensaje=Nueva Asisgnacion Registrada Correctamente");
            }else{
                     response.sendRedirect("view/equipo/lista.jsp?exito=2&mensaje=Error al asignar ");
            } 
             
            System.out.println("ENTRADA A ASIGNAR");
        }
        
         if(metodo.equals("retirar")){
             equipoBean= new EquipoBean();
             equipoBean.setEquipo_id(Integer.parseInt(request.getParameter("id")));
            if(equiModel.eliminarAsignacion(equipoBean)){
                        response.sendRedirect("view/equipo/lista.jsp?exito=1&mensaje=Asignacion Eliminada Correctamente");
            }else{
                     response.sendRedirect("view/equipo/lista.jsp?exito=2&mensaje=Error al eliminar asignacion  ");
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
            Logger.getLogger(EquipoController.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(EquipoController.class.getName()).log(Level.SEVERE, null, ex);
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
