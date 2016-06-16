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
        <title>Crear Personal</title>
        <link rel="stylesheet" href="css/bootstrap.min.css"/>
        <link rel="stylesheet" href="css/estilos.css"/>
    </head>
    <body>
        <div class="container" >
            <div class="row" >
                <div class="col-md-1"></div>
                <div class="col-md-6" >
                    <h2>Administrador: <%out.println(us.nombre + " " + us.apellidos);%></h2>
                    <form action="crearPersonal.do" method="post">
                        <h4>Crear Personal</h4><br/>
                        <input class="form-control" name="txtRut" placeholder="Rut: " type="text" required="required"/><br/>
                        <input class="form-control" name="txtNombre" placeholder="Nombre: " type="text" required="required"/><br/>
                        <input class="form-control" name="txtApellido" placeholder="Apellido: " type="text" required="required"/><br/>
                        Fecha de nacimiento.
                        <input class="form-control" name="txtFechaNaci" type="date" required="required"/><br/>
                        <input class="form-control" name="txtEmail" placeholder="Email: " type="email" required="required"/><br/>
                        Estado: <select class="form-control" name="cboTipoPersonal">
                            <option value=1>Administrador</option>
                            <option value=2>Secretario</option>
                            <option value=3>Doctor</option>
                            <option value=4>Enfermera</option>
                        </select><br/>
                        Tipo Usuario: <select class="form-control" name="cboTipoTurno">
                            <option value=1>Mañana "7Hrs a 15Hrs"</option>
                            <option value=2>Tarde "15Hrs a 23Hrs"</option>
                            <option value=2>Noche "23Hrs a 7Hrs"</option>
                            <option value=2>Horario completo "admin"</option>
                        </select><br/>
                        <input class="btn btn-primary" name="btnCrearPersonal" type="submit" value="Crear Personal"><br/><br/>
                        <a class="btn btn-danger" role="button" href="menuAdministrador.jsp">Limpiar</a>
                    </form>
                    <div style="margin-top: 60px; ">
                        <%
                            String m = request.getParameter("m");
                            if (m != null) {
                                out.println("<div class='alert alert-success' role='alert'>La clave del usuario creado es : " + m + "</div>");
                            }
                        %>
                    </div>
                </div>
                <div class="col-md-3"><br/><br/><br/><br/>
                    <a class="btn btn-danger" role="button" href="confirmarContra.jsp">Cambiar contraseña</a><br/><br/>
                    <a class="btn btn-danger" role="button" href="editarUsuarios.jsp">Editar Usuarios</a><br/><br/>
                    <a class="btn btn-danger" role="button" href="regRespaldo.jsp">Respaldos</a><br/><br/>
                    <a class="btn btn-danger" role="button" href="cerrarSesion.do">Cerrar sesión</a><br/>
                    <div style="margin-top: 60px; ">
                        <%
                            String rr = request.getParameter("rr");
                            if (rr != null) {
                                out.println("<div class='alert alert-success' role='alert'>La clave se a cambiado correctamente</div>");
                            }
                        %>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
