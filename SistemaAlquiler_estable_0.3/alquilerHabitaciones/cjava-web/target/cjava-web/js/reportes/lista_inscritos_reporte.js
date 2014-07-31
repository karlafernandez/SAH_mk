$(document).ready(function() {

    if ($('#total').val() <= 0) {
        $("#btnReporte").hide();
        $('#div-table').hide();
    } else {
        $("#btnReporte").show();
        $('#div-table').show();
    }
    
    var dataPaginador = new Paginador('pagination', $('#inicio').val(), $('#total').val(), 'pag', $('#cantidad').val());
    fnPaginadorMini(dataPaginador);

    $('#btnReporte').click(function() {
        var url = "reporte_alumnos_inscritos.html?generar&" + $("#frmFiltro").serialize();
        $("#btnReporte").attr("href", url);
    });
    $("#fechaInicioOp").datepicker({yearRange: "1945:2080", formatDate: "dd/mm/yy"});
    $("#fechaFinOp").datepicker({yearRange: "1945:2080", formatDate: "dd/mm/yy"});
});

function pag(page) {
    $('#inicio').val(page);
    $.ajax({
        type: 'post',
        url: 'lista-inscritos-reporte.html',
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
                /*Sólo para lista_inscritos_reporte*/
                $("#btnReporte").show();
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
    $('#idEstadoTodo').prop('checked', true);
    pag(1);
}



