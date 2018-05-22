/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.Connection;
/**
 *
 * @author Gers
 */
public class conexion {
    
    public static Connection getConnection(){
        Connection connection = null;
        //String bdName = "AdventureWorks2014";
        //String user = "sa";
        //String pass = "vargas7706";
        String bdName = "AdventureWorks2014";
        String user = "sa";
        String pass = "123Gilda";
        
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String connectionBD = "jdbc:sqlserver://192.168.1.115;databaseName="+bdName+";user="+user+";password="+pass+";";
            connection = DriverManager.getConnection(connectionBD);
            
        } catch (ClassNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }catch(SQLException e){
            System.out.println("Error: " + e.getMessage());
        }catch(Exception e){
            System.out.println("Error" + e.getMessage());
        }
        
        return connection;
    }
    public static void main(String[] args){
        if(conexion.getConnection() != null){
            System.out.println("Conexion realizada");
        }
    }
}
