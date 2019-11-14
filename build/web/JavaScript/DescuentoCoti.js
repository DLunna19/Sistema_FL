/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(function(){
    $("#AplicarDesc").click(function (e){
       e.preventDefault();
       var porcentaje = $(this).parent().find("#Descuento").val();
       $.ajax({
           url: 'DescuentoCoti',
            type: 'POST',
            data : {porcentaje:porcentaje},
            success: function (data, textStatus, jqXHR) {
                window.location.reload(true);
            }
       });
    });
});

