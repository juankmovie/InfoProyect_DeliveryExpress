/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package delivery.controlador;

import delivery.modelo.Usuarios;
import delivery.modelo.UsuariosDAO;
import delivery.vista.FrmMenu;
import delivery.vista.FrmValidacion;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author usuario
 */
public class ControladorUsuario implements ActionListener{

    private FrmValidacion fvalida;
    private Usuarios usu;
    private UsuariosDAO usuD;

    public ControladorUsuario(FrmValidacion fvalida, Usuarios usu, UsuariosDAO usuD) {
        this.fvalida = fvalida;
        this.usu = usu;
        this.usuD = usuD;
        this.fvalida.jBtAceptar.addActionListener(this);
        this.fvalida.jBtSalir.addActionListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == fvalida.jBtAceptar) {
            String usu = fvalida.jTxUsuario.getText();
            String pass = fvalida.jPsContrasena.getText();
            try {
                if(usuD.validarUsuario(usu,pass)){
                 FrmMenu fmenu = new FrmMenu();   
                    fmenu.setVisible(true);
                    } else {
                     JOptionPane.showMessageDialog(fvalida, "Usuario y / o contraseña incorrectos");
                    
                }} catch (ClassNotFoundException ex) {
                Logger.getLogger(ControladorUsuario.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }
   
}
