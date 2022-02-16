/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prydeliveryexpress;

import delivery.controlador.ControladorConsClientes;
import delivery.controlador.ControladorUsuario;
import delivery.modelo.Usuarios;
import delivery.modelo.UsuariosDAO;
import delivery.vista.FrmMenu;
import delivery.vista.FrmValidacion;

/**
 *
 * @author badle
 */
public class PryDeliveryExpress {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Usuarios usu = new Usuarios();
        UsuariosDAO usud = new UsuariosDAO();
        FrmValidacion fvalida = new FrmValidacion();
        ControladorUsuario contrau = new ControladorUsuario(fvalida, usu, usud);
        fvalida.setVisible(true);     
    }

}
