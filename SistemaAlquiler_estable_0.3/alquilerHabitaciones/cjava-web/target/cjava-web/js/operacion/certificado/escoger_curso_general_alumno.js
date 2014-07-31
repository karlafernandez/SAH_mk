$(document).ready(function(){
   
    var idVar = 0;
    $("#tablaAlumno").hide();
    
    $("#alumno").autocomplete({
        source:function(request, response){
            $.ajax({
               url: "autocomplete/nomAlumnoCursoGeneral.html",
               data:{
                   term: request.term
               },
               success: function(data){
                   response($.map(data, function(item){                       
                       return{
                           label: item.nombreCompleto + " ( DNI " + item.documento + ")",
                           value: item.nombreCompleto,
                           nomAlum: item.nombreCompleto,
                           numDoc: item.documento,
                           idAlumno: item.idAlumno                          
                       };
                   }));
               }
            });                           
        },
        
        select: function(event, ui){
            if(ui.item.nomAlum != "00000"){                
                aumentarTablaAlumno(ui.item, idVar);
                $("#idAlumno"+idVar).val(ui.item.idAlumno);
                $("#idAlumnoEscogio"+idVar).val("true");
                $('#nomAlumnoCursoGeneral').val();                
                console.log("valor del id " + ui.item.idAlumno);
                idVar++;
            }
            return false;
        }
    });    
});

function aumentarTablaAlumno(alum, idVar){
    var DOM = '<tr id="filaAlum' + idVar +'">';
    DOM += '<td>' + alum.nomAlum;
    DOM += '<input id="idAlumno' + idVar + '" type="hidden" value="" name="listaAlumno[' + idVar + '].idAlumno">';
    DOM += '<input id="idAlumnoEscogio' + idVar + '" type="hidden" value="" name="listaAlumno[' + idVar + '].valido">';
    DOM += '</td>';
    DOM += '<td>' + alum.numDoc + '</td>';
    DOM += '<td style="text-align: center;"> <a class="btn btn-link"  onclick="eliminarAlumno('+ idVar +')" ><i class="icon-remove"></i></a></td>';
    DOM += '</tr>';
    $("#cabeceraTablaAlumno #cuerpoTablaAlumno").append(DOM);
    $("#tablaAlumno").show();
}

function eliminarAlumno(idVar){
    var id = "#idAlumnoEscogio" + idVar;
    var idFila = "#filaAlum" + idVar;
    $(id).val("false");
    $(idFila).hide();
}