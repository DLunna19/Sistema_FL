/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(function (){
   $("#botonMostrarAllMat").click(function (e){
       e.preventDefault();
       var borrarMat = false;
       var data = {borrarMat:borrarMat};
       $.post("mostrarAllMat", data, function (res, est, jpXHR3){
           window.location.reload(true);
       });
   }); 
});
