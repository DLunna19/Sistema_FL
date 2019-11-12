/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(function () {
    $("tr #a-agregar").click(function (e){
        e.preventDefault();
        var ClaveMaterial = $(this).parent().parent().find("#td-ClaveMaterial").find("#ClaveMaterial").val();
        var NombreMaterial = $(this).parent().parent().find("#td-NombreMaterial").find("#NombreMaterial").val();
        var UnidadControl = $(this).parent().parent().find("#td-UnidadControl").find("#UnidadControl").val();
        var PrecioLista = $(this).parent().parent().find("#td-PrecioLista").find("#PrecioLista").val();
        var PesoTeorico = $(this).parent().parent().find("#td-PesoTeorico").find("#PesoTeorico").val();
        var Cantidad = $(this).parent().parent().find("#td-Cantidad").find("#Cantidad").val();
        
        var confirmarCantidad = confirm("¿Desea agregar "+Cantidad+" "+NombreMaterial+ "?");
        
        if(confirmarCantidad)
        {
            var campos = {ClaveMaterial:ClaveMaterial, NombreMaterial:NombreMaterial, UnidadControl:UnidadControl, PrecioLista:PrecioLista, PesoTeorico:PesoTeorico, Cantidad:Cantidad};
            $.post("AgregarCarrito",campos, function (res, est, jqXHQ4){
            location.href = 'Cotizacion.jsp';
        });            
        }
    }); 
});
