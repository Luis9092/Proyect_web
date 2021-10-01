<%-- 
    Document   : index_prooveedores
    Created on : Sep 26, 2021, 5:16:59 PM
    Author     : Luis Fernando Paxel
--%>
<%@page  import="modelo.Proveedor" %>
<%@page import="java.util.HashMap" %>
<%@page import="javax.swing.table.DefaultTableModel" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Proveedores</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
        <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>

    </head>
    <body>
        <button type="button" class="btn btn-primary text-white" data-toggle="modal" data-target="#modal_proveedor" onclick="Limpiar()">
            Formulario
        </button>
        <div class="container p-3 my-3 bg-light  text-black">
            <h5><center>Formulario Proveedores:0</center> </h5>
            <br>
            <div class="modal fade" id="modal_proveedor" role="dialog">
                <div class="modal-dialog">
                    <div class="modal-content">

                        <!-- Modal body -->
                        <div class="modal-body">
                            <form action="src_proveedor" method="post" class="form-group">
                                <label for="lbl_id"><b>ID:</b> </label>
                                <input class="form-control" type="text" name="txt_id" id="txt_id" value="0"readonly>


                                <label for="lbl_proo"><b>Proveedor:</b> </label>
                                <input class="form-control" type="text" name="txt_proo" id="txt_proo" placeholder="campo#" required>

                                <label for="lbl_nit"><b>NIT:</b> </label>
                                <input class="form-control" type="text" name="txt_nit" id="txt_nit" placeholder="Apellidos" required>

                                <label for="lbl_direccion"><b>Dirección:</b> </label>
                                <input class="form-control" type="text" name="txt_direccion" id="txt_direccion" placeholder="###########" required>

                                <label for="lbl_Telefono"><b>Teléfono:</b> </label>
                                <input class="form-control" type="number" name="txt_telefono" id="txt_telefono" placeholder="000000000" required>
                                <br>
                                <br>
                                <center>    
                                    <button  name="btn_agregar" id="btn_agregar" value="agregar" class="btn btn-primary">Agregar</button>
                                    <button  name="btn_modificar" id="btn_modificar" value="modificar" class="btn btn-success ">Modificar</button>
                                    <button  name="btn_eliminar" id="btn_eliminar" value="eliminar" class="btn btn btn-danger " onclick ="javascript:if (!confirm('¿Desea Eliminar'))
                                                return false"  >Eliminar</button>
                                </center>
                            </form>

                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-warning text-white"  data-dismiss="modal">Close</button>
                        </div>

                    </div>
                </div>
            </div>






            <div class= "container">
                <table class="table table-hover">
                    <thead class="thead-dark">
                        <tr>
                            <th>Proveedor</th> 
                            <th>Nit</th>
                            <th>Direccion</th>
                            <th>Teléfono</th>
                        </tr>
                    </thead>
                    <tbody id="tbl_proveedores">
                        <% 
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
                        %>
                    </tbody>
                </table>
            </div>
            <script type="text/javascript">

                function Limpiar() {
                    $("#txt_id").val(0);
                    $("#txt_proo").val('');
                    $("#txt_nit").val('');
                    $("#txt_direccion").val('');
                    $("#txt_telefono").val('');

                }

                $('#tbl_proveedores').on('click', 'tr td', function (evt) {
                    var target, id, proveedor, direccion, telefono, nit;
                    target = $(event.target);
                    id = target.parent().data('id');
                    proveedor = target.parent("tr").find("td").eq(0).html();
                    nit = target.parent("tr").find("td").eq(1).html();
                    direccion = target.parent("tr").find("td").eq(2).html();
                    telefono = target.parent("tr").find("td").eq(3).html();


                    $("#txt_id").val(id);
                    $("#txt_proo").val(proveedor);
                    $("#txt_nit").val(nit);
                    $("#txt_direccion").val(direccion);
                    $("#txt_telefono").val(telefono);
                    $("#modal_proveedor").modal('show');
                });

            </script>
        </div>
    </body>
</html>
