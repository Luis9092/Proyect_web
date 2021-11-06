<%-- 
    Document   : index_compras
    Created on : Nov 5, 2021, 9:51:51 AM
    Author     : Luis Fernando Paxel
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="modelo.Proveedor"%>
<%@page import="modelo.Detalle_compra"%>
<%@page import="java.util.HashMap"%>
<%@page import="modelo.Compras"%>
<%@page import="javax.swing.table.DefaultTableModel"%>
<%@page import="modelo.Producto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Maestro Compras</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
        <link rel="stylesheet" href="css/estilo_compra.css">
        <link href="css/estilo_menu.css" rel="stylesheet" type="text/css"/>


    </head>
    <body>
        <div id="header">
            <ul class="nav">
                <img src="imagenes/onitech.png" alt=""/>
                <li><a href="index_inicio_principal.jsp">Inicio</a></li>
                <li><a href="index_producto.jsp">Productos</a>
                    <ul>
                        <li><a href="index_marcas.jsp">Marcas</a></li>
                    </ul>
                </li>
                <li><a href="index_ventas.jsp">Ventas</a>
                    <ul>
                        <li><a href="index_cliente.jsp">Clientes</a></li>
                        <li><a href="index_empleado.jsp">Empleados</a>
                            <ul>
                                <li><a href="index_puesto.jsp">Puestos</a></li>
                            </ul>
                        </li>
                    </ul>
                </li>
                <li><a href="index_compras.jsp">Compras</a>
                    <ul>
                        <li><a href="index_prooveedores.jsp">Proveedores</a></li>
                    </ul>
                </li>
                <li><a href="Menu_reportes.jsp">Reportes</a></li>
                <li>
                    <%
                        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
                        if (session.getAttribute("txtUsuario") == null && session.getAttribute("nombre") == null) {
                            response.sendRedirect("index.html");
                        }  %>
                    <a > 
                        <form action="sr_cerrar_sesion" >
                            <input class="cerrar_sesion" type="submit"  value="Cerrar Sesion">
                        </form>
                    </a>
                </li>
            </ul>
        </div>


        <!-- Primer Formulario Para Insertar A ventas -->
        <div class="container-fluid  p-3 my-3  text-black">

            <div class="modal fade" data-backdrop="static" data-keyboard="false" tabindex="-1" id="modal_compras" role="dialog">
                <div class="modal-xl modal-dialog  modal-dialog-scrollable" >
                    <div class="modal-content formula_modal">
                        <!-- Modal Header -->
                        <div class="modal-header">
                            <h4 class="modal-title">Formulario Ventas</h4>
                            <button type="button" class="close" data-dismiss="modal">&times;</button>
                        </div>


                        <div class="modal-body ">
                            <form action="control_compras?menu=Compras" class="formulario" method="post" id="formulario" >

                                <div class="formulario__grupo" >
                                    <label for="lbl_id" class="formulario__label">ID</label>
                                    <div class="formulario__grupo-input">
                                        <input type="text" class="formulario__input" name="txt_id" id="txt_id" value="0" readonly>
                                    </div>
                                </div>
                                <div class="formulario__grupo">
                                    <label for="lbl_orden" class="formulario__label">No. orden</label>
                                    <div class="formulario__grupo-input">

                                        <input type="text" class="formulario__input " name="txt_orden" id="txt_orden"  readonly>
                                    </div>
                                </div>

                                <!-- Seleccionar Proveedor -->
                                <div class="formulario__grupo" >
                                    <label for="lbl_proveedor" class="formulario__label">Proveedor</label>
                                    <div class="formulario__grupo-input">
                                        <select name="drop_proveedor" class="formulario__input" id="drop_proveedor" >
                                            <%
                                                Compras c_prov = new Compras();
                                                HashMap<String, String> drop = c_prov.buscar_prov();
                                                for (String i : drop.keySet()) {
                                                    out.println("<option value=" + i + ">" + drop.get(i) + "</option>");
                                                }
                                            %>
                                        </select>
                                    </div>
                                </div>
                                <!-- Grupo: Fecha Factura -->
                                <div class="formulario__grupo" id="grupo__txt_ffact">
                                    <label for="lbl_fechaOrden" class="formulario__label">Fecha Orden</label>
                                    <div class="formulario__grupo-input">
                                        <input type="date" class="formulario__input" name="txt_forden"  id="txt_forden" required placeholder="yyyy-MM-dd" >
                                    </div>
                                </div>
                                <!-- Fecha Ingreso-->
                                <div class="formulario__grupo" id="grupo__txt_fni">
                                    <label for="lbl_fechaIngreso" class="formulario__label">Fecha Ingreso:</label>
                                    <div class="formulario__grupo-input">
                                        <input class="formulario__input" type="text" name="txt_fni" id="txt_fni"  >
                                    </div>
                                </div>
                                <br>
                                <div class="formulario__grupo-btn-enviar">
                                    <button  type="submit" name="accion" id="btn_modificar" value="modificar" class="nekros_verde" >Modificar</button>
                                    <button  name="btn_2" id="btn_2" onclick="return confirmar2();" class="nekros_rojo" > Eliminar </button>
                                </div>
                                <button type="submit" name="accion" id="btn_eliminar" value="eliminar" class="btn_falso" >  </button>
                                <br>

                            </form>  
                            <!-- Ventas Tabla -->
                            <div class= "">
                                <table class="table table-hover table-bordered">
                                    <thead class="thead-dark   titulos">
                                        <tr>
                                            <th>Id Compra</th> 
                                            <th>No. Orden</th>
                                            <th>Proveedor</th>
                                            <th>Fecha Orden</th>
                                            <th>Fecha Ingreso</th>

                                        </tr>
                                    </thead>
                                    <tbody class="formula_tabla" id="tbl_compras">
                                        <%
                                            Compras ver_compras = new Compras();
                                            DefaultTableModel tabla2 = new DefaultTableModel();
                                            tabla2 = ver_compras.leer_proveedor();
                                            for (int r = 0; r < tabla2.getRowCount(); r++) {
                                                out.println("<tr data-idproveedores=" + tabla2.getValueAt(r, 5) + " >");
                                                out.println("<td>" + tabla2.getValueAt(r, 0) + "</td>");
                                                out.println("<td>" + tabla2.getValueAt(r, 1) + "</td>");
                                                out.println("<td>" + tabla2.getValueAt(r, 2) + "</td>");
                                                out.println("<td>" + tabla2.getValueAt(r, 3) + "</td>");
                                                out.println("<td>" + tabla2.getValueAt(r, 4) + "</td>");

                                                out.println("</tr>");
                                            }

                                        %>
                                    </tbody>
                                </table>
                            </div>
                            <div class="modal-footer">
                                <button type="button"  class="btn btn-warning mod_salir" onclick="recargar()"   data-dismiss="modal">Salir</button>
                            </div>
                        </div>
                    </div>
                </div>
            </div> 

            <!-- Primer Formulario Para Insertar A ventas Detalle -->
            <div class="modal fade" data-backdrop="static" data-keyboard="false" tabindex="-1" id="modal_detalle" role="dialog">
                <div class="modal-xl modal-dialog  modal-dialog-scrollable " >
                    <div class="modal-content formula_modal">
                        <!-- Modal Header -->
                        <div class="modal-header">
                            <h4 class="modal-title">Formulario Detalle</h4>
                            <button type="button" class="close" data-dismiss="modal">&times;</button>
                        </div>

                        <div class="modal-body ">
                            <form action="control_compras?menu=Compras_detalle" class="formulario" method="post"  >

                                <div class="formulario__grupo">
                                    <label for="lbl_detalles" class="formulario__label">ID</label>
                                    <div class="formulario__grupo-input">
                                        <input type="text" class="formulario__input" name="txt_id_detalle" id="txt_id_detalle" value="0" readonly>
                                    </div>
                                </div>

                                <div class="formulario__grupo" >
                                    <label for="No_venta" class="formulario__label">No. compra</label>
                                    <div class="formulario__grupo-input">
                                        <input type="text" class="formulario__input" name="No_compra" id="No_compra"  readonly>
                                    </div>
                                </div>

                                <!-- Seleccionar Productos -->
                                <div class="formulario__grupo" >
                                    <label for="lbl_producto" class="formulario__label">Productos</label>
                                    <div class="formulario__grupo-input">
                                        <select name="drop_prod" class="formulario__input" id="drop_prod" >

                                            <%                                                Compras selectPro = new Compras();
                                                HashMap<String, String> drop44 = selectPro.compras_prod();
                                                for (String i : drop44.keySet()) {
                                                    out.println("<option value=" + i + ">" + drop44.get(i) + "</option>");
                                                }
                                            %>
                                        </select>
                                    </div>
                                </div>


                                <div class="formulario__grupo">
                                    <label for="cantidad" class="formulario__label">Cantidad</label>
                                    <div class="formulario__grupo-input">
                                        <input type="number" class="formulario__input" name="cantidad_detalle" id="cantidad_detalle" value="0" >
                                    </div>
                                </div>


                                <div class=" formulario__grupo-btn-enviar">
                                    <button type="submit" name="accion"  value="modificar2" class="nekros_verde" >Modificar</button>
                                    <button  name="btn_3" id="btn_3" onclick="return confirmar3();"  class="nekros_rojo" > Eliminar </button>
                                </div>
                                <button type="submit" name="accion" id="btn_eliminar2"  value="eliminar2" class="btn_falso" >  </button>
                                <br>
                            </form>   
                            <!-- Ventas Tabla -->
                            <div class= "">
                                <table class="table table-hover table-bordered">
                                    <thead class="thead-dark   titulos">
                                        <tr>
                                            <th>No. Venta</th> 
                                            <th>Producto</th>
                                            <th>Cantidad</th>
                                            <th>Precio</th>

                                        </tr>
                                    </thead>
                                    <tbody class="formula_tabla" id="tbl_ComprasDetalle">
                                        <%
                                            Detalle_compra compra_det = new Detalle_compra();
                                            DefaultTableModel tabla4 = new DefaultTableModel();
                                            tabla4 = compra_det.Mostrar();
                                            for (int r = 0; r < tabla4.getRowCount(); r++) {

                                                out.println("<tr data-id22=" + tabla4.getValueAt(r, 0) + " data-idprodd=" + tabla4.getValueAt(r, 5) + " >");
                                                out.println("<td>" + tabla4.getValueAt(r, 1) + "</td>");
                                                out.println("<td>" + tabla4.getValueAt(r, 2) + "</td>");
                                                out.println("<td>" + tabla4.getValueAt(r, 3) + "</td>");
                                                out.println("<td>" + tabla4.getValueAt(r, 4) + "</td>");

                                                out.println("</tr>");
                                            }

                                        %>
                                    </tbody>
                                </table>
                            </div>
                            <div class="modal-footer">
                                <button type="button"  class="btn btn-warning mod_salir" onclick="recargar()"   data-dismiss="modal">Salir</button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <!-- The Modal -->
            <div class="modal fade" id="modal_menu">
                <div class="modal-dialog">
                    <div class="modal-content">

                        <!-- Modal Header -->
                        <div class="modal-header">
                            <h4 class="modal-title">Acciones</h4>
                            <button type="button" class="close" data-dismiss="modal">&times;</button>
                        </div>

                        <!-- Modal body -->
                        <div class="modal-body">
                            <div class=" formulario__grupo-btn-enviar">
                                <button  name="btn_ventas" id="btn_ventas" value="compras"    class="btn btn-danger" onclick="dos()" >Compras</button>
                                <button  name="detalle" id="detalle" value="detalle" class="btn btn-warning"  onclick="tres()">Detalle</button>
                            </div>
                        </div>

                        <!-- Modal footer -->
                        <div class="modal-footer">
                            <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>





        <!-- Insertar Maestro Compras  -->
        <form action="ser_compras?menu=Compras" method="post" class="formulario" id="formulario55">
            <div  class="MA1  parte1">
                <h3 class="titulo" >Compras</h3>
                <br>

                <div class="parent2 ">
                    <div class="div_uno"> 
                        <!-- Codigo Producto -->
                        <div class="Centrar" id="grupo__txt_codigo">
                            <label for="lbl_producto" class="formulario__label" >Codigo</label>

                            <div class="formulario__grupo-input">
                                <input type="text" class="producto_input " value="${proo.getId()}" name="codigoproducto" id="codigoproducto" readonly >

                            </div>
                        </div>  
                    </div>
                    <div class="div_dos">
                        <!-- Codigo Producto -->
                        <div class="" id="grupo__txt_producto">
                            <label for="lbl_producto" class="formulario__label">Producto</label>
                            <div class="formulario__grupo-input">
                                <input type="text" class="producto_input " value="${proo.getProducto()}" name="nombreproducto" id="nombreproducto" readonly >
                            </div>
                        </div>  
                    </div>
                    <div class="div_tres">
                        <!-- Precio Producto -->
                        <div class="" id="grupo__txt_precio">
                            <label for="lbl_precio" class="formulario__label" >Precio</label>
                            <div class="formulario__grupo-input">
                                <input type="text" class="producto_input " value="${proo.getPrecio()}" name="precio" id="precio" readonly >
                            </div>
                        </div> 
                    </div>
                    <div class="div_cuatro">
                        <!-- Existencia Producto -->
                        <div class="" id="grupo__txt_existencia">
                            <label for="lbl_direccion" class="formulario__label" >Existencia</label>
                            <div class="formulario__grupo-input">
                                <input type="text" class="producto_input " value="${proo.getExistencia()}" name="existencia" id="existencia" readonly required >
                            </div>
                        </div>  
                    </div>
                    <div class="div_cinco"> 
                        <!-- Cantidad Producto -->
                        <div class="" id="grupo__txt_cantidad">
                            <label for="lbl_cantidad" class="formulario__label" >Cantidad</label>
                            <div class="formulario__grupo-input">
                                <input type="number" class="producto_input" onkeypress="return event.charCode >= 48" min="1"  name="cantidad" value="1" id="cantidad" required>
                            </div>
                        </div>
                    </div>
                    <div class="div_seis"> 
                        <button type="button" class="nekros_amarillo"  data-toggle="modal" data-target="#modal_menu" >
                            Menu
                        </button>

                    </div>
                </div>

                <br>

                <div class="">
                    <button  name="accion" value="Agregar" onclick="cantidad()" id="btn_agregar44" class="nekros" >Agregar</button>  
                    <button  name="accion" value="Modificar" id="btn_mod" class="nekros_verde" >Modificar</button>  
                </div>

                <div class= " ">
                    <table class="table table-hover table-bordered">
                        <thead class="thead-dark   titulos">
                            <tr>
                                <th>Producto</th> 
                                <th>Descripcion</th>
                                <th>Precio</th>
                                <th>Existencia</th>
                                <th>Marca</th>
                            </tr>
                        </thead>
                        <tbody class="formula_tabla" id="tbl_productos">
                            <%                                Producto cprod = new Producto();
                                DefaultTableModel tabla77 = new DefaultTableModel();
                                tabla77 = cprod.leer2();
                                for (int r = 0; r < tabla77.getRowCount(); r++) {
                                    out.println("<tr data-id=" + tabla77.getValueAt(r, 0) + " data-id_pues=" + tabla77.getValueAt(r, 6) + " >");
                                    out.println("<td>" + tabla77.getValueAt(r, 1) + "</td>");
                                    out.println("<td>" + tabla77.getValueAt(r, 2) + "</td>");
                                    out.println("<td>" + tabla77.getValueAt(r, 3) + "</td>");
                                    out.println("<td>" + tabla77.getValueAt(r, 4) + "</td>");
                                    out.println("<td>" + tabla77.getValueAt(r, 5) + "</td>");
                                    out.println("</tr>");
                                }
                            %>
                        </tbody>
                    </table>
                </div>
            </div>


            <div class="casa26 parte2">
                <div class="parent">
                    <div class="div1">
                        <!-- Logotipo-->
                        <img src="imagenes/onitech.png">   
                    </div>
                    <div class="div2">
                        <h4 class="formulario_pre">Productos y Sevicios Onitech</h4>    
                    </div>
                    <div class="div3">
                        <h4 class="formulario_pre">3ra Calle Poniente</h4>    
                    </div>
                    <div class="div4">
                        <!-- Fecha Automatica -->
                        <div class="formulario_fecha">
                            <label for="lbl_direccion" class="formulario__label" >Fecha </label>
                            <div class="formulario__grupo-input">
                                <input type="text" class="formulario__input " name="txt_fecha" id="txt_fecha" readonly >
                            </div>
                        </div>  
                    </div>
                    <div class="div5"> 
                        <!-- No factura -->
                        <div class="formulario__grupo" >
                            <label for="lbl_puesto" class="formulario__label">No. Orden</label>
                            <div class="formulario__grupo-input">
                                <select name="drop_orden" class="formulario__input" id="drop_orden" readonly >
                                    <%
                                        Compras max_orden = new Compras();
                                        HashMap<String, String> orden = max_orden.max_Orden();
                                        for (String e : orden.keySet()) {
                                            out.println("<option value=" + orden.get(e) + ">" + orden.get(e) + "</option>");
                                        }
                                    %>
                                </select>
                            </div>
                        </div>
                    </div>
                    <div class="div6">
                        <!--No Serie -->

                    </div>
                    <div class="div7">
                        <!-- Obtner Nombre,Apellidos y Nit del cliente -->
                        <div class="formulario__grupo ">
                            <label for="lbl_prov" class="formulario__label">Proveedor</label>
                            <div class="formulario__grupo-input">
                                <select name="drop_prov" class="formulario__input" id="drop_prov" readonly >
                                    <%
                                        Proveedor ver_prov = new Proveedor();
                                        HashMap<String, String> prov = ver_prov.seleccionar();
                                        for (String m : prov.keySet()) {
                                            out.println("<option value=" + m + ">" + prov.get(m) + "</option>");
                                        }
                                    %>
                                </select>
                            </div>
                        </div>
                    </div>


                    <div class="div8"> 
                        <!-- Obtnener Nombre, Apellidos Y Puesto -->
                        <div class="formulario__grupo container" id="grupo__txt_puesto">
                            <label for="lbl_puesto" class="formulario__label">Fecha Ingreso</label>
                            <div class="formulario__grupo-input">
                                <input type="text" class="formulario__input " name="fecha_ingreso" id="fecha_ingreso" readonly >

                            </div>
                        </div>  
                    </div>
                </div>

                <div class="blanco">
                    <div class="table table-hover table-bordered ">
                        <table class="table table-hover " id="tbl_ventas" >
                            <thead class="thead-dark   titulos">
                                <tr>
                                    <th>No.</th>
                                    <th>Codigo</th>
                                    <th>Producto</th>
                                    <th>Precio</th>
                                    <th>Cantidad</th>
                                    <th>Sub-Total</th>
                                    <th class="accion">Acciones</th>
                                </tr>
                            </thead>
                            <tbody class="formula_tabla">

                                <c:forEach var="list" items="${lista}" > 
                                    <tr>
                                        <td>${list.getItem()}</td>
                                        <td>${list.getIdproducto()}</td>
                                        <td>${list.getDescripcion()}</td>
                                        <td>Q. ${list.getPrecio()}</td>
                                        <td>${list.getCantidad()}</td>
                                        <td>${list.getSubtotal()}</td>
                                        <td class="d-flex"> 
                                            <a href="ser_compras?menu=Compras&accion=editar&id=${list.getIdproducto()}&id33=${list.getItem()} "class="btn btn-warning" >Editar</a>
                                            <a href="ser_compras?menu=Compras&accion=remover&id22=${list.getItem()}" class="btn btn-danger" style="margin-left: 2px" >Borrar</a>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                    <div class="card-footer d-flex">
                        <button id="accion" name="accion" value="Agregar_compra" class="nekros" >Agregar venta </button>
                        <button id="accion" name="accion" value="Cancelar" class="nekros_rojo" >Cancelar </button>

                        <div class="col-sm-3 ml-auto">
                            <input type="text" name="txt_total" value="Q. ${total}" style="font-weight: bold" readonly class="form-control">  
                        </div>
                    </div>
                </div>

            </div>
        </form>  
        <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
        <script type = "text/javascript " src = "js/formulario_compras.js" > </script>                   
        <script type = "text/javascript " src = "js/crud_compras.js" > </script>

    </body>
</html>
