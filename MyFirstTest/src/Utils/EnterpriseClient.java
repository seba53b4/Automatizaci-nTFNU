/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

/**
 *
 * @author ipupo
 */
public class EnterpriseClient extends Client {
    private String rut;

    /**
     * @return the rut
     */
    public String getRut() {
        return rut;
    }

    /**
     * @param rut the rut to set
     */
    public void setRut(String rut) {
        this.rut = rut;
    }
    
    public EnterpriseClient(String name, String secondName, String dni, String address, String rut) {
        super(name, secondName, dni, address);
        this.rut = rut;
    }
    
    public EnterpriseClient() {
        super();
    }
}
