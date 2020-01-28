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
public class ClienteEmp extends Cliente{
    
    
    private String rut;
    private String contacto_primario;
    private String rol_contacto;
    
    public ClienteEmp(String name, String ape, String cat, String typeDoc, 
            String numD, String nat, String dir,String rut,String contact, String rol) {
        super(name, ape, cat, typeDoc, numD, nat, dir);
        rut = this.rut;
        contacto_primario =contact;
        rol_contacto = rol;
    }
    
    
    
}
