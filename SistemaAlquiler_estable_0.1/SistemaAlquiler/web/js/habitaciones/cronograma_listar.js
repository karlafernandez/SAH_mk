/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).ready(function() {

    var today = new Date();
    var todayDate;
    if (today.getMonth() + 1 < 10) {
        if (today.getDate() < 10) {
            todayDate = today.getFullYear() + "-0" + (today.getMonth() + 1) + "-0" + today.getDate();
        } else {
            todayDate = today.getFullYear() + "-0" + (today.getMonth() + 1) + "-" + today.getDate();
        }
    } else {
        todayDate = today.getFullYear() + "-" + (today.getMonth() + 1) + "-" + today.getDate();
    }

    $('#div-info').hide();
    $('#calendar').fullCalendar({
        defaultView: 'year',
        header: {
            left: 'none',
            center: 'title',
            right: 'prev,next,year,month'
        },
        editable: false,
        events: "listar-cronograma/listar.html",
        dayClick: function(date, allDay, jsEvent, view) {
            window.location = 'reprogramar-cronograma.html?idCronograma=' + $(this).attr('id');
        },
        loading: function(bool) {
            $('td div.fc-div-day-' + todayDate).addClass('fc-state-highlight');
            if (bool)
                $('#loading').show();
            else
                $('#loading').hide();
        }
    });
    //mouseover sobre el día seleccionado.
    $('td[class*="fc-day"]').mouseover(function() {
        $(this).addClass('seleccionado');
    });
    $('td[class*="fc-day"]').mouseleave(function() {
        $(this).removeClass('seleccionado');
    });
    $('div.fc-div-day-' + todayDate).mouseover(function() {
        $(this).removeClass('fc-state-highlight');
        $(this).addClass('seleccionado');
    });
    $('div.fc-div-day-' + todayDate).mouseleave(function() {
        $(this).addClass('fc-state-highlight');
        $(this).removeClass('seleccionado');
    });
    $('td[class*="fc-day"]').dblclick(function() {
        if ($(this).hasClass("fc-year-have-event") || $(this).hasClass("fc-year-have-event-correcto")) {
            window.location = 'reprogramar-cronograma.html?idCronograma=' + $(this).attr('id');
        }
    });
});

function eliminarCronograma(id){
    if(confirm("Con esta accion eliminará el cronograma. ¿Desea continuar?")){
        $.ajax({
            type:'post',
            async: false,
            url: 'listar-cronograma.html?eliminar',
            data: {
                idOperacion : id
            },
            success: function(data, textStatus, jqXHR){                
                console.log(id);
                window.location = 'detalle-curso-apertura.html?idOperacion=' + id;
            },
            error: function(data, textStatus, jqXHR){
                $("#msg-error").show();
            }
        });
    }
}

