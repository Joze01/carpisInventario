/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.dkcapris.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import sv.com.dkcapris.beans.FabricanteBean;
import sv.com.dkcapris.beans.ImageBean;

import sv.com.dkcapris.beans.ProductoBean;
import sv.com.dkcarpis.model.ProductoModel;

/**
 *
 * @author Jose-PC
 */
@WebServlet(name = "productoController", urlPatterns = {"/productoController"})
public class ProductoController extends HttpServlet {

    
        
           private boolean isMultipart;
	   private String filePath="";
	   private int maxFileSize = 4096 * 1024;
	   private int maxMemSize = 4096 * 1024;
	   private File file ;
        
           private static final String SAVE_DIR = "view\\producto\\images\\";
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
            throws ServletException, IOException, FileUploadException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

        // gets absolute path of the web application
        String appPath = request.getServletContext().getRealPath("");
        // constructs path of the directory to save uploaded file
        String savePath = appPath+ SAVE_DIR;
        String mod = "";
            ProductoModel pdModel = new ProductoModel();
          

                        String metodo="";
                        ProductoBean prdData = new ProductoBean();
                        ArrayList<ImageBean> listaImgs = new ArrayList<ImageBean>();
                   // Check that we have a file upload request
                      isMultipart = ServletFileUpload.isMultipartContent(request);
                      response.setContentType("text/html");
                      if( !isMultipart ) {
                         out.println("<html>");
                         out.println("<head>");
                         out.println("<title>Servlet upload</title>");  
                         out.println("</head>");
                         out.println("<body>");
                         out.println("<p>No file uploaded</p>"); 
                         out.println("</body>");
                         out.println("</html>");
                         return;
                      }
                      DiskFileItemFactory factory = new DiskFileItemFactory();
                      // maximum size that will be stored in memory
                      factory.setSizeThreshold(maxMemSize);
                      // Location to save data that is larger than maxMemSize.
                      factory.setRepository(new File(savePath));
                      filePath=savePath;
                      // Create a new file upload handler
                      ServletFileUpload upload = new ServletFileUpload(factory);
                      // maximum file size to be uploaded.
                      upload.setSizeMax( maxFileSize );
                      
                      
                      try { 
                         // Parse the request to get file items.
                         List fileItems = upload.parseRequest(request);
                         // Process the uploaded file items
                         Iterator i = fileItems.iterator();
                         out.println("<html>");
                         out.println("<head>");
                         out.println("<title>Servlet upload</title>");  
                         out.println("</head>");
                         out.println("<body>");
                         while ( i.hasNext () ) {
                             System.out.println("Iteracion de campos");
                            FileItem fi = (FileItem)i.next();
                            if ( !fi.isFormField () ) {
                               // Get the uploaded file parameters
                                    if(mod.equals("cambio")){
                                    String fieldName = fi.getFieldName();
                                    String fileName = fi.getName();
                                    String contentType = fi.getContentType();
                                    boolean isInMemory = fi.isInMemory();
                                    long sizeInBytes = fi.getSize();
                                    // Write the file
                                    
                                    if( fileName.lastIndexOf("\\") >= 0 ) {
                                       file = new File( filePath + fileName.substring( fileName.lastIndexOf("\\"))) ;
                                    } else {
                                       file = new File( filePath + fileName.substring(fileName.lastIndexOf("\\")+1)) ;
                                    }
                                    fi.write( file ) ;
                                    
                                     System.out.println("Uploaded Filename: " + fileName + "<br>");
                                     ImageBean portada = new ImageBean();
                                     portada.setImage_url(fileName);
                                     listaImgs.add(portada);
                                     out.println("DIRECCION "+filePath);
                                    }
                            }else{
                                if(fi.getFieldName().equals("idproducto")){
                                   prdData.setProducto_id(Integer.parseInt(fi.getString()));
                                }
                                if(fi.getFieldName().equals("serie")){
                                   prdData.setProducto_serie(fi.getString());
                                }
                                if(fi.getFieldName().equals("nombre")){
                                   prdData.setProducto_nombre(fi.getString());
                                }
                                if(fi.getFieldName().equals("descripcion")){
                                   prdData.setProducto_descripcion(fi.getString());
                                }
                                if(fi.getFieldName().equals("fabricante")){
                                  prdData.setId_fabricante(Integer.parseInt(fi.getString()));
                                }
                                if(fi.getFieldName().equals("categoria")){
                                  prdData.setId_categoria(Integer.parseInt(fi.getString()));
                                }
                                 if(fi.getFieldName().equals("cambio")){
                                 mod=fi.getString();
                                     System.out.println("CHECKBOX CLICKED "+mod );
                                }
                                if(fi.getFieldName().equals("tipo")){
                                  prdData.setId_tipoproducto(Integer.parseInt(fi.getString()));
                                }
                                if(fi.getFieldName().equals("metodo")){
                                   metodo=(fi.getString());
                                }
                                if(fi.getFieldName().equals("ubicacion")){
                                   prdData.setProducto_ubicacion(fi.getString());
                                }
                            }
                         }
                         out.println("</body>");
                         out.println("</html>");
                         
            

                         
             prdData.setProductoImagenes(listaImgs);
             System.out.println("end de iteraciones: "+metodo);
            if(metodo.equals("insertar")){          
            if(pdModel.nuevoProducto(prdData)){
                 response.sendRedirect("view/producto/lista.jsp?exito=1&mensaje=Producto Registrado Correctamente");
            }else{
                 response.sendRedirect("view/producto/lista.jsp?exito=2&mensaje=Error al registar ");
                }
            }
            
            if(metodo.equals("asignarImagen")){
                System.out.println("AsignarImagen");
               if(pdModel.asignarImagen(prdData)){
                    response.sendRedirect("view/producto/lista.jsp?exito=1&mensaje=Imagen Asignada Correctamente");
              }else{
                    response.sendRedirect("view/producto/lista.jsp?exito=2&mensaje=Error al Asignar ");
              }
            }
            
             if(metodo.equals("modificar")){
                System.out.println("Modificar");
                if(pdModel.modificarProducto(prdData)){
                    if(mod.equals("cambio")){
                    pdModel.asignarImagen(prdData);
                    }
                 response.sendRedirect("view/producto/lista.jsp?exito=1&mensaje=Producto Modificado Correctamente");
                }else{
                 response.sendRedirect("view/producto/lista.jsp?exito=2&mensaje=Error Al modificar ");
                }
             }

              } catch(Exception ex) {
                            System.out.println(ex);
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
                   ProductoModel pdModel = new ProductoModel();
                   ProductoBean prdData = new ProductoBean();
                   String metodo="";
                   metodo = request.getParameter("metodo");
                   
                   prdData.setProducto_id(Integer.parseInt(request.getParameter("id")));
                  
                 if(metodo.equals("eliminar")){     
               
                       try {
                           if(pdModel.eliminarProducto(prdData)){
                               response.sendRedirect("view/producto/lista.jsp?exito=1&mensaje=Producto Eliminado Correctamente");
                           }else{
                               response.sendRedirect("view/producto/lista.jsp?exito=2&mensaje=Error Al eliminar ");
                           }      } catch (SQLException ex) {
                           Logger.getLogger(ProductoController.class.getName()).log(Level.SEVERE, null, ex);
                       }
            
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
               } catch (FileUploadException ex) {
                   Logger.getLogger(ProductoController.class.getName()).log(Level.SEVERE, null, ex);
               } catch (SQLException ex) {
                   Logger.getLogger(ProductoController.class.getName()).log(Level.SEVERE, null, ex);
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
