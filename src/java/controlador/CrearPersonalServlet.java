package controlador;

import bd.DAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.TipoUsuario;
import modelo.Usuario;

@WebServlet(name = "CrearPersonalServlet", urlPatterns = {"/crearPersonal.do"})
public class CrearPersonalServlet extends HttpServlet {
    String fiinal = "";
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            String nombre, rut, apellido, tipoPersonal, tipoTurno, email;
            int tipoPersonalfin, tipoTurnoFin;
            
            rut = request.getParameter("txtRut");
            nombre = request.getParameter("txtNombre");
            apellido = request.getParameter("txtApellido");
            Date fechaNa = Date.valueOf(request.getParameter("txtFechaNaci"));
            email = request.getParameter("txtEmail");
            
            tipoPersonal = request.getParameter("cboTipoPersonal");
            tipoTurno = request.getParameter("cboTipoTurno");
            
            tipoTurnoFin = Integer.parseInt(tipoTurno);
            tipoPersonalfin = Integer.parseInt(tipoPersonal);
            
            generarClave();
            
            try {
                DAO d = new DAO();
                
                Usuario u = new Usuario(1, rut, nombre, apellido, fechaNa, email, fiinal, tipoPersonalfin, tipoTurnoFin);
                
                d.crearUsuario(u);
                
                response.sendRedirect("menuAdministrador.jsp?m="+fiinal+"");
                
            } catch (SQLException ex) {
                Logger.getLogger(CrearPersonalServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private void generarClave() {
        int num1 = 65;
        int num2 = 126;

        char c = 0;
        for (int i = 1; i <= 6; i++) {
            int numAleatorio = (int) Math.floor(Math.random() * (num2 - num1) + num1);

            if (i == 1) {
                fiinal = Integer.toString(numAleatorio);
            }
            fiinal = fiinal + (char) numAleatorio;
            c++;
        }
    }

}
