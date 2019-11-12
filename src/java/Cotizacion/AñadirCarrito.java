/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cotizacion;

import Materiales.Material;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author David
 */
public class AñadirCarrito extends HttpServlet {

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
        
        String Clave = request.getParameter("ClaveMaterial");
        String Nombre = request.getParameter("NombreMaterial");
        String Unidad = request.getParameter("UnidadControl");
        float PrecioLista = Float.parseFloat(request.getParameter("PrecioLista"));
        float PesoTeorico = Float.parseFloat(request.getParameter("PesoTeorico"));
        int Cantidad = Integer.parseInt(request.getParameter("Cantidad"));
        
        HttpSession sesion = request.getSession(true);
        ArrayList<Cotizacion> cotizacion; 
        
        if(sesion.getAttribute("cotización") == null)
        {
            cotizacion = new ArrayList<>(); 
        }else{   
            cotizacion = (ArrayList)sesion.getAttribute("cotización");
        }
        
        boolean bandera = false;
        if(cotizacion.size()>0)
        {
            for (Cotizacion c : cotizacion) 
            {
                if(Clave.equals(c.getClaveMaterial()))
                {
                    c.setCantidadMaterial(c.getCantidadMaterial() +  Cantidad);
                    bandera = true;
                    break;                    
                }                
            }
        }
        if(!bandera)
        {
             cotizacion.add(new Cotizacion(Clave, Nombre, Unidad, PrecioLista, PesoTeorico, Cantidad));
        }
        
        sesion.setAttribute("cotización", cotizacion);
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
