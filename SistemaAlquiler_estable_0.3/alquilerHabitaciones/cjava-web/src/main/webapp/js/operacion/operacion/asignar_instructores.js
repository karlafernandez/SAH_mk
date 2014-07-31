$(document).ready(function() {
//    calcularMtoAjuste();
 

    $("#fechaInicio").val($.datepicker.formatDate('dd/mm/yy', new Date()));
    $("#fechaFin").datepicker();

    $('#validacionDatos').hide();// PARA QUE NO APAREZCA HASTA QUE SE PRESIONE BUSCAR
    $("#cmbErrorEmision").hide();
    $("#obsErrorEmision").hide();


    /*AUTOCOMPLETE*/
    $("#nomInstructor").autocomplete({
        source: function(request, response) {
            $.ajax({
                url: "autocomplete/nomInstructores.html",
                data: {
                    term: request.term
                },
                success: function(data) {
                    response($.map(data, function(item) {
                        // $('#nomInstructores').val(item.value);
                        return {
                           label: item.descripcion,
                            value: item.nombre,
                            id: item.idInstructor,
                            primerApellido: item.primerApellido,
                            segundoApellido: item.segundoApellido
                            
                        };
                    }));
                }
            });
        },
        //        source: ,
        select: function(event, ui) {
            if (ui.item.value !== "000000")
            { 
                $("#nomInstructor").val(ui.item.value + " " + ui.item.primerApellido + " " + ui.item.segundoApellido);
                $("#nombreInstructor").val(ui.item.nombre);
                $("#primerApe").val(ui.item.primerApellido);
                $("#segundoApe").val(ui.item.segundoApellido);
                $("#idInstructor").val(ui.item.id);
               
            }
            return false;
        }
    });
});








function agregarLista(){
  //alert($('#idOperacion').val());
  //alert($('#idInstructor').val());
    $.ajax({
        type: 'post',
        async: false,
        
        url: 'asignar-instructor.html?activarInstructor',
        data: {
            idInstructor: $('#idInstructor').val(),
            idOperacion: $('#idOperacion').val()
        },
        success: function(data, textStatus, jqXHR) {
            window.location.href = "asignar-instructor.html?idOperacion="+$('#idOperacion').val();
        },
        error: function(data, textStatus, jqXHR) {
            $("#msg-error").show();
        }
    });
}



function eliminarRow(elem,idOperacionInstructor,idOperacion) {

    if (confirm("Con esta acción eliminará el instructor. ¿Desea continuar?")) {
        eliminarInstructorOperacion(idOperacionInstructor, idOperacion);
        $(elem).parent().parent().remove();
    }
}

function eliminarInstructorOperacion(idOperacionInstructor,idOperacion) {
   //alert($('#idOperacionAlumno').val());
    //alert(idOperacion);
    $.ajax({
        type: 'get',
        async: false,
        url: 'asignar-instructor.html?eliminar',
        data: {
            idOperacion: idOperacion,
            idOperacionInstructor: idOperacionInstructor
               
        },
        success: function(data, textStatus, jqXHR) {
        },
        error: function(data, textStatus, jqXHR) {
            $("#msg-error").show();
        }
    });
}




