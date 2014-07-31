$(document).ready(function() {
 
    $("#fecInicio").val($.datepicker.formatDate('dd/mm/yy', new Date()));
    $("#fecInicio").datepicker({yearRange: "2014:2024"});
    $("#fecFin").val($.datepicker.formatDate('dd/mm/yy', new Date()));
    $("#fecFin").datepicker({yearRange: "2014:2024"});
    $("#listaEmpresa").hide();
    $("#tablaCurso").hide();
        
    $("#tipoCurso").change(function(){
       var corporativo = $("#tipoCurso option:selected").val();       
       if(corporativo == "true")
           $("#listaEmpresa").show();           
       else
           $("#listaEmpresa").hide();           
    });

    /*AUTOCOMPLETE*/
    $("#curso").autocomplete({
        source: function(request, response) {
            $.ajax({
                url: "autocomplete/nomCursoEsp.html",
                data: {
                    term: request.term
                },
                success: function(data) {
                    response($.map(data, function(item) {
                        $('#nomCursoEsp').val(item.value);
                        return {
                            label: item.nomCurso + " (" + item.numSesion + " ses)",
                            value: item.nomCurso,
                            nomenCurso: item.nomenCurso,    
                            idCurEsp: item.idCursoEspecifico,
                            nomCurso: item.nomCurso,
                            numHora: item.numHora,
                            numSesion: item.numSesion
                        };
                    }));
                }
            });
        },
        //        source: ,
        select: function(event, ui) {
            if (ui.item.nomenCurso !== "00000"){
                console.log("  ==== > value " + ui.item.value + " " + ui.item.idCurEsp + " asdsad ");
                $("#idCurEsp").val(ui.item.idCurEsp);
                mostrarTablaCurEsp(ui.item);                
            }else{
                $("#tablaCurso").hide();
                $("#idCurEsp").val(0);
            }   
            return false;
        }
    });
});


function mostrarTablaCurEsp(curEsp){
    $("#cuerpoTablaCurso").empty();
    var DOM = '<tr>';
    DOM += '<td class="hidden-phone">' + curEsp.nomenCurso + '</td>';
    DOM += '<td>' + curEsp.nomCurso + '</td>';
    DOM += '<td>' + curEsp.numHora + '</td>';
    DOM += '<td class="hidden-phone">' + curEsp.numSesion + '</td>';    
    DOM += '</tr>';
    $("#cabeceraTablaCurso #cuerpoTablaCurso").append(DOM);    
    $("#tablaCurso").show();
}
