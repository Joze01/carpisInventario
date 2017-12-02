<%-- 
    Document   : nuevo
    Created on : 10-15-2017, 04:59:46 PM
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
    Conexion con = new Conexion();
    ResultSet rs;
%>
<%@page import="java.sql.ResultSet"%>
<%@page import="sv.com.dkcarpis.model.Conexion"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Equipo | Modificar</title>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link rel="stylesheet" href="../css/bootstrap.min.css" />
<link rel="stylesheet" href="../css/bootstrap-responsive.min.css" />
<link rel="stylesheet" href="../css/fullcalendar.css" />

<link rel="stylesheet" href="../css/colorpicker.css" />
<link rel="stylesheet" href="../css/datepicker.css" />
<link rel="stylesheet" href="../css/uniform.css" />
<link rel="stylesheet" href="../css/select2.css" />

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

        <li><a href="../usuario/cambiarpassword.jsp"><i class="icon-check"></i>Cambiar contrase�a</a></li>
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
    <li class="submenu"> <a href="#"><i class="icon icon-shopping-cart"></i> <span>Pedidos</span> </a>
      <ul>
        <li><a href="../pedido/lista.jsp">Listado</a></li>
        <li><a href="../pedido/nuevo.jsp">Nuevo</a></li>
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
        <a href="../indexadmin.jsp" title="Ir a Inicio" class="tip-bottom"><i class="icon-home"></i>Dashboard</a>
        <a href="lista.jsp" title="" class="tip-bottom"><i class="icon-folder-close"></i>Equipo</a>
        <a href="#" title="" class="tip-bottom"><i class="icon-plus"></i>Nuevo</a>
    </div>
  </div>
<!--End-breadcrumbs-->

  
<!--Action boxes-->
  <div class="container-fluid">
    <div class="quick-actions_homepage">
      <ul class="quick-actions">
        <li class="bg_lr"> <a href="lista.jsp"> <i class="icon-ban-circle"></i> Cancelar </a> </li>
      </ul>
    </div>
<!--End-Action boxes--> 
<!--Chart-box-->    
    <%
      Integer idmarca=0;
      String serie="";
      String modelo="";
      String descripcion="";
      String nombre_equipo="";
      Integer estadoint=0;
      con=new Conexion();
      String ids=request.getParameter("id");
      con.query="select * from equipo where equipo_id="+ids;
      con.setRs(con.query);
      rs=con.getRs();
      while(rs.next()){
       idmarca=rs.getInt(2);
       serie=rs.getString(3);
       modelo=rs.getString(4);
       descripcion=rs.getString(5);
       nombre_equipo=rs.getString(6);
       estadoint=rs.getInt(7);
      }
      con.cerrarConexion();
    %>
         <div class="widget-box">
          <div class="widget-title"> <span class="icon"><i class="icon-group"></i></span>
            <h5>Modificar Equipo</h5>
          </div>
          <div class="widget-content nopadding">
             <form class="form-horizontal" method="post" action="/inventariocapris/EquipoController" name="basic_validate" id="basic_validate" novalidate="novalidate">
              <div class="control-group">
                <label class="control-label" disa >Numero de Serie</label>
                <div class="controls">
                    <input type="text" class="required" value="<% out.print(serie);%>" name="serie" id="required">
                </div>
              </div>
              <div class="control-group">
                <label class="control-label">Nombre</label>
                <div class="controls">
                  <input type="text" class="required" value="<% out.print(nombre_equipo);%>" name="nombre" id="required">
                </div>
              </div>   
              <div class="control-group">
                <label class="control-label">Descripcion</label>
                <div class="controls">
                  <input type="text" class="required" value="<% out.print(descripcion);%>" name="descripcion" id="required">
                </div>
              </div>   
              <div class="control-group">
                <label class="control-label">Modelo</label>
                <div class="controls">
                  <input type="text" class="required" value="<% out.print(modelo);%>" name="modelo" id="required">
                </div>
              </div> 
             <div class="control-group">
                <label class="control-label">Fabricante</label>
                 <div class="controls">
                    <select name="fabricante">
                            <%

                            con = new Conexion();
                            con.query ="select * from fabricante order by fabricante.fabricante_nombre";
                            con.setRs(con.query);
                            rs = con.getRs();
                            out.println("<option value='"+idmarca+"'>"+request.getParameter("marcaName")+"</td>");
                            while(rs.next()){
                               out.println("<option value='"+rs.getInt(1)+"'>"+rs.getString(2)+"</td>");

                            }

                            %>
                    </select>
                </div>
               </div> 
                            <div class="control-group">
                <label class="control-label">Estado</label>
                 <div class="controls">
                    <select name="estado">
                        <%
                        if(estadoint==1){
                        out.print("<option value='1'>Activo</option>");
                        }else{
                           out.print("<option value='0'>Desactivado</option>");
                        }
                        %>
                        <option value="1">Activo</option>
                        <option value="0">Desactivado</option>
                    </select>
                </div>
               </div>      
 
              <div class="form-actions">
                  <input type="hidden" name="id" value="<%out.print(ids);%>"/>
                  <input type="hidden" name="metodo" value="modificar"/>
                <input type="submit" value="Guardar" class="btn btn-success">
              </div>
            </form>
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
<script src="../js/jquery.validate.js"></script> 
<script src="../js/matrix.js"></script> 
<script src="../js/matrix.form_validation.js"></script>
<script src="../js/matrix.form_common.js"></script>


</body>
</html>
