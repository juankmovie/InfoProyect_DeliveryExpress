/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package delivery.modelo;

/**
 *
 * @author Hogar
 */
public class Usuarios {

    private int idUsuario;
    private String nombreUsuario;
    private String usuario;
    private String contrasena;
    private String correoE;

    public Usuarios() {
    }

    public Usuarios(int idUsuario, String nombreUsuario, String usuario, String contraseña, String correoE) {
        this.idUsuario = idUsuario;
        this.nombreUsuario = nombreUsuario;
        this.usuario = usuario;
        this.contrasena = contraseña;
        this.correoE = correoE;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String Usuario) {
        this.usuario = Usuario;
    }

    public String getContraseña() {
        return contrasena;
    }

    public void setContraseña(String contraseña) {
        this.contrasena = contraseña;
    }

    public String getCorreoE() {
        return correoE;
    }

    public void setCorreoE(String correoE) {
        this.correoE = correoE;
    }
    
}
