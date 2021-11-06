
/* global Swal */

var suma, hoy, f, fila;
hoy = new Date();
f = new Date();
//Fecha Y Hora Automatico
var hora = hoy.getHours() + ':' + hoy.getMinutes() + ':' + hoy.getSeconds();
var fecha = f.getFullYear() + '-' + (f.getMonth() + 1) + '-' + f.getDate();
var fechaYHora = fecha + ' ' + hora;
$("#fecha_ingreso").val(fechaYHora);
$("#txt_fecha").val(fecha);


//Tabla Productos Con precio Compra
$('#tbl_productos').on('click', 'tr td', function (evt) {
    var target, id, producto, descripcion, precio, existencia, marca;
    target = $(event.target);
    id = target.parent().data('id');
    producto = target.parent("tr").find("td").eq(0).html();
    descripcion = target.parent("tr").find("td").eq(1).html();
    precio = target.parent("tr").find("td").eq(2).html();
    existencia = target.parent("tr").find("td").eq(3).html();
    marca = target.parent("tr").find("td").eq(4).html();

    $("#codigoproducto").val(id);
    $("#nombreproducto").val(producto);
  $("#precio").val(precio);
    $("#existencia").val(existencia);

});

