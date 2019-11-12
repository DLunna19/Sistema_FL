/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(function (){
    $("tr #a-quitarMaterial").click(function (e){
        e.preventDefault();
        var fila = $(this).parent().parent();
        var claveMaterial = $(this).parent().parent().find("#td-ClaveMaterial").find("#ClaveMaterial").val();
        $.ajax({
            url : 'EliminarCarrito',
            type: 'POST',
            data : {claveMaterial:claveMaterial},
            success: function (r) {
                fila.remove();
            }
        });
    });
});


