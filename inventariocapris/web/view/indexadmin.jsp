<%-- 
    Document   : indexAdmin
    Created on : 10-13-2017, 11:55:06 PM
    Author     : Jose-PC
--%>
<%
   HttpSession sesion = request.getSession();
   String id=sesion.getAttribute("id").toString();
   String nombre=sesion.getAttribute("nombre").toString();
   String tipo=sesion.getAttribute("tipo").toString();
   System.out.println("TIPO EN JSP: "+tipo);
   if(Integer.parseInt(tipo)>2){
       response.sendRedirect("../");
   }
%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Dashboard </title>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link rel="stylesheet" href="css/bootstrap.min.css" />
<link rel="stylesheet" href="css/bootstrap-responsive.min.css" />
<link rel="stylesheet" href="css/fullcalendar.css" />
<link rel="stylesheet" href="css/matrix-style.css" />
<link rel="stylesheet" href="css/matrix-media.css" />
<link href="font-awesome/css/font-awesome.css" rel="stylesheet" />
<link rel="stylesheet" href="css/jquery.gritter.css" />
<link href='http://fonts.googleapis.com/css?family=Open+Sans:400,700,800' rel='stylesheet' type='text/css'>
</head>
<body>

<!--Header-part-->
<div id="header">
  <h1><a href="dashboard.html">Inventario</a></h1>
</div>
<!--close-Header-part--> 


<!--top-Header-menu-->
<div id="user-nav" class="navbar navbar-inverse">
  <ul class="nav">
      <li  class="dropdown" id="profile-messages" ><a title="" href="#" data-toggle="dropdown" data-target="#profile-messages" class="dropdown-toggle"><i class="icon icon-user"></i>  <span class="text"><%out.println(nombre);%>  </span><b class="caret"></b></a>
      <ul class="dropdown-menu">

        <li><a href="usuario/cambiarpassword.jsp"><i class="icon-check"></i>Cambiar contrase�a</a></li>
        <li class="divider"></li>
        <li><a href="../index.jsp"><i class="icon-key"></i> Cerrar Sesion</a></li>
      </ul>
    </li>

    <li class=""><a title="" href="../index.jsp"><i class="icon icon-share-alt"></i> <span class="text">Logout</span></a></li>
  </ul>
</div>
<!--close-top-Header-menu-->

<!--sidebar-menu-->
<div id="sidebar"><a href="#" class="visible-phone"><i class="icon icon-home"></i> Dashboard</a>
  <ul>
    <li class="active"><a href="indexadmin.jsp"><i class="icon icon-home"></i> <span>Dashboard</span></a> </li>
    <li class="submenu"> <a href="#"><i class="icon icon-th-list"></i> <span>Productos</span> </a>
      <ul>
       <li><a href="producto/lista.jsp">Buscador</a></li>
        <li><a href="producto/entrada/lista.jsp">Entradas</a></li>
        <li><a href="producto/salida/lista.jsp">Salidas</a></li>
      </ul>
    </li>
    <li class="submenu"> <a href="#"><i class="icon icon-truck"></i> <span>Fabricantes</span> </a>
      <ul>
        <li><a href="fabricante/lista.jsp">Listado</a></li>
        <li><a href="fabricante/nuevo.jsp">Nuevo</a></li>
      </ul>
    </li>
    <li class="submenu"> <a href="#"><i class="icon icon-group"></i> <span>Usuarios</span> </a>
      <ul>
        <li><a href="usuario/lista.jsp">Listado</a></li>
        <li><a href="usuario/nuevo.jsp">Nuevo</a></li>
      </ul>
    </li>
    <li class="submenu "> <a href="#"><i class="icon icon-hospital"></i> <span>Hospitales</span> </a>
      <ul>
        <li><a href="hospital/lista.jsp">Listado</a></li>
        <li><a href="hospital/nuevo.jsp">Nuevo</a></li>
      </ul>
    </li>

    <li class="submenu "> <a href="#"><i class="icon icon-folder-close"></i> <span>Equipos</span> </a>
      <ul>
        <li><a href="equipo/lista.jsp">Listado</a></li>
        <li><a href="equipo/nuevo.jsp">Nuevo</a></li>
      </ul>
    </li>
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    <li class="submenu "> <a href="#"><i class="icon icon-shopping-cart"></i> <span>pedido</span> </a>
      <ul>
        <li><a href="pedido/lista.jsp">Listado</a></li>
        <li><a href="pedido/nuevo.jsp">Nuevo</a></li>
      </ul>
    </li>
    
  </ul>
</div>
<!--sidebar-menu-->

<!--main-container-part-->
<div id="content">
<!--breadcrumbs-->
  <div id="content-header">
    <div id="breadcrumb"> <a href="indexadmin.jsp" title="Go to Home" class="tip-bottom"><i class="icon-home"></i> Home</a></div>
  </div>
<!--End-breadcrumbs-->

<!--Action boxes-->
  <div class="container-fluid">
    <div class="quick-actions_homepage">
      <ul class="quick-actions">
        <li class="bg_db span2"> <a href="indexadmin.jsp"> <i class="icon-dashboard"></i>  Inicio </a> </li>
        <li class="bg_dy span2"> <a href="producto/lista.jsp"> <i class="icon-th-list"></i>  Productos </a> </li>
        <li class="bg_lr span2"> <a href="fabricante/lista.jsp"> <i class="icon-truck"></i>  Fabricantes </a> </li>
        <li class="bg_lv span2"> <a href="usuario/lista.jsp"> <i class="icon-group"></i> Usuarios </a> </li>
        <li class="bg_ls span2"> <a href="hospital/lista.jsp"> <i class="icon-hospital"></i> Hospital </a> </li>
        <li class="bg_lg span2"> <a href="equipo/lista.jsp"> <i class="icon-folder-close"></i> Equipo </a> </li>
        <li class="bg_lo span2"> <a href="pedido/lista.jsp"> <i class="icon-shopping-cart"></i> Pedido </a> </li>
      </ul>
    </div>
<!--End-Action boxes-->    

<!--Chart-box-->    
    <div class="row-fluid">
      <div class="widget-box">
        <div class="widget-title bg_lg"><span class="icon"><i class="icon-print"></i></span>
          <h5>Reportes</h5>
        </div>
        <div class="widget-content" >
          <div class="row-fluid">
            <div class="span9">
                
            </div>
            <div class="span3">

            </div>
          </div>
        </div>
      </div>
        
              <div class="widget-box">
        <div class="widget-title bg_lg"><span class="icon"><i class="icon-shopping-cart"></i></span>
          <h5>Pedidos por llegar</h5>
        </div>
        <div class="widget-content" >
          <div class="row-fluid">
            <div class="span9">
                
            </div>
            <div class="span3">

            </div>
          </div>
        </div>
      </div>
    </div>
<!--End-Chart-box--> 

  </div>
</div>

<!--end-main-container-part-->

<!--Footer-part-->

<div class="row-fluid">
  <div id="footer" class="span12"> 2013 &copy; Matrix Admin. Brought to you by <a href="http://themedesigner.in">Themedesigner.in</a> </div>
</div>

<!--end-Footer-part-->

        <script src="js/jquery.min.js"></script>  
        <script src="js/matrix.login.js"></script> 
        
        <script src="js/excanvas.min.js"></script> 
        <script src="js/jquery.ui.custom.js"></script> 
        <script src="js/bootstrap.min.js"></script> 
        <script src="js/jquery.flot.min.js"></script> 
        <script src="js/jquery.flot.resize.min.js"></script> 
        <script src="js/jquery.peity.min.js"></script> 
        <script src="js/fullcalendar.min.js"></script> 
        <script src="js/matrix.js"></script> 
        <script src="js/matrix.dashboard.js"></script> 
        <script src="js/jquery.gritter.min.js"></script> 
        <script src="js/matrix.interface.js"></script> 
        <script src="js/matrix.chat.js"></script> 
        <script src="js/jquery.validate.js"></script> 
        <script src="js/matrix.form_validation.js"></script> 
        <script src="js/jquery.wizard.js"></script> 
        <script src="js/jquery.uniform.js"></script> 
        <script src="js/select2.min.js"></script> 
        <script src="js/matrix.popover.js"></script> 
        <script src="js/jquery.dataTables.min.js"></script> 
        <script src="js/matrix.tables.js"></script> 
        
        
    </body>

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

<script type="text/javascript">
  // This function is called from the pop-up menus to transfer to
  // a different page. Ignore if the value returned is a null string:
  function goPage (newURL) {

      // if url is empty, skip the menu dividers and reset the menu selection to default
      if (newURL != "") {
      
          // if url is "-", it is this page -- reset the menu:
          if (newURL == "-" ) {
              resetMenu();            
          } 
          // else, send page to designated URL            
          else {  
            document.location.href = newURL;
          }
      }
  }

// resets the menu selection upon entry to this page:
function resetMenu() {
   document.gomenu.selector.selectedIndex = 2;
}
</script>
</body>
</html>
