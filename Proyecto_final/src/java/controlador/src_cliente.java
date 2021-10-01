
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.Cliente;

/**
 * @author Luis Fernando Paxel
 */
public class src_cliente extends HttpServlet {

    Cliente cliente;
   private int genero;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
        //    out.println("<head>");
          //  out.println("<title>Cliente</title>");
            out.println("</head>");
            out.println("<body>");

            if ("Masculino".equals(request.getParameter("gen"))) {
                //   out.println("<h1>A seleccionado Hombre </h1>");
                genero = 1;

            } else {
                //   out.println("<h1>A seleccionado Mujer </h1>"); 
                genero = 0;
            }
            cliente = new Cliente(Integer.valueOf(request.getParameter("txt_id")), request.getParameter("txt_nombre"), request.getParameter("txt_apellido"), request.getParameter("txt_nit"), genero, request.getParameter("txt_telefono"), request.getParameter("txt_correo"), "", "", "");

           cliente.agregar();
        
            
            if ("agregar".equals(request.getParameter("btn_agregar"))) {

                if (cliente.agregar() > 0) {
                response.sendRedirect("index_cliente.jsp");
            //        out.println("<h1>Registro Ingresado Correctamente :vv</h1>");
            //        out.println("<a href ='index_cliente.jsp' > Regresar </a>");
                } else {
              //      out.println("<h1>Error carnal</h1>");
              //      out.println("<a href ='index_cliente.jsp '> Regresar </a>");
                }
            }
   /*
            if ("modificar".equals(request.getParameter("btn_modificar"))) {

                if (cliente.modificar() > 0) {
                    out.println("<h1>Registro Modificado Correctamente :vv</h1>");
                    out.println("<a href ='index_cliente.jsp '> Regresar </a>");
                } else {
                    out.println("<h1>Error carnal</h1>");
                    out.println("<a href ='index_cliente.jsp '> Regresar </a>");
                }
            }

            if("eliminar".equals(request.getParameter("btn_eliminar"))){
                
            if (cliente.eliminar() > 0) {
                out.println("<h1>Registro eliminado Correctamente :vv</h1>");
                out.println("<a href ='index_cliente.jsp '> Regresar </a>");
            } else {
                out.println("<h1>Error carnal</h1>");
                out.println("<a href ='index_cliente.jsp '> Regresar </a>");
            }
            }
*/
        
            out.println("</body>");
            out.println("</html>");
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

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
