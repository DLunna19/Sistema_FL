window.addEventListener
(
        'load', function()
{
    document.getElementById('BotonMat').addEventListener('click', function(){
        var Clave = document.getElementById('ClaveMaterial').value;
        var Nombre = document.getElementById('Nombre').value;
        var UnidadControl = document.getElementById('UnidadControl').value;
        var PrecioLista = document.getElementById('PrecioLista').value;
        var PesoTeorico = document.getElementById('PesoTeorico').value;
        var Bandera = false;
                
        if(Clave.length>0 && Nombre.length> 0 && UnidadControl.length>0 && 
                PrecioLista.length>0 && PesoTeorico.length>0){
            Bandera = true;
        }
        if(Bandera)
        {
            document.getElementById('formMAT').submit();
        }else
        {
            alert("Rellena todos los campos");
        }       
    })
}
);

