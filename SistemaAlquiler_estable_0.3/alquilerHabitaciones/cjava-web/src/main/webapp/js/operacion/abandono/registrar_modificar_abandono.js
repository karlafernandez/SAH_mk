$(document).ready(function() {
    
    $("#textAreaMotivo").hide();

    $("#abandono").change(function() {
        var corporativo = $("#abandono option:selected").val();
        if (corporativo == "true") {
            $("#listaEmpresa").show();
            $('#textAreaMotivo').focus();
        }
        else
            $("#textAreaMotivo").hide();
    });

});


