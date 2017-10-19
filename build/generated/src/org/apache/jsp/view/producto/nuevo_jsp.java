package org.apache.jsp.view.producto;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.ResultSet;
import sv.com.dkcarpis.model.Conexion;

public final class nuevo_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("<head>\n");
      out.write("<title>Producto | Nuevo</title>\n");
      out.write("<meta charset=\"UTF-8\" />\n");
      out.write("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\" />\n");
      out.write("<link rel=\"stylesheet\" href=\"../css/bootstrap.min.css\" />\n");
      out.write("<link rel=\"stylesheet\" href=\"../css/bootstrap-responsive.min.css\" />\n");
      out.write("<link rel=\"stylesheet\" href=\"../css/fullcalendar.css\" />\n");
      out.write("\n");
      out.write("<link rel=\"stylesheet\" href=\"../css/colorpicker.css\" />\n");
      out.write("<link rel=\"stylesheet\" href=\"../css/datepicker.css\" />\n");
      out.write("<link rel=\"stylesheet\" href=\"../css/uniform.css\" />\n");
      out.write("<link rel=\"stylesheet\" href=\"../css/select2.css\" />\n");
      out.write("\n");
      out.write("<link rel=\"stylesheet\" href=\"../css/matrix-style.css\" />\n");
      out.write("<link rel=\"stylesheet\" href=\"../css/matrix-media.css\" />\n");
      out.write("<link href=\"../font-awesome/css/font-awesome.css\" rel=\"stylesheet\" />\n");
      out.write("<link rel=\"stylesheet\" href=\"../css/jquery.gritter.css\" />\n");
      out.write("<link href='http://fonts.googleapis.com/css?family=Open+Sans:400,700,800' rel='stylesheet' type='text/css'>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("\n");
      out.write("<!--Header-part-->\n");
      out.write("<div id=\"header\">\n");
      out.write("  <h1><a href=\"dashboard.html\">Matrix Admin</a></h1>\n");
      out.write("</div>\n");
      out.write("<!--close-Header-part--> \n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!--top-Header-menu-->\n");
      out.write("<div id=\"user-nav\" class=\"navbar navbar-inverse\">\n");
      out.write("  <ul class=\"nav\">\n");
      out.write("    <li  class=\"dropdown\" id=\"profile-messages\" ><a title=\"\" href=\"#\" data-toggle=\"dropdown\" data-target=\"#profile-messages\" class=\"dropdown-toggle\"><i class=\"icon icon-user\"></i>  <span class=\"text\">Welcome User</span><b class=\"caret\"></b></a>\n");
      out.write("      <ul class=\"dropdown-menu\">\n");
      out.write("\n");
      out.write("        <li><a href=\"#\"><i class=\"icon-check\"></i>Cambiar contraseña</a></li>\n");
      out.write("        <li class=\"divider\"></li>\n");
      out.write("        <li><a href=\"login.html\"><i class=\"icon-key\"></i> Cerrar Sesion</a></li>\n");
      out.write("      </ul>\n");
      out.write("    </li>\n");
      out.write("\n");
      out.write("    <li class=\"\"><a title=\"\" href=\"login.html\"><i class=\"icon icon-share-alt\"></i> <span class=\"text\">Logout</span></a></li>\n");
      out.write("  </ul>\n");
      out.write("</div>\n");
      out.write("<!--close-top-Header-menu-->\n");
      out.write("\n");
      out.write("<!--sidebar-menu-->\n");
      out.write("<div id=\"sidebar\"><a href=\"#\" class=\"visible-phone\"><i class=\"icon icon-home\"></i> Dashboard</a>\n");
      out.write("  <ul>\n");
      out.write("    <li class=\"\"><a href=\"../indexadmin.jsp\"><i class=\"icon icon-home\"></i> <span>Dashboard</span></a> </li>\n");
      out.write("    <li class=\"submenu active\"> <a href=\"#\"><i class=\"icon icon-th-list\"></i> <span>Productos</span> </a>\n");
      out.write("      <ul>\n");
      out.write("        <li><a href=\"../producto/lista.jsp\">Buscador</a></li>\n");
      out.write("        <li><a href=\"../producto/entrada/lista.jsp\">Entradas</a></li>\n");
      out.write("        <li><a href=\"../producto/salida/lista.jsp\">Salidas</a></li>\n");
      out.write("      </ul>\n");
      out.write("    </li>\n");
      out.write("    <li class=\"submenu\"> <a href=\"#\"><i class=\"icon icon-truck\"></i> <span>Fabricantes</span> </a>\n");
      out.write("      <ul>\n");
      out.write("          <li><a href=\"../fabricante/lista.jsp\">Listado</a></li>\n");
      out.write("        <li><a href=\"../fabricante/nuevo.jsp\">Nuevo</a></li>\n");
      out.write("      </ul>\n");
      out.write("    </li>\n");
      out.write("    <li class=\"submenu\"> <a href=\"#\"><i class=\"icon icon-group\"></i> <span>Usuarios</span> </a>\n");
      out.write("      <ul>\n");
      out.write("        <li><a href=\"../usuario/lista.jsp\">Listado</a></li>\n");
      out.write("        <li><a href=\"../usuario/nuevo.jsp\">Nuevo</a></li>\n");
      out.write("      </ul>\n");
      out.write("    </li>\n");
      out.write("\n");
      out.write("\n");
      out.write("  </ul>\n");
      out.write("</div>\n");
      out.write("<!--sidebar-menu-->\n");
      out.write("\n");
      out.write("<!--main-container-part-->\n");
      out.write("<div id=\"content\">\n");
      out.write("<!--breadcrumbs-->\n");
      out.write("  <div id=\"content-header\">\n");
      out.write("    <div id=\"breadcrumb\"> \n");
      out.write("        <a href=\"../indexadmin.jsp\" title=\"Ir a Inicio\" class=\"tip-bottom\"><i class=\"icon-home\"></i> Dashboard</a>\n");
      out.write("        <a href=\"#\" title=\"\" class=\"tip-bottom\"><i class=\"icon-list\"></i>Producto</a>\n");
      out.write("    </div>\n");
      out.write("  </div>\n");
      out.write("<!--End-breadcrumbs-->\n");
      out.write("\n");
      out.write("\n");
      out.write("<!--Action boxes-->\n");
      out.write("  <div class=\"container-fluid\">\n");
      out.write("    <div class=\"quick-actions_homepage\">\n");
      out.write("      <ul class=\"quick-actions\">\n");
      out.write("        <li class=\"bg_lr\"> <a href=\"lista.jsp\"> <i class=\"icon-ban-circle\"></i> Cancelar </a> </li>\n");
      out.write("      </ul>\n");
      out.write("    </div>\n");
      out.write("<!--End-Action boxes-->    \n");
      out.write("<!--Chart-box-->    \n");
      out.write("         <div class=\"widget-box\">\n");
      out.write("          <div class=\"widget-title\"> <span class=\"icon\"><i class=\"icon-th\"></i></span>\n");
      out.write("            <h5>Nuevo Producto</h5>\n");
      out.write("          </div>\n");
      out.write("          <div class=\"widget-content nopadding\">\n");
      out.write("             <form class=\"form-horizontal\" method=\"post\" action=\"#\" name=\"basic_validate\" id=\"basic_validate\" novalidate=\"novalidate\">\n");
      out.write("              <div class=\"control-group\">\n");
      out.write("                <label class=\"control-label\">Numero de Serie</label>\n");
      out.write("                <div class=\"controls\">\n");
      out.write("                  <input type=\"text\" class=\"required\" name=\"serie\" id=\"required\">\n");
      out.write("                </div>\n");
      out.write("              </div>\n");
      out.write("              <div class=\"control-group\">\n");
      out.write("                <label class=\"control-label\">Nombre</label>\n");
      out.write("                <div class=\"controls\">\n");
      out.write("                  <input type=\"text\" class=\"required\" name=\"nombre\" id=\"required\">\n");
      out.write("                </div>\n");
      out.write("              </div>   \n");
      out.write("              <div class=\"control-group\">\n");
      out.write("                <label class=\"control-label\">Descripcion</label>\n");
      out.write("                <div class=\"controls\">\n");
      out.write("                  <input type=\"text\" class=\"required\" name=\"descripcion\" id=\"required\">\n");
      out.write("                </div>\n");
      out.write("              </div>   \n");
      out.write("             <div class=\"control-group\">\n");
      out.write("                <label class=\"control-label\">Fabricante</label>\n");
      out.write("                 <div class=\"controls\">\n");
      out.write("                    <select name=\"fabricante\">\n");
      out.write("                            ");


                            Conexion con = new Conexion();
                            ResultSet rs;
                            con.query ="select * from fabricante order by fabricante.fabricante_nombre";
                            con.setRs(con.query);
                            rs = con.getRs();
                            while(rs.next()){
                               out.println("<option value='"+rs.getInt(1)+"'>"+rs.getString(2)+"</td>");

                            }

                            
      out.write("\n");
      out.write("                    </select>\n");
      out.write("                </div>\n");
      out.write("               </div> \n");
      out.write("               <div class=\"control-group\">\n");
      out.write("                <label class=\"control-label\">Categoria</label>\n");
      out.write("                 <div class=\"controls\">\n");
      out.write("                    <select name=\"categoria\">\n");
      out.write("                            ");


                            con = new Conexion();
                     
                            con.query ="select * from categoria order by categoria.categoria_nombre";
                            con.setRs(con.query);
                            rs = con.getRs();
                            while(rs.next()){
                               out.println("<option value='"+rs.getInt(1)+"'>"+rs.getString(2)+"</td>");
                               
                            }

                            
      out.write("\n");
      out.write("                    </select>\n");
      out.write("                </div>\n");
      out.write("               </div> \n");
      out.write("               <div class=\"control-group\">\n");
      out.write("                <label class=\"control-label\">Tipo</label>\n");
      out.write("                 <div class=\"controls\">\n");
      out.write("                    <select name=\"tipo\">\n");
      out.write("                            ");


                            con = new Conexion();
                     
                            con.query ="select * from tipoproducto order by tipoproducto.tipoproducto_nombre";
                            con.setRs(con.query);
                            rs = con.getRs();
                            while(rs.next()){
                               out.println("<option value='"+rs.getInt(1)+"'>"+rs.getString(2)+"</td>");
                               
                            }

                            
      out.write("\n");
      out.write("                    </select>\n");
      out.write("                </div>\n");
      out.write("               </div>      \n");
      out.write("                    \n");
      out.write("              <div class=\"form-actions\">\n");
      out.write("                <input type=\"submit\" value=\"Guardar\" class=\"btn btn-success\">\n");
      out.write("              </div>\n");
      out.write("            </form>\n");
      out.write("          </div>\n");
      out.write("        </div>\n");
      out.write("<!--End-Chart-box--> \n");
      out.write("    <hr/>\n");
      out.write("\n");
      out.write("  </div>\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("<!--end-main-container-part-->\n");
      out.write("\n");
      out.write("<!--Footer-part-->\n");
      out.write("\n");
      out.write("<div class=\"row-fluid\">\n");
      out.write("  <div id=\"footer\" class=\"span12\"> 2017 &copy; Diagnostikal Capris </div>\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("<!--end-Footer-part-->\n");
      out.write("\n");
      out.write("\n");
      out.write("<script src=\"../js/jquery.min.js\"></script> \n");
      out.write("<script src=\"../js/jquery.ui.custom.js\"></script> \n");
      out.write("<script src=\"../js/bootstrap.min.js\"></script> \n");
      out.write("<script src=\"../js/jquery.uniform.js\"></script> \n");
      out.write("<script src=\"../js/select2.min.js\"></script> \n");
      out.write("<script src=\"../js/jquery.validate.js\"></script> \n");
      out.write("<script src=\"../js/matrix.js\"></script> \n");
      out.write("<script src=\"../js/matrix.form_validation.js\"></script>\n");
      out.write("<script src=\"../js/matrix.form_common.js\"></script>\n");
      out.write("\n");
      out.write("\n");
      out.write("</body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
