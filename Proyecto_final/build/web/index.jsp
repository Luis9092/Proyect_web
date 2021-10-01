<%-- 
    Document   : index
    Created on : Sep 23, 2021, 6:27:41 PM
    Author     : Luis Fernando Paxel
--%>
<%@page  import="modelo.Puesto" %>
<%@page import="java.util.HashMap" %>
<%@page import="javax.swing.table.DefaultTableModel" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Puestos</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
        <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
    </head>
    <body>
        <button type="button" class="btn btn-secondary" data-toggle="modal" data-target="#modal_puesto" onclick="Limpiar()">
            Puestos
        </button>

        <div class="container" >
            <div class  ="list-group" >
                <a href="index_empleado.jsp"  class="list-group-item bg-success text-center text-white list-group-item-action">Fomulario Empleado</a>
                <a href="index_cliente.jsp"  class="list-group-item btn btn-danger bg-info btn text-center text-white btn btn-success list-group-item-action">Formulario Cliente</ a>
                    <a href="index_prooveedores.jsp"  class="list-group-item text-center bg-danger text-white list-group-item-action">formulario Proveedores</a>

            </div>
        </div>
        <div class="container p-3 my-3 bg-light  text-black">
            <div class="modal fade " id="modal_puesto" role="dialog">
                <div class="modal-dialog">
                    <div class="modal-content bg-danger">

                        <!-- Modal body -->
                        <div class="modal-body">
                            <form  action="src_puesto" method="post" class="form-group">
                                <label class="font-weight-bold"for="lbl_id">ID: </label>
                                <input class="form-control text-dark input-lg" type="text" name="txt_id" id="txt_id" value="0" readonly>

                                <label class="font-weight-bold" for="lbl_producto">Puesto: </label>
                                <input class="form-control text-dark input-lg" type="text" name="txt_puesto" id="txt_puesto" placeholder="Puesto" required>
                                <br><br>
                                <center>    
                                    <button  name="btn_agregar" id="btn_agregar" value="agregar" class="btn btn-primary">Agregar</button>

                                    <button  name="btn_modificar" id="btn_modificar" value="modificar" class="btn btn-success ">Modificar</button>
                                    <button  name="btn_eliminar" id="btn_eliminar" value="eliminar" class="btn btn btn-danger " onclick ="javascript:if (!confirm('¿Desea Eliminar'))
                                                return false"  >Eliminar</button>
                                </center>
                            </form>
                        </div>

                        <!-- Modal footer -->
                        <div class="modal-footer">
                            <button type="button" class="btn btn-warning text-white" data-dismiss="modal">Close</button>
                        </div>

                    </div>
                </div>
            </div>
            <center> <h3 class="text-primary">Formulario Puestos</h3></center>
            <br>
            <div class= "container row ">
                <table class="table table-responsiver text-center ">
                    <thead class="thead-dark">
                        <tr>
                            <th>Puesto</th>
                        </tr>
                    </thead>

                    <tbody id="tbl_puestos">

                        <% 
                        Puesto puesto = new Puesto();
                        DefaultTableModel tabla = new DefaultTableModel();
                        tabla= puesto.Leer();
                        for (int r=0; r<tabla.getRowCount(); r++){
                        out.println("<tr data-id=" + tabla.getValueAt(r,0)+ " >");
                        out.println("<td>" + tabla.getValueAt(r,1) + "</td>");
                        out.println("</tr>");
                        }
                        %>
                    </tbody>

                </table>
            </div>

            <script type="text/javascript">
                function Limpiar() {
                    $("#txt_id").val(0);
                    $("#txt_puesto").val('');


                }
                $('#tbl_puestos').on('click', 'tr td', function (evt) {
                    var target, id, puesto;
                    target = $(event.target);
                    id = target.parent().data('id');

                    puesto = target.parent("tr").find("td").eq(0).html();
                    $("#txt_id").val(id);
                    $("#txt_puesto").val(puesto);
                    $("#modal_puesto").modal('show');
                });

            </script>
        </div>

    </body>
</html>
