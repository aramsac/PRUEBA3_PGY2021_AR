/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package appcancia.ahorros;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author nono
 */
public class conexion {
    Connection conn = null;
    
    
    // metodo para conetar db
    public conexion(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn= DriverManager.getConnection("jdbc:mysql://localhost/Alcancia", "root", "1234");
            System.out.println("conexion exitosa");
            
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(" error de conexion " + e);
        }
        
    }
       
    
    // metodo para ejecutar sentencias sql
    public int ejecutarSentenciaSQL( String strSentenciaSQL){
        try {
            PreparedStatement pstm = conn.prepareStatement(strSentenciaSQL);
            pstm.execute();
            return 1;
        } catch (SQLException ex) {
            Logger.getLogger(conexion.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }
    
    
    public ResultSet resultadoConsultaSQL(String strSentenciaSQL){
        try {
            PreparedStatement pstm = conn.prepareStatement(strSentenciaSQL);
            ResultSet respuesta = pstm.executeQuery(strSentenciaSQL);           
            return respuesta;
            
        } catch (SQLException e) {
            System.out.print("error "+e);
            return null;
        }
        
    }
    
    
    
    
    
}
