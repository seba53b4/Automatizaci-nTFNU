/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objects;

/**
 *
 * @author seolivera
 */
public class Cliente {
    
    private String nombre;
   private String apellidos;
   private String categoria;
   private String tipoDoc;
   private String numDoc;
   private String nacionalidad;
   private String direccion;
   private String object_id;

    public String getNombre() {
        return nombre;
    }

    public String getObject_id() {
        return object_id;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getCategoria() {
        return categoria;
    }

    public String getTipoDoc() {
        return tipoDoc;
    }

    public String getNumDoc() {
        return numDoc;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public String getDireccion() {
        return direccion;
    }

   
   
    
    public Cliente(String name, String ape,String cat,String typeDoc,
            String numD,String nat,String dir)
    {
            nombre = name;
            apellidos = ape;
            categoria = cat;
            tipoDoc = typeDoc;
            numDoc = numD;
            nacionalidad = nat;
            direccion = dir;
            
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void setTipoDoc(String tipoDoc) {
        this.tipoDoc = tipoDoc;
    }

    public void setNumDoc(String numDoc) {
        this.numDoc = numDoc;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setObject_id(String object_id) {
        this.object_id = object_id;
    }
            
    
}
