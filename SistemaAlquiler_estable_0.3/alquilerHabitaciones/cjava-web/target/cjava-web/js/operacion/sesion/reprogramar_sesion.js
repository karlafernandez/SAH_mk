$(document).ready(function() {
 
    $("#aplazarCrono").hide(); 
    $("#nuevaFecha").val($.datepicker.formatDate('dd/mm/yy', new Date()));
    $("#nuevaFecha").datepicker({yearRange: "2014:2024"});
           
    $("#tipoCambio").change(function(){
       var tipoCambio = $("#tipoCambio option:selected").val();       
       if(tipoCambio == "true"){
           $("#aplazarCrono").show();           
           $("#moverFecha").hide();
            reiniciarField(1);
       }else{
           $("#aplazarCrono").hide();           
           $("#moverFecha").show();           
           reiniciarField(0);
       }
    });


});

function reiniciarField(tipo){
    if(tipo == 0){
        $("#nuevaFecha").val("");
        $("#horInicioNueva").val("");
        $("#horFinNueva").val("");
        var fieldHorIni = document.getElementById("horInicioNueva");
        var fieldHorFin = document.getElementById("horFinNueva");
        fieldHorIni.style.backgroundColor = '#eeeeee';        
        fieldHorFin.style.backgroundColor = '#eeeeee';
    }else if(tipo == 1){
        $("#numDias").val("");
    }
}

