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
import sv.com.dkcapris.beans.HospitalBean;
import sv.com.dkcarpis.model.HospitalModel;
/**
 *
 * @author Jose-PC
 */
@WebServlet(name = "HospitalController", urlPatterns = {"/HospitalController"})
public class HospitalController extends HttpServlet {

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
            HospitalModel hostModel = new HospitalModel();
            HospitalBean hospitalData;
            if(metodo.equals("insertar")){
                hospitalData = new HospitalBean();
                    hospitalData.setHospital_Nombre(request.getParameter("nombre"));
                    hospitalData.setHospital_Descripcion(request.getParameter("descripcion"));
                    if(hostModel.nuevoHospital(hospitalData)){
                        response.sendRedirect("view/hospital/lista.jsp?exito=1&mensaje=Hospital Registrado Correctamente");
                    }else{
                         response.sendRedirect("view/hospital/lista.jsp?exito=2&mensaje=Error al registar ");
                    }
            }
            
            if(metodo.equals("modificar")){
                hospitalData = new HospitalBean();
                    if(hostModel.modificarHospital(hospitalData)){
                        response.sendRedirect("view/hospital/lista.jsp?exito=1&mensaje=Hospital Modificado Correctamente");
                    }else{
                         response.sendRedirect("view/hospital/lista.jsp?exito=2&mensaje=Error al registar ");
                    }            
            }
            if(metodo.equals("eliminar")){
                hospitalData = new HospitalBean();
                    hospitalData.setHospital_Id(Integer.parseInt(request.getParameter("id")));
                    if(hostModel.eliminarHospital(hospitalData)){
                        response.sendRedirect("view/hospital/lista.jsp?exito=1&mensaje=Hospital Eliminado Correctamente");
                    }else{
                         response.sendRedirect("view/hospital/lista.jsp?exito=2&mensaje=Error al registar ");
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
            Logger.getLogger(HospitalController.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(HospitalController.class.getName()).log(Level.SEVERE, null, ex);
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
