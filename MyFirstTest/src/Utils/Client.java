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
public class Client {

    private String name;
    private String secondName;
    private String dni;
    private String address;
    private String clientId;
    private String line;
    private String link_recharge;
    private String total_recharge;
    private String object_id;
    
     /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the secondName
     */
    public String getSecondName() {
        return secondName;
    }

    /**
     * @return the dni
     */
    public String getDni() {
        return dni;
    }

    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }
    
    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @param secondName the secondName to set
     */
    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    /**
     * @param dni the dni to set
     */
    public void setDni(String dni) {
        this.dni = dni;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return the clientId
     */
    public String getClientId() {
        return clientId;
    }

    /**
     * @param clientId the clientId to set
     */
    public void setClientId(String clientId) {
        this.clientId = clientId;
    }
    
    public Client(String name, String secondName, String dni, String address) {
        this.name = name;
        this.secondName = secondName;
        this.dni = dni;
        this.address = address;
        this.line="";
        
    }
    
    public Client(String line){
    this.line=line;
    }
    public Client(){
    }

    /**
     * @return the line
     */
    public String getLine() {
        return line;
    }

    /**
     * @param line the line to set
     */
    public void setLine(String line) {
        this.line = line;
    }

    /**
     * @return the link_recharge
     */
    public String getLink_recharge() {
        return link_recharge;
    }

    /**
     * @param link_recharge the link_recharge to set
     */
    public void setLink_recharge(String link_recharge) {
        this.link_recharge = link_recharge;
    }

    /**
     * @return the total_recharge
     */
    public String getTotal_recharge() {
        return total_recharge;
    }

    /**
     * @param total_recharge the total_recharge to set
     */
    public void setTotal_recharge(String total_recharge) {
        this.total_recharge = total_recharge;
    }

    /**
     * @return the object_id
     */
    public String getObject_id() {
        return object_id;
    }

    /**
     * @param object_id the object_id to set
     */
    public void setObject_id(String object_id) {
        this.object_id = object_id;
    }

}
