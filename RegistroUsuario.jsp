<%-- 
    Document   : RegistroUsuario
    Created on : 3/11/2016, 08:29:49 PM
    Author     : David
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%
    HttpSession ObjSession = request.getSession(true);
    boolean UsRepetido = false;
    
    try{
        UsRepetido = (boolean) ObjSession.getAttribute("UserRepetido");
    }catch(Exception e){
        
    }
    if(UsRepetido)
    {
        String mensaje="<script language='javascript'>alert('Ya existe este usuario');</script>"; 
        out.println(mensaje); 
    }
%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>RegistroUsuarios</title>
        <link rel="stylesheet" HREF="CSS/Estilo1.css">
    </head>
    <body>
        <center>
        <h2>Registro de Usuarios</h2>
        <form action="RegistroU" method="post">
            <label>Usuario<label/>
            <input type="text" name="Usuario"/><br/><br/>
            <label>Contraseña<label/>
            <input type="password" name="Pass"/><br/><br/>
            <label>Admin<label/>
                <input type="checkbox" name="check1" value="off"/>
            <input type="submit" value="Registro"/>
        </form>
        <br><br>
            <table align="center">
                <tr>
                    <td>
                        <input type="button" value="Volver" onclick="location.href = 'Menu.jsp'">
                    </td>
                </tr>
            </table>
        </center>
    </body>
</html>
