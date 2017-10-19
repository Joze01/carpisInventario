<%-- 
    Document   : nuevo
    Created on : 10-15-2017, 04:59:46 PM
    Author     : Jose-PC
--%>
<%@page import="java.util.ArrayList"%>
<%@page import="sv.com.dkcapris.beans.ProductoBean"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="sv.com.dkcarpis.model.Conexion"%>
<%@page import="sv.com.dkcarpis.model.ProductoModel"%>
<%@page import="sv.com.dkcarpis.model.ImageModel"%>
<%@page import="sv.com.dkcarpis.model.EntradaModel"%>
<%@page import="sv.com.dkcapris.beans.EntradaBean"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Producto | Lista</title>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link rel="stylesheet" href="../../css/bootstrap.min.css" />
<link rel="stylesheet" href="../../css/bootstrap-responsive.min.css" />
<link rel="stylesheet" href="../../css/fullcalendar.css" />
<link rel="stylesheet" href="../../css/matrix-style.css" />
<link rel="stylesheet" href="../../css/matrix-media.css" />
<link href="../../font-awesome/css/font-awesome.css" rel="stylesheet" />
<link rel="stylesheet" href="../../css/jquery.gritter.css" />
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
    <li  class="dropdown" id="profile-messages" ><a title="" href="#" data-toggle="dropdown" data-target="#profile-messages" class="dropdown-toggle"><i class="icon icon-user"></i>  <span class="text">Welcome User</span><b class="caret"></b></a>
      <ul class="dropdown-menu">

        <li><a href="#"><i class="icon-check"></i>Cambiar contraseña</a></li>
        <li class="divider"></li>
        <li><a href="login.html"><i class="icon-key"></i> Cerrar Sesion</a></li>
      </ul>
    </li>

    <li class=""><a title="" href="login.html"><i class="icon icon-share-alt"></i> <span class="text">Logout</span></a></li>
  </ul>
</div>
<!--close-top-Header-menu-->

<!--sidebar-menu-->
<div id="sidebar"><a href="#" class="visible-phone"><i class="icon icon-home"></i> Dashboard</a>
  <ul>
    <li class=""><a href="../../indexadmin.jsp"><i class="icon icon-home"></i> <span>Dashboard</span></a> </li>
    <li class="submenu active"> <a href="#"><i class="icon icon-th-list"></i> <span>Productos</span> </a>
      <ul>
        <li><a href="../lista.jsp">Buscador</a></li>
        <li><a href="lista.jsp">Entradas</a></li>
        <li><a href="../salida/lista.jsp">Salidas</a></li>
      </ul>
    </li>
    <li class="submenu"> <a href="#"><i class="icon icon-truck"></i> <span>Fabricantes</span> </a>
      <ul>
          <li><a href="../../fabricante/lista.jsp">Listado</a></li>
        <li><a href="../../fabricante/nuevo.jsp">Nuevo</a></li>
      </ul>
    </li>
    <li class="submenu"> <a href="#"><i class="icon icon-group"></i> <span>Usuarios</span> </a>
      <ul>
        <li><a href="../../usuario/lista.jsp">Listado</a></li>
        <li><a href="../../usuario/nuevo.jsp">Nuevo</a></li>
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
        <a href="../lista.jsp" title="" class="tip-bottom"><i class="icon-list"></i>Productos</a>
        <a href="#" title="" class="tip-bottom"><i class="icon-signin"></i>Entradas</a>
    </div>
  </div>
<!--End-breadcrumbs-->

   
<!--Action boxes-->
  <div class="container-fluid">
    <div class="quick-actions_homepage">
      <ul class="quick-actions">
        <li class="bg_lo"> <a href="../lista.jsp"> <i class="icon-search"></i> Listado de Producto </a> </li>
        <li class="bg_lg"> <a href="nuevo.jsp"> <i class="icon-plus"></i> Nueva Entrada </a> </li>
      </ul>
    </div>
<!--End-Action boxes-->    
<!--Chart-box-->    
         <div class="widget-box">
          <div class="widget-title"> <span class="icon"><i class="icon-signin"></i></span>
            <h5>Nueva Entrada</h5>
          </div>
          <div class="widget-content nopadding">
                
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

<script src="../../js/jquery.min.js"></script> 
<script src="../../js/jquery.ui.custom.js"></script> 
<script src="../../js/bootstrap.min.js"></script> 
<script src="../../js/jquery.uniform.js"></script> 
<script src="../../js/select2.min.js"></script> 
<script src="../../js/jquery.dataTables.min.js"></script> 
<script src="../../js/matrix.js"></script> 
<script src="../../js/matrix.tables.js"></script>
</script>
</body>
</html>
