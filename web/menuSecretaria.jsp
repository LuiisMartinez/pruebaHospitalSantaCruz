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
        <title>Menu Secretaria</title>
        <link rel="stylesheet" href="css/bootstrap.min.css"/>
        <link rel="stylesheet" href="css/estilos.css"/>
    </head>
    <body>
        <div class="container" >
            <div class="row" >
                <h2>Secretaria: <%out.println(us.nombre+" "+us.apellidos);%></h2> 
                <div class="col-md-6" >
                    <form action="crearPaciente.do" method="post">
                        <h4>Crear paciente</h4><br/>
                        <input class="form-control" name="txtRut" placeholder="Rut: " type="text" required="required"/><br/>
                        <input class="form-control" name="txtNombre" placeholder="Nombre: " type="text" required="required"/><br/>
                        <input class="form-control" name="txtApellido" placeholder="Apellido: " type="text" required="required"/><br/>
                        Fecha de nacimiento.
                        <input class="form-control" name="txtFechaNaci" type="date" required="required"/><br/>
                        <input class="form-control" name="txtDireccion" placeholder="Direccion: " type="text" required="required"/><br/>
                        
                        <input class="btn btn-primary" name="btnCrearPaciente" type="submit" value="Crear Paciente"><br/><br/>
                        <a class="btn btn-danger" role="button" href="menuSecretaria.jsp">Limpiar</a>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
