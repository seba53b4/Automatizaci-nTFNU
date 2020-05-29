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
public class Plan {
    
    private String ambiente;
    private String name;
    private String object_id;
    private String ICCID;
    private String MSISDN;
    private String urlSO;
    private String statuSO;
    private String name_change_plan;
    
     public Plan(String name) {
        this.name = name;
        this.object_id= "";
    }
    
    public Plan(){}
    
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
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
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

    /**
     * @return the ICCID
     */
    public String getICCID() {
        return ICCID;
    }

    /**
     * @param ICCID the ICCID to set
     */
    public void setICCID(String ICCID) {
        this.ICCID = ICCID;
    }

    /**
     * @return the MSISDN
     */
    public String getMSISDN() {
        return MSISDN;
    }

    /**
     * @param MSISDN the MSISDN to set
     */
    public void setMSISDN(String MSISDN) {
        this.MSISDN = MSISDN;
    }

    /**
     * @return the urlSO
     */
    public String getUrlSO() {
        return urlSO;
    }

    /**
     * @param urlSO the urlSO to set
     */
    public void setUrlSO(String urlSO) {
        this.urlSO = urlSO;
    }

    /**
     * @return the statuSO
     */
    public String getStatuSO() {
        return statuSO;
    }

    /**
     * @param statuSO the statuSO to set
     */
    public void setStatuSO(String statuSO) {
        this.statuSO = statuSO;
    }

    /**
     * @return the name_change_plan
     */
    public String getName_change_plan() {
        return name_change_plan;
    }

    /**
     * @param name_change_plan the name_change_plan to set
     */
    public void setName_change_plan(String name_change_plan) {
        this.name_change_plan = name_change_plan;
    }
}
 

