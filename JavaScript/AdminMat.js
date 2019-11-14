/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(function (){
    $("tr #a-eliminar").click(function (e){
        e.preventDefault();
        var fila = $(this).parent().parent();
        var nombreMat = fila.find("#Id-NombreMaterial").find("#NombreMaterial").val();
        var opcion = confirm("Desea eliminar el material: \""+nombreMat+"\"");
        if(opcion)
        {
            var data = {nombreMaterial:nombreMat};
            $.post("EliminarMat", data, function (res, est, jqXHR){
                alert(res);
                fila.remove();
        });
        }
    });
    $("#modificarMat").click(function (e){
       e.preventDefault();
       var data = $('#formModificarMat').serialize();
       $.post("ModificarMat", data, function (res, est, jqXHR2){
            alert(res);
            location.href = 'mostrarMateriales.jsp';
        });
    });
});


