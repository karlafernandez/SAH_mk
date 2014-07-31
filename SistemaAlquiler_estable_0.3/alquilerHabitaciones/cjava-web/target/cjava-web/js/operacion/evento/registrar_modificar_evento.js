$(document).ready(function() {
    $('#nomCursoGeneral').focus();
    $('span[id*="errors"]').parents('div[class*="control-group"]').addClass('error');
     $("#listaIdCriCali").pickList({
        sourceListLabel: "Disponibles",
        targetListLabel: "Seleccionados",
        addAllLabel: "Agregar Todos",
        addLabel: "Agregar",
        removeAllLabel: "Quitar Todos",
        removeLabel: "Quitar",
        sortItems: false

    });
});