<%-- 
    Document   : Menu_reportes
    Created on : Oct 27, 2021, 5:30:10 PM
    Author     : Luis Fernando Paxel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Reportes</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
        
        <link rel="stylesheet" href="css/reporte.css">
        <link href="css/estilo_menu.css" rel="stylesheet" type="text/css"/>

    </head>
    <div id="header">
        <ul class="nav">
            <img src="imagenes/onitech.png" alt=""/>
            <li><a href="index_inicio_principal.jsp">Inicio</a></li>
            <li><a href="index_producto.jsp">Productos</a>
                <ul>
                    <li><a href="index_marcas.jsp">Marcas</a></li>
                </ul>
            </li>
            <li><a href="">Ventas</a>
                <ul>
                    <li><a href="index_cliente.jsp">Clientes</a></li>
                    <li><a href="index_empleado.jsp">Empleados</a>
                        <ul>
                            <li><a href="index_puesto.jsp">Puestos</a></li>
                        </ul>
                    </li>
                </ul>
            </li>
            <li><a href="">Compras</a>
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
                    }%>
                <a > 
                    <form action="sr_cerrar_sesion" >
                        <input class="cerrar_sesion" type="submit"  value="Cerrar Sesion">
                    </form>
                </a>
            </li>
        </ul>
    </div>

    <div class="contenedor">
        <div class="parent">
            <div class="div1">

                <input type="button" value="Reporte Clientes"  class="enlaze_modal" onclick="javascript:window.open('http://localhost:8080/Pro_final/Reportes/Reporte_cliente.jsp');" />
            </div>
            <div class="div2">
                <input type="button" value="Reporte Puestos"  class="enlaze_modal" onclick="javascript:window.open('http://localhost:8080/Pro_final/Reportes/Reporte_puesto.jsp');" />
     
            </div>
            <div class="div3">
                <input type="button" value="Reporte Empleados"  class="enlaze_modal" onclick="javascript:window.open('http://localhost:8080/Pro_final/Reportes/Reporte_empleado.jsp');" />
            </div>
            <div class="div4">
                <input type="button" value="Reporte Marcas"  class="enlaze_modal" onclick="javascript:window.open('http://localhost:8080/Pro_final/Reportes/Reporte_marca.jsp');" />
            </div>
            <div class="div5">
                <input type="button" value="Reporte Proveedores"  class="enlaze_modal" onclick="javascript:window.open('http://localhost:8080/Pro_final/Reportes/Reporte_proveedores.jsp');" />
            </div>
        </div>
    </div>
</body>
</html>
