/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

function llenarUsuario() {
   // alert("dddd");
    var cuestVirtual = $("#porcCuestionarioVirtual").val();
    var tareaVirtual = $("#porcTareaVirtual").val();
    var practicas = $("#porcPracticas").val();
    var evalParcial = $("#porcPracticas").val();
    var evalFinal = $("#porcPracticas").val();
    var usTemporal = "";
   
//    if ( parseInt(cuestVirtual) == null) {
//       var cuestVirtual = $("#porcCuestionarioVirtual").val() ==  0 ;
//       }
    usTemporal = parseInt(cuestVirtual) + parseInt(tareaVirtual) + parseInt(practicas) +parseInt(evalParcial)+ parseInt(evalFinal);
    $("#porcNotaFinal").val(usTemporal);
     alert("cuestVirtual");
    
//    if (cuestVirtual.length > 0 && tareaVirtual.length > 0) {
//        if (tareaVirtual.length > 7) {
//            tareaVirtual = tareaVirtual.substr(0, 8);
//        }
//        usTemporal = cuestVirtual.substr(0, 1) + tareaVirtual + apeM.substr(0, 1);
//        $("#usuario").val(usTemporal.noSpace().toLowerCase());
//    }
    
}
