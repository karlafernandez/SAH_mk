$(document).ready(function(){    
    $("#fieldsetSubmit").hide();
    $('.check-nojust').hide();
});

function reiniciarChecks(){
    $('.check-just').attr('checked', false);
    $('.check-just').attr('disabled', false);
    $('.check-nojust').attr('checked', false);    
}

function cambiarEstado(val){
    if(val == 1){
        $("#botonesJust").hide();
        $("#fieldsetSubmit").show();
    }else{
        $("#botonesJust").show();
        $("#fieldsetSubmit").hide();
    }
    $("#motJust").val("");
}

function fnJustficar(){
    cambiarEstado(1);    
    $('.check-nojust').attr('checked', false);    
}

function cancelarJustificacion(){
    cambiarEstado(0);
    reiniciarChecks();
}

function mostrarJustificacion(contenido, posId){    
    var id="#listaAsis"+posId;
    fnJustficar();    
    reiniciarChecks();
    $('.check-just').attr('disabled', true);    
    $(id).attr('checked', true);
    $("#motJust").val(contenido);
}   