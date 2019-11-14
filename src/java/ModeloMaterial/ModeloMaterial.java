/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloMaterial;
import Conexion.*;
import Controlador.controladorMaterial;
import Materiales.Material;
import com.mysql.jdbc.ResultSet;
import java.sql.PreparedStatement;
import java.util.ArrayList;
/**
 *
 * @author David
 */
public class ModeloMaterial extends Conexion 
{
    public boolean registroMaterial(Material m)
    {       
        PreparedStatement pt = null;
        boolean bandera = false;
        
        try {
            String query = "Insert into material (ClaveMaterial, NombreMaterial, UnidadControl, "
                    + "PrecioLista, PesoTeorico) values (?,?,?,?,?)";
            pt = getConexion().prepareStatement(query);
            pt.setString(1, m.getClave());
            pt.setString(2, m.getNombre());
            pt.setString(3, m.getUnidadControl());
            pt.setFloat(4, m.getPrecioLista());
            pt.setFloat(5, m.getPesoTeorico());
            
            if(pt.executeUpdate() == 1)
            {
                bandera = true;
            }
        } catch (Exception e) 
        {
            System.err.println("Error");
        }finally{
            try {
                if(getConexion() != null)getConexion().close();
                if(pt != null) pt.close();
            } catch (Exception e) {
            }
        }
        return bandera;
    }    
    public ArrayList<Material> getAllMateriales()
    {
        ArrayList<Material> materiales = new ArrayList<>();
        PreparedStatement pst = null;
        ResultSet rs = null;
         try {
            String consulta = "select * from material";
            pst = getConexion().prepareStatement(consulta);
            rs = (ResultSet) pst.executeQuery();
            
             while (rs.next()) 
             {                 
                 materiales.add(new Material(rs.getString("ClaveMaterial"), rs.getString("NombreMaterial"), rs.getString("UnidadControl"), rs.getFloat("PrecioLista"), rs.getFloat("PesoTeorico")));
             }
        } catch (Exception e) {
        }finally{
             try {
                 if(getConexion() != null) getConexion().close();
                 if (pst != null) pst.close();  
                 if(rs != null) rs.close();
             } catch (Exception e) {
             }
         }
        return materiales;
    }
    
    public Material getOneMaterial(String ClaveMaterial)
    {
        Material m = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
         try {
            String consulta = "select * from material where ClaveMaterial=?";
            pst = getConexion().prepareStatement(consulta);
            pst.setString(1, ClaveMaterial);
            rs = (ResultSet) pst.executeQuery();
            
             while (rs.next()) 
             {                 
                 m = new Material(rs.getString("ClaveMaterial"), rs.getString("NombreMaterial"), 
                                  rs.getString("UnidadControl"), rs.getFloat("PrecioLista"),
                                  rs.getFloat("PesoTeorico"));
             }
        } catch (Exception e) {
        }finally{
             try {
                 if(getConexion() != null) getConexion().close();
                 if (pst != null) pst.close();  
                 if(rs != null) rs.close();
             } catch (Exception e) {
             }
         }
        return m;
    }
    public boolean eliminarMaterial(String nombreMaterial)
    {
        boolean bandera = false;
        PreparedStatement pst = null;
         try {
            String consulta = "delete from material where NombreMaterial=?";
            pst = getConexion().prepareStatement(consulta);
            pst.setString(1, nombreMaterial);
            if(pst.executeUpdate() == 1)
            {
                bandera = true;
            }
        } catch (Exception e) {
        }finally{
             try {
                 if(getConexion() != null) getConexion().close();
                 if (pst != null) pst.close();  
             } catch (Exception e) {
             }
         }
        return bandera;
    }
    public boolean modificarMaterial(Material m)
    {
        PreparedStatement pt = null;
        boolean bandera = false;
        
        try {
            String query = "UPDATE material SET NombreMaterial= ?, UnidadControl= ?, PrecioLista= ?, PesoTeorico= ? where ClaveMaterial = ?";
            pt = getConexion().prepareStatement(query);
            pt.setString(1, m.getNombre());
            pt.setString(2, m.getUnidadControl());
            pt.setFloat(3, m.getPrecioLista());
            pt.setFloat(4, m.getPesoTeorico());
            pt.setString(5, m.getClave());
            
            if(pt.executeUpdate() == 1)
            {
                bandera = true;
            }
        } catch (Exception e) 
        {
            System.err.println("Error");
        }finally{
            try {
                if(getConexion() != null)getConexion().close();
                if(pt != null) pt.close();
            } catch (Exception e) {
            }
        }
        return bandera;
    }
    
    public ArrayList<Material> getMaterialesConsulta(String NombreMaterial)
    {
        String Nombre="'"+NombreMaterial+"%'";
        
        ArrayList<Material> materiales = new ArrayList<>();
        PreparedStatement pst = null;
        ResultSet rs = null;
         try { 
            String consulta = "select * from material where NombreMaterial like "+Nombre;
            pst = getConexion().prepareStatement(consulta);
            //pst.setString(1, Nombre);
            //System.out.println("Hasta aqui");
            rs = (ResultSet)pst.executeQuery();
            
            while (rs.next()) 
            {                 
                materiales.add(new Material(rs.getString("ClaveMaterial"), rs.getString("NombreMaterial"),
                rs.getString("UnidadControl"), rs.getFloat("PrecioLista"), rs.getFloat("PesoTeorico")));
            }
        } catch (Exception e) {
             System.out.println("Error en la consulta");
        }finally{
             try {
                 if(getConexion() != null) getConexion().close();
                 if (pst != null) pst.close();  
                 if(rs != null) rs.close();
             } catch (Exception e) {
             }
         }
        return materiales;
    }
}
