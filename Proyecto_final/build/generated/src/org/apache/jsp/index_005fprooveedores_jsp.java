package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import modelo.Proveedor;
import java.util.HashMap;
import javax.swing.table.DefaultTableModel;

public final class index_005fprooveedores_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <title>Proveedores</title>\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css\">\n");
      out.write("        <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js\"></script>\n");
      out.write("        <script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js\"></script>\n");
      out.write("        <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js\"></script>\n");
      out.write("        <script src=\"https://unpkg.com/sweetalert/dist/sweetalert.min.js\"></script>\n");
      out.write("\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <button type=\"button\" class=\"btn btn-primary text-white\" data-toggle=\"modal\" data-target=\"#modal_proveedor\" onclick=\"Limpiar()\">\n");
      out.write("            Formulario\n");
      out.write("        </button>\n");
      out.write("        <div class=\"container p-3 my-3 bg-light  text-black\">\n");
      out.write("            <h5><center>Formulario Proveedores:0</center> </h5>\n");
      out.write("            <br>\n");
      out.write("            <div class=\"modal fade\" id=\"modal_proveedor\" role=\"dialog\">\n");
      out.write("                <div class=\"modal-dialog\">\n");
      out.write("                    <div class=\"modal-content\">\n");
      out.write("\n");
      out.write("                        <!-- Modal body -->\n");
      out.write("                        <div class=\"modal-body\">\n");
      out.write("                            <form action=\"src_proveedor\" method=\"post\" class=\"form-group\">\n");
      out.write("                                <label for=\"lbl_id\"><b>ID:</b> </label>\n");
      out.write("                                <input class=\"form-control\" type=\"text\" name=\"txt_id\" id=\"txt_id\" value=\"0\"readonly>\n");
      out.write("\n");
      out.write("\n");
      out.write("                                <label for=\"lbl_proo\"><b>Proveedor:</b> </label>\n");
      out.write("                                <input class=\"form-control\" type=\"text\" name=\"txt_proo\" id=\"txt_proo\" placeholder=\"campo#\" required>\n");
      out.write("\n");
      out.write("                                <label for=\"lbl_nit\"><b>NIT:</b> </label>\n");
      out.write("                                <input class=\"form-control\" type=\"text\" name=\"txt_nit\" id=\"txt_nit\" placeholder=\"Apellidos\" required>\n");
      out.write("\n");
      out.write("                                <label for=\"lbl_direccion\"><b>Dirección:</b> </label>\n");
      out.write("                                <input class=\"form-control\" type=\"text\" name=\"txt_direccion\" id=\"txt_direccion\" placeholder=\"###########\" required>\n");
      out.write("\n");
      out.write("                                <label for=\"lbl_Telefono\"><b>Teléfono:</b> </label>\n");
      out.write("                                <input class=\"form-control\" type=\"number\" name=\"txt_telefono\" id=\"txt_telefono\" placeholder=\"000000000\" required>\n");
      out.write("                                <br>\n");
      out.write("                                <br>\n");
      out.write("                                <center>    \n");
      out.write("                                    <button  name=\"btn_agregar\" id=\"btn_agregar\" value=\"agregar\" class=\"btn btn-primary\">Agregar</button>\n");
      out.write("                                    <button  name=\"btn_modificar\" id=\"btn_modificar\" value=\"modificar\" class=\"btn btn-success \">Modificar</button>\n");
      out.write("                                    <button  name=\"btn_eliminar\" id=\"btn_eliminar\" value=\"eliminar\" class=\"btn btn btn-danger \" onclick =\"javascript:if (!confirm('¿Desea Eliminar'))\n");
      out.write("                                                return false\"  >Eliminar</button>\n");
      out.write("                                </center>\n");
      out.write("                            </form>\n");
      out.write("\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"modal-footer\">\n");
      out.write("                            <button type=\"button\" class=\"btn btn-warning text-white\"  data-dismiss=\"modal\">Close</button>\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("            <div class= \"container\">\n");
      out.write("                <table class=\"table table-hover\">\n");
      out.write("                    <thead class=\"thead-dark\">\n");
      out.write("                        <tr>\n");
      out.write("                            <th>Proveedor</th> \n");
      out.write("                            <th>Nit</th>\n");
      out.write("                            <th>Direccion</th>\n");
      out.write("                            <th>Teléfono</th>\n");
      out.write("                        </tr>\n");
      out.write("                    </thead>\n");
      out.write("                    <tbody id=\"tbl_proveedores\">\n");
      out.write("                        ");
 
                                Proveedor prov = new Proveedor();
                                DefaultTableModel tabla = new DefaultTableModel();
                                tabla= prov.leer3();
                                for (int r=0; r<tabla.getRowCount(); r++){
                                out.println("<tr data-id=" + tabla.getValueAt(r,0) + " >");
                                out.println("<td>" + tabla.getValueAt(r,1) + "</td>");
                                out.println("<td>" + tabla.getValueAt(r,2) + "</td>");
                                out.println("<td>" + tabla.getValueAt(r,3) + "</td>");             
                                out.println("<td>" + tabla.getValueAt(r,4) + "</td>");
                                out.println("</tr>");
                                }
                        
      out.write("\n");
      out.write("                    </tbody>\n");
      out.write("                </table>\n");
      out.write("            </div>\n");
      out.write("            <script type=\"text/javascript\">\n");
      out.write("\n");
      out.write("                function Limpiar() {\n");
      out.write("                    $(\"#txt_id\").val(0);\n");
      out.write("                    $(\"#txt_proo\").val('');\n");
      out.write("                    $(\"#txt_nit\").val('');\n");
      out.write("                    $(\"#txt_direccion\").val('');\n");
      out.write("                    $(\"#txt_telefono\").val('');\n");
      out.write("\n");
      out.write("                }\n");
      out.write("\n");
      out.write("                $('#tbl_proveedores').on('click', 'tr td', function (evt) {\n");
      out.write("                    var target, id, proveedor, direccion, telefono, nit;\n");
      out.write("                    target = $(event.target);\n");
      out.write("                    id = target.parent().data('id');\n");
      out.write("                    proveedor = target.parent(\"tr\").find(\"td\").eq(0).html();\n");
      out.write("                    nit = target.parent(\"tr\").find(\"td\").eq(1).html();\n");
      out.write("                    direccion = target.parent(\"tr\").find(\"td\").eq(2).html();\n");
      out.write("                    telefono = target.parent(\"tr\").find(\"td\").eq(3).html();\n");
      out.write("\n");
      out.write("\n");
      out.write("                    $(\"#txt_id\").val(id);\n");
      out.write("                    $(\"#txt_proo\").val(proveedor);\n");
      out.write("                    $(\"#txt_nit\").val(nit);\n");
      out.write("                    $(\"#txt_direccion\").val(direccion);\n");
      out.write("                    $(\"#txt_telefono\").val(telefono);\n");
      out.write("                    $(\"#modal_proveedor\").modal('show');\n");
      out.write("                });\n");
      out.write("\n");
      out.write("            </script>\n");
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
