<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<!DOCTYPE html>
<%
HttpSession sesion = request.getSession();
                    sesion.setAttribute("id",null);
                    sesion.setAttribute("nombre", null);
                    sesion.setAttribute("tipo", null);
session.invalidate();
System.out.println("CHECKOUT");
%>
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
        <div id="loginbox">            
            <form id="loginform" method="post" class="form-vertical" action="/inventariocapris/usuarioController">
				 <div class="control-group normal_text"> <h3><img src="view/img/logoblancodk.png" alt="Logo" /></h3></div>
                <div class="control-group">
                    <div class="controls">
                        <div class="main_input_box">
                            <span class="add-on bg_lg"><i class="icon-user"> </i></span><input type="text" name="username" placeholder="Username" />
                        </div>
                    </div>
                </div>
                <div class="control-group">
                    <div class="controls">
                        <div class="main_input_box">
                            <span class="add-on bg_ly"><i class="icon-lock"></i></span><input type="password" name="password" placeholder="Password" />
                        </div>
                    </div>
                </div>
                <div class="form-actions">
                    <center>
                    <span class=""><input type="submit" class="btn btn-success" value="Login" /> </span>
                    <input type="hidden" value="login" name="metodo"/>
                    </center>
                </div>
            </form>

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
