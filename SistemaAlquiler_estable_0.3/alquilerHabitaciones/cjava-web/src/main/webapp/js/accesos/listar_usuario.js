$(document).ready(function() {


    $('#btnBuscar').click(function() {
        $('#divMensaje').hide();
        $.ajax({
            dataType: 'json',
            type: 'GET',
            url: 'listar_usuarios.html',
            data: {
                nomPersona: $('#inpNomPersona').val()
            },
            success: function(data) {
                if (data != null) {
                    construirTabla(data);
                }
                else {
                    limpiarTabla();
                }
            }
        });
    });
    
    $( "#btnBuscar" ).trigger( "click" )
});

function construirTabla(data) {
    var DOM = poblarTabla(data);
    $('#divUsuariosWrapper').html(DOM);
}

function poblarTabla(data) {
    var color_fila = 'row-pair';
    var grilla = eval(data);
    var DOM = '<table id="tbl" class="dataTable">';
    DOM += '<thead><tr>';
    DOM += '<th>Usuario</th>';
    DOM += '<th>Nombre</th>';
    DOM += '<th>Apellido</th>';
    DOM += '<th>Correo</th>';
    DOM += '<th>Accesos</th>';
    DOM += '</tr></thead><tbody>';
    $.each(grilla, function(i, p) {
        if (i % 2 == 0)
            color_fila = 'row-pair';
        else
            color_fila = 'row-impair';
        DOM += '<tr id=' + i + ' class="' + color_fila + '"  >';
        DOM += '<td>' + p.nomUsuario + '</td>';
        DOM += '<td>' + p.nomNombre + '</td>';
        DOM += '<td>' + p.nomApePaterno + '</td>';
        DOM += '<td>' + p.email + '</td>';
        DOM += '<td><a href="asignar_acceso.html?idUsuario=' + p.idUsuario + '">Asignar Accesos</a></td>';


    });

    DOM += '</tbody></table>';
    return DOM;
}
 