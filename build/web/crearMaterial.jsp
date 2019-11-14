<%-- 
    Document   : crearMaterial
    Created on : 13/12/2016, 04:46:48 PM
    Author     : David
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    HttpSession ObjSession = request.getSession(true);
    boolean MtRepetido = false;
    
    try{
        MtRepetido = (boolean) ObjSession.getAttribute("MatRepetido");
    }catch(Exception e){
        
    }
    if(MtRepetido)
    {
        String mensaje="<script language='javascript'>alert('Ya existe este material');</script>"; 
        out.println(mensaje); 
    }
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Crear Material</title>
        <script src="JavaScript/crearMaterial.js"> </script>
        <link rel="stylesheet" HREF="CSS/Estilo1.css">
    </head>
    <body>
        <h2 align="center">Nuevo Material</h2>
        <form name="formMat" action="nuevoMaterial" method="post" id="formMAT">
            <table border="0" align="center">
                <tbody>
                    <tr>
                        <th>Clave Material</th>
                        <td><input align="center" type="text" name="ClaveMaterial" id="ClaveMaterial"></td>
                    </tr>
                    <tr>
                        <th>Nombre</th>
                        <td> <input type="text" name="Nombre" id="Nombre"> </td>
                    </tr>
                    <tr>
                        <th>Unidad de Control</th>
                        <td> <select name="UnidadControl" id="UnidadControl"> 
                                <option> </option>
                                <option value="1">Kilo</option>
                                <option value="2">Litro</option>
                                <option value="3">Pieza</option>
                                <option value="4">Metros</option>
                             </select>
                        </td>
                    </tr>
                    <tr>
                        <th>Precio de Lista</th>
                        <td> <input type="number" step="any" name="PrecioLista" id="PrecioLista"> </td>
                    </tr>
                    <tr>
                        <th>Peso Teorico</th>
                        <td> <input type="number" step="any" name="PesoTeorico" id="PesoTeorico"> </td>
                    </tr>
                </tbody>
            </table>
            
            <table border="0" align="center">
                <tbody>
                    <tr>
                        <td style="text-align:center">
                            <input type="button" value="Nuevo" id="BotonMat"> <br><br>
                        </td>  
                    </tr>
                </tbody>
            </table>            
            <table align="center">
                <tr>
                    <td>
                        <input type="button" value="Volver" onclick="location.href = 'Menu.jsp'">
                    </td>
                </tr>
            </table>
        </form>
    </body>
</html>
