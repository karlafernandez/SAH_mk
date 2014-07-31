$(document).ready(function(){   
   $('.in-horini').attr('readonly', true);
   $('.in-horfin').attr('readonly', true);
   $('.in-numhor').attr('readonly', true);
   for(var i = 0; i < 7; i++){
       var idCheckBox = document.getElementById(("listSesCheck" +  i));       
       if(idCheckBox.checked == true){           
            $("#listSesHorIni" + i).attr('readonly', false);
            $("#listSesHorFin" + i).attr('readonly', false);
            $("#listSesNumHor" + i).attr('readonly', false);         
       }
   }
});

function activarInput(val){
    var idCheckBox = document.getElementById(("listSesCheck" +  val));
    var idHorIni = "#listSesHorIni" + val;
    var idHorFin = "#listSesHorFin" + val;
    var idNumHor = "#listSesNumHor" + val;    
    if(idCheckBox.checked == true){        
        $(idHorIni).attr('readonly', false);
        $(idHorFin).attr('readonly', false);
        $(idNumHor).attr('readonly', false);
        
    }else{
        $(idHorIni).val("");
        $(idHorFin).val("");
        $(idNumHor).val("");                                
        $(idHorIni).attr('readonly', true);
        $(idHorFin).attr('readonly', true);
        $(idNumHor).attr('readonly', true);         
        var fieldHorIni = document.getElementById(("listSesHorIni" +  val));
        var fieldHorFin = document.getElementById(("listSesHorFin" +  val));
        fieldHorIni.style.backgroundColor = '#eeeeee';
        fieldHorFin.style.backgroundColor = '#eeeeee';
    }    
}
