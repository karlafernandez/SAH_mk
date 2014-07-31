$(document).ready(function() {  
    $('#div-error').hide(); 
    var dataPaginador = new Paginador('pagination', $('#inicio').val(), $('#total').val(), 'pag', $('#cantidad').val());
    fnPaginadorMini(dataPaginador);
});

function pag(page) {
    $('#inicio').val(page);
    $.ajax({
        type: 'post',
        url: 'lista-alumnos-por-certificado-general.html?idCurGen=25',
        data: $('#frmFiltro').serialize(),
        success: function(data, textStatus, jqXHR) {
            var content = $(data).find('#listado');
            $('#listado').empty();
            var total = $(data).find('#total').val();
            var inicio = $(data).find('#inicio').val();
            var cantidad = $(data).find('#cantidad').val();
            console.log('registro desde jsp de cesar '+ total + ' ' + inicio + ' '+ cantidad);
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
    pag(1);
}

function fnBuscar(){    
    pag(1);
}


