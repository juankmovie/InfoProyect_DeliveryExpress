/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package delivery.modelo;

/**
 *
 * @author badle
 */
public class Clientes {
    //Atributos
    private String cedula;
    private String nombres;
    private String apellidos;
    private String edad;
    private String direccion;
    private String barrio;
    private String ciudad;
    private String celular;
    private String telefono;
    private String correoElectronico;
    
    // Metodos constructores
    
    public Clientes() {
    }
    public Clientes(String idCliente, String nombre, String apellido, String edad, String direccion, String barrio, String ciudad, String celular, String telefono, String correoElectronico) {
        this.cedula = idCliente;
        this.nombres = nombre;
        this.apellidos = apellido;        
        this.edad = edad;
        this.direccion = direccion;
        this.barrio = barrio;
        this.ciudad = ciudad;
        this.celular = celular;
        this.telefono = telefono;
        this.correoElectronico = correoElectronico;
    }
    
    // Metodos getter/setter
    
    public String getcedula() {
        return cedula;
    }

    public void setcedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombre(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getBarrio() {
        return barrio;
    }

    public void setBarrio(String barrio) {
        this.barrio = barrio;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getCelular() {
        return celular;
    }
    
    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreoelectronico() {
        return correoElectronico;
    }

    public void setCorreoelectronico(String correoelectronico) {
        this.correoElectronico = correoelectronico;
    }  
}
