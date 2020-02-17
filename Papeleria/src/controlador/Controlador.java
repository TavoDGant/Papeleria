/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import modelo.Consulta;
import modelo.Producto;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import vista.Menu;

/**
 *
 * @author ta_o1
 */
public class Controlador implements ActionListener{
    
    private Consulta consulta;
    private Producto producto;
    private Menu menu;

    public Controlador(Consulta consulta, Producto producto, Menu menu) {
        this.consulta = consulta;
        this.producto = producto;
        this.menu = menu;
        
        this.menu.btnAgregar.addActionListener(this);
        this.menu.btnActualizar.addActionListener(this);
        this.menu.btnBuscar.addActionListener(this);               
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        
        if(e.getSource() == menu.btnBuscar){
            buscar();
        }
        if(e.getSource() == menu.btnAgregar){
            registrar();
            borrarCampos();
        }
        if(e.getSource() == menu.btnActualizar){
            actualizar();
        }
    }
    
    
    
    
    
    //METODOS DE REGISTRO, BUSQUEDA, ACTUALIZACION
    public void registrar(){
        producto.setTipo(menu.txtTipo.getText());
        producto.setMarca(menu.txtMarca.getText());
        producto.setPrecio(Float.parseFloat(menu.txtPrecio.getText()));
        producto.setCantidad(Integer.parseInt(menu.txtCantidad.getText()));
        producto.setCodigo(menu.txtCodigo.getText());
        if(consulta.registrar(producto)){
            JOptionPane.showMessageDialog(null, "Producto registrado exitosamente", "Información", JOptionPane.INFORMATION_MESSAGE);
        } else{
            JOptionPane.showMessageDialog(null, "Error al registrar producto", "Error", JOptionPane.ERROR_MESSAGE);
        } 
    }
    
    public void buscar(){
        producto.setCodigo(menu.txtCodigo.getText());
        if(consulta.buscar(producto)){
            menu.txtTipo.setText(producto.getTipo());
            menu.txtMarca.setText(producto.getMarca());
            menu.txtPrecio.setText(String.valueOf(producto.getPrecio()));
            menu.txtCantidad.setText(String.valueOf(producto.getCantidad()));
            menu.txtCodigo.setText(producto.getCodigo());
        }
        else{
            JOptionPane.showMessageDialog(null, "Producto no encontrado","Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void actualizar(){
        producto.setTipo(menu.txtTipo.getText());
        producto.setMarca(menu.txtMarca.getText());
        producto.setPrecio(Float.parseFloat(menu.txtPrecio.getText()));
        producto.setCantidad(Integer.parseInt(menu.txtCantidad.getText()));
        producto.setCodigo(menu.txtCodigo.getText());
        if(consulta.actualizar(producto)){
            JOptionPane.showMessageDialog(null, "Productos actualizados exitosamente", "Información", JOptionPane.INFORMATION_MESSAGE);
            borrarCampos();
        } else{
            JOptionPane.showMessageDialog(null, "Error al actualizar producto", "Error", JOptionPane.ERROR_MESSAGE);
        } 
        
    }
    
    
    //METODO DE LIMPIAR CAMPOS DE LAS VENTANAS SECUNDARIAS
   public void borrarCampos(){
       menu.txtTipo.setText(null);
       menu.txtMarca.setText(null);
       menu.txtPrecio.setText(null);
       menu.txtCantidad.setText(null);
       menu.txtCodigo.setText(null);
   }
}
