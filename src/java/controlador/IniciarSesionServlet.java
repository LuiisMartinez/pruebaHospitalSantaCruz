package controlador;

import bd.DAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Usuario;

@WebServlet(name = "IniciarSesionServlet", urlPatterns = {"/iniciarSesion.do"})
public class IniciarSesionServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            String rut = request.getParameter("txtRut");
            String pass = request.getParameter("txtPass");
            
            try {
            DAO d = new DAO();
            Usuario usu = d.getUsuarioRutClave(rut, pass);
            if (usu != null) {
                if(usu.getIdTipoUsuario() == 1){//administrador
                    request.getSession().setAttribute("usuario", usu);
                    response.sendRedirect("menuAdministrador.jsp");
                    
                }else if(usu.getIdTipoUsuario() == 2){//Secretario
                    request.getSession().setAttribute("usuario", usu);
                    
                    
                }else if(usu.getIdTipoUsuario() == 3){//Doctor
                    request.getSession().setAttribute("usuario", usu);
                    
                    
                }else if(usu.getIdTipoUsuario() == 4){//Enfermera
                    request.getSession().setAttribute("usuario", usu);
                    
                    
                }
            } else {
                response.sendRedirect("index.jsp?m=1");
            }

        } catch (Exception ex) {
            Logger.getLogger(IniciarSesionServlet.class.getName()).log(Level.SEVERE, null, ex);
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
