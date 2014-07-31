$(document).ready(function() {

    $('.edit').focus(function() {
        var id = $(this).attr('id');
        $('#' + id).parent('td').removeClass('control-group error');
        $('#' + id).parent('td').removeClass('control-group success');
    })
    $('.edit').change(function() {
        var id = $(this).attr('id');
        iniciarSpinner('spin');

        $.ajax({
            type: 'post',
            url: 'registro-calificacion.html',
            data: ({
                guardar: '',
                idOpe: $('#' + id).attr("data-idOpe"),
                idDet: $('#' + id).attr("data-idDetalle"),
                valor: $('#' + id).val()
            }),
            success: function(data, textStatus, jqXHR) {
                if (data.success) {
                    var rpta = data.data;
                    $('#' + id).val(rpta.valor);
                    var idOperacion = $('#' + id).attr("data-idOpe");
                    $('#prom_' + idOperacion).val(rpta.promedio);
                    $('#' + id).parent('td').removeClass('control-group error');
                    $('#' + id).parent('td').addClass('control-group success');
                } else {
                    $('#' + id).parent('td').addClass('control-group error');
                }

                //Crear MENSAJE
                $("#mensaje_calificacion").empty();
                $("#mensaje_calificacion").append(crearMensajeAjax(data));

            },
            error: function(data, textStatus, jqXHR) {
                $('#' + id).parent('td').addClass('control-group error');
            },
            complete: function( ) {
                finalizarSpinner('spin');
            }
        });
    });
});