/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package delivery.modelo;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author badle
 */
public class Conexion {

    Connection con;
    //Atributos o variables de la clase, declaradas e inicializadas.
    public String bd = "bddeliveryexpress";
    public String login = "root";
    public String password = "";
    //public String url = "jdbc:mysql://localhost/" + bd;es para conectar al netbeans normal
    public String url = "jdbc:mysql://localhost:33065/" + bd + "?zeroDateTimeBehavior=CONVERT_TO_NULL";

    public Conexion() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, login, password);

        } catch (Exception e) {
            System.err.println("Error " + e);
        }
    }

    public Connection getConnection() {
        return con;
    }

}
