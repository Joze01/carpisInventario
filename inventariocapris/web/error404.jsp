<%-- 
    Document   : 404
    Created on : 10-31-2017, 02:22:35 PM
    Author     : Jose-PC
--%>

<!DOCTYPE html>

<html lang="en">
    
<head>
        <title>Matrix Admin</title><meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
		<link rel="stylesheet" href="view/css/bootstrap.min.css" />
		<link rel="stylesheet" href="view/css/bootstrap-responsive.min.css" />
                <link rel="stylesheet" href="view/css/matrix-login.css" />
                <link rel="stylesheet" href="view/css/fullcalendar.css" />
                <link rel="stylesheet" href="view/css/matrix-style.css" />
                <link rel="stylesheet" href="view/css/matrix-media.css" />
                <link rel="stylesheet" href="view/css/jquery.gritter.css" />
                <link href='http://fonts.googleapis.com/css?family=Open+Sans:400,700,800' rel='stylesheet' type='text/css'>
                <link href="view/font-awesome/css/font-awesome.css" rel="stylesheet" />
    </head>
    <body>
        <div class="error_ex">
              <h1>404</h1>
              <h3>Opps, La pagina que buscas no existe.</h3>
              <p>Por seguridad tu session se ha eliminado, debes regrar al login</p>
              <a class="btn btn-warning btn-big" href="index.jsp">Regresar</a>
        </div>
        
        <script src="view/js/jquery.min.js"></script>  
        <script src="view/js/matrix.login.js"></script> 
        
        <script src="view/js/excanvas.min.js"></script> 
        <script src="view/js/jquery.ui.custom.js"></script> 
        <script src="view/js/bootstrap.min.js"></script> 
        <script src="view/js/jquery.flot.min.js"></script> 
        <script src="view/js/jquery.flot.resize.min.js"></script> 
        <script src="view/js/jquery.peity.min.js"></script> 
        <script src="view/js/fullcalendar.min.js"></script> 
        <script src="view/js/matrix.js"></script> 
        <script src="view/js/matrix.dashboard.js"></script> 
        <script src="view/js/jquery.gritter.min.js"></script> 
        <script src="view/js/matrix.interface.js"></script> 
        <script src="view/js/matrix.chat.js"></script> 
        <script src="view/js/jquery.validate.js"></script> 
        <script src="view/js/matrix.form_validation.js"></script> 
        <script src="view/js/jquery.wizard.js"></script> 
        <script src="view/js/jquery.uniform.js"></script> 
        <script src="view/js/select2.min.js"></script> 
        <script src="view/js/matrix.popover.js"></script> 
        <script src="view/js/jquery.dataTables.min.js"></script> 
        <script src="view/js/matrix.tables.js"></script> 
        
        
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
</html>
