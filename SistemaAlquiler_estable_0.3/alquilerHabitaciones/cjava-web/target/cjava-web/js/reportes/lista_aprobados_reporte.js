$(document).ready(function() {

    cargarInputBusqueda();
    var tamBody = $('#tbodyJ tr').length;
    $('#notaA_1').css({"color": "#63AF57"});
    $('#notaJ_' + tamBody).css({"color": "#E53751"});

    if ($('#totalA').val() <= 0 && $('#totalJ').val() <= 0) {
        $("#btnReporte").hide();
    }
    $('#btnReporte').click(function() {
        var url = "reporte_aprobados_operacion.html?generar&" + $("#frmFiltro").serialize();
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
                $("#nomAlumno").val(ui.item.primerApellido + " " + ui.item.segundoApellido + ", " + ui.item.value);
                $("#nombreAlumno").val(ui.item.value);
                $("#primerApe").val(ui.item.primerApellido);
                $("#segundoApe").val(ui.item.segundoApellido);
                $("#idAlumno").val(ui.item.id);
            }
            return false;
        }
    });
});


function fnLimpiarBusqueda() {
    $('.input-limpiar').val('');
    $('#btnBuscar').trigger('click');
}
function  cargarInputBusqueda() {
    if ($('#nombreAlumno').val() !== '') {
        $('#nomAlumno').val($("#primerApe").val() + " " + $("#segundoApe").val() + ", " + $("#nombreAlumno").val());
    }
}