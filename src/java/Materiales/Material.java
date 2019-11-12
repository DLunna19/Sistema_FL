/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Materiales;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author David
 */
public class Material 
{
    private String clave = "";    
    private String nombre = "";
    private String unidadControl = "";
    private float precioLista = 0.0f;    
    private float pesoTeorico = 0.0f;

    public Material() 
    {
        
    }
    public Material(String clave, String nombre, String unidadControl, float precioLista, float pesoTeorico)
    {
        this.clave = clave;
        this.nombre = nombre;
        this.precioLista = precioLista;
        this.pesoTeorico = pesoTeorico;
        this.unidadControl = unidadControl;
    }        
    
    public String getClave() {
        return clave;
    }

    /**
     * @param clave the clave to set
     */
    public void setClave(String clave) {
        this.clave = clave;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
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
}
