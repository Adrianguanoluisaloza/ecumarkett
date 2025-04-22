/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Adrian
 */
public class Usuario {
    private String usuario;
    private String correo;
    private  String contraseña;
      private   String nombrecompleto;
     private   int telefono;
       private     String ciudad;

    public Usuario(String usuario, String correo, String contraseña, String nombrecompleto, int telefono, String ciudad) {
        this.usuario = usuario;
        this.correo = correo;
        this.contraseña = contraseña;
        this.nombrecompleto = nombrecompleto;
        this.telefono = telefono;
        this.ciudad = ciudad;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public void setNombrecompleto(String nombrecompleto) {
        this.nombrecompleto = nombrecompleto;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public Usuario() {}

    public String getUsuario() {
        return usuario;
    }

    public String getCorreo() {
        return correo;
    }

    public String getContraseña() {
        return contraseña;
    }

    public String getNombrecompleto() {
        return nombrecompleto;
    }

    public int getTelefono() {
        return telefono;
    }

    public String getCiudad() {
        return ciudad;
    }
    
}
