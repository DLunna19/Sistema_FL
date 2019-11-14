<%-- 
    Document   : Productos
    Created on : 18/12/2016, 02:11:13 PM
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
        <title>Producto</title>
        <script src="JavaScript/jquery.min.js"></script>
        <script src="JavaScript/AdminMat.js"></script>
        <script src="JavaScript/BuscarMat.js"></script>
        <script src="JavaScript/mostrarAllMateriales.js"></script>
        <link rel="stylesheet" HREF="CSS/Estilo1.css">
    </head>
    <body> 
        <h2 align="center">Productos</h2>         
        <form name="formMAT" method="post" id="formMAT">
            <table border="0" align="center">
                <tbody>
                    <tr>
                        <td>
                            <input type="text" name="buscarMat" id="buscarMat"> 
                            <input type="button" value="Buscar" id="botonBuscarMat"> <br> <br>
                        </td>  
                    </tr>
                    <tr>
                        <td>
                            <input type="button" value="Mostrar todos los materiales" id="botonMostrarAllMat"> 
                            <br><br>
                        </td>
                    </tr>
                </tbody>
            </table>
            <table border="1" align="center" id="ContenidoTab">
                <thead>
                    <tr>
                        <th style="font-size:12px">Clave Material</th>
                        <th style="font-size:12px">Nombre</th>
                        <th style="font-size:12px">Unidad de Control</th>
                        <th style="font-size:12px">Precio de Lista</th>
                        <th style="font-size:12px">Peso Teorico</th>
                        <th style="font-size:12px">Administrar</th>

                    </tr>
                </thead>
                <tbody>
                    <%
                        if(!borrarAllMat)
                        {%>
                            <%=cm.getMateriales()%>
                        <%}else{%>
                            <%=cm.getMaterialesConsulta(NombreMat)%>   
                        <%}
                    %>
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
