$(document).ready(function() {
//    calcularMtoAjuste();
 

    $("#fechaInicio").val($.datepicker.formatDate('dd/mm/yy', new Date()));
    $("#fechaFin").datepicker();

    $('#validacionDatos').hide();// PARA QUE NO APAREZCA HASTA QUE SE PRESIONE BUSCAR
    $("#cmbErrorEmision").hide();
    $("#obsErrorEmision").hide();
    $("#msgBadFormat").hide();

    

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
                       // $('#nomAlumnos').val(item.value);
                        return {
//                            label: item.descripcion,
//                            value: item.nombre,
//                            nomAlumno: item.nombre,
//                            idAlumno: item.idAlumno,
//                            documento: item.documento
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
                $("#nomAlumno").val(ui.item.value + " " + ui.item.primerApellido + " " + ui.item.segundoApellido);
                $("#nombreAlumno").val(ui.item.nombre);
                $("#primerApe").val(ui.item.primerApellido);
                $("#segundoApe").val(ui.item.segundoApellido);
                $("#idAlumno").val(ui.item.id);
            }
            return false;
        }
    });


});

function mostrarTablaAlumno(alumm){
    $("#cuerpoTablaAlumno").empty();
    var DOM = '<tr>';
    
    DOM += '<td>' + alumm.nombre + '</td>';
    DOM += '<td>' + alumm.documento + '</td>';
   
    DOM += '</tr>';
    $("#cabeceraTablaAlumno #cuerpoTablaAlumno").append(DOM);    
    $("#tablaAlumno").show();
}




 
function agregarLista(){
  //alert($('#idOperacion').val());
   //alert(idOperacion);
   var cantFo = $('#cantFotos').val()
   if(cantFo== ""){
    $('#cantFotos').val("0");
    console.log("cantidad de fotos " + cantFo);
   }
   var cantFo = $('#cantFotos').val()
   console.log("cantidad de fotos " + cantFo);
    $.ajax({
        type: 'post',
        async: false,
        
        url: 'asignar-alumno.html?activarAlumno',
        data: {
            idAlumno: $('#idAlumno').val(),
            idOperacion: $('#idOperacion').val(),
            cantFotos: $('#cantFotos').val()            
        },
        success: function(data, textStatus, jqXHR) {
            window.location.href = "asignar-alumno.html?idOperacion="+$('#idOperacion').val();
            $("#msgBadFormat").hide();
        },
        error: function(data, textStatus, jqXHR) {
            console.log("no pasa nada")
            $("#msgBadFormat").show();
        }
    });
}



function eliminarRow(elem,idOperacionAlumno,idOperacion) {

    if (confirm("Con esta acción eliminará el alumno. ¿Desea continuar?")) {
        eliminarAlumnoOperacion(idOperacionAlumno, idOperacion);
        $(elem).parent().parent().remove();
    }
}

function eliminarAlumnoOperacion(idOperacionAlumno,idOperacion) {
  // alert(idOperacionAlumno);
  //  alert(idOperacion);
    $.ajax({
        type: 'post',
        async: false,
        url: 'asignar-alumno.html?eliminar',
        data: {
            idOperacion: idOperacion,
            idOperacionAlumno: idOperacionAlumno
            },
        success: function(data, textStatus, jqXHR) {
        },
        error: function(data, textStatus, jqXHR) {
            $("#msg-error").show();
        }
    });
}




