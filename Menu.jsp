<%-- 
    Document   : Menu
    Created on : 3/11/2016, 10:04:19 PM
    Author     : David
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    HttpSession ObjSession = request.getSession(true);
    boolean admin = false;
    try{
        
    }catch(Exception e){
        
    }
    String usuario = (String) ObjSession.getAttribute("Usuario");
    admin = (boolean) ObjSession.getAttribute("Admin");
    
if (usuario.equals(""))
{
    response.sendRedirect("index.jsp");
}
%>    
<html>
    <head>    
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0,, minimum-scale=1.0">
        <title>Inicio</title>
        <link rel="stylesheet" HREF="CSS/Estilo1.css">
    </head>
    <body>
        <center>
            <div class="Banner">
                <img src="BANNER-UNITRADE.png" alt="" class="Banner-img">
                    <div class="Banner-texto">
                        <h1>Bienvenido</h1>
                        <h2><%out.println(usuario);%></h2>
                    </div>
            </div>         
            <div class="contenedor-menu" >
                <nav class="nav-menu">
                    <ul class="menu">
                        <h5>Menu</h5>             
                    <%
                        if(admin)
                        { 
                            %>
                            <li class="menu-item"><a class="menu-link" href="RegistroUsuario.jsp">Registrar Nuevo Usuario</a> <br><br></li>
                            <li class="menu-item"><a class="menu-link" href="crearMaterial.jsp">Nuevo Material</a> <br><br></li>
                            <%  
                        }    
                    %>       
                        <li class="menu-item"><a class="menu-link" href="mostrarMateriales.jsp">Mostrar Productos</a><br><br></li>
                        <li class="menu-item"><a class="menu-link" href="SelecionMatCotizacion.jsp">Cotizacion</a></li>
                    </ul>
                </nav>  
            </div>
        </center>
    </body>
</html>
