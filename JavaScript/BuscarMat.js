/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(function (){
   $("#botonBuscarMat").click(function (e){
        e.preventDefault();
        var buscarMat = $(this).parent().find("#buscarMat").val();
        var data = {BuscarMat:buscarMat};
        $.post("ConsultarMat", data, function (res, est, jpXHR3){
            window.location.reload(true);
        });
    }); 
    
       $("#botonBuscarMatCoti").click(function (e){
        e.preventDefault();
        var buscarMat = $(this).parent().find("#buscarMatCoti").val();
        var data = {BuscarMat:buscarMat};
        $.post("ConsultarMat", data, function (res, est, jpXHR3){
            window.location.reload(true);
        });
    }); 
});