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


    $.datepicker.regional['es'] = {
        closeText: 'Cerrar',
        prevText: '<< Anterior',
        nextText: 'Siguiente >>',
        currentText: 'Hoy',
        monthNames: ['Enero', 'Febrero', 'Marzo', 'Abril', 'Mayo', 'Junio',
            'Julio', 'Agosto', 'Setiembre', 'Octubre', 'Noviembre', 'Diciembre'],
        monthNamesShort: ['Ene', 'Feb', 'Mar', 'Abr', 'May', 'Jun',
            'Jul', 'Ago', 'Set', 'Oct', 'Nov', 'Dic'],
        dayNames: ['Domingo', 'Lunes', 'Martes', 'Miércoles', 'Jueves', 'Viernes', 'Sábado'],
        dayNamesShort: ['Dom', 'Lun', 'Mar', 'Mie', 'Jue', 'Vie', 'Sab'],
        dayNamesMin: ['Dom', 'Lun', 'Mar', 'Mie', 'Jue', 'Vie', 'Sab'],
        weekHeader: 'No',
        firstDay: 1,
        isRTL: false,
        showMonthAfterYear: false,
        yearSuffix: '',
        dateFormat: 'dd/mm/yy',
        changeMonth: true,
        changeYear: true
//        minDate: new Date()

    };
    $.datepicker.setDefaults($.datepicker.regional['es']);

});

function crearMensajeAjax(mensaje) {
    var DOM = '';
    var msgStyle = '';

    if (mensaje.messageType == 'SUCCESS') {
        msgStyle = "alert alert-success";
    }
    if (mensaje.messageType == 'WARNING') {
        msgStyle = "alert alert";
    }
    if (mensaje.messageType == 'ERROR') {
        msgStyle = "alert alert-error";
    }

    DOM = '<div class = "' + msgStyle + '">';
    DOM = DOM + '<button type="button" class="close" data-dismiss="alert">&times;</button>';
    for (var i = 0; i < mensaje.messages.length; i++) {
        DOM = DOM + '<strong>' + mensaje.messages[i] + '</strong> &nbsp; &nbsp;';
    }
    DOM =DOM + '</div>';
    return DOM;
}




var opcionesSpinner = {
    lines: 13, // The number of lines to draw
    length: 7, // The length of each line
    width: 4, // The line thickness
    radius: 10, // The radius of the inner circle
    corners: 1, // Corner roundness (0..1)
    rotate: 0, // The rotation offset
    color: '#002A5F', // #rgb or #rrggbb
    speed: 1, // Rounds per second
    trail: 60, // Afterglow percentage
    shadow: false, // Whether to render a shadow
    hwaccel: false, // Whether to use hardware acceleration
    className: 'spinner', // The CSS class to assign to the spinner
    zIndex: 2e9, // The z-index (defaults to 2000000000)
    top: 'auto', // Top position relative to parent in px
    left: 'auto' // Left position relative to parent in px
};

  