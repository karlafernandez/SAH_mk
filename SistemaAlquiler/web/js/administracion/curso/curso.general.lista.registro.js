$(document).ready(function() {  
    $('#div-error').hide(); 
    var dataPaginador = new Paginador('pagination', $('#inicio').val(), $('#total').val(), 'pag', $('#cantidad').val());
    fnPaginadorMini(dataPaginador);
});

function pag(page) {
    $('#inicio').val(page);
    $.ajax({
        type: 'post',
        url: 'lista-curso-general.html',
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

function fnLimpiarBusqueda() {
    $('.input-limpiar').val("");
    $('#div-error').hide();
    pag(1);
}

function fnBuscar(){    
    pag(1);
}

function eliminarRow(elem, id) {

    if (confirm("Con esta acción eliminará el curso. ¿Desea continuar?")) {
        eliminarCurso(id);
        $(elem).parent().parent().remove();        
    }    
}

function eliminarCurso(id) {
    $.ajax({
        type: 'post',
        async: false,
        url: 'lista-curso-general.html?eliminar',
        data: {
            idCurGenPlantilla: id
        },
        success: function(data, textStatus, jqXHR) {
            pag(1);
        },
        error: function(data, textStatus, jqXHR) {
            $("#msg-error").show();
        }
    });
}

