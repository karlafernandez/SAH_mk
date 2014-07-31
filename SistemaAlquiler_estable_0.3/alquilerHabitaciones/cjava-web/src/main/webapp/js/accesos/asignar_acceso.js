$(document).ready(function() {

//
    cargarUsuario($('#hidIdUsuario').val());


    $('.modulo').change(function() {
        var contenedor = "#" + $(this).parent().attr('id') + " .opcion";
        if ($(this).attr('checked')) {
            $(contenedor).attr('checked', 'checked');
        } else {
            $(contenedor).removeAttr('checked');
        }
    });


    $('#btnAsignar').click(function() {
        var id = $("#hidIdUsuario").val()
        if (id == 0) {
            alert("Debe seleccionar un usuario al cual asignar accesos")
        } else {
            $('#hidIdUsuario').val(id)
            var lstAccesos = $('#divAccesos input.opcion:checkbox:checked').map(function() {
                return this.value;
            }).get();

            $('#hidLstAccesos').val(lstAccesos);
            $('#frmAsignarAcceso').submit();
        }
    });
   $('#divAccesos').easytabs({
        animate: false});

});



function cargarUsuario(elem) {
    $('#divAccesos').show();
    $.ajax({
        dataType: 'json',
        type: 'POST',
        url: 'listar_accesos.html',
        data: {
            idUsuario: elem
        },
        success: function(data) {
            $("input").removeAttr('checked');
            if (data != null) {
                for (var i = 0; i < data.length; i++) {
                    var id = "#check_" + data[i];
                    $(id).attr('checked', 'checked'); 
                } 
            } else {
                $("input").removeAttr('checked');
            }
        }
    });


}