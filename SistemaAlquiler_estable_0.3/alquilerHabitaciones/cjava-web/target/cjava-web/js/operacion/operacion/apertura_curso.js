$(document).ready(function() {

//traerEstados();
    $("#fechaActual").val($.datepicker.formatDate('dd/mm/yy', new Date()));

    var fecha = new Date();
    if (fecha.getMonth() === 0) {
        $("#idSelMes option[value=" + 11 + "]").attr("selected", "selected");
    }
    else {
        $("#idSelMes option[value=" + (fecha.getMonth() - 1) + "]").attr("selected", "selected");
    }

    $("#idSelAnio option[value=" + fecha.getFullYear() + "]").attr("selected", "selected");

   //MELI document.getElementById("idBtnGenerar").disabled = true;
    
    
    
//MELI    $('#idBtnGenerar').disabled=true;

    $('#idBtnGenerar').click(function() {
        if ($('#estado').text().toString() === 'true') {
            $('#idBtnGenerar').submit();
        }
        else {
            if (confirm("Se va generar la facturación sin la actualización de SUNAT. ¿Desea continuar?")) {
                $('#idBtnGenerar').submit();
            }
            else {
                spinner.stop();
                return false;
            }
        }

    });

});

function traerEstados() {
   //iniciarSpinner();
    $.ajax({
        type: 'get',
        async: false,
        url: 'detalle-curso-apertura.html?traerEstados',
        data: {
            idOperacion: $('#idOperacion').val()

        },
//         complete: function (data){
//            spinner.stop();
//        },
        success: function(data) {

            var asistencia = "icon-remove";
            var encuestas = "icon-remove";
            var alumnos = "icon-remove";
            var instructores = "icon-remove";
            var sesiones = "icon-remove";
            var calificaciones, sesiones = "icon-remove";

            if (data.estAlumnos) {
                alumnos = "icon-ok";
            }
            if (data.estInstructores) {
                instructores = "icon-ok";
            }
            if (data.estEncuesta) {
                encuestas = "icon-ok";
            }
            if (data.estCalificaciones) {
                calificaciones = "icon-ok";
            }
            if (data.estAsistencia) {
                asistencia = "icon-ok";
            }
            if (data.estSesiones) {
                sesiones = "icon-ok";
            }

            $("#listado #bodyEstados").empty();
            var DOM = '';
            DOM += '<tr > <td > Alumnos inscritos</td> '; //Requisito 	 	 	
            DOM += '<td> Agregar Alumnos <a  class="btn btn-link fa-input" href="asignar-alumno.html?idOperacion='+$('#idOperacion').val()+'"><i class="icon-pencil"></i></a> </td></td>'; //Agregar
            DOM += '<td > --- </td> '; //Nº de Alumnos
            DOM += '<td > <i class = "' + alumnos + '" > </i> </td > ';  //Estado
            DOM += '<td id="estado_1" class="oculto">' + data.estAlumnos + '</td > </tr> ';

            DOM += '<tr > <td > Instructores asignados </td> ';
            DOM += '<td> Agregar Instructores <a  class="btn btn-link fa-input" href="asignar-instructor.html?idOperacion= '+$('#idOperacion').val()+'"><i class="icon-pencil"></i></a> </td></td>';
            DOM += '<td > --- </td> ';
            DOM += '<td > <i class = "' + instructores + '" > </i> </td >  ';
            DOM += '<td id="estado_2" class="oculto">' + data.estInstructores + '</td > </tr> ';

            DOM += '<tr > <td > Programación de sesiones </td> ';
//            DOM += '<td> Agregar Sesiones <a  class="btn btn-link fa-input" href="registrar-sesiones.html?idOpe='+$('#idOperacion').val()+'"><i class="icon-pencil"></i></a> </td></td>';
            DOM += '<td> Agregar Sesiones <a  class="btn btn-link fa-input" href="listar-cronograma.html?idOperacion='+$('#idOperacion').val()+'"><i class="icon-pencil"></i></a> </td></td>';
            DOM += '<td > --- </td> ';
            DOM += '<td > <i class = "' + sesiones + '" > </i> </td >  ';
            DOM += '<td id="estado_3" class="oculto">' + data.estSesiones + '</td > </tr> ';
            
            DOM += '<tr > <td > Inasistencias </td> ';
            DOM += '<td> Registrar Justificación <a  class="btn btn-link fa-input" href="lista-operacion-alumno.html?idOperacion='+$('#idOperacion').val()+'"><i class="icon-pencil"></i></a> </td></td>';
            DOM += '<td > --- </td> ';
            DOM += '<td > <i class = "' + /* asistencia  */ ""+ '" > </i> </td > ';
            DOM += '<td id="estado_4" class="oculto">' + data.estAsistencia + '</td > </tr> ';

            DOM += '<tr > <td > Criterio de Calificación </td> ';
            DOM += '<td> Registrar porcentajes <a  class="btn btn-link fa-input" href="modificar-criterio-calif.html?idOperacion= '+$('#idOperacion').val()+'"><i class="icon-pencil"></i></a> </td></td>';
            DOM += '<td > --- </td> ';
            DOM += '<td > <i class = "' + calificaciones + '" > </i> </td > ';
            DOM += '<td id="estado" class="oculto">' + data.estCalificaciones + '</td > </tr> ';
            
            DOM += '<tr >  <td > Eventos </td> ';
            DOM += '<td> Registro eventos <a  class="btn btn-link fa-input" href="listar-evento.html?idOperacion='+$('#idOperacion').val()+'"><i class="icon-pencil"></i></a> </td></td>';
            DOM += '<td > --- </td> ';
            DOM += '<td > </td > ';
            DOM += '<td id="estado" class="oculto"> </td > </tr> ';

            DOM += '<tr >  <td > Abandono </td> ';
            DOM += '<td> Registro abandono <a  class="btn btn-link fa-input" href="listar-alumno-abandono.html?idOperacion='+$('#idOperacion').val()+'"><i class="icon-pencil"></i></a> </td></td>';
            DOM += '<td > --- </td> ';
            DOM += '<td > </td > ';
            DOM += '<td id="estado" class="oculto"> </td > </tr> ';

            DOM += '<tr > <td > Encuestas </td> ';
            DOM += '<td> Registrar Encuestas <a  class="btn btn-link fa-input" href="mantenimiento.html?"><i class="icon-pencil"></i></a> </td></td>';
            DOM += '<td > --- </td> ';
            DOM += '<td > <i class = "' + encuestas + '" > </i> </td > ';
            DOM += '<td id="estado" class="oculto">' + data.estEncuesta + '</td > </tr> ';

            $("#listado #bodyEstados").append(DOM);

        }
    });
  //  activarBoton();
}
//function cantEstadosValidos() {
//    var cantidad = 0;
//    $('#bodyEstados tr').each(function(i) {
//        if ($('#estado_' + (i + 1)).text() !== "") {
//            var est = $('#estado_' + (i + 1)).text().toString();
//            if (est === "true") {
//                cantidad++;
//            }
//        }
//    });
//    return cantidad;
//}
//function activarBoton() {
//    if (cantEstadosValidos() > 1) {
//        document.getElementById("idBtnGenerar").disabled = false;
//}
//    else {
//        document.getElementById("idBtnGenerar").disabled = true;
//    }
//}
//function iniciarSpinner() {
//    var target = document.getElementById('spinner');
//    spinner = new Spinner(opcionesSpinner).spin(target);
//}


var spinner;