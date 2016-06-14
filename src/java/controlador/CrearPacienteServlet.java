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
import modelo.Paciente;
import modelo.StaticPa;

@WebServlet(name = "CrearPacienteServlet", urlPatterns = {"/crearPaciente.do"})
public class CrearPacienteServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            String nombre, rut, apellido, tipoPersonal, tipoTurno, direccion;
            
            rut = request.getParameter("txtRut");
            nombre = request.getParameter("txtNombre");
            apellido = request.getParameter("txtApellido");
            Date fechaNa = Date.valueOf(request.getParameter("txtFechaNaci"));
            direccion = request.getParameter("txtDireccion");
            
            try {
                DAO d = new DAO();
                
                Paciente p = new Paciente(1, rut, nombre, apellido, fechaNa, direccion);
                
                d.crearPaciente(p);
                StaticPa.rutpaciente = rut;
                
                response.sendRedirect("regHospitalizacion.jsp?m="+rut+"");
                
                
            } catch (SQLException ex) {
                Logger.getLogger(CrearPacienteServlet.class.getName()).log(Level.SEVERE, null, ex);
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

}
