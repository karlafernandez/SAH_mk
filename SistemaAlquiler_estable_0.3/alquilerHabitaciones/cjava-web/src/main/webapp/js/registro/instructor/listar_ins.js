
$(document).ready(function() {
    var total = $('#total').val();
    $('#div-error').hide();
    if (total > 0) {
        $("#msg-empty-table").hide();
        $("#div-table").show();

    } else {
        $("#msg-empty-table").show();
        $("#div-table").hide();
    }
    var dataPaginador = new Paginador('pagination', $('#inicio').val(), $('#total').val(), 'pag', $('#cantidad').val());
    fnPaginadorMini(dataPaginador);

});
function pag(page) {
    $('#inicio').val(page);
    $.ajax({
        type: 'post',
        url: 'listarInstructores.html',
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
            }else{                                
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
    $('#div-error').hide();
    pag(1);
}


function fnCerrar() {
    $('#dialog').dialog('close');
}

function eliminarRow(elem, id) {

    if (confirm("Con esta acción eliminará el instructor. ¿Desea continuar?")) {
        eliminarInstructor(id);
        $(elem).parent().parent().remove();
    }
}

function eliminarInstructor(id) {
    $.ajax({
        type: 'get',
        async: false,
        url: 'listarInstructores.html?eliminar',
        data: {
            idInstructor: id
        },
        success: function(data, textStatus, jqXHR) {
        },
        error: function(data, textStatus, jqXHR) {
            $("#msg-error").show();
        }
    });
}