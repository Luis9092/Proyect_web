package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import modelo.Puesto;
import modelo.Empleado;
import java.util.HashMap;
import javax.swing.table.DefaultTableModel;

public final class index_005fempleado_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Formulario</title>\n");
      out.write("\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css\">\n");
      out.write("        <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js\"></script>\n");
      out.write("        <script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js\"></script>\n");
      out.write("        <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js\"></script>\n");
      out.write("        \n");
      out.write("        <script src=\"https://unpkg.com/sweetalert/dist/sweetalert.min.js\"></script>\n");
      out.write("\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <button type=\"button\" class=\"btn btn-primary\" data-toggle=\"modal\" data-target=\"#modal_empleado\" onclick=\"Limpiar()\">\n");
      out.write("            Formulario\n");
      out.write("        </button>\n");
      out.write("\n");
      out.write("        <div class=\"container p-3 my-3 bg-light  text-black\">\n");
      out.write("\n");
      out.write("            <h5><center>Formulario Empleados :3</center> </h5>\n");
      out.write("            <div class=\"modal fade\" id=\"modal_empleado\" role=\"dialog\">\n");
      out.write("                <div class=\"modal-dialog\">\n");
      out.write("                    <div class=\"modal-content\">\n");
      out.write("                        <div class=\"modal-body\">\n");
      out.write("\n");
      out.write("                            <form action=\"src_empleado\" method=\"post\" class=\"form-group\">\n");
      out.write("                                <label for=\"lbl_id\"><b>ID:</b> </label>\n");
      out.write("                                <input class=\"form-control\" type=\"text\" name=\"txt_id\" id=\"txt_id\" value=\"0\" readonly>\n");
      out.write("                                <label for=\"lbl_nombres\"><b>Nombres:</b> </label>\n");
      out.write("                                <input class=\"form-control\" type=\"text\" name=\"txt_nombres\" id=\"txt_nombres\" placeholder=\"Nombres\" required>\n");
      out.write("\n");
      out.write("                                <label for=\"lbl_apellidos\"><b>Apellidos:</b> </label>\n");
      out.write("                                <input class=\"form-control\" type=\"text\" name=\"txt_apellidos\" id=\"txt_apellidos\" placeholder=\"Apellidos\" required>\n");
      out.write("\n");
      out.write("                                <label for=\"lbl_direccion\"><b>Direccion:</b> </label>\n");
      out.write("                                <input class=\"form-control\" type=\"text\" name=\"txt_direccion\" id=\"txt_direccion\" placeholder=\"Pais, Lugar, Casa\" required>\n");
      out.write("\n");
      out.write("                                <label for=\"lbl_telefono\"><b>No. Telefono:</b> </label>\n");
      out.write("                                <input class=\"form-control\" type=\"number\" name=\"txt_telefono\" id=\"txt_telefono\" placeholder=\"000000000\" required>\n");
      out.write("\n");
      out.write("                                <label for=\"lbl_dpi\"><b>No. DPI</b></label>\n");
      out.write("                                <input  class=\"form-control\"type=\"text\" name=\"txt_dpi\" id=\"txt_dpi\" placeholder=\"--------------\">\n");
      out.write("\n");
      out.write("                                <label for=\"lbl_genero\"><b>Genero</b></label>\n");
      out.write("\n");
      out.write("                                <center>   \n");
      out.write("                                    <div class=\"form-check form-check-inline  custom-radio\">\n");
      out.write("                                        <input class=\"form-check form-check-input\"  name=\"gen\" type=\"radio\" id=\"uno\" value=\"Masculino\"  />Masculino           \n");
      out.write("                                        <input class=\"form-check form-check-input\" name=\"gen\"  type=\"radio\" id=\"dos\" value=\"Femenino\"  />Femenino\n");
      out.write("                                    </div>\n");
      out.write("                                </center>\n");
      out.write("\n");
      out.write("                                <br>\n");
      out.write("\n");
      out.write("                                <label for=\"lbl_fn\"><b>Fecha Nacimiento:</b> </label>\n");
      out.write("                                <input class=\"form-control\" type=\"date\" name=\"txt_fn\" id=\"txt_fn\" required placeholder=\"yyyy-MM-dd\">\n");
      out.write("\n");
      out.write("                                <label for=\"lbl_fn\"><b>Fecha Inicio Laboral:</b> </label>\n");
      out.write("                                <input class=\"form-control\" type=\"date\" name=\"txt_fni\" id=\"txt_fni\" required placeholder=\"yyyy-MM-dd\">\n");
      out.write("\n");
      out.write("                                <br>\n");
      out.write("                                <label for=\"lbl_puesto\" ><b>Puestos</b></label>\n");
      out.write("\n");
      out.write("                                <select name=\"drop_puestos\" class=\"form-control custom-select mr-sm-2\" id=\"drop_puestos\" >\n");
      out.write("                                    ");

                                        Puesto puesto= new Puesto();
                                        HashMap<String,String> drop= puesto.seleccionar();
                                        for(String i:drop.keySet())
                                        {
                                            out.println("<option value="+i+">"+drop.get(i)+ "</option>");
                                        }
                                    
      out.write("\n");
      out.write("                                </select>\n");
      out.write("                                <br>\n");
      out.write("                                <br>\n");
      out.write("                                <center>    \n");
      out.write("                                    <button  name=\"btn_agregar\" id=\"btn_agregar\" value=\"agregar\" class=\"btn btn-primary\">Agregar</button>\n");
      out.write("                                    <button  name=\"btn_modificar\" id=\"btn_modificar\" value=\"modificar\" class=\"btn btn-success \">Modificar</button>\n");
      out.write("                                    <button  name=\"btn_eliminar\" id=\"btn_eliminar\" value=\"eliminar\" class=\"btn btn btn-danger \" onclick =\"javascript:if (!confirm('¿Desea Eliminar'))\n");
      out.write("                                                return false\"  >Eliminar</button>\n");
      out.write("                                </center>\n");
      out.write("\n");
      out.write("                                <br>\n");
      out.write("                            </form>\n");
      out.write("                        </div>\n");
      out.write("                        <!-- Modal footer -->\n");
      out.write("                        <div class=\"modal-footer\">\n");
      out.write("                            <button  type=\"button\" class=\"btn btn-warning text-white\" onclick=\"unselect()\" data-dismiss=\"modal\">Close</button>\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            <div class= \"container\">\n");
      out.write("                <table class=\"table table-hover\">\n");
      out.write("                    <thead class=\"thead-dark\">\n");
      out.write("                        <tr>\n");
      out.write("                            <th>Nombres</th> \n");
      out.write("                            <th>Apellidos</th>\n");
      out.write("                            <th>Dirección</th>\n");
      out.write("                            <th>Teléfono</th>\n");
      out.write("                            <th>DPI</th>\n");
      out.write("                            <th>Genero</th>\n");
      out.write("                            <th>Fecha Nacimiento</th>\n");
      out.write("                            <th>Fecha Labor</th>\n");
      out.write("                            <th>Fecha Ingreso</th>\n");
      out.write("                            <th>Puesto</th>\n");
      out.write("\n");
      out.write("                        </tr>\n");
      out.write("                    </thead>\n");
      out.write("                    <tbody id=\"tbl_empleados\">\n");
      out.write("\n");
      out.write("                        ");
 
                        Empleado empleado = new Empleado();
                        DefaultTableModel tabla = new DefaultTableModel();
                        tabla= empleado.leer3();
                        for (int r=0; r<tabla.getRowCount(); r++){
                        out.println("<tr data-id=" + tabla.getValueAt(r,0) + " data-id_pues=" + tabla.getValueAt(r,11) + " >");
                        out.println("<td>" + tabla.getValueAt(r,1) + "</td>");
                        out.println("<td>" + tabla.getValueAt(r,2) + "</td>");
                        out.println("<td>" + tabla.getValueAt(r,3) + "</td>");             
                        out.println("<td>" + tabla.getValueAt(r,4) + "</td>");
                        out.println("<td>" + tabla.getValueAt(r,5) + "</td>");     
                        out.println("<td>" + tabla.getValueAt(r,6) + "</td>");
                        out.println("<td>" + tabla.getValueAt(r,7) + "</td>");
                        out.println("<td>" + tabla.getValueAt(r,8) + "</td>");
                        out.println("<td>" + tabla.getValueAt(r,9) + "</td>");
                        out.println("<td>" + tabla.getValueAt(r,10) + "</td>");
                      
                        out.println("</tr>");
                        }
                        
      out.write("\n");
      out.write("                    </tbody>\n");
      out.write("                </table>\n");
      out.write("            </div>\n");
      out.write("            <script type=\"text/javascript\">\n");
      out.write("\n");
      out.write("                function Limpiar() {\n");
      out.write("\n");
      out.write("                    $(\"#txt_id\").val(0);\n");
      out.write("                    $(\"#txt_nombres\").val('');\n");
      out.write("                    $(\"#txt_apellidos\").val('');\n");
      out.write("                    $(\"#txt_direccion\").val('');\n");
      out.write("                    $(\"#txt_telefono\").val('');\n");
      out.write("                    $(\"#txt_dpi\").val('');\n");
      out.write("                    $(\"#txt_fn\").val('');\n");
      out.write("                    $(\"#drop_puestos\").val(0);\n");
      out.write("                    $(\"#txt_fn\").val('');\n");
      out.write("                    $(\"#txt_fni\").val('');\n");
      out.write("\n");
      out.write("                }\n");
      out.write("\n");
      out.write("                function unselect() {\n");
      out.write("                    document.querySelectorAll('[name=gen]').forEach((x) => x.checked = false);\n");
      out.write("                }\n");
      out.write("                function setRadio(obj)\n");
      out.write("                {\n");
      out.write("                    obj.checked = false;\n");
      out.write("                }\n");
      out.write("\n");
      out.write("                $('#tbl_empleados').on('click', 'tr td', function (evt) {\n");
      out.write("                    var target, id, id_pu, nombres, apellidos, direccion, telefono, dpi, genero, f_nacido, f_labor, f_ingreso;\n");
      out.write("                    var unos, gemm;\n");
      out.write("\n");
      out.write("                    target = $(event.target);\n");
      out.write("                    id = target.parent().data('id');\n");
      out.write("                    id_pu = target.parent().data('id_pues');\n");
      out.write("                    nombres = target.parent(\"tr\").find(\"td\").eq(0).html();\n");
      out.write("                    apellidos = target.parent(\"tr\").find(\"td\").eq(1).html();\n");
      out.write("                    direccion = target.parent(\"tr\").find(\"td\").eq(2).html();\n");
      out.write("                    telefono = target.parent(\"tr\").find(\"td\").eq(3).html();\n");
      out.write("                    dpi = target.parent(\"tr\").find(\"td\").eq(4).html();\n");
      out.write("                    genero = target.parent(\"tr\").find(\"td\").eq(5).html();\n");
      out.write("                    f_nacido = target.parent(\"tr\").find(\"td\").eq(6).html();\n");
      out.write("                    f_labor = target.parent(\"tr\").find(\"td\").eq(7).html();\n");
      out.write("                    f_ingreso = target.parent(\"tr\").find(\"td\").eq(8).html();\n");
      out.write("                    gemm = genero;\n");
      out.write("\n");
      out.write("\n");
      out.write("                    $(\"#txt_id\").val(id);\n");
      out.write("                    $(\"#txt_nombres\").val(nombres);\n");
      out.write("                    $(\"#txt_apellidos\").val(apellidos);\n");
      out.write("                    $(\"#txt_direccion\").val(direccion);\n");
      out.write("                    $(\"#txt_telefono\").val(telefono);\n");
      out.write("                    $(\"#txt_dpi\").val(dpi);\n");
      out.write("                    $(\"#txt_fn\").val(f_nacido);\n");
      out.write("                    $(\"#txt_fni\").val(f_labor);\n");
      out.write("                    $(\"#drop_puestos\").val(id_pu);\n");
      out.write("\n");
      out.write("                    if (gemm === \"Masculino\") {\n");
      out.write("                        unos = \"uno\";\n");
      out.write("\n");
      out.write("                    } else {\n");
      out.write("                        unos = \"dos\";\n");
      out.write("\n");
      out.write("                    }\n");
      out.write("                    $(\"#modal_empleado\").modal('show');\n");
      out.write("\n");
      out.write("                    $(\"#\" + unos).val(genero).click();\n");
      out.write("\n");
      out.write("                });\n");
      out.write("\n");
      out.write("            </script>\n");
      out.write("\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("    </body>\n");
      out.write("\n");
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
