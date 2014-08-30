/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).ready(function() {

    //$('#nombre').focus();
    $("#fechaNac").val($.datepicker.formatDate('dd/mm/yy', new Date(2000, 01, 01)));
    $("#fechaNac").datepicker({yearRange: "1945:2024"});


    
    $("#msg-error").hide();
});
