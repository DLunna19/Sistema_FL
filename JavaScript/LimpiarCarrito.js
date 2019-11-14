/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(function (){
   $("#LimpiarCarrito").click(function (e){
      e.preventDefault();
      var porcentaje = $(this).parent().find("#Descuento").val();
      $.post("LimpiarCar",porcentaje, function (res, est, jqXHQ4){
          window.location.reload(true);
      });
   }); 
});


