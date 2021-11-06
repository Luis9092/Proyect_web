
/* global Swal */

function dos() {
    $("#modal_compras").modal('show');
    $("#modal_menu").removeClass('show');

    //$("#modalID .close").click()
}

function tres() {
    $("#modal_detalle").modal('show');
    $("#modal_menu").removeClass('show');
}


$('#tbl_compras').on('click', 'tr td', function (evt) {
    var target, id, No_orden, proveedor, fecha_orden, Fecha_ingreso, idprob;
    target = $(event.target);
    idprob = target.parent().data('idproveedores');
    id = target.parent("tr").find("td").eq(0).html();
    No_orden = target.parent("tr").find("td").eq(1).html();
    proveedor = target.parent("tr").find("td").eq(2).html();
    fecha_orden = target.parent("tr").find("td").eq(3).html();
    Fecha_ingreso = target.parent("tr").find("td").eq(4).html();


    $("#txt_id").val(id);
    $("#txt_orden").val(No_orden);
    $("#drop_proveedor").val(idprob);
    $("#txt_forden").val(fecha_orden);
    $("#txt_fni").val(Fecha_ingreso);
    $("#modal_compras").modal('show');


});


$('#tbl_ComprasDetalle').on('click', 'tr td', function (evt) {
    var target, id, idCompra, producto, cantidad, precioCosto, productoId;
    target = $(event.target);
    id = target.parent().data('id22');
    productoId = target.parent().data('idprodd');
    idCompra = target.parent("tr").find("td").eq(0).html();
    producto = target.parent("tr").find("td").eq(1).html();
    cantidad = target.parent("tr").find("td").eq(2).html();
    precioCosto = target.parent("tr").find("td").eq(3).html();

    $("#txt_id_detalle").val(id);
    $("#No_compra").val(idCompra);
    $("#drop_prod").val(productoId);
    $("#cantidad_detalle").val(cantidad);
    $("#modal_detalle").modal('show');

});

function confirmar2(evt) {

    Swal.fire({
        title: 'Eliminar',
        text: "Desea eliminar el registro?",
        icon: 'warning',
        showCancelButton: true,
        confirmButtonColor: '#3085d6',
        cancelButtonColor: '#d33',
        confirmButtonText: 'Si, eliminar',
        cancelButtonText: 'Cancelar'
    }).then((result) => {
        if (result.value === true) {
            Swal.fire({
                title: 'Eliminado',
                html: '<h5 style=color:lime><br><b>Datos Eliminados Correctamente!!</b></h5>',
                icon: 'success',
                showConfirmButton: false
            });

            $("#btn_eliminar").click();
        } else {
            Swal.fire({
                confirmButtonColor: '#d33',
                icon: 'error',
                title: 'Cancelado',
                text: 'Datos No Eliminados'

            });
        }
    });
    return false;
}


function confirmar3(evt) {

    Swal.fire({
        title: 'Eliminar',
        text: "Desea eliminar el registro?",
        icon: 'warning',
        showCancelButton: true,
        confirmButtonColor: '#3085d6',
        cancelButtonColor: '#d33',
        confirmButtonText: 'Si, eliminar',
        cancelButtonText: 'Cancelar'
    }).then((result) => {
        if (result.value === true) {
            Swal.fire({
                title: 'Eliminado',
                html: '<h5 style=color:lime><br><b>Datos Eliminados Correctamente!!</b></h5>',
                icon: 'success',
                showConfirmButton: false
            });

            $("#btn_eliminar2").click();
        } else {
            Swal.fire({
                confirmButtonColor: '#d33',
                icon: 'error',
                title: 'Cancelado',
                text: 'Datos No Eliminados'

            });
        }
    });
    return false;
}





