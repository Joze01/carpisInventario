<%-- 
    Document   : newpedidoDetalle
    Created on : 11-30-2017, 10:07:26 PM
    Author     : Jose-PC
--%>
<%@page import="sv.com.dkcapris.beans.ProductoBean"%>
<%@page import="sv.com.dkcarpis.model.ImageModel"%>
<%@page import="java.util.ArrayList"%>
<%@page import="sv.com.dkcarpis.model.ProductoModel"%>
<%
   HttpSession sesion = request.getSession();
   String id=sesion.getAttribute("id").toString();
   String nombre=sesion.getAttribute("nombre").toString();
   String tipo=sesion.getAttribute("tipo").toString();
   if(Integer.parseInt(tipo)>2){
       response.sendRedirect("../../");
   }
   
   Integer idPedido = Integer.parseInt(request.getParameter("id"));



%>
<%@page import="java.sql.ResultSet"%>
<%@page import="sv.com.dkcarpis.model.Conexion"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Hospitales | Listado</title>
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

        <li><a href="../usuario/cambiarpassword.jsp"><i class="icon-check"></i>Cambiar contraseņa</a></li>
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
        <li><a href="lista.jsp">Listado</a></li>
        <li><a href="nuevo.jsp">Nuevo</a></li>
      </ul>
    </li>
    <li class="submenu "> <a href="#"><i class="icon icon-folder-close"></i> <span>Equipos</span> </a>
      <ul>
        <li><a href="../equipo/lista.jsp">Listado</a></li>
        <li><a href="../equipo/nuevo.jsp">Nuevo</a></li>
      </ul>
    </li>
    <li class="submenu active"> <a href="#"><i class="icon icon-shopping-cart"></i> <span>Pedidos</span> </a>
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
        <a href="#" title="" class="tip-bottom"><i class="icon-shopping-cart"></i>Pedidos</a>
    </div>
  </div>
<!--End-breadcrumbs-->

 
<!--Action boxes-->
  <div class="container-fluid">
    <div class="quick-actions_homepage">
      <ul class="quick-actions">
        <li class="bg_lr"> <a href="lista.jsp"> <i class="icon-ban-circle"></i> Regresar </a> </li>
      </ul>
    </div>
<!--End-Action boxes-->    
<!--Chart-box-->    
         <div class="widget-box">
          <div class="widget-title"> <span class="icon"><i class="icon-list"></i></span>
            <h5>Lista de productos</h5>
          </div>
          <div class="widget-content nopadding">
          <table class="table table-bordered data-table">
              <thead>
                <tr>
                  <th>Cantidad Pedido</th>
                  <th>#</th>
                  <th>Serie</th>
                  <th>Nombre</th>
                  <th>Descripcion</th>
                  <th>Imagen</th>
                  <th>Marca</th>
                  <th>Categoria</th>
                  <th>Tipo</th>
                  <th>Guardar</th>
                </tr>
              </thead>
              <tbody>
              <%
                  ProductoModel pdFunc = new ProductoModel();
                  ArrayList<ProductoBean> listado;
                  listado = new ArrayList<ProductoBean>();
                  ImageModel imgMod = new ImageModel();
                  listado=pdFunc.getTable();
                  
             
                  
                  for(ProductoBean pd: listado ){
                          
                         String precios=pdFunc.getEntradaPrecios(pd.getProducto_id());
                         String imgdir = imgMod.getOneUrl(pd.getProducto_id());  
                         pd.setProducto_ImgPortada("../producto/images/"+imgdir);

                         out.println("<tr class='gradeX'>");
                         out.println("<td><input type='number' min='0' value='0' id='id"+pd.getProducto_id()+"' name='id"+pd.getProducto_id()+"'></td>");
                         out.println("<td>"+pd.getProducto_id()+"</td>");
                         out.println("<td>"+pd.getProducto_serie()+"</td>");
                         out.println("<td>"+pd.getProducto_nombre()+"</td>");
                         out.println("<td>"+pd.getProducto_descripcion()+"</td>");
                         out.println("<td><img class='img-responsive' src='"+pd.getProducto_ImgPortada()+"'/></td>");
                         out.println("<td>"+pd.getFabricante_Nombre()+"</td>");
                         out.println("<td>"+pd.getCategoria_Nombre()+"</td>");
                         out.println("<td>"+pd.getTipoproducto_nombre()+"</td>");
                         out.println("<td><button onclick=\"nuevoDetalle("+pd.getProducto_id()+","+idPedido+",document.getElementById('id"+pd.getProducto_id()+"').value)\" class='btn btn-success btn-mini'>Guardar</button></td>");
                         out.println("</tr>");
                  
                  }
                  
   


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
<script src="../js/ajax.js"></script>


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
