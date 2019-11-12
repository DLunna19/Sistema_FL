/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexion;

/**
 *
 * @author David
 */
import java.sql.*;
import java.io.*;
import java.util.*;

public class Conexion 
{
   private String use = "root";
    private String pss = "root";
    private String db = "amp";
    private String host = "localhost";
    private String puerto = "3308";
    private String CLASSNAME = "com.mysql.jdbc.Driver";
    private String dir = "jdbc:mysql://" +host+":"+puerto+"/"+db;
    private Connection con;
    
    public Conexion() 
    {
        try{
            Class.forName(CLASSNAME);
            con = DriverManager.getConnection(dir,use,pss);
        }catch(ClassNotFoundException e){
            System.err.println("Driver no encontrado! "+e);
        }catch(SQLException e)
        {
            System.err.println("SQLError: "+e);
        }
    }
    public Connection getConexion()
    {
        return con;
    }        
    public static void main(String[] args) throws SQLException 
    {
        Conexion con = new Conexion();
    }
}
