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
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author David
 */
public class ModificarMaterial extends HttpServlet {

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
        
        String claveMaterial = request.getParameter("ClaveMaterial");
        String nombreMaterial = request.getParameter("NombreMaterial");
        float precioLista = Float.parseFloat(request.getParameter("PrecioLista"));
        float pesoTeorico = Float.parseFloat(request.getParameter("PesoTeorico"));
        String Unidad = request.getParameter("UnidadControl");
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
            
            Material mat = new Material(claveMaterial, nombreMaterial, Unidad, precioLista, pesoTeorico);
            controladorMaterial con = new controladorMaterial();
            if(con.modificarMaterial(mat))
            {
                response.getWriter().println("Material modificado exitosamente");
            }else{
                response.getWriter().println("Error al modificar Material");
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
