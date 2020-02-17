/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ta_o1
 */
public class Consulta extends Conexion{
    
    public boolean registrar(Producto producto){
        PreparedStatement ps;
        Connection cn = conexion();
        
        String sql = "INSERT INTO producto (tipo, marca, precio, cantidad, codigo) VALUES (?, ?, ?, ?, ?)";
        
        try {
            ps = cn.prepareStatement(sql);
            ps.setString(1, producto.getTipo());
            ps.setString(2, producto.getMarca());
            ps.setFloat(3, producto.getPrecio());
            ps.setInt(4, producto.getCantidad());
            ps.setString(5, producto.getCodigo());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                cn.close();
            } catch (SQLException ex) {
                Logger.getLogger(Consulta.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public boolean buscar(Producto producto){
        PreparedStatement ps;
        ResultSet rs;
        Connection cn = conexion();
        
        String sql = "SELECT * FROM producto where codigo = ?";
        
        try {
            ps = cn.prepareStatement(sql);
            ps.setString(1, producto.getCodigo());
            rs = ps.executeQuery();
            
            while(rs.next()){
                producto.setTipo(rs.getString("tipo"));
                producto.setMarca(rs.getString("marca"));
                producto.setPrecio(rs.getFloat("precio"));
                producto.setCantidad(rs.getInt("cantidad"));
                return true;
            }
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally{
            try {
                cn.close();
            } catch (SQLException ex) {
                Logger.getLogger(Consulta.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }
    
    public boolean actualizar(Producto producto){
        PreparedStatement ps;
        Connection cn = conexion();
        
        String sql = "UPDATE producto SET tipo=?, marca=?, precio=?, cantidad=? WHERE codigo=?";
        
        try {
            ps = cn.prepareStatement(sql);
            ps.setString(1, producto.getTipo());
            ps.setString(2, producto.getMarca());
            ps.setFloat(3, producto.getPrecio());
            ps.setInt(4, producto.getCantidad());
            ps.setString(5, producto.getCodigo());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                cn.close();
            } catch (SQLException ex) {
                Logger.getLogger(Consulta.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
