<%-- 
    Document   : modificarMaterial
    Created on : 20/12/2016, 12:18:15 AM
    Author     : David
--%>

<%@page import="Controlador.controladorMaterial"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Modificar Material</title>
        <script src="JavaScript/jquery.min.js"></script>
        <script src="JavaScript/AdminMat.js"></script>
        <link rel="stylesheet" HREF="CSS/Estilo1.css">
    </head>
    <body>
        <h2 align="center">Modificar</h2>
        <form name="formMat" action="nuevoMaterial" method="post" id="formModificarMat">
            <table border="0" align="center">
                <tbody>
                    <%controladorMaterial cm=new controladorMaterial(); %>
                    <%= cm.getMaterial(request.getParameter("ClaveMaterial")) %>
                </tbody>
            </table>
            <table border="0" align="center">
                <tbody>
                    <tr>
                        <td style="text-align:center">
                            <input type="button" value="Modificar" id="modificarMat">
                            <input type="button" value="Volver" onclick="location.href = 'mostrarMateriales.jsp'">
                        </td>  
                    </tr>
                </tbody>
            </table>
        </form>
    </body>
</html>
