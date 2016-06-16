<%@page import="bd.DAO"%>
<%@page import="modelo.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    Usuario us = (Usuario) request.getSession().getAttribute("usuario");
    if (us == null) {
        response.sendRedirect("index.jsp");
    }
    String contr = request.getParameter("txtContra");
    DAO d = new DAO();
    
    if(contr != null){
        Usuario usu = d.getUsuarioRutClave(us.rut, contr);
        if(usu != null){
            response.sendRedirect("contraNueva.jsp");
        }else{
            response.sendRedirect("confirmarContra.jsp?r=1");
        }
    }
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cambiar contraseña</title>
        <link rel="stylesheet" href="css/bootstrap.min.css"/>
        <link rel="stylesheet" href="css/estilos.css"/>
    </head>
    <body>
        <div class="container" >
            <div class="row" >
                <div class="col-md-6" >
                    <form action="confirmarContra.jsp" method="post">
                        <h4>Ingrese contraseña actual</h4><br/>
                        <input class="form-control" name="txtContra" placeholder="******* " type="password" required="required"/><br/>
                        <input class="btn btn-primary" name="btnConfrmarCon" type="submit" value="Confirmar contraseña"><br/><br/>
                    </form>
                </div>
            </div>
            <a class="btn btn-danger" role="button" href="menuAdministrador.jsp">Atras</a><br/>

        <div style="margin-top: 60px; ">
            <%
                String m = request.getParameter("r");
                if (m != null) {
                    out.println("<div class='alert alert-success' role='alert'>La clave ingresada es incorrecta</div>");
                }
            %>
        </div>
        </div>
        
    </body>
</html>
