/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloUsuario;

import Conexion.Conexion;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author David
 */
public class ModeloUsuario extends Conexion 
{
    public boolean autentificacion(String us, String pss)
    {
        PreparedStatement pt = null;
        ResultSet rs = null;
        try{
            String consulta = "Select * from usuarios where Nombre = ? and Pass = ?";
            pt = (PreparedStatement) getConexion().prepareStatement(consulta);
            pt.setString(1, us);
            pt.setString(2, pss);
            rs = (ResultSet) pt.executeQuery();
            
            if (rs.absolute(1)){
                return true;
            }
        }catch(Exception e)
        {
            System.err.println("Error!!");
        }
        finally{
                   try {
                       if(getConexion() != null){
                           getConexion().close();
                       }
                       if(pt != null){
                           pt.close();
                       }
                       if(rs != null){
                           rs.close();
                       }
                   } catch (Exception e) {
                       System.err.println("Error!!");
                   }     
        }        
        return false;
    }     
    public boolean Registro(String Nombre, String Pass, String Admin)
    {
        PreparedStatement ps = null;
        try{
            String consulta = "Insert into usuarios(Nombre, Pass, Admin) values (?,?,?)";
            ps = (PreparedStatement) getConexion().prepareStatement(consulta);
            ps.setString(1, Nombre);
            ps.setString(2, Pass);
            ps.setString(3, Admin);
            
            if(ps.executeUpdate() == 1){
                return true;
            }
        }catch(Exception e){
            System.err.println("Error al ingresar nuevo usuario");
        }finally{
            try{
                if(getConexion() != null){
                    getConexion().close();
                }
                if(ps != null){
                    ps.close();
                }
            }catch(Exception e){
                System.err.println("Error!!");
            }           
        }
        return false;
    }
    public boolean autentificarAdmin(String us, String pss)
    {
        PreparedStatement pt = null;
        ResultSet rs = null;
        String si = "s";
        try{
            String consulta = "Select * from usuarios where Nombre = ? and Pass = ? and Admin = ?";
            pt = (PreparedStatement) getConexion().prepareStatement(consulta);
            pt.setString(1, us);
            pt.setString(2, pss);
            pt.setString(3, si);
            rs = (ResultSet) pt.executeQuery();
            
            if (rs.absolute(1)){
                return true;
            }
        }catch(Exception e)
        {
            System.err.println("Error query!!");
        }
        finally{
                   try {
                       if(getConexion() != null){
                           getConexion().close();
                       }
                       if(pt != null){
                           pt.close();
                       }
                       if(rs != null){
                           rs.close();
                       }
                   } catch (Exception e) {
                       System.err.println("Error al cerrar conexion!!");
                   }     
        }        
        return false;
    }     
}
