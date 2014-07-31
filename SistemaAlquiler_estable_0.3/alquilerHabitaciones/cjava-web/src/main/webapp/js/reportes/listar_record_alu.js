
$(document).ready(function() {

    cargarInputBusqueda();
    if ($('#total').val() <= 0) {
        $("#btnReporte").hide();
        $('#div-table').hide();
        $('#div-error').show();
    } else {
        $("#btnReporte").show();
        $('#div-table').show();
        $('#div-error').hide();
    }

    var dataPaginador = new Paginador('pagination', $('#inicio').val(), $('#total').val(), 'pag', $('#cantidad').val());
    fnPaginadorMini(dataPaginador);

    $('#btnReporte').click(function() {
        var url = "reporte_record_alumnos.html?generar&" + $("#frmFiltro").serialize();
        $("#btnReporte").attr("href", url);
    });

    /*AUTOCOMPLETE*/
    $("#nomAlumno").autocomplete({
        source: function(request, response) {
            $.ajax({
                url: "autocomplete/nomAlumnos.html",
                data: {
                    term: request.term
                },
                success: function(data) {
                    response($.map(data, function(item) {
                        return {
                            label: item.descripcion,
                            value: item.nombre,
                            id: item.idAlumno,
                            primerApellido: item.primerApellido,
                            segundoApellido: item.segundoApellido
                        };
                    }));
                }
            });
        },
        select: function(event, ui) {
            if (ui.item.value !== "000000") {
                $("#nomAlumno").val(ui.item.primerApellido + " " + ui.item.segundoApellido + " " + ui.item.value);
                $("#nombreAlumno").val(ui.item.value);
                $("#primerApe").val(ui.item.primerApellido);
                $("#segundoApe").val(ui.item.segundoApellido);
            }
            return false;
        }
    });
});

function pag(page) {
    $('#inicio').val(page);
    $.ajax({
        type: 'post',
        url: 'lista-alurecord-reporte.html',
        data: $('#frmFiltro').serialize(),
        success: function(data, textStatus, jqXHR) {
            var content = $(data).find('#listado');
            $('#listado').empty();
            var total = $(data).find('#total').val();
            var inicio = $(data).find('#inicio').val();
            var cantidad = $(data).find('#cantidad').val();

            $('#total').val(total);
            $('#inicio').val(inicio);
            $('#cantidad').val(cantidad);
            if (total > 0) {
                $('#listado').replaceWith(content);
                $('#div-error').hide();
                $('#div-table').show();
            } else {
                $('#div-error').show();
            }
            var dataPaginador = new Paginador('pagination', inicio, total, 'pag', cantidad);
            fnPaginadorMini(dataPaginador);
        },
        error: function(data, textStatus, jqXHR) {
            $("#msg-error").show();
        }});
}

function fnBuscar() {
    pag(1);
}

function fnLimpiarBusqueda() {
    $('.input-limpiar').val("");
    pag(1);
}

function  cargarInputBusqueda() {
    if ($('#nombreAlumno').val() !== '') {
        $('#nomAlumno').val($("#primerApe").val() + " " + $("#segundoApe").val() + ", " + $("#nombreAlumno").val());
    }
}
