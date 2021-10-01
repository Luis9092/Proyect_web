<%-- 
    Document   : index_empleado
    Created on : Sep 24, 2021, 1:00:56 AM
    Author     : Luis Fernando Paxel
--%>

<%@page import="modelo.Puesto" %>
<%@page import="modelo.Empleado" %>
<%@page import="java.util.HashMap" %>
<%@page import="javax.swing.table.DefaultTableModel" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Formulario</title>

        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
        
        <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>

    </head>
    <body>
        <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#modal_empleado" onclick="Limpiar()">
            Formulario
        </button>

        <div class="container p-3 my-3 bg-light  text-black">

            <h5><center>Formulario Empleados :3</center> </h5>
            <div class="modal fade" id="modal_empleado" role="dialog">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-body">

                            <form action="src_empleado" method="post" class="form-group">
                                <label for="lbl_id"><b>ID:</b> </label>
                                <input class="form-control" type="text" name="txt_id" id="txt_id" value="0" readonly>
                                <label for="lbl_nombres"><b>Nombres:</b> </label>
                                <input class="form-control" type="text" name="txt_nombres" id="txt_nombres" placeholder="Nombres" required>

                                <label for="lbl_apellidos"><b>Apellidos:</b> </label>
                                <input class="form-control" type="text" name="txt_apellidos" id="txt_apellidos" placeholder="Apellidos" required>

                                <label for="lbl_direccion"><b>Direccion:</b> </label>
                                <input class="form-control" type="text" name="txt_direccion" id="txt_direccion" placeholder="Pais, Lugar, Casa" required>

                                <label for="lbl_telefono"><b>No. Telefono:</b> </label>
                                <input class="form-control" type="number" name="txt_telefono" id="txt_telefono" placeholder="000000000" required>

                                <label for="lbl_dpi"><b>No. DPI</b></label>
                                <input  class="form-control"type="text" name="txt_dpi" id="txt_dpi" placeholder="--------------">

                                <label for="lbl_genero"><b>Genero</b></label>

                                <center>   
                                    <div class="form-check form-check-inline  custom-radio">
                                        <input class="form-check form-check-input"  name="gen" type="radio" id="uno" value="Masculino"  />Masculino           
                                        <input class="form-check form-check-input" name="gen"  type="radio" id="dos" value="Femenino"  />Femenino
                                    </div>
                                </center>

                                <br>

                                <label for="lbl_fn"><b>Fecha Nacimiento:</b> </label>
                                <input class="form-control" type="date" name="txt_fn" id="txt_fn" required placeholder="yyyy-MM-dd">

                                <label for="lbl_fn"><b>Fecha Inicio Laboral:</b> </label>
                                <input class="form-control" type="date" name="txt_fni" id="txt_fni" required placeholder="yyyy-MM-dd">

                                <br>
                                <label for="lbl_puesto" ><b>Puestos</b></label>

                                <select name="drop_puestos" class="form-control custom-select mr-sm-2" id="drop_puestos" >
                                    <%
                                        Puesto puesto= new Puesto();
                                        HashMap<String,String> drop= puesto.seleccionar();
                                        for(String i:drop.keySet())
                                        {
                                            out.println("<option value="+i+">"+drop.get(i)+ "</option>");
                                        }
                                    %>
                                </select>
                                <br>
                                <br>
                                <center>    
                                    <button  name="btn_agregar" id="btn_agregar" value="agregar" class="btn btn-primary">Agregar</button>
                                    <button  name="btn_modificar" id="btn_modificar" value="modificar" class="btn btn-success ">Modificar</button>
                                    <button  name="btn_eliminar" id="btn_eliminar" value="eliminar" class="btn btn btn-danger " onclick ="javascript:if (!confirm('¿Desea Eliminar'))
                                                return false"  >Eliminar</button>
                                </center>

                                <br>
                            </form>
                        </div>
                        <!-- Modal footer -->
                        <div class="modal-footer">
                            <button  type="button" class="btn btn-warning text-white" onclick="unselect()" data-dismiss="modal">Close</button>
                        </div>

                    </div>
                </div>
            </div>
            <div class= "container">
                <table class="table table-hover">
                    <thead class="thead-dark">
                        <tr>
                            <th>Nombres</th> 
                            <th>Apellidos</th>
                            <th>Dirección</th>
                            <th>Teléfono</th>
                            <th>DPI</th>
                            <th>Genero</th>
                            <th>Fecha Nacimiento</th>
                            <th>Fecha Labor</th>
                            <th>Fecha Ingreso</th>
                            <th>Puesto</th>

                        </tr>
                    </thead>
                    <tbody id="tbl_empleados">

                        <% 
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
                        %>
                    </tbody>
                </table>
            </div>
            <script type="text/javascript">

                function Limpiar() {

                    $("#txt_id").val(0);
                    $("#txt_nombres").val('');
                    $("#txt_apellidos").val('');
                    $("#txt_direccion").val('');
                    $("#txt_telefono").val('');
                    $("#txt_dpi").val('');
                    $("#txt_fn").val('');
                    $("#drop_puestos").val(0);
                    $("#txt_fn").val('');
                    $("#txt_fni").val('');

                }

                function unselect() {
                    document.querySelectorAll('[name=gen]').forEach((x) => x.checked = false);
                }
                function setRadio(obj)
                {
                    obj.checked = false;
                }

                $('#tbl_empleados').on('click', 'tr td', function (evt) {
                    var target, id, id_pu, nombres, apellidos, direccion, telefono, dpi, genero, f_nacido, f_labor, f_ingreso;
                    var unos, gemm;

                    target = $(event.target);
                    id = target.parent().data('id');
                    id_pu = target.parent().data('id_pues');
                    nombres = target.parent("tr").find("td").eq(0).html();
                    apellidos = target.parent("tr").find("td").eq(1).html();
                    direccion = target.parent("tr").find("td").eq(2).html();
                    telefono = target.parent("tr").find("td").eq(3).html();
                    dpi = target.parent("tr").find("td").eq(4).html();
                    genero = target.parent("tr").find("td").eq(5).html();
                    f_nacido = target.parent("tr").find("td").eq(6).html();
                    f_labor = target.parent("tr").find("td").eq(7).html();
                    f_ingreso = target.parent("tr").find("td").eq(8).html();
                    gemm = genero;


                    $("#txt_id").val(id);
                    $("#txt_nombres").val(nombres);
                    $("#txt_apellidos").val(apellidos);
                    $("#txt_direccion").val(direccion);
                    $("#txt_telefono").val(telefono);
                    $("#txt_dpi").val(dpi);
                    $("#txt_fn").val(f_nacido);
                    $("#txt_fni").val(f_labor);
                    $("#drop_puestos").val(id_pu);

                    if (gemm === "Masculino") {
                        unos = "uno";

                    } else {
                        unos = "dos";

                    }
                    $("#modal_empleado").modal('show');

                    $("#" + unos).val(genero).click();

                });

            </script>

        </div>

    </body>

</html>
