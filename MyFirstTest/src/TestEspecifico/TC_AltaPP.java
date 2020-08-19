/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestEspecifico;

import Test_PLM_Regression.*;
import Base.BaseTest;
import Tests.TestAltaPP;
import Tests.TestNewResiClient;
import Tests.Test_CambioPlan;
import Utils.Client;
import Utils.HandleFile;
import Utils.Plan;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.junit.Test;

/**
 *
 * @author ipupo
 */
public class TC_AltaPP extends BaseTest {
    
    private TestAltaPP alta_pp;
    private Plan p;
    private Client clte;
    
    //private Tests.Test Desconexion incluirlo
   
    public TC_AltaPP(Client client) throws Exception{
        HandleFile.initHandleFile();
        clte = client;
        p = new Plan("PLR315");
        System.out.println("Object id cliente : " + clte.getClientId());
        
        p.setAmbiente(clte.getAmbiente());
        p.setObject_id(clte.getClientId());
        p.setMSISDN(HandleFile.getHandleFile().getMSISDN_Regresion(p.getAmbiente()));
        p.setICCID(HandleFile.getHandleFile().getICCID_Regresion(p.getAmbiente()));
        //p.setMSISDN("95059314");
        this.alta_pp = new TestAltaPP(p);
  
 }

    @Override
    public String test() {
        
        
        alta_pp.test();
        
        
      
        return "hello there!";
    }
    
   
}
