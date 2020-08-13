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
public class Limpieza_Class {
    private String numero;
    private String sim;
    private String status;
    private String SO;
    private String ambiente;

    
    public Limpieza_Class(String num)
    {
        numero = num;
        sim = "";
        status = "";
        SO ="";
        ambiente = "";
    }
    
    
    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }
    
    
     public String getSim() {
        return sim;
    }

    public void setSim(String sim) {
        this.sim = sim;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * @return the SO
     */
    public String getSO() {
        return SO;
    }

    /**
     * @param SO the SO to set
     */
    public void setSO(String SO) {
        this.SO = SO;
    }

    /**
     * @return the ambiente
     */
    public String getAmbiente() {
        return ambiente;
    }

    /**
     * @param ambiente the ambiente to set
     */
    public void setAmbiente(String ambiente) {
        this.ambiente = ambiente;
    }
     
    
}
