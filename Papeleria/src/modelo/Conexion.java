/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author ta_o1
 */
public class Conexion {
    
    //BASE DE DATOS 2 DE LA SEGUNDA CUENTA
    private static final String url = "jdbc:mysql://remotemysql.com:3306/1aduJNebgB";
    private static final String user = "1aduJNebgB";
    private static final String password = "tjomb1JWO5";
    
    public Connection conexion(){
        Connection cn = null;
        
        try {
            cn = DriverManager.getConnection(url, user, password);
            System.out.println("Conexion exitosa");
        } catch (SQLException e) {
            System.err.println(e);
        }
        
        return cn;
    }
}
