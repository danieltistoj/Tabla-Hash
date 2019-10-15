/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tablahash;

/**
 *
 * @author Usuario
 */
public class Nodo {
    private String nombre,correo,organizacion,comentario;
    private int telefono;
    private Nodo siguiente;

    public Nodo(String nombre, String correo, String organizacion, String comentario, int telefono) {
        this.nombre = nombre;
        this.correo = correo;
        this.organizacion = organizacion;
        this.comentario = comentario;
        this.telefono = telefono;
    }
    
    

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getOrganizacion() {
        return organizacion;
    }

    public void setOrganizacion(String organizacion) {
        this.organizacion = organizacion;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public Nodo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }
    
    
    
}
