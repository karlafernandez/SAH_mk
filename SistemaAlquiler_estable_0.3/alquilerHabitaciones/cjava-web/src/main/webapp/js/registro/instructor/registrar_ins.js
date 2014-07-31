/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).ready(function() {

    $('#nombre').focus();
//    $("#fechaNacimiento").val($.datepicker.formatDate('dd/mm/yy', new Date()));
//    $("#fechaNacimiento").datepicker();
    $("#fechaNacimiento").val($.datepicker.formatDate('dd/mm/yy', new Date(2000, 01, 01)));
    $("#fechaNacimiento").datepicker({yearRange: "1945:2024"});

    obtenerPaises();
// obteniendo departamento
    $("#pais").change(function() {
        var idPais = $("#pais option:selected").val();
        $("#idPais").val(idPais);
        $("#idDepartamento").val('00');
        $("#idProvincia").val('00');
        $("#idDistrito").val('00');
        obtenerDepartamento(idPais);
    });
// obteniendo provincias
    $("#departamento").change(function() {
        var idPais = $("#pais option:selected").val();
        var idDepartamento = $("#departamento option:selected").val();
        $("#idDepartamento").val(idDepartamento)
        $("#idProvincia").val('00')
        $("#idDistrito").val('00')

        obtenerProvincias(idPais, idDepartamento);
    });
// obteniendo distritos
    $("#provincia").change(function() {
        var idPais = $("#pais option:selected").val();
        var idDepartamento = $("#departamento option:selected").val();
        var idProvincia = $("#provincia option:selected").val();
        $("#idDistrito").val('00')
        $("#idProvincia").val(idProvincia)
        obtenerDistritos(idPais, idDepartamento, idProvincia);
    });



//   $("#departamentos").val($('#departamento').val()).change();
    $('#btnGuardar').click(function() {
        // cargarDatosTelefono();
        $('#frmDatosInstructor').submit();
    });
    $("#msg-error").hide();
});




function obtenerPaises() {
    $(function() {
        $.ajax({
            url: 'obtenerPais.html',
            async: false,
            success: function(data) {
                var DOM = "";
                $("#departamento").empty().append("<option value='0'>Seleccione uno</option>");
                $("#provincia").empty().append("<option value='0'>Seleccione uno</option>");
                $("#distrito").empty().append("<option value='0'>Seleccione uno</option>");
                var pais = $("#idPais").val();
                $.each(data, function(i, p) {
                    if (p.codigo != pais) {
                        DOM = DOM + "<option value='" + p.codigo + "'>" + p.nombre + "</option>";
                    } else {
                        DOM = DOM + "<option selected='selected' value='" + p.codigo + "'>" + p.nombre + "</option>";
                    }
                });

                $("#pais").append(DOM);
                if (pais != null && pais != 0) {
                    obtenerDepartamento(pais);
                }


            }

        });

    });
}
function obtenerDepartamento(idPais) {

    $(function() {
        $.ajax({
            url: 'obtenerDepartamentos.html',
            data: {codPais: idPais},
            async: false,
            success: function(data) {
                $("#departamento").empty().append("<option value='0'>Seleccione uno</option>");
                $("#provincia").empty().append("<option value='0'>Seleccione uno</option>");
                $("#distrito").empty().append("<option value='0'>Seleccione uno</option>");
                var departamento = $("#idDepartamento").val();
                $.each(data, function(i, p) {
                    if (p.codigo != departamento) {
                        $("#departamento").append("<option value='" + p.codigo + "'>" + p.nombre + "</option>");
                    } else {
                        $("#departamento").append("<option selected='selected' value='" + p.codigo + "'>" + p.nombre + "</option>");
                    }

                });
                if (idPais != null && idPais != 0 && departamento != null && departamento != 0) {
                    obtenerProvincias(idPais, departamento);
                }

            }

        });

    });

}

function obtenerProvincias(idPais, idDepartamento) {
    $("#provincia").empty();
    $.ajax({
        url: 'obtenerProvincias.html',
        data: {codPais: idPais,
            codDepartamento: idDepartamento},
        async: false,
        success: function(data) {
            $("#provincia").empty().append("<option value='0'>Seleccione uno</option>");
            $("#distrito").empty().append("<option value='0'>Seleccione uno</option>");
            var provincia = $("#idProvincia").val();
            $.each(data, function(i, p) {
                if (p.codigo != provincia) {
                    $("#provincia").append("<option value='" + p.codigo + "'>" + p.nombre + "</option>");
                } else {
                    $("#provincia").append("<option  selected='selected' value='" + p.codigo + "'>" + p.nombre + "</option>");

                }

            });

            if (idPais != null && idPais != 0 && idDepartamento != null && idDepartamento != 0 && provincia != null && provincia != 0) {
                obtenerDistritos(idPais, idDepartamento, provincia);
            }


        }
    });
}

function obtenerDistritos(idPais, idDepartamento, idProvincia) {
    $("#distrito").empty();
    $.ajax({
        url: 'obtenerDistritos.html',
        data: {codPais: idPais,
            codDepartamento: idDepartamento,
            codProvincia: idProvincia},
        async: false,
        success: function(data) {
            $("#distrito").empty().append("<option value='0'>Seleccione uno</option>");
            var distrito = $("#idDistrito").val();
            $.each(data, function(i, p) {
                if (p.codigo != distrito) {
                    $("#distrito").append("<option value='" + p.codigo + "'>" + p.nombre + "</option>");
                } else {
                    $("#distrito").append("<option  selected='selected' value='" + p.codigo + "'>" + p.nombre + "</option>");

                }

            });
        }
    });

}

function llenarUsuario() {
    var nombre = $("#nombre").val();
    var apeP = $("#primerApellido").val();
    var apeM = $("#segundoApellido").val();
    var usuTemporal = "";
    if (nombre.length > 0 && apeP.length > 0) {
        if (apeP.length > 7) {
            apeP = apeP.substr(0, 8);
        }
        usuTemporal = nombre.substr(0, 1) + apeP + apeM.substr(0, 1);
        $("#usuario").val(usuTemporal.noSpace().toLowerCase());
    }
}




















function agregarRow() {
    var DOM = '<tr>';
    DOM += '<td>' + ($("#tbodyTelefono tr").length + 1) + '</td> ';
    var num = $("#tbodyTelefono tr").length;
    DOM += '<td><select id="tipo_fono_' + num + '" class="span-3" style="margin-top: 0px" >';
    DOM += '<option value="58">FIJO</option>';
    DOM += '<option value="59">CLARO</option>';
    DOM += '<option value="60">MOVISTAR</option>';
    DOM += '<option value="61">RPC</option>';
    DOM += '<option value="62">RPM</option>';
    DOM += '<option value="63">OTRO</option>';
    DOM += '</select></td>';
    DOM += '<td><input id="numTelefono_' + num + '" class="span-3" type="text" ></td>';
//    DOM += '<td><input id="apoderado_' + num + '" class="span-3" type="text" ></td>';
    DOM += '<td><select id="apoderado_' + num + '" class="span-3" style="margin-top: 0px" >';
    DOM += '<option value="64">TITULAR</option>';
    DOM += '<option value="65">ESPOSO(A)</option>';
    DOM += '<option value="66">PADRE</option>';
    DOM += '<option value="67">MADRE</option>';
    DOM += '<option value="68">HIJO</option>';
    DOM += '<option value="69">EMPLEADA</option>';
    DOM += '<option value="70">OTRO</option>';
    DOM += '</select></td>';

    DOM += '<td><span onclick="eliminar(this)" class="ui-icon ui-icon-trash" > </span></td>';
    $('#tbodyTelefono').append(DOM);
    $(".tipo_fono").focus();
}
function cargarInfo() {
    var datos = [];
    var len = $("#tblPromotor #tbodyTelefono tr").length;
    for (var i = 0; i < len; i++) {

        var idTipoFono = $('#tipo_fono_' + i + ' option:selected').val();
        var numTelefono = $('#numTelefono_' + i).val();
        var apoderado = $('#apoderado_' + i + ' option:selected').val();
        datos.push([idTipoFono, numTelefono, apoderado]);

    }
    return datos;
}

function cargarDatosTelefono() {
    var datos = cargarInfo();

    var DOM = '';
    for (var i = 0; i < datos.length; i++) {
        DOM += '<input class="oculto" name="lstTelefono[' + i + '].idTipoFono" value="' + datos[i][0] + '"/>';
        DOM += '<input class="oculto" name="lstTelefono[' + i + '].numTelefono" value="' + datos[i][1] + '"/>';
        DOM += '<input class="oculto" name="lstTelefono[' + i + '].apoderado" value="' + datos[i][2] + '"/>';
    }

    $('#divReco').append(DOM);

}

function eliminar(elem) {
    $(elem).parent().parent().remove();
}
function limpiarPromotor() {
    $('#idPromotor').val("");
    $('#mtoComision').val("");
    $('#nombrePromotor').val("");
    $('#nomProm').val("");
    $('#idTipPromotor').val("");
}

//function buscarPromotor() {
//    $.ajax({
//        type: 'get',
//        async: false,
//        url: 'datos_basicos.html?buscar',
//        data: {
//            term: $('#nombrePromotor').val()
//        },
//        success: function(data) {
//            $('#idPromotor').val("");
//            $('#mtoComision').val("");
//            $('#nombrePromotor').val("");
//            $('#nomProm').val("");
//            $('#idTipPromotor').val("");
//            
//            if (data !== null) {
//                $('#idPromotor').val(data.idPromotor);
//                $('#mtoComision').val(data.mtoComision);
//                $('#nombrePromotor').val(data.nomPromotor);
//                $('#nomProm').val(data.nomPromotor);
//                $('#idTipPromotor').val(data.idTipPromotor);
//            }
//            else {
//                $('#mtoComision').hide();
//                $('#nomProm').hide();
//                $('#comProm').hide();
//                $('#limpiar').hide();
//                $("#msg-error").show();
//            }
//
//        },
//        error: function(data, textStatus, jqXHR) {
//    $('#idPromotor').val("");
//            $('#mtoComision').val("");
//            $('#nombrePromotor').val("");
//            $('#nomProm').val("");
//            $('#idTipPromotor').val("");
//            $("#msg-error").show();
//            $('#mtoComision').hide();
//            $('#nomProm').hide();
//            $('#comProm').hide();
//            $('#limpiar').hide();
//        }
//    });
//}
