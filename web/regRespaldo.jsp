<%@page import="bd.DAO"%>
<%@page import="java.util.List"%>
<%@page import="modelo.Respaldo"%>
<%@page import="modelo.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    Usuario us = (Usuario) request.getSession().getAttribute("usuario");
    if (us == null) {
        response.sendRedirect("index.jsp");
    }
    
    DAO d = new DAO(); 
    List<Respaldo> respaldos = d.getRespaldos();
%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registrar respaldo</title>
        <link rel="stylesheet" href="css/bootstrap.min.css"/>
        <link rel="stylesheet" href="css/estilos.css"/>
    </head>
    <body>
        <div class="container" >
            <div class="row" >
                <div class="col-md-6" >
                    <h2>Respaldos Base de Datos</h2>
                    <table class="table table-bordered" style="margin-top: 30px;">
                        <tr>
                            <th>ID</th>
                            <th>Fecha</th>
                            <th>Hora</th>
                            <th>Restaurar</th>
                        </tr>
                        <%                            
                            for (Respaldo r : respaldos) {
                                out.println("<tr>");
                                out.println("<td>" + r.getId() + "</td>");
                                out.println("<td>" + r.getFecha() + "</td>");
                                out.println("<td>" + r.getHora() + "</td>");
                                out.println("<td><a href='confirmarRestauracion.jsp?d=" + r.getId() + "'>Restaurar</a></td>");
                                out.println("</tr>");
                            }
                        %>
                    </table>
                    <a href="" class="pull-right"><button class="btn btn-primary">Generar Respaldo</button></a>
                    <br><br><br>
                    <a href="menuAdministrador.jsp" class="pull-right"><button class="btn btn-danger">Atras</button></a>
                </div>
            </div>
        </div>
    </body>
</html>
