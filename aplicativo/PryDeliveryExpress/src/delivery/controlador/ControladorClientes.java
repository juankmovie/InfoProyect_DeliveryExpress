/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package delivery.controlador;

import delivery.modelo.Clientes;
import delivery.modelo.ClientesDAO;
import delivery.vista.FrmCliente;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author SALA404-28
 */
public class ControladorClientes implements ActionListener {

    private FrmCliente fclient;
    private Clientes client;
    private ClientesDAO clientD;

    public ControladorClientes(FrmCliente fclient, Clientes inqui, ClientesDAO ClientesD) {
        this.fclient = fclient;
        this.client = client;
        this.clientD = clientD;
        this.fclient.JBtConsultar.addActionListener(this);
        this.fclient.JBtEliminar.addActionListener(this);
        this.fclient.JBtGuardar.addActionListener(this);
        this.fclient.JBtModificar.addActionListener(this);
        this.fclient.JBtNuevo.addActionListener(this);
        this.fclient.JBtSalir.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == fclient.JBtGuardar) {
            
            String ced = fclient.jTxCedula.getText();
            String nom = fclient.jTxNombre.getText();
            String ape = fclient.jTxApellidos.getText();
            String ed  = fclient.jTxEdad.getText();
            String dir = fclient.jTxDireccion.getText();
            String bar = fclient.jTxBarrio.getText();
            String ciu = fclient.jTxCiudad.getText();
            String cel = fclient.jTxCelular.getText();
            String tel = fclient.jTxTelefono.getText();
            String cor = fclient.jTxCorreoElectronico.getText();
            client = new Clientes(ced, nom, ape, ed, dir, bar, ciu, cel, tel,cor);
            if (clientD.adicionar(client)) {
                JOptionPane.showMessageDialog(fclient, "El Cliente se registró adecuadamente");
            } else {
                JOptionPane.showMessageDialog(fclient, "El Cliente no se registró adecuadamente");
            }

        }
        if (e.getSource() == fclient.JBtConsultar) {
            String ced = JOptionPane.showInputDialog(fclient, "Cédula del Cliente a consultar:");
               try {
                client = clientD.consultarClientes(ced);
            } catch (SQLException ex) {
                Logger.getLogger(ControladorClientes.class.getName()).log(Level.SEVERE, null, ex);
            }


            if (client != null) {
                fclient.jTxCedula.setText(client.getcedula());
                fclient.jTxNombre.setText(client.getNombres());
                fclient.jTxApellidos.setText(client.getApellidos());
                fclient.jTxEdad.setText(client.getEdad());
                fclient.jTxDireccion.setText(client.getDireccion());
                fclient.jTxBarrio.setText(client.getBarrio());
                fclient.jTxCiudad.setText(client.getCiudad());
                fclient.jTxCelular.setText(client.getCelular());
                fclient.jTxTelefono.setText(client.getTelefono());
                fclient.jTxCorreoElectronico.setText(String.valueOf(client.getCorreoelectronico()));

            } else {
                JOptionPane.showMessageDialog(fclient, "El cliente consultado no se encuentra registrado como cliente activo en la base de datos");

            }

        }
        if (e.getSource() == fclient.JBtModificar) {
            
            String ced = fclient.jTxCedula.getText();
            String nom = fclient.jTxNombre.getText();
            String ape = fclient.jTxApellidos.getText();
            String ed = fclient.jTxEdad.getText();
            String dir = fclient.jTxDireccion.getText();
            String bar = fclient.jTxBarrio.getText();
            String ciu = fclient.jTxCiudad.getText();
            String cel = fclient.jTxCelular.getText();
            String tel = fclient.jTxTelefono.getText();
            String cor = fclient.jTxCorreoElectronico.getText();
            client = new Clientes(ced, nom, ape, ed, dir, bar, ciu, cel, tel,cor);
            if (clientD.actualizar(client)) {
                JOptionPane.showMessageDialog(fclient, "El Cliente se actualizó adecuadamente en la base de datos");
                limpiarControles();
            } else {
                JOptionPane.showMessageDialog(fclient, "El Cliente no se actualizó adecuadamente en la base de datos");
            }

        }
        if (e.getSource() == fclient.JBtEliminar) {
            String ced = fclient.jTxCedula.getText();
            int respuesta = JOptionPane.showConfirmDialog(fclient, "¿Está seguro de eliminar el registro del cliente?", "Eliminar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (respuesta == JOptionPane.YES_OPTION) {
                if (clientD.eliminar(ced)) {
                    JOptionPane.showMessageDialog(fclient, "El registro se eliminó con éxito");
                    limpiarControles();
                } else {
                    JOptionPane.showMessageDialog(fclient, "El registro no se eliminó - Por favor verifique los datos ingresados.");
                }
            }
        }
        if (e.getSource() == fclient.JBtSalir) {
            int respuesta = JOptionPane.showConfirmDialog(fclient, "¿Está seguro de salir de la aplicación?", "Salir", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (respuesta == JOptionPane.YES_OPTION) {
                fclient.dispose();

            }
        }
        if (e.getSource() == fclient.JBtNuevo) {
            limpiarControles();
        }
    }

    public void limpiarControles() {
        fclient.jTxCedula.setText("");
        fclient.jTxNombre.setText("");
        fclient.jTxApellidos.setText("");
        fclient.jTxEdad.setText("");
        fclient.jTxDireccion.setText("");
        fclient.jTxBarrio.setText("");
        fclient.jTxCiudad.setText("");
        fclient.jTxCelular.setText("");
        fclient.jTxTelefono.setText("");
        fclient.jTxCorreoElectronico.setText("");
        fclient.jTxCedula.requestFocus();

    }
}
