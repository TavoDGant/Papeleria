/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package papeleria;

import modelo.Consulta;
import modelo.Producto;
import controlador.Controlador;
import vista.Menu;

/**
 *
 * @author ta_o1
 */
public class Papeleria {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Consulta consulta = new Consulta();
        Producto producto = new Producto();
        Menu menu = new Menu();
        
        
        Controlador control = new Controlador(consulta, producto, menu);
        menu.setLocationRelativeTo(null);
        menu.setVisible(true);
        
        
    }
    
    
}
