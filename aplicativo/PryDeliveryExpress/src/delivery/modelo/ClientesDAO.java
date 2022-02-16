/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package delivery.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author badle
 */
public class ClientesDAO {

    // Definir un objeto de la clase conexion
    Conexion cn = new Conexion();

    // Definir un objeto para validar conexion
    Connection con;

    // Verificar las instrucciones sql y ejecutarlas
    PreparedStatement ps;

    //Carga el resultado de la consulta en un objeto
    ResultSet rs;

    // Instanciar la clase Inquilinos
    Clientes client = new Clientes();

    // Metodo para insertar datos a la tabla Clientes en BD
    public boolean adicionar(Clientes client) {
        String sql = "insert into clientes(cedula, nombres, apellidos, edad, direccion, barrio, ciudad, celular, telefono,"
                + "correoElectronico) values " + "('" + client.getcedula()+ "','"
                + client.getNombres() + "','" + client.getApellidos() + "','" + client.getEdad()+ "','"
                + client.getDireccion() + "','" + client.getBarrio() + "','" + client.getCiudad() + "','"
                + client.getCelular() + "','" + client.getTelefono() + "','" + client.getCorreoelectronico()+ "')";
        System.out.println(sql);
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("Error" + ex);
            return false;
        }
        return true;

    }

    public Clientes consultarClientes(String cedula) throws SQLException {
        String sql = "Select * from clientes where cedula='" + client + "'";
        con = cn.getConnection();
        ps = con.prepareStatement(sql);
        rs = ps.executeQuery();//guarda el resultado
        if (rs.next()) {
            client.setcedula(rs.getString("cedula"));
            client.setNombre(rs.getString("nombres"));
            client.setApellidos(rs.getString("apellidos"));
            client.setEdad(rs.getString("edad"));
            client.setDireccion(rs.getString("direccion"));
            client.setBarrio(rs.getString("barrio"));
            client.setCiudad(rs.getString("ciudad"));
            client.setCelular(rs.getString("celular"));
            client.setTelefono(rs.getString("telefono"));
            client.setCorreoelectronico(rs.getString("correoElectronico"));
            return client;
        } else {
            return null;
        }

    }

    public boolean actualizar(Clientes client) {
        String sql = "update clientes set nombre=?, apellido=?, edad=?, direccion=?, barrio=?, ciudad=?, celular=?, telefono=?, "
                + "correoElectronico=? where idCliente=?";

        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, client.getNombres());
            ps.setString(2, client.getApellidos());
            ps.setString(3, client.getEdad());
            ps.setString(4, client.getDireccion());
            ps.setString(5, client.getBarrio());
            ps.setString(6, client.getCiudad());
            ps.setString(7, client.getCelular());
            ps.setString(8, client.getTelefono());
            ps.setString(9, client.getCorreoelectronico());
            ps.setString(10, client.getcedula());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("Error" + ex);
            return false;
        }
        return true;
    }

    public boolean eliminar(String cedula) {
        String sql = "Delete from clientes where cedula='" + client + "'";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("Error" + ex);
            return false;
        }
        return true;
    }

    // consultar todos los inquilinos
    public ArrayList consultarClientes() throws SQLException {
        String sql = "Select * from clientes";
        con = cn.getConnection();
        ps = con.prepareStatement(sql);
        rs = ps.executeQuery();//guarda el resultado
        ArrayList listClient = new ArrayList();
        while (rs.next()) {
            client.setcedula(rs.getString("cedula"));
            client.setNombre(rs.getString("nombres"));
            client.setApellidos(rs.getString("apellido"));
            client.setEdad(rs.getString("edad"));
            client.setDireccion(rs.getString("direccion"));
            client.setBarrio(rs.getString("barrio"));
            client.setCiudad(rs.getString("ciudad"));
            client.setCelular(rs.getString("celular"));
            client.setTelefono(rs.getString("telefono"));
            client.setCorreoelectronico(rs.getString("correoElectronico"));
            listClient.add(new Clientes(client.getcedula(), client.getNombres(), client.getApellidos(), client.getEdad(), client.getDireccion(),
                    client.getBarrio(), client.getCiudad(), client.getCelular(), client.getTelefono(), client.getCorreoelectronico()));

        }
       return listClient;
    }


    public ArrayList consultaGeneral(String sql) throws SQLException {
        con = cn.getConnection();
        ps = con.prepareStatement(sql);
        rs = ps.executeQuery();//guarda el resultado
        ArrayList listClient = new ArrayList();
        while(rs.next()) {
            client.setcedula(rs.getString("cedula"));
            client.setNombre(rs.getString("nombres"));
            client.setApellidos(rs.getString("apellidos"));
            client.setEdad(rs.getString("edad"));
            client.setDireccion(rs.getString("direccion"));
            client.setBarrio(rs.getString("barrio"));
            client.setCiudad(rs.getString("ciudad"));
            client.setCelular(rs.getString("celular"));
            client.setTelefono(rs.getString("telefono"));
            client.setCorreoelectronico(rs.getString("correoElectronico"));
            listClient.add(new Clientes(client.getcedula(), client.getNombres(), client.getApellidos(), client.getEdad(), client.getDireccion(),
                    client.getBarrio(), client.getCiudad(), client.getCelular(), client.getTelefono(), client.getCorreoelectronico()));
            
        }
        return listClient;
    }
}
