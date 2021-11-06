package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import modelo.Puesto;
import java.util.HashMap;
import javax.swing.table.DefaultTableModel;

public final class index_005fpuesto_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Puestos</title>\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css\">\n");
      out.write("        <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js\"></script>\n");
      out.write("        <script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js\"></script>\n");
      out.write("        <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js\"></script>\n");
      out.write("\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/estilo_puesto.css\">\n");
      out.write("        <link href=\"css/estilo_menu.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div id=\"header\">\n");
      out.write("            <ul class=\"nav\">\n");
      out.write("                <img src=\"imagenes/onitech.png\" alt=\"\"/>\n");
      out.write("                <li><a href=\"index_inicio_principal.jsp\">Inicio</a></li>\n");
      out.write("                <li><a href=\"index_producto.jsp\">Productos</a>\n");
      out.write("                    <ul>\n");
      out.write("                        <li><a href=\"index_marcas.jsp\">Marcas</a></li>\n");
      out.write("                    </ul>\n");
      out.write("                </li>\n");
      out.write("                <li><a href=\"index_ventas.jsp\">Ventas</a>\n");
      out.write("                    <ul>\n");
      out.write("                        <li><a href=\"index_cliente.jsp\">Clientes</a></li>\n");
      out.write("                        <li><a href=\"index_empleado.jsp\">Empleados</a>\n");
      out.write("                            <ul>\n");
      out.write("                                <li><a href=\"index_puesto.jsp\">Puestos</a></li>\n");
      out.write("                            </ul>\n");
      out.write("                        </li>\n");
      out.write("                    </ul>\n");
      out.write("                </li>\n");
      out.write("                <li><a href=\"index_compras.jsp\">Compras</a>\n");
      out.write("                    <ul>\n");
      out.write("                        <li><a href=\"index_prooveedores.jsp\">Proveedores</a></li>\n");
      out.write("                    </ul>\n");
      out.write("                </li>\n");
      out.write("                <li><a href=\"Menu_reportes.jsp\">Reportes</a></li>\n");
      out.write("                <li >\n");
      out.write("                    ");

       response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
       if(session.getAttribute("txtUsuario")==null&&session.getAttribute("nombre")==null){
           response.sendRedirect("index.html");
       }
                    
      out.write("\n");
      out.write("                    <a > \n");
      out.write("                        <form action=\"sr_cerrar_sesion\" >\n");
      out.write("                            <input class=\"cerrar_sesion\" type=\"submit\"  value=\"Cerrar Sesion\">\n");
      out.write("                        </form>\n");
      out.write("                    </a>\n");
      out.write("\n");
      out.write("                </li>\n");
      out.write("            </ul>\n");
      out.write("        </div>\n");
      out.write("        <br>\n");
      out.write("        <button type=\"button\" class=\" btn_form\" data-toggle=\"modal\" data-target=\"#modal_puesto\" onclick=\"Limpiar()\">\n");
      out.write("            Puestos\n");
      out.write("        </button>\n");
      out.write("\n");
      out.write("\n");
      out.write("        <div class=\"container p-3 my-3  text-black\">\n");
      out.write("            <div class=\"modal fade \" data-backdrop=\"static\" data-keyboard=\"false\" tabindex=\"-1\" id=\"modal_puesto\" role=\"dialog\">\n");
      out.write("                <div class=\"modal-dialog modal-xl \">\n");
      out.write("                    <div class=\"modal-content formula_modal\">\n");
      out.write("                        <div class=\"modal-body \">\n");
      out.write("                            <form  action=\"index_empleado.jsp\">\n");
      out.write("                                <input class=\"enlaze_empleado\" type=\"submit\" value=\"Empleados\" />\n");
      out.write("                            </form>\n");
      out.write("\n");
      out.write("                            <form  action=\"src_puesto\" name=\"formulario\" method=\"post\" class=\"form-group\" id=\"formulario\" >\n");
      out.write("\n");
      out.write("\n");
      out.write("                                <div class=\"formulario__grupo\" id=\"grupo_txt_id\">\n");
      out.write("                                    <label for=\"lbl_id\" class=\"formulario__label\">ID:</label>\n");
      out.write("                                    <div class=\"formulario__grupo-input\">\n");
      out.write("                                        <input type=\"text\" class=\"formulario__input\" name=\"txt_id\" id=\"txt_id\" value=\"0\" readonly>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("\n");
      out.write("                                <div class=\"formulario__grupo\" id=\"grupo__txt_puesto\">\n");
      out.write("                                    <label for=\"lbl_puesto\" class=\"formulario__label\">Puesto: </label>\n");
      out.write("                                    <div class=\"formulario__grupo-input\">\n");
      out.write("                                        <input type=\"text\" class=\"formulario__input\" name=\"txt_puesto\" id=\"txt_puesto\" value=\"\" placeholder=\"puesto\" pattern=\"[A-Z]{1}[a-zA-ZÀ-ÿ\\s]{3,40}\"   required>\n");
      out.write("                                        <i class=\"formulario__validacion-estado fas fa-times-circle\"></i>\n");
      out.write("                                    </div>\n");
      out.write("                                    <p class=\"formulario__input-error\">Solo estan permitido letras.</p>\n");
      out.write("                                </div>\n");
      out.write("                                <br>\n");
      out.write("                                <center>    \n");
      out.write("                                    <button  name=\"btn_agregar\" id=\"btn_agregar\" value=\"agregar\"    class=\"formulario__btn \" >Agregar</button>\n");
      out.write("                                    <button  name=\"btn_modificar\" id=\"btn_modificar\" value=\"modificar\" class=\"formulario__btn1\" >Modificar</button>\n");
      out.write("                                    <button  name=\"btn_2\" id=\"btn_2\" onclick=\"return confirmar2();\" value=\"eliminar\"class=\"formulario__btn2\" > Eliminar </button>\n");
      out.write("                                </center>\n");
      out.write("                                <button name=\"btn_eliminar\" id=\"btn_eliminar\"  value=\"eliminar\"class=\"btn_falso\"> </button>\n");
      out.write("                            </form>\n");
      out.write("\n");
      out.write("                            <div class=\"modal-footer\">\n");
      out.write("                                <button type=\"button\" class=\"btn btn-warning mod_salir\" onclick=\"recargar()\"  data-dismiss=\"modal\">Salir</button>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <div class=\"formulario_titulo\">\n");
      out.write("                <h5>Formulario Puestos</h3>\n");
      out.write("            </div>\n");
      out.write("            <br>\n");
      out.write("            <div class= \"container \">\n");
      out.write("                <table class=\"table table-hover table-bordered\">\n");
      out.write("                    <thead class=\"thead-dark   titulos\">\n");
      out.write("\n");
      out.write("                        <tr>\n");
      out.write("                            <th>Puestos</th>\n");
      out.write("                        </tr>\n");
      out.write("                    </thead>\n");
      out.write("\n");
      out.write("                    <tbody class=\"formula_puesto\" id=\"tbl_puestos\">\n");
      out.write("\n");
      out.write("                        ");
 
                        Puesto puesto = new Puesto();
                        DefaultTableModel tabla = new DefaultTableModel();
                        tabla= puesto.Leer();
                        int cero=0;
                        for (int r=0; r<tabla.getRowCount(); r++){
                            cero++;
                         out.println("<tr data-id=" + tabla.getValueAt(r,0)+ " >");
                        out.println("<td>" + tabla.getValueAt(r,1) + "</td>");
                        out.println("</tr>");
                        }
                          out.println("<div class='contador_lbl'>"+"<h5 >"+"Puestos Encontrados: "+cero+"</h5>"+"</div>"); 
                        
      out.write("\n");
      out.write("                    </tbody>\n");
      out.write("                </table>\n");
      out.write("            </div>\n");
      out.write("            <script src=\"https://kit.fontawesome.com/2c36e9b7b1.js\" crossorigin=\"anonymous\"></script>\n");
      out.write("            <script src=\"https://cdn.jsdelivr.net/npm/sweetalert2@11\"></script>\n");
      out.write("\n");
      out.write("            <script type = \"text/javascript \" src = \"js/formulario_puesto.js\" > </script> \n");
      out.write("        </div>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
