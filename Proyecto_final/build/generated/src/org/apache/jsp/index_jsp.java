package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import modelo.Puesto;
import java.util.HashMap;
import javax.swing.table.DefaultTableModel;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <script src=\"https://unpkg.com/sweetalert/dist/sweetalert.min.js\"></script>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <button type=\"button\" class=\"btn btn-secondary\" data-toggle=\"modal\" data-target=\"#modal_puesto\" onclick=\"Limpiar()\">\n");
      out.write("            Puestos\n");
      out.write("        </button>\n");
      out.write("\n");
      out.write("        <div class=\"container\" >\n");
      out.write("            <div class  =\"list-group\" >\n");
      out.write("                <a href=\"index_empleado.jsp\"  class=\"list-group-item bg-success text-center text-white list-group-item-action\">Fomulario Empleado</a>\n");
      out.write("                <a href=\"index_cliente.jsp\"  class=\"list-group-item btn btn-danger bg-info btn text-center text-white btn btn-success list-group-item-action\">Formulario Cliente</ a>\n");
      out.write("                    <a href=\"index_prooveedores.jsp\"  class=\"list-group-item text-center bg-danger text-white list-group-item-action\">formulario Proveedores</a>\n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"container p-3 my-3 bg-light  text-black\">\n");
      out.write("            <div class=\"modal fade \" id=\"modal_puesto\" role=\"dialog\">\n");
      out.write("                <div class=\"modal-dialog\">\n");
      out.write("                    <div class=\"modal-content bg-danger\">\n");
      out.write("\n");
      out.write("                        <!-- Modal body -->\n");
      out.write("                        <div class=\"modal-body\">\n");
      out.write("                            <form  action=\"src_puesto\" method=\"post\" class=\"form-group\">\n");
      out.write("                                <label class=\"font-weight-bold\"for=\"lbl_id\">ID: </label>\n");
      out.write("                                <input class=\"form-control text-dark input-lg\" type=\"text\" name=\"txt_id\" id=\"txt_id\" value=\"0\" readonly>\n");
      out.write("\n");
      out.write("                                <label class=\"font-weight-bold\" for=\"lbl_producto\">Puesto: </label>\n");
      out.write("                                <input class=\"form-control text-dark input-lg\" type=\"text\" name=\"txt_puesto\" id=\"txt_puesto\" placeholder=\"Puesto\" required>\n");
      out.write("                                <br><br>\n");
      out.write("                                <center>    \n");
      out.write("                                    <button  name=\"btn_agregar\" id=\"btn_agregar\" value=\"agregar\" class=\"btn btn-primary\">Agregar</button>\n");
      out.write("\n");
      out.write("                                    <button  name=\"btn_modificar\" id=\"btn_modificar\" value=\"modificar\" class=\"btn btn-success \">Modificar</button>\n");
      out.write("                                    <button  name=\"btn_eliminar\" id=\"btn_eliminar\" value=\"eliminar\" class=\"btn btn btn-danger \" onclick =\"javascript:if (!confirm('¿Desea Eliminar'))\n");
      out.write("                                                return false\"  >Eliminar</button>\n");
      out.write("                                </center>\n");
      out.write("                            </form>\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                        <!-- Modal footer -->\n");
      out.write("                        <div class=\"modal-footer\">\n");
      out.write("                            <button type=\"button\" class=\"btn btn-warning text-white\" data-dismiss=\"modal\">Close</button>\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            <center> <h3 class=\"text-primary\">Formulario Puestos</h3></center>\n");
      out.write("            <br>\n");
      out.write("            <div class= \"container row \">\n");
      out.write("                <table class=\"table table-responsiver text-center \">\n");
      out.write("                    <thead class=\"thead-dark\">\n");
      out.write("                        <tr>\n");
      out.write("                            <th>Puesto</th>\n");
      out.write("                        </tr>\n");
      out.write("                    </thead>\n");
      out.write("\n");
      out.write("                    <tbody id=\"tbl_puestos\">\n");
      out.write("\n");
      out.write("                        ");
 
                        Puesto puesto = new Puesto();
                        DefaultTableModel tabla = new DefaultTableModel();
                        tabla= puesto.Leer();
                        for (int r=0; r<tabla.getRowCount(); r++){
                        out.println("<tr data-id=" + tabla.getValueAt(r,0)+ " >");
                        out.println("<td>" + tabla.getValueAt(r,1) + "</td>");
                        out.println("</tr>");
                        }
                        
      out.write("\n");
      out.write("                    </tbody>\n");
      out.write("\n");
      out.write("                </table>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <script type=\"text/javascript\">\n");
      out.write("                function Limpiar() {\n");
      out.write("                    $(\"#txt_id\").val(0);\n");
      out.write("                    $(\"#txt_puesto\").val('');\n");
      out.write("\n");
      out.write("\n");
      out.write("                }\n");
      out.write("                $('#tbl_puestos').on('click', 'tr td', function (evt) {\n");
      out.write("                    var target, id, puesto;\n");
      out.write("                    target = $(event.target);\n");
      out.write("                    id = target.parent().data('id');\n");
      out.write("\n");
      out.write("                    puesto = target.parent(\"tr\").find(\"td\").eq(0).html();\n");
      out.write("                    $(\"#txt_id\").val(id);\n");
      out.write("                    $(\"#txt_puesto\").val(puesto);\n");
      out.write("                    $(\"#modal_puesto\").modal('show');\n");
      out.write("                });\n");
      out.write("\n");
      out.write("            </script>\n");
      out.write("        </div>\n");
      out.write("\n");
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
