/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Compras;
import modelo.Detalle_compra;

/**
 *
 * @author Luis Fernando Paxel
 */
public class control_compras extends HttpServlet {

    Compras compras = new Compras();
    Detalle_compra detalle = new Detalle_compra();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, InterruptedException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet control_compras</title>");
            out.println("</head>");
            out.println("<body>");

            String accion = request.getParameter("accion");
            String menu = request.getParameter("menu");

            if (menu.equals("Compras")) {

                switch (accion) {
                    case "modificar":
                        compras = new Compras(Integer.valueOf(request.getParameter("txt_id")), Integer.valueOf(request.getParameter("txt_orden")), Integer.valueOf(request.getParameter("drop_proveedor")), request.getParameter("txt_forden"), request.getParameter("txt_fni"));
                        compras.modificar();
                        Thread.sleep(2000);
                        response.sendRedirect("index.jsp");
                        break;

                    case "eliminar":
                        int Id_venta = Integer.valueOf(request.getParameter("txt_id"));
                        compras.eliminar_detalles(Id_venta);
                        compras.eliminar_compra(Id_venta);
                        Thread.sleep(2000);
                        response.sendRedirect("index.jsp");

                        break;
                }
            }

            if (menu.equals("Compras_detalle")) {

                switch (accion) {

                    case "eliminar2":

                        int Id_venta2 = Integer.valueOf(request.getParameter("txt_id_detalle"));
                        detalle.eliminar_detalle(Id_venta2);
                        Thread.sleep(2000);
                        response.sendRedirect("index.jsp");

                        break;

                    case "modificar2":
                        detalle = new Detalle_compra(Integer.valueOf(request.getParameter("txt_id_detalle")), Integer.valueOf(request.getParameter("No_compra")), 0, 0, Integer.valueOf(request.getParameter("drop_prod")), Integer.valueOf(request.getParameter("cantidad_detalle")), 0.0, "", 0.0);

                        if (detalle.modificando_cantidades() > 0) {

                            if (detalle.modificar() > 0) {
                                response.sendRedirect("index.jsp");
                            } else {
                                out.print("<p>ERROR AL MODIFICAR COMPRA_DETALLE </p>");
                            }
                        } else {
                            String imagen = "https://c.tenor.com/2CoAwNOjrDYAAAAC/aqua-konosuba.gif";
                            out.println("<p>Error, hubo un error al modificar la cantidad</p>");
                            out.println("<img src=" + imagen);
                        }

                        break;
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
        try {
            processRequest(request, response);
        } catch (InterruptedException ex) {
            Logger.getLogger(control_compras.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (InterruptedException ex) {
            Logger.getLogger(control_compras.class.getName()).log(Level.SEVERE, null, ex);
        }
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
