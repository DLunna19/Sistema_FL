<%-- 
    Document   : Cotizacion
    Created on : 6/01/2017, 12:34:08 AM
    Author     : David
--%>

<%@page import="Materiales.Material"%>
<%@page import="Cotizacion.Cotizacion"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    HttpSession sesion = request.getSession(true);
    ArrayList<Cotizacion> cotizacion = (ArrayList)sesion.getAttribute("cotización");
    boolean DescuentoTrue = false;
    try {
         DescuentoTrue = (boolean)sesion.getAttribute("DescuentoTrue");   
        } 
    catch (Exception e) {
        }
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cotizacion</title>
        <script src="JavaScript/jquery.min.js"></script>
        <script src="JavaScript/EliminarCarrito.js"> </script>
        <script src="JavaScript/DescuentoCoti.js"> </script>
        <script src="JavaScript/LimpiarCarrito.js"> </script>
        <link rel="stylesheet" HREF="CSS/Estilo1.css">
    </head>
    <body>
        <h2 align="center">Cotizacion</h2>
        <form name="formCotizacion" action="CotizacionPDF"method="post" id="formCotizacion">
            <table border="0" align="center">
                    <tr>
                        <td>
                            <input type="button" value="Agregar Material" onclick = "location='SelecionMatCotizacion.jsp'" id="botonAbrirSelection">
                            <br> <br>
                        </td>  
                    </tr>
            </table>
            <table border="1" align="center" id="ContenidoTab">
                <thead>
                    <tr>
                        <th style="font-size:12px">Clave Material</th>
                        <th style="font-size:12px">Nombre</th>
                        <th style="font-size:12px">Unidad de Control</th>
                        <th style="font-size:12px">Precio Unitario</th>
                        <th style="font-size:12px">Peso Teorico</th>
                        <th style="font-size:12px">Cantidad</th>   
                        <th style="font-size:12px">Precio total</th>   
                    </tr>
                </thead>
                <tbody>
                    <%
                        double totalCotizacion = 0;
                        for(Cotizacion c: cotizacion)
                        {
                            float totalMaterial = (c.getPrecioLista()*c.getCantidadMaterial());
                            totalCotizacion += totalMaterial;
                            
                            sesion.setAttribute("PrecioMaterial"+c.getClaveMaterial(), totalMaterial);
                    %>
                    <tr>
                        <td id="td-ClaveMaterial"><input align="center" type="text" name="ClaveMaterial" id="ClaveMaterial" size="6" readonly value="<%=c.getClaveMaterial()%>"></td>
                        <td id="Id-NombreMaterial"> <textarea name="NombreMaterial" id="NombreMaterial" rows="1" readonly> <%=c.getNombreMaterial()%>  </textarea></td>
                        <td id="td-UnidadControl"> <input type="text" name="UnidadControl" id="UnidadControl" size="9" readonly value="<%=c.getUnidadControl()%>"> 
                        <td id="td-PrecioLista"> <input type="text" name="PrecioLista" id="PrecioLista" size="6" readonly value="<%=c.getPrecioLista()%>"> </td>
                        <td id="td-PesoTeorico"> <input type="text" name="PesoTeorico" id="PesoTeorico" size="5" readonly value="<%=c.getPesoTeorico()%>"> </td>
                        <td id="td-cantidadMaterial"> <input type="text" name="cantidadMaterial" id="cantidadMaterial" size="5" readonly value="<%=c.getCantidadMaterial()%>"> </td>
                        <td id="td-precioTotalMat"> <input type="number" name="precioTotalMat" id="precioTotalMat" size="3" min="0" max="10000" readonly value="<%=totalMaterial%>"> </td>
                        <td> <a id="a-quitarMaterial" href="">Quitar</a></td>
                    </tr>
                    <%}%>
                </tbody>
            </table>      
            <table border="2" align="center">
                <tbody>
                    <tr>
                        <%
                            if (DescuentoTrue)
                            {
                                totalCotizacion = (Double)sesion.getAttribute("CostoCotizacion");
                            }
                        %>
                        <td> Costo Total: <%=totalCotizacion%></td>
                        <%
                            sesion.setAttribute("CostoCotizacion", totalCotizacion);
                        %>
                    </tr>
                </tbody>
            </table>
            <br><br>
            <table border="0" align="center" id="TablaDes">
                <tr>
                    <td>
                        Descuento:
                        <select name="Descuento" id="Descuento">
                            <option> </option>
                            <option value="1">%1</option>
                            <option value="2">%2</option>
                            <option value="3">%3</option>                                    
                        </select>
                        <input type="button" value="Aplicar" name="AplicarDesc" id="AplicarDesc">
                    </td> 
                </tr>
            </table>
            <br>
            <table border="0" align="center">                                    
                <tr>
                    <td>
                        <input type="submit" value="Generar PDF">
                        <input type="button" value="Limpiar Cotizacion" id="LimpiarCarrito">
                    </td> 
                </tr>
            </table>
        </form>
    </body>
</html>
