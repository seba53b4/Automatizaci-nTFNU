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

    private String ambiente;
    private String name;
    private String secondName;
    private String passport;
    private String international_id;
    private String address;
    private String clientId;
    private String line;
    private String link_recharge;
    private String status_recharge;
    private String object_id;
    private String amount;
    private String payment_method;
    

    /**
     * 
     * @return 
     */
    public String getAmbiente() {
        return ambiente;
    }
    
    public void setAmbiente(String ambiente) {
        this.ambiente = ambiente;
    }
    
    
    
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
    
    public Client(String name, String secondName, String passport,String inte_id,String address) {
        this.name = name;
        this.secondName = secondName;
        this.passport=passport;
        this.international_id=inte_id;
        this.address = address;
        
    }
    
    
    public Client(String line,String amount,String mp){
    this.line=line;
    this.amount=amount;
    this.payment_method=mp;
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
    
    public String getObject_id() {
        return object_id;
    }

    /**
     * @param object_id the object_id to set
     */
    public void setObject_id(String object_id) {
        this.object_id = object_id;
    }

    /**
     * @return the passport
     */
    public String getPassport() {
        return passport;
    }

    /**
     * @param passport the passport to set
     */
    public void setPassport(String passport) {
        this.passport = passport;
    }

    /**
     * @return the international_id
     */
    public String getInternational_id() {
        return international_id;
    }

    /**
     * @param international_id the international_id to set
     */
    public void setInternational_id(String international_id) {
        this.international_id = international_id;
    }

    /**
     * @return the amount
     */
    public String getAmount() {
        return amount;
    }

    /**
     * @param amount the amount to set
     */
    public void setAmount(String amount) {
        this.amount = amount;
    }

    /**
     * @return the payment_method
     */
    public String getPayment_method() {
        return payment_method;
    }

    /**
     * @param payment_method the payment_method to set
     */
    public void setPayment_method(String payment_method) {
        this.payment_method = payment_method;
    }

    /**
     * @return the status_recharge
     */
    public String getStatus_recharge() {
        return status_recharge;
    }

    /**
     * @param status_recharge the status_recharge to set
     */
    public void setStatus_recharge(String status_recharge) {
        this.status_recharge = status_recharge;
    }

}
