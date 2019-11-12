/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServletMaterial;

import Controlador.controladorMaterial;
import Materiales.Material;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.servlet.*;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.tomcat.util.http.fileupload.*;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;

/**
 *
 * @author David
 */
@WebServlet(name = "CrearMat", urlPatterns = {"/nuevoMaterial"})
public class CrearMaterial extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            String Clave = request.getParameter("ClaveMaterial");
            String Nombre = request.getParameter("Nombre");
            String Unidad = request.getParameter("UnidadControl");
            float PrecioLista = Float.parseFloat(request.getParameter("PrecioLista"));
            float PesoTeorico = Float.parseFloat(request.getParameter("PesoTeorico"));
            
            if(Unidad.equals("1"))
            {
                Unidad = "Kilo";
            }
            if(Unidad.equals("2"))
            {
                Unidad = "Litro";
            }
            if(Unidad.equals("3"))
            {
                Unidad = "Pieza";
            }
            if(Unidad.equals("4"))
            {
                Unidad = "Metros";
            }
                        
            Material m = new Material(Clave, Nombre, Unidad, PrecioLista, PesoTeorico);
            controladorMaterial cm = new controladorMaterial();
            if(cm.crarMaterial(m))
            {
                HttpSession ObjSession= request.getSession(true);
                response.sendRedirect("Menu.jsp");
                ObjSession.setAttribute("MatRepetido", false);
            }else
            {           
                response.sendRedirect("crearMaterial.jsp");        
                HttpSession ObjSession= request.getSession(true);
                ObjSession.setAttribute("MatRepetido", true);
            }
        }
    }
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
