/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
String.prototype.noSpace = function() {
    return this.replace(/(^\s*)|(\s*$)|[ ]/g, "");
};

$(document).ready(function() {

    //agrega estilo a la div error 
    $('span[id*="errors"]').parents('div[class*="control-group"]').addClass('error');
    $('.close_messagebox').click(function(e) {
        $(this).parent().remove();
    });


    
});







  