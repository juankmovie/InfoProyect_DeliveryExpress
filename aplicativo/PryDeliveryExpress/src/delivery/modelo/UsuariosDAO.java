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

/**
 *
 * @author Hogar
 */
public class UsuariosDAO {
    //definir un objeto de la clase conexion
    Conexion cn = new Conexion();
    //objeto que nos valide si estamos conectados
    Connection con;
    // clase que trae y verifica las instrucciones de la base de datos y ejecutarlas
    PreparedStatement ps;
    //clase que carga el resultado de la consulta en un objeto
    ResultSet rs;
    Usuarios user = new Usuarios();

    //Metodo para insertar datos a inquilinos
    public boolean adicionar(Usuarios user) {
        String sql = "insert into usuarios(idusuario,nombreUsuario,usuario,contrasena,correoE)values"
                + "("+ user.getIdUsuario()+ ","
                + ",'" + user.getNombreUsuario()+ "','" +user.getUsuario()+ "','"
                + user.getContraseña() + "','" +user.getCorreoE()+ ")";
              try{
        con=cn.getConnection();
              ps=con.prepareStatement(sql);
              ps.executeUpdate();}
              catch (SQLException ex){
                  System.out.println("Error"+ex);
                  return false;
              }
              return true;
    }
    
    public boolean validarUsuario(String usuario, String password) throws ClassNotFoundException{
        boolean ok=false;
        Conexion conex = new Conexion();
        String sql = "Select * from usuarios";
        try{
            con = cn.getConnection();
            PreparedStatement ps = conex.getConnection().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
           while (rs.next()){
            if (rs.getString("usuario").trim().equals(usuario) && 
                rs.getString("contrasena").trim().equals(password)){
                ok= true;
                
            }
           }
        }catch(SQLException ex){
            System.out.println(ex);
        }        
        return ok;
    }


}
    

