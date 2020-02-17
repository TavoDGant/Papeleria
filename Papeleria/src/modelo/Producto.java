/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author ta_o1
 */
public class Producto {

    private static int id;
    private static String tipo;
    private static String marca;
    private static float precio;
    private static int cantidad;
    private static String codigo;
    
    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        Producto.id = id;
    }

    public static String getTipo() {
        return tipo;
    }

    public static void setTipo(String tipo) {
        Producto.tipo = tipo;
    }

    public static String getMarca() {
        return marca;
    }

    public static void setMarca(String marca) {
        Producto.marca = marca;
    }

    public static float getPrecio() {
        return precio;
    }

    public static void setPrecio(float precio) {
        Producto.precio = precio;
    }

    public static int getCantidad() {
        return cantidad;
    }

    public static void setCantidad(int cantidad) {
        Producto.cantidad = cantidad;
    }

    public static String getCodigo() {
        return codigo;
    }

    public static void setCodigo(String codigo) {
        Producto.codigo = codigo;
    }
    
    
}
