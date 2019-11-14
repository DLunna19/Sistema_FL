<%-- 
    Document   : index
    Created on : 3/11/2016, 09:34:59 PM
    Author     : David
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%
    HttpSession ObjSession = request.getSession(true);
    String usuario = ""; 
  try{
      usuario = (String) ObjSession.getAttribute("Usuario");
      if (usuario.equals("false"))
      {
        String mensaje="<script language='javascript'>alert('Usuario o contraseña incorrectos');</script>"; 
        out.println(mensaje); 
      }
  }catch(Exception e)
  {
      System.err.println("Error al registrar Usuario!!");  
  }
%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Login</title>
        <script src="JavaScript/MainIndex.js"> </script>
        <link rel="stylesheet" HREF="CSS/Estilo1.css">
    </head>
    <body>
        <center>
        <h2>Inicio de Sesion</h2>
        <form action="Inicio" method="post" id="FormLogin">
            <table border="0" align="center">
                <tbody>
                    <tr>
                        <th>Usuario</th>
                        <td>
                            <input type=text name=usuario id="Usuario">                            
                        </td>
                    </tr>
                    <tr>
                        <th>Contraseña</th>
                        <td><input type=password name=pass id="Pass"></td>
                    </tr>
                </tbody>
            </table>
            
            <table border="0" align="center">
                <tbody>
                    <tr>
                        <td style="text-align:center">
                            <input type=button value=Entrar id="BotonIni">
                        </td>  
                    </tr>
                </tbody>
            </table>
        </form>
        </center>
    </body>
</html>
