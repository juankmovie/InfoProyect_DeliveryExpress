/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package delivery.controlador;

import delivery.modelo.Clientes;
import delivery.modelo.ClientesDAO;
import delivery.modelo.Usuarios;
import delivery.modelo.UsuariosDAO;
import delivery.vista.FrmCliente;
import delivery.vista.FrmValidacion;
import delivery.vista.FrmCliente;
import delivery.vista.FrmConsClientes;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author usuario
 */
public class ControladorConsClientes implements ActionListener {

    private Clientes client;
    private ClientesDAO clientd;
    private FrmConsClientes fconsClientes;
    DefaultTableModel modelo = new DefaultTableModel();

    public ControladorConsClientes(Clientes client, ClientesDAO clientd, FrmConsClientes fconsClientes) throws SQLException {
        this.client = client;
        this.clientd = clientd;
        this.fconsClientes = fconsClientes;
        this.fconsClientes.jBtSalir.addActionListener(this);
                //mostrarLugarTrabInqui();
        modelo.addColumn("Cédula");
        modelo.addColumn("Nombres");
        modelo.addColumn("Apellidos");
        modelo.addColumn("Direccion");
        fconsClientes.jTbClientes.setModel(modelo);

    }

  

    public void mostrarConsClientes() throws SQLException {//con esto se llama la info de inquilinos en el combobox
        Clientes clientes = new Clientes();
        ClientesDAO clientD = new ClientesDAO();
        String sql = "Select * from Clientes group by cedula";
        ArrayList clientA = (ArrayList) clientD.consultaGeneral(sql);
        for (int i = 0; i < clientA.size(); i++) {
            client = (Clientes) clientA.get(i);
            fconsClientes.jcbcliente.addItem(String.valueOf(client.getcedula()));
        }
    }
    public void limpiarJTable(){
        while(fconsClientes.jTbClientes.getRowCount()!=0){
            ((DefaultTableModel)fconsClientes.jTbClientes.getModel()).removeRow(0);
        }
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == fconsClientes.jcbcliente) {
            String sql = "Select * from clientes where cedula='"+fconsClientes.jcbcliente.getSelectedItem().toString()+"'";
            ArrayList clientCedula=null;
            try {
                clientCedula = (ArrayList)clientd.consultaGeneral(sql);
            } catch (SQLException ex) {
                Logger.getLogger(ControladorConsClientes.class.getName()).log(Level.SEVERE, null, ex);
            }
            for (int i=0; i<clientCedula.size();i++){
                String[] datos = new String[4];
                client = (Clientes)clientCedula.get(i);
                datos[0]=client.getcedula();
                datos[1]=client.getNombres();
                datos[2]=client.getApellidos();
                datos[3]=String.valueOf(client.getcedula());
                
               modelo.addRow(datos);
                
            }
        }
        if (e.getSource() == fconsClientes.jBtSalir) {

        }
    }
}
