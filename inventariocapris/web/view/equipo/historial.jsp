<%-- 
    Document   : historial
    Created on : 11-17-2017, 12:47:31 PM
    Author     : Jose-PC
--%>

<%
    
   HttpSession sesion = request.getSession();
   String id=sesion.getAttribute("id").toString();
   String nombre=sesion.getAttribute("nombre").toString();
   String tipo=sesion.getAttribute("tipo").toString();
   if(Integer.parseInt(tipo)>2){
       response.sendRedirect("../../");
   }
      ResultSet rs;
             
%>
<%@page import="java.sql.ResultSet"%>
<%@page import="sv.com.dkcarpis.model.Conexion"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Historial | <% out.print(request.getParameter("nombre")); %></title>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link rel="stylesheet" href="../css/bootstrap.min.css" />
<link rel="stylesheet" href="../css/bootstrap-responsive.min.css" />
<link rel="stylesheet" href="../css/fullcalendar.css" />
<link rel="stylesheet" href="../css/matrix-style.css" />
<link rel="stylesheet" href="../css/matrix-media.css" />
<link href="../font-awesome/css/font-awesome.css" rel="stylesheet" />
<link rel="stylesheet" href="../css/jquery.gritter.css" />
<link href='http://fonts.googleapis.com/css?family=Open+Sans:400,700,800' rel='stylesheet' type='text/css'>
</head>
<body>

<!--Header-part-->
<div id="header">
  <h1><a href="dashboard.html">Matrix Admin</a></h1>
</div>
<!--close-Header-part--> 



<!--top-Header-menu-->
<div id="user-nav" class="navbar navbar-inverse">
  <ul class="nav">
    <li  class="dropdown" id="profile-messages" ><a title="" href="#" data-toggle="dropdown" data-target="#profile-messages" class="dropdown-toggle"><i class="icon icon-user"></i>  <span class="text"><%out.println(nombre);%> </span><b class="caret"></b></a>
      <ul class="dropdown-menu">

        <li><a href="../usuario/cambiarpassword.jsp"><i class="icon-check"></i>Cambiar contraseña</a></li>
        <li class="divider"></li>
        <li><a href="../../index.jsp"><i class="icon-key"></i> Cerrar Sesion</a></li>
      </ul>
    </li>

    <li class=""><a title="" href="../../index.jsp"><i class="icon icon-share-alt"></i> <span class="text">Logout</span></a></li>
  </ul>
</div>
<!--close-top-Header-menu-->
<!--sidebar-menu-->
<div id="sidebar"><a href="#" class="visible-phone"><i class="icon icon-home"></i> Dashboard</a>
  <ul>
    <li class=""><a href="../indexadmin.jsp"><i class="icon icon-home"></i> <span>Dashboard</span></a> </li>
    <li class="submenu "> <a href="#"><i class="icon icon-th-list"></i> <span>Productos</span> </a>
      <ul>
        <li><a href="../producto/lista.jsp">Buscador</a></li>
        <li><a href="../producto/entrada/lista.jsp">Entradas</a></li>
        <li><a href="../producto/salida/lista.jsp">Salidas</a></li>
      </ul>
    </li>
    <li class="submenu "> <a href="#"><i class="icon icon-truck"></i> <span>Fabricantes</span> </a>
      <ul>
          <li><a href="../fabricante/lista.jsp">Listado</a></li>
        <li><a href="../fabricante/nuevo.jsp">Nuevo</a></li>
      </ul>
    </li>
    <li class="submenu"> <a href="#"><i class="icon icon-group"></i> <span>Usuarios</span> </a>
      <ul>
        <li><a href="../usuario/lista.jsp">Listado</a></li>
        <li><a href="../usuario/nuevo.jsp">Nuevo</a></li>
      </ul>
    </li>
    <li class="submenu "> <a href="#"><i class="icon icon-hospital"></i> <span>Hospitales</span> </a>
      <ul>
        <li><a href="../hospital/lista.jsp">Listado</a></li>
        <li><a href="../hospital/nuevo.jsp">Nuevo</a></li>
      </ul>
    </li>
    <li class="submenu active"> <a href="#"><i class="icon icon-folder-close"></i> <span>Equipos</span> </a>
      <ul>
        <li><a href="lista.jsp">Listado</a></li>
        <li><a href="nuevo.jsp">Nuevo</a></li>
      </ul>
    </li>

  </ul>
</div>
<!--sidebar-menu-->

<!--main-container-part-->
<div id="content">
<!--breadcrumbs-->
  <div id="content-header">
    <div id="breadcrumb"> 
        <a href="../indexadmin.jsp" title="Ir a Inicio" class="tip-bottom"><i class="icon-home"></i> Dashboard</a>
        <a href="lista.jsp" title="" class="tip-bottom"><i class="icon-folder-close"></i>Equipos</a>
         <a href="#" title="" class="tip-bottom"><i class="icon-folder-open"></i>Historial</a>
    </div>
  </div>
<!--End-breadcrumbs-->

 
<!--Action boxes-->
  <div class="container-fluid">
    <div class="quick-actions_homepage">
      <ul class="quick-actions">
        <li class="bg_lr"> <a href="lista.jsp"> <i class="icon-arrow-left"></i> Regresar </a> </li>
        <li class="bg_dg"> <a href="asignar.jsp?id=<%out.print(request.getParameter("id"));%>"> <i class="icon-plus"></i> Nueva Asignacion </a> </li>
      </ul>
    </div>
<!--End-Action boxes-->    
<!--Chart-box-->   
  <div class="row-fluid">
      <div class="span12">
        <div class="widget-box">
          <div class="widget-title"> <span class="icon"> <i class="icon-folder-close"></i> </span>
            <h5>Equipo </h5>
          </div>
        
          <div class="widget-content">
            <div class="row-fluid">
              <div class="span6">
                <table class="">
                  <tbody>
                    <tr>
                      <td><h4> <%out.print(request.getParameter("nombre"));%></h4></td>
                    </tr>
                    <tr>
                      <td>  <%out.print(request.getParameter("descripcion"));%></td>
                    </tr>

                  </tbody>
                </table>
              </div>
              <div class="span6">
                <table class="table table-bordered table-invoice">
                  <tbody>
                    <tr>
                    <tr>
                      <td class="width30">Marca:</td>
                      <td class="width70"><strong>  <%out.print(request.getParameter("marca"));%></strong></td>
                    </tr>
                    <tr>
                      <td>Modelo:</td>
                      <td><strong>  <%out.print(request.getParameter("modelo"));%></strong></td>
                    </tr>

                  <td class="width30">Estado</td>
                  <td class="width70"><strong>  <%out.print(request.getParameter("estado"));%></strong></td>
                  </tr>
                    </tbody>
                  
                </table>
              </div>
            </div>

          </div>
         </div>
      </div>
    </div>
         <div class="widget-box">
          <div class="widget-title"> <span class="icon"><i class="icon-folder-open"></i></span>
            <h5>Historial</h5>
          </div>
          <div class="widget-content nopadding">
            <table class="table table-bordered data-table">
              <thead>
                <tr>
                  <th>#</th>
                  <th>HOSPITAL</th>
                  <th>AREA</th>
                  <th>FECHA</th>
                  <th>TIPO MOVIMIENTO</th>
                  <th>FUNCIONES</th> 
                </tr>
              </thead>
              <tbody>
              <%
             
              String query="select * from historial_equipo inner join equipo on equipo.equipo_id=historial_equipo.id_equipo inner join area on area.area_id=historial_equipo.id_area inner join hospital on hospital.hospital_id=historial_equipo.id_hospital where equipo.equipo_id="+request.getParameter("id");
              Conexion con = new Conexion();
              
             
              con.setRs(query);
              rs=con.getRs();
              while(rs.next()){
                out.println("<tr class='gradeX'>");
                out.println("<td>"+rs.getInt(4)+"</td>");
                out.println("<td>"+rs.getString(18)+"</td>");
                out.println("<td>"+rs.getString(15)+"</td>");
                out.println("<td>"+rs.getString(5)+"</td>");
                out.println("<td>"+rs.getString(5)+"</td>");

                out.println("<td>");
                 out.println("<button onclick=\"eliminar2('Equipo',"+rs.getInt(4)+",'/inventariocapris/EquipoController')\" class='btn btn-danger btn-mini'>Eliminar</button>");           
                out.println("</td>");
                out.println("</tr>");
              }
              con.cerrarConexion();

              %>
              </tbody>
            </table>
          </div>
        </div>
<!--End-Chart-box--> 
    <hr/>

  </div>
</div>

<!--end-main-container-part-->

<!--Footer-part-->

<div class="row-fluid">
  <div id="footer" class="span12"> 2017 &copy; Diagnostikal Capris </div>
</div>

<!--end-Footer-part-->


<script src="../js/jquery.min.js"></script> 
<script src="../js/jquery.ui.custom.js"></script> 
<script src="../js/bootstrap.min.js"></script> 
<script src="../js/jquery.uniform.js"></script> 
<script src="../js/select2.min.js"></script> 
<script src="../js/jquery.dataTables.min.js"></script> 
<script src="../js/matrix.js"></script> 
<script src="../js/matrix.tables.js"></script>



<script src="../js/jquery.peity.min.js"></script> 
<script src="../js/jquery.gritter.min.js"></script> 
<script src="../js/matrix.interface.js"></script> 
<script src="../js/jquery.uniform.js"></script> 
<script src="../js/matrix.popover.js"></script> 
<script src="../js/redirecciones.js"></script>



<% 
        String exito="3";
        String mensaje="";
         if(request.getParameterMap().containsKey("exito"))
        {
            exito = request.getParameter("exito");
            mensaje = request.getParameter("mensaje");
        }
        if(exito.equals("1")){
        out.println(" <script>"
                + " $(document).ready(function() "
                + "{ $.gritter.add({ "
                + "title:'Completado Exitosamente', "
                + "text:'"+mensaje+"',"
                + "time: 5000, "
                + "class_name: 'gritter-itemOk' ,"
                + "sticky: false})"
                + ";}); </script>");
        }else if(exito.equals("2")){
         out.println(" <script>"
                + " $(document).ready(function() "
                + "{ $.gritter.add({ "
                + "title:'Error.', "
                + "text:'"+mensaje+"',"
                + "time: 5000, "
                + "class_name: 'gritter-itemError' ,"
                + "sticky: false})"
                + ";}); </script>");  
        }

    %> 

</body>
</html>
