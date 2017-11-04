<%-- 
    Document   : modificar
    Created on : 11-04-2017, 03:25:28 PM
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
%>
<%@page import="java.sql.ResultSet"%>
<%@page import="sv.com.dkcarpis.model.Conexion"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Usuario | Nuevo</title>
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




<!--main-container-part-->
<div id="content">
<!--breadcrumbs-->
  <div id="content-header">
    <div id="breadcrumb"> 
        <a href="../indexadmin.jsp" title="Ir a Inicio" class="tip-bottom"><i class="icon-home"></i> Dashboard</a>
        <a href="#" title="" class="tip-bottom"><i class="icon-group"></i>Usuarios</a>
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
         <div class="widget-box">
          <div class="widget-title"> <span class="icon"><i class="icon-group"></i></span>
            <h5>Usuarios</h5>
          </div>
          <div class="widget-content nopadding">
             <form class="form-horizontal" method="post" action="/inventariocapris/usuarioController" name="basic_validate" id="basic_validate" novalidate="novalidate">
              <div class="control-group">
                <label class="control-label">Nombre</label>
                <div class="controls">
                  <input type="text" class="required" name="nombre" value="<%out.print(request.getParameter("nombre"));%>" class="required" id="required">
                </div>
              </div>
              <div class="control-group">
              <label class="control-label">Privilegios</label>
              <div class="controls">
                <select name="tipo">
                  <option value="<%out.print(request.getParameter("tipo"));%>"><%out.print(request.getParameter("tipoNombre"));%></option>
                  <option value="2">Administrador</option>
                  <option value="3">Ingeniero</option> 
                </select>
              </div>
            </div>
              <div class="control-group">
                <label class="control-label">Usuario</label>
                <div class="controls">
                    <input type="text" class="required" value="<%out.print(request.getParameter("usuario"));%>" name="usuario" id="required">
                </div>
              </div>
              <div class="control-group">
                <label class="control-label">Password</label>
                <div class="controls">
                     <input type="password" name="password" value="<%out.print(request.getParameter("password"));%>" class="required" id="required">
                </div>
              </div>   
              <div class="form-actions">
                  <input type="hidden" name="id" value="<%out.print(request.getParameter("id"));%>" />
                <input type="hidden" name="metodo" value="modificar"/>
                <input type="submit" value="Modificar" class="btn btn-success">
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
