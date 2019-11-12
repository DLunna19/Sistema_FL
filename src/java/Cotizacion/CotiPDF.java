/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cotizacion;

import com.lowagie.text.*;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import java.awt.Color;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
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
public class CotiPDF extends HttpServlet {

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
        
        
        
        Document documento = new Document(PageSize.LETTER,50,50,50,50);
        SimpleDateFormat formatoFecha  = new SimpleDateFormat("dd/MMMMMMMM/yyyy h:mm a");
        String cadenaFecha =  formatoFecha.format(new java.util.Date());
        
        Font estiloAzulBig = new Font(Font.TIMES_ROMAN, 18, Font.BOLD,Color.BLACK);
        Font estiloAzulBig2 = new Font(Font.TIMES_ROMAN, 14,   Font.BOLD,Color.BLUE);
        Font estiloNegroBig = new Font(Font.TIMES_ROMAN, 14,   Font.BOLD,Color.BLACK);
        Font estiloNegro = new Font(Font.TIMES_ROMAN, 12,   Font.BOLD,Color.BLACK);
        Font estiloNegroLittle = new Font(Font.TIMES_ROMAN, 9, Font.BOLD,Color.BLACK);
        Font estiloAzulLittle = new Font(Font.TIMES_ROMAN, 9, Font.BOLD,Color.BLUE);
        
        try {
            HttpSession sesion = request.getSession(true);
            ArrayList<Cotizacion> cotizacion = (ArrayList)sesion.getAttribute("cotización");
            double costoTotal = (double) sesion.getAttribute("CostoCotizacion");     
            float totalMaterial = 0f;
        
            response.setContentType("application/pdf");
            PdfWriter.getInstance(documento,response.getOutputStream());
            documento.open();
            
            Paragraph fecha = new Paragraph("Fecha: "+cadenaFecha+"\n",estiloAzulLittle);
            fecha.setAlignment(Element.ALIGN_RIGHT);
            documento.add(fecha);
            Paragraph esp3 = new Paragraph(" ");
            documento.add(esp3);
      
            Paragraph titulo = new Paragraph("Cotización de pedido",estiloAzulBig);
            titulo.setAlignment(1);
            documento.add(titulo);
            
            PdfPTable tabla = new PdfPTable(7);
            tabla.setHorizontalAlignment(Element.ALIGN_CENTER); 
            
            Paragraph espacio = new Paragraph(" ");
            documento.add(espacio);
            
            PdfPCell ClaveMaterial =  new PdfPCell(new Paragraph("Clave Material",estiloNegroLittle));
            ClaveMaterial.setBorder(2);
            
            ClaveMaterial.setBackgroundColor(Color.lightGray);            
            tabla.addCell(ClaveMaterial);
            
            PdfPCell NombreMaterial =  new PdfPCell(new Paragraph("Nombre Material",estiloNegroLittle));
            NombreMaterial.setBorder(6);
            NombreMaterial.setBackgroundColor(Color.lightGray);            
            tabla.addCell(NombreMaterial);

            PdfPCell UnidadControl =  new PdfPCell(new Paragraph("Unidad Control",estiloNegroLittle));
            UnidadControl.setBorder(6);
            UnidadControl.setBackgroundColor(Color.lightGray);            
            tabla.addCell(UnidadControl);
            
            PdfPCell PrecioLista =  new PdfPCell(new Paragraph("Precio Unitario",estiloNegroLittle));
            PrecioLista.setBorder(6);
            PrecioLista.setBackgroundColor(Color.lightGray);            
            tabla.addCell(PrecioLista);
            
            PdfPCell PesoTeorico =  new PdfPCell(new Paragraph("Peso Teorico",estiloNegroLittle));
            PesoTeorico.setBorder(6);
            PesoTeorico.setBackgroundColor(Color.lightGray);            
            tabla.addCell(PesoTeorico);
            
            PdfPCell CantidadMaterial =  new PdfPCell(new Paragraph("Cantidad",estiloNegroLittle));
            CantidadMaterial.setBorder(6);
            CantidadMaterial.setBackgroundColor(Color.lightGray);            
            tabla.addCell(CantidadMaterial);
            
            PdfPCell precioTotalMat =  new PdfPCell(new Paragraph("Precio total",estiloNegroLittle));
            precioTotalMat.setBorder(6);
            precioTotalMat.setBackgroundColor(Color.lightGray);            
            tabla.addCell(precioTotalMat);
            
            for (Cotizacion c : cotizacion) {
                totalMaterial = (float) sesion.getAttribute("PrecioMaterial"+c.getClaveMaterial());
                tabla.addCell(c.getClaveMaterial());
                tabla.addCell(c.getNombreMaterial());
                tabla.addCell(c.getUnidadControl());
                tabla.addCell(""+c.getPrecioLista());
                tabla.addCell(""+c.getPesoTeorico());
                tabla.addCell(""+c.getCantidadMaterial());
                tabla.addCell(""+totalMaterial);
            }
            documento.add(tabla);
            
            PdfPTable tabla2 = new PdfPTable(2);
            tabla.setHorizontalAlignment(Element.ALIGN_RIGHT); 
            
            documento.add(espacio);
            PdfPCell CostoPedido =  new PdfPCell(new Paragraph("Costo Total del pedido: ",estiloNegroBig));
            CostoPedido.setBorder(PdfPCell.NO_BORDER);
            CostoPedido.setBackgroundColor(Color.lightGray);            
            tabla2.addCell(CostoPedido);
            
            PdfPCell TextoCostoPedido =  new PdfPCell(new Paragraph(""+costoTotal,estiloAzulBig2));
            TextoCostoPedido.setBorder(PdfPCell.NO_BORDER);
            tabla2.addCell(TextoCostoPedido);
            documento.add(tabla2);
            
            documento.add(espacio);
            Paragraph aviso = new Paragraph("Cualquier costo mostrado en esta cotización puede cambiar de un día para otro sin previo aviso", estiloNegroLittle);
            aviso.setAlignment(Element.ALIGN_CENTER);
            documento.add(aviso);

            documento.close();
        } catch (Exception e) {
            response.getWriter().println("Error al generar PDF");
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
