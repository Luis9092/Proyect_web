<%-- 
    Document   : index_puesto
    Created on : Oct 4, 2021, 9:40:55 PM
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
        <link rel="stylesheet" href="https://necolas.github.io/normalize.css/8.0.1/normalize.css">
        <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;700&display=swap" rel="stylesheet"> 
        <link rel="stylesheet" href="css/estilo_puesto.css">
    </head>
    <body>
         <form  action="index.jsp">
            <input class="btn_form" type="submit" value="Menu" />
       
        <button type="button" class=" btn_form" data-toggle="modal" data-target="#modal_puesto" onclick="Limpiar()">
            Puestos
        </button>
        </form>

        <div class="container p-3 my-3 bg-light  text-black">
            <div class="modal fade" data-backdrop="static" data-keyboard="false" tabindex="-1" id="modal_puesto" role="dialog">
                <div class="modal-dialog modal-xl ">
                    <div class="modal-content ">
                        <div class="modal-body formula_modal">
                            <form  action="index_empleado.jsp">
                                <input class="enlaze_empleado" type="submit" value="Empleados" />
                            </form>

                            <form  action="src_puesto" method="post" class="form-group" id="formulario">


                                <div class="formulario__grupo" id="grupo_txt_id">
                                    <label for="lbl_id" class="formulario__label">ID:</label>
                                    <div class="formulario__grupo-input">
                                        <input type="text" class="formulario__input" name="txt_id" id="txt_id" value="0" readonly>
                                    </div>
                                </div>

                                <div class="formulario__grupo" id="grupo__txt_puesto">
                                    <label for="lbl_puesto" class="formulario__label">Nombres: </label>
                                    <div class="formulario__grupo-input">
                                        <input type="text" class="formulario__input" name="txt_puesto" id="txt_puesto" placeholder="puesto" pattern="[A-Z]{1}[a-zA-ZÀ-ÿ\s]{3,40}"   required>
                                        <i class="formulario__validacion-estado fas fa-times-circle"></i>
                                    </div>
                                    <p class="formulario__input-error">Solo esta permitido letras </p>
                                </div>
                                <br>
                                <center>    
                                    <button  name="btn_agregar" id="btn_agregar" value="agregar"    class="formulario__btn " >Agregar</button>
                                    <button  name="btn_modificar" id="btn_modificar" value="modificar" class="formulario__btn1" >Modificar</button>
                                    <button  name="btn_eliminar" id="btn_eliminar" value="eliminar" class="formulario__btn2"  onclick ="javascript:if (!confirm('¿Desea Eliminar'))
                                                return false"  >Eliminar</button>
                                </center>
                            </form>

                            <div class="modal-footer">
                                <button type="button" class="btn btn-warning mod_salir" onclick="recargar()"  data-dismiss="modal">Salir</button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <div class="formulario_titulo">
                <h5>Formulario Puestos</h3>
            </div>
            <br>
            <div class= "container ">
                <table class="table table-hover table-bordered">
                    <thead class="thead-dark   titulos">

                        <tr>
                            <th>Puestos</th>
                        </tr>
                    </thead>

                    <tbody class="formula_puesto" id="tbl_puestos">

                        <% 
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
                        %>
                    </tbody>
                </table>
            </div>

            <script src="https://kit.fontawesome.com/2c36e9b7b1.js" crossorigin="anonymous"></script>
            <script type = "text/javascript " src = "js/formulario_puesto.js" > </script> 
        </div>
    </body>
</html>
