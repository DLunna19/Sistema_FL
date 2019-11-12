<%-- 
    Document   : SelecionMatCotizacion
    Created on : 6/01/2017, 12:56:36 AM
    Author     : David
--%>

<%@page import="Controlador.controladorMaterial"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
        <% 
            controladorMaterial cm = new controladorMaterial();
            
            HttpSession ObjSession = request.getSession(true);
            String NombreMat ="";
            boolean borrarAllMat = false;
            
            try{
                borrarAllMat = (boolean) ObjSession.getAttribute("borrarAllMat");                
                NombreMat = (String)ObjSession.getAttribute("NombreMat");
            }catch(Exception e){
                
            }
        %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Agregar Material</title>
        <script src="JavaScript/jquery.min.js"></script>
        <script src="JavaScript/BuscarMat.js"></script>
        <script src="JavaScript/AgregarCarrito.js"></script>
        <script src="JavaScript/mostrarAllMateriales.js"></script>
        <link rel="stylesheet" HREF="CSS/Estilo1.css">
    </head>
    <body>
        <h2 align="center">Agregar material a cotizacion</h2>
        <form name="formAgregarMat" method="post" id="formAgregarMat">
            <table border="0" align="center">
                    <tr>
                        <td>
                            <input type="text" name="buscarMatCoti" id="buscarMatCoti"> 
                            <input type="button" value="Buscar" id="botonBuscarMatCoti"> 
                            <br><br>
                        </td>  
                    </tr>
                    <tr>
                        <td>
                            <input type="button" value="Mostrar todos los materiales" id="botonMostrarAllMat"> 
                            <br><br>
                        </td>
                    </tr>
            </table>
            <table border="1" align="center" id="ContenidoTab">
                <thead>
                    <tr>
                        <th style="font-size:12px">Clave Material</th>
                        <th style="font-size:12px">Nombre</th> 
                        <th style="font-size:12px">Unidades</th> 
                    </tr>
                </thead>
                <tbody>
                    <%=cm.getMatParaCotizacion(NombreMat,borrarAllMat)%>
                </tbody>
            </table>   
            <br>
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
