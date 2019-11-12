package Cotizacion;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author David
 */
public class Cotizacion 
{
    private String claveMaterial;
    private String nombreMaterial;    
    private String unidadControl;
    private float precioLista;    
    private float pesoTeorico;
    private int cantidadMaterial;

    public Cotizacion(String claveMaterial, String nombreMaterial, String unidadControl, 
            float precioLista, float pesoTeorico, int cantidadMaterial) {
        this.claveMaterial = claveMaterial;
        this.nombreMaterial = nombreMaterial;
        this.unidadControl = unidadControl;
        this.precioLista = precioLista;
        this.pesoTeorico = pesoTeorico;
        this.cantidadMaterial = cantidadMaterial;
    }

    /**
     * @return the claveMaterial
     */
    public String getClaveMaterial() {
        return claveMaterial;
    }

    /**
     * @param claveMaterial the claveMaterial to set
     */
    public void setClaveMaterial(String claveMaterial) {
        this.claveMaterial = claveMaterial;
    }

    /**
     * @return the nombreMaterial
     */
    public String getNombreMaterial() {
        return nombreMaterial;
    }

    /**
     * @param nombreMaterial the nombreMaterial to set
     */
    public void setNombreMaterial(String nombreMaterial) {
        this.nombreMaterial = nombreMaterial;
    }

    /**
     * @return the unidadControl
     */
    public String getUnidadControl() {
        return unidadControl;
    }

    /**
     * @param unidadControl the unidadControl to set
     */
    public void setUnidadControl(String unidadControl) {
        this.unidadControl = unidadControl;
    }

    /**
     * @return the precioLista
     */
    public float getPrecioLista() {
        return precioLista;
    }

    /**
     * @param precioLista the precioLista to set
     */
    public void setPrecioLista(float precioLista) {
        this.precioLista = precioLista;
    }

    /**
     * @return the pesoTeorico
     */
    public float getPesoTeorico() {
        return pesoTeorico;
    }

    /**
     * @param pesoTeorico the pesoTeorico to set
     */
    public void setPesoTeorico(float pesoTeorico) {
        this.pesoTeorico = pesoTeorico;
    }

    /**
     * @return the cantidadMaterial
     */
    public int getCantidadMaterial() {
        return cantidadMaterial;
    }

    /**
     * @param cantidadMaterial the cantidadMaterial to set
     */
    public void setCantidadMaterial(int cantidadMaterial) {
        this.cantidadMaterial = cantidadMaterial;
    }
}
