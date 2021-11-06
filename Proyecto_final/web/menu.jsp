<%-- 
    Document   : menu
    Created on : Oct 16, 2021, 5:42:36 PM
    Author     : Luis Fernando Paxel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <title>Menu Desplegable</title>
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

            <li><a href="Menu_reportes.jsp">Reportes</a>
            
            </li>

            <li><a href="index_compras.jsp">Compras</a>
                <ul>
                    <li><a href="index_prooveedores.jsp">Proveedores</a></li>
                </ul>
            </li>
        </ul>
    </div>
</body>
</html>