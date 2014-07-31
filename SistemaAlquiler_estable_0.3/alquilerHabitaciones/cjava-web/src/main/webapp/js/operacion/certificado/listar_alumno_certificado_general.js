$(document).ready(function(){
    
});

function ocultarDetalle(idVar){
    var idFilaTabla = "#detalleAlumno" + idVar;
    console.log("apreto el ocultar");
    $(idFilaTabla).hide();
}

function mostrarDetalle(idVar){
    var idFilaTabla = "#detalleAlumno" + idVar;
    console.log("apreto el visualizar");
    $(idFilaTabla).show();    
}

