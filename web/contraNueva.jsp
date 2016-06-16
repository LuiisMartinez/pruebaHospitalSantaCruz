<%@page import="modelo.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    Usuario us = (Usuario) request.getSession().getAttribute("usuario");
    if (us == null) {
        response.sendRedirect("index.jsp");
    }
    
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="css/bootstrap.min.css"/>
        <link rel="stylesheet" href="css/estilos.css"/>
    </head>
    <body>
        <div class="container" >
            <div class="row" >
                <div class="col-md-6" >
                    <form action="cambiarContra.do" method="post">
                        <h4>Ingrese contraseña Nueva</h4><br/>
                        <input class="form-control" name="txtContra" placeholder="******* " type="password" required="required"/><br/>
                        <input class="btn btn-primary" name="btnConfrmarCon" type="submit" value="Confirmar contraseña"><br/><br/>
                    </form>
                </div>
            </div>
            <a class="btn btn-danger" role="button" href="menuAdministrador.jsp">Atras</a><br/>
        </div>
    </body>
</html>
