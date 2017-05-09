
var model;
var view;
var controller;

function pageLoad(event) {
    model = new AirlineModel();
    view = new AirlineView(model);
    controller = new AirlineController(model,view);
    
    
    jQuery(function(){
        $("#btnBuscar").click(function(){controller.buscar();});
        $("#salida").datepicker({dateFormat:"dd/mm/yy"});
        $("#llegada").datepicker({dateFormat:"dd/mm/yy"});
    });
   
 
}

document.addEventListener("DOMContentLoaded", pageLoad);
