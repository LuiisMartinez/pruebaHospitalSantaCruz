<%@page import="modelo.TipoUsuario"%>
<%@page import="java.util.List"%>
<%@page import="bd.DAO"%>
<%@page import="modelo.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    Usuario us = (Usuario) request.getSession().getAttribute("usuario");
    if (us == null) {
        response.sendRedirect("index.jsp");
    }
    DAO d = new DAO();
    List<Usuario> liUsu = d.getUsuarios();
    
    
    if(request.getParameter("txtBuscar") != null){
        if(!request.getParameter("txtBuscar").equalsIgnoreCase("")){
            liUsu = d.getUsuarioLike(request.getParameter("txtBuscar"));
        }
    }
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar Usuarios</title>
        <link rel="stylesheet" href="css/bootstrap.min.css"/>
        <link rel="stylesheet" href="css/estilos.css"/>
    </head>
    <body>
        <div class="container" >
            <div class="row" >
                <div class="col-md-11" >
                    <h2>Buscar Usuario</h2>
                    <div class="col-md-7" >
                    <form action="editarUsuarios.jsp" method="POST">
                        <label for="producto">Buscar:</label>
                        <div class="form-group">
                            <input name="txtBuscar" type="text" class="form-control" placeholder="Buscar">
                        </div>
                        <a class="btn btn-primary" role="button" href="editarUsuarios.jsp">Ver todo</a>
                        <button type="submit" class="btn btn-default pull-right">Buscar</button>
                    </form>
                        </div>
                    <br><br><br><br><br><br>
                    <h2>Lista de Usuarios</h2>
                    <table class="table table-bordered" style="margin-top: 30px;">
                        <tr>
                            <th>RUT</th>
                            <th>NOMBRE</th>
                            <th>EMAIL</th>
                            <th>TIPO USUARIO</th>
                            <th>Editar</th>
                        </tr>
                        <%
                            for (Usuario p : liUsu) {

                                out.println("<tr>");
                                out.println("<td>" + p.getRut() + "</td>");
                                out.println("<td>" + p.getNombre() + " " + p.getApellidos() + "</td>");
                                out.println("<td>" + p.getEmail() + "</td>");
                                TipoUsuario tp = d.getTipoUsuarioPorId(p.getIdTipoUsuario());
                                out.println("<td>" + tp.nombre + "</td>");
                                out.println("<td><a href='confirmarEliminar.jsp?e=" + p.getId() + "'>Editar</a></td>");
                                out.println("</tr>");

                            }
                        %>
                    </table>
                    <a class="btn btn-danger" role="button" href="menuAdministrador.jsp">Volver</a><br/><br/><br/>
                </div>
            </div>
        </div>
    </body>
</html>
