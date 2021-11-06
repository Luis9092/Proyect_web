/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Ventas_detalle;

/**
 *
 * @author Luis Fernando Paxel
 */
public class control_detalles extends HttpServlet {

    Ventas_detalle detalle = new Ventas_detalle();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet control_detalles</title>");
            out.println("</head>");
            out.println("<body>");

            if ("eliminar2".equals(request.getParameter("btn_eliminar2"))) {
                int Id_venta2 = Integer.valueOf(request.getParameter("txt_id_detalle"));
                detalle.eliminar_detalle(Id_venta2);
                response.sendRedirect("index_ventas.jsp");

            }

            detalle = new Ventas_detalle(0, Integer.valueOf(request.getParameter("txt_id_detalle")), Integer.valueOf(request.getParameter("drop_prod")), request.getParameter("cantidad_detalle"), 0);

            if ("modificar_venta".equals(request.getParameter("btn_modificar_venta"))) {
                if (detalle.modificando_cantidad() > 0) {
                    if (detalle.modificar() > 0) {

                        response.sendRedirect("index_ventas.jsp");
                    } else {
                        //String imagen ="https://i.blogs.es/4329e4/error500/450_1000.png";
                        out.println("<p>Error en el modificar en general</p>");
                        //response.sendRedirect("Tablas\\producto.jsp");
                        //out.println("<img src="+imagen);
                    }
                } else {
                    String imagen = "https://c.tenor.com/2CoAwNOjrDYAAAAC/aqua-konosuba.gif";
                    out.println("<p>Error, hubo un error al modificar la cantidad</p>");
                    out.println("<img src=" + imagen);
                }
            }

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
