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
        <title>Menu_control</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
        <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
         <link rel="stylesheet" href="css/estilo_puesto.css">
    </head>
    <body>
        <div class="container" >
            <br><br><br><br><br>
            <div class  ="list-group" >
                <a href="index_empleado.jsp"  class="list-group-item bg-success text-center text-white list-group-item-action">Fomulario Empleados</a>
                <a href="index_cliente.jsp"  class="list-group-item btn btn-danger bg-info btn text-center text-white btn btn-success list-group-item-action">Formulario Clientes</a>
                <a href="index_prooveedores.jsp"  class="list-group-item text-center bg-danger text-white list-group-item-action">Formulario Proveedores</a>
                <a href="index_puesto.jsp"  class="list-group-item text-center bg-warning text-white list-group-item-action">Formulario Puestos</a>
               <a href="https://matias.ma/nsfw/"  class="list-group-item text-center bg-primary text-white list-group-item-action">Relajata Crack \°o°/ </a>

            </div>
            <br><br><br><br><br>
        </div>
    </body>
</html>
