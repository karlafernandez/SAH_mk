


$(document).ready(function() {

//   if(poblarCriterio2() == 0)
//   {
    //  poblarCriterio3(); 
    //  cargarDatosCriterio4() 

//   }
//   else
    poblarCriterio2();

    $('#btnAgregarRow').click(function() {
        agregarRow();

    });


    $(function() {
        $('#tbodyTelefono span').live('click', function() {
            var input = $('<input/>', {
                'type': 'text',
                'name': 'aname',
                'class': 'dinamic',
                'value': $(this).html()
            });
            $(this).parent().append(input);
            $(this).remove();
            input.focus();
        });

        $('#tbodyTelefono input.dinamic').live('blur', function() {
            $(this).parent().append($('<span />').html($(this).val()));
            $(this).remove();
        });
    });   
    desactivarInput($('#isStarted').val());
});

function agregarRow() {
    var DOM = '<tr>';
    DOM += '<td>' + ($("#tbodyTelefono tr").length + 1) + '</td> ';
    var num = $("#tbodyTelefono tr").length;

    DOM += '<td><input id="tipo_calificacion_' + num + '" class="span-3" type="text" ></td>';
    DOM += '<td><input id="detalleCalif_' + num + '" class="span-3" type="text" ></td>';
    DOM += '<td><input id="porcentaje_' + num + '" class="span-3" type="text" onkeyup="sumaPorcentaje(' + num + ');" ></td>';
    $('#tbodyTelefono').append(DOM);
    $(".tipo_fono").focus();
}

function cargarInfo() {
    var datos = [];
    var len = $("#tblCriterio #tbodyTelefono tr").length;

    for (var i = 0; i < len; i++) {

        var nombreSubtipoCalif = $('#tipo_calificacion_' + i).val();
        var cantidad = $('#detalleCalif_' + i).val();
        var porcentaje = $('#porcentaje_' + i).val();
        var subtipoIdCalif = $('#subTipoIdCal_' + i).val();

        datos.push([nombreSubtipoCalif, cantidad, porcentaje, subtipoIdCalif]);
    }

    return datos;
}

function cargarDatosCriterio() {
    var datos = cargarInfo();

    var DOM = '';
    for (var i = 0; i < datos.length; i++) {
        DOM += '<input class="oculto" name="listaDetalleCalif[' + i + '].nombreSubtipoCalif" value="' + datos[i][0] + '"/>';
        DOM += '<input class="oculto" name="listaDetalleCalif[' + i + '].subtipoIdCalif" value="' + datos[i][3] + '"/>';
        if (datos[i][3] == 21) {
            DOM += '<input class="oculto" name="cantCV" value="' + datos[i][1] + '"/>';
            DOM += '<input class="oculto" name="porcCV" onkeyup="sumaPorcentaje(' + i + ');" value="' + datos[i][2] + '"/>';
        }
        if (datos[i][3] == 22) {
            DOM += '<input class="oculto" name="cantTV" value="' + datos[i][1] + '"/>';
            DOM += '<input class="oculto" name="porcTV" onkeyup="sumaPorcentaje(' + i + ');" value="' + datos[i][2] + '"/>';
        }
        if (datos[i][3] == 23) {

            DOM += '<input class="oculto" name="cantPR" value="' + datos[i][1] + '"/>';
            DOM += '<input class="oculto" name="porcPR" onkeyup="sumaPorcentaje(' + i + ');" value="' + datos[i][2] + '"/>';
        }
        if (datos[i][3] == 24) {
            DOM += '<input class="oculto" name="cantEP" value="' + datos[i][1] + '"/>';
            DOM += '<input class="oculto" name="porcEP" onkeyup="sumaPorcentaje(' + i + ');" value="' + datos[i][2] + '"/>';

        }
        if (datos[i][3] == 25) {
            DOM += '<input class="oculto" name="cantEF" value="' + datos[i][1] + '"/>';
            DOM += '<input class="oculto" name="porcEF" onkeyup="sumaPorcentaje(' + i + ');" value="' + datos[i][2] + '"/>';

        }
        /////




    }
    sumarMontos();
    $('#divReco').append(DOM);

}

function eliminar(elem) {
    $(elem).parent().parent().remove();
}


function sumaPorcentaje() {
    // alert("dddd");
    var suma = 0;
    $("input[id*='porcentaje_']").each(function(index) {
//        console.log(index + ": " + $(this).val());
        suma =parseInt( suma ) + parseInt($(this).val());
    });
    $("#porcentajeTotal").val(suma);
    verificarPorc();

}


function verificarPorc(){
    
    if( $("#porcentajeTotal").val() != 100){
   //   message('El porcentaje total debe ser igual a 100%')
      $("#mensaje1").fadeIn("slow");            
    }
     else{
      $("#mensaje1").fadeOut();
     }
    
    
}


function poblarCriterio2() {
//    $.ajax({
//        type: 'post',
//        async: false,
//        url: 'modificar-criterio-calif.html?traerCriterio',
//        data: {idOperacion: $('#idOperacion').val()},
//        success: function(data, textStatus, jqXHR) {
//
//            $('#tblCriterio #tbodyTelefono').empty();
//
//
//
//            if (data.listaDetalleCalif !== null && data.listaDetalleCalif.length > 0) {
//                for (var i = 0, len = data.listaDetalleCalif.length; i < len; i++) {
//                    var DOM = '<tr id="num_' + i + '"> ';
//                    DOM += '<td  id="num_' + i + '" >' + (i + 1) + '</td>';
//                    DOM += '<td><input style="display:none" id="subTipoIdCal_' + i + '" class="span-3" type="text" value=" ' + data.listaDetalleCalif[i].subtipoIdCalif + '" ></td>';
//                    DOM += '<td><input id="tipo_calificacion_' + i + '" class="span-3" type="text" value="' + data.listaDetalleCalif[i].nombreSubtipoCalif + '" ></td>';
//
//
//                    if (data.listaDetalleCalif[i].subtipoIdCalif == 21) {
//                        DOM += '<td><input id="detalleCalif_' + i + '" class="span-3" type="text" value="' + data.cantCV + '" ></td>';
//                        DOM += '<td><input id="porcentaje_' + i + '" class="span-3" type="text" onkeyup="sumaPorcentaje(' + i + ');" value= "' + data.porcCV + '"></td>';
//                    }
//                    if (data.listaDetalleCalif[i].subtipoIdCalif == 22) {
//                        DOM += '<td><input id="detalleCalif_' + i + '" class="span-3" type="text" value="' + data.cantTV + '" ></td>';
//                        DOM += '<td><input id="porcentaje_' + i + '" class="span-3" type="text" onkeyup="sumaPorcentaje(' + i + ');" value= "' + data.porcTV + '"></td>';
//                    }
//                    if (data.listaDetalleCalif[i].subtipoIdCalif == 23) {
//                        DOM += '<td><input id="detalleCalif_' + i + '" class="span-3" type="text" value="' + data.cantPR + '" ></td>';
//                        DOM += '<td><input id="porcentaje_' + i + '" class="span-3" type="text" onkeyup="sumaPorcentaje(' + i + ');" value= "' + data.porcPR + '"></td>';
//                    }
//                    if (data.listaDetalleCalif[i].subtipoIdCalif == 24) {
//                        DOM += '<td><input id="detalleCalif_' + i + '" class="span-3" type="text" value="' + data.cantEP + '" ></td>';
//                        DOM += '<td><input id="porcentaje_' + i + '" class="span-3" type="text" onkeyup="sumaPorcentaje(' + i + ');" value= "' + data.porcEP + '"></td>';
//                    }
//                    if (data.listaDetalleCalif[i].subtipoIdCalif == 25) {
//                        DOM += '<td><input id="detalleCalif_' + i + '" class="span-3" type="text" value="' + data.cantEF + '" ></td>';
//                        DOM += '<td><input id="porcentaje_' + i + '" class="span-3" type="text" onkeyup="sumaPorcentaje(' + i + ');" value= "' + data.porcEF + '"></td>';
//                    }
//
//
//
//
//                    DOM += '</tr>';
//                    $("#tblCriterio #tbodyTelefono").append(DOM);
//                    $('#tipo_calificacion_' + i + ' option[value="' + data.listaDetalleCalif[i].subtipoIdCalif + '"]').attr("selected", "selected");
//                }
//            }
//                sumarMontos();
////            else {
////                 for (var i = 0, j=21; i< 5; i++, j++) {
////                  
////                    var DOM = '<tr id="num_' + i + '"> ';
////                    DOM += '<td  id="num_' + i + '" >' + (i + 1) + '</td>';
////                    DOM += '<td><input id="tipo_calificacion_' + i + '" class="span-3" type="text" value=" ' + j + '" ></td>';
////                    DOM += '<td><input id="detalleCalif_' + i + '" class="span-3" type="text" value=" ' + 0 + '" ></td>';
////                    DOM += '<td><input id="porcentaje_' + i + '" class="span-3" type="text" onkeyup="sumaPorcentaje('+i+');" value= "' + 0 + '"></td>';
////               
////                   DOM += '</tr>';
////                    $("#tblCriterio #tbodyTelefono").append(DOM);
////                   
////                  
////                }
////
////            }
//
//        },
//        error: function(dataa, textStatus, jqXHR) {
//            $("#msg-error").show();
//        }
//    });
}


function sumarMontos() {
    var total = 0;
    $("#porcentajeTotal").val(0);
    $("#tbodyTelefono tr").each(function(i) {
        total = parseInt($("#porcentaje_" + i).val()) + total;
        $("#porcentajeTotal").val(total);
    });
}

function desactivarInput(val){
    if(val == 'true'){
        $('.classCriterio').attr('disabled', true);
        $('.classPorcen').attr('disabled', true);
    }else{
        $('.classCriterio').attr('disabled', false);
        $('.classPorcen').attr('disabled', false);
    }
}