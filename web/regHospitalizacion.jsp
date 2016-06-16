<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="bd.DAO"%>
<%@page import="modelo.StaticPa"%>
<%@page import="modelo.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    Usuario us = (Usuario) request.getSession().getAttribute("usuario");
    if (us == null) {
        response.sendRedirect("index.jsp");
    }
    String rutFin = "";
    String rut = request.getParameter("m");
    
    if(rut != null){
        rutFin = rut;
    }else{
        rutFin = StaticPa.rutpaciente;
    }
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registrar Hospitalizacion</title>
        <link rel="stylesheet" href="css/bootstrap.min.css"/>
        <link rel="stylesheet" href="css/estilos.css"/>
    </head>
    <body>
        <div class="container" >
            <div class="row" >
                <h2>Secretaria: <%out.println(us.nombre+" "+us.apellidos);%></h2> 
                <div class="col-md-6" >
                    <form action="crearHospitalizacion.do" method="post">
                        <h4>Crear Personal</h4><br/>
                        <input class="form-control" name="txtRut" type="text" value="<%out.println(rutFin);%>" readonly/><br/>
                        Motivo: <textarea class="form-control" name="txtMotivo"></textarea><br/>
                        <input class="form-control" name="txtDiasHos" placeholder="Dias Hospitalizacion: " type="number" required="required"/><br/>
                        <select class="form-control" name="cboDoctor">
                                <%
                                    DAO d = new DAO();
                                    List<Usuario> usu = new ArrayList<>();
                                    usu = d.getUsuarios();
                                    for (Usuario u : usu) {
                                        if(u.getIdTipoUsuario() == 3){
                                            out.println("<option value='" + u.getId() + "'>" + u.getNombre() +" "+u.getApellidos()+ "</option>");
                                        }
                                    }
                                %>
                            </select><br/>
                        <input class="btn btn-primary" name="btnCrearPaciente" type="submit" value="Crear Hospitalizacion"><br/><br/>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
