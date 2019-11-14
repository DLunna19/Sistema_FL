/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
window.addEventListener
(
        'load', function()
{
    document.getElementById('BotonIni').addEventListener('click', function(){
        var Nombre = document.getElementById('Usuario').value;
        var Pass = document.getElementById('Pass').value;
        var Bandera = false;
                
        if(Nombre.length > 0 && Pass.length > 0){
            Bandera = true;
        }
        if(Bandera)
        {
            document.getElementById('FormLogin').submit();
        }else
        {
            alert("Rellena Todos los campos");
        }       
    })
}
);

