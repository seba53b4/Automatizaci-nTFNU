/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test_PLM_Regression;

import Base.BaseTest;
import Tests.TestNewResiClient;
import Tests.Test_CambioPlan;
import Utils.Client;
import Utils.Plan;
import org.junit.Test;

/**
 *
 * @author ipupo
 */
public class TC1 extends BaseTest {
    
    private Tests.TestNewResiClient test_new_resi;
    private Tests.TestAltaPosP test_alta_plr;
    private Tests.Test_CambioPlan test_cambio;
    private Plan p;
    private Client clte;
    //private Tests.Test Desconexion incluirlo
   
    public TC1(Client client){
        clte = client;
        p = new Plan("PLR315");
        System.out.println("Object id cliente : " + clte.getClientId());
        
        p.setAmbiente(clte.getAmbiente());
        p.setObject_id(clte.getClientId());
        p.setICCID("89598076102034958108");
        p.setMSISDN("95059314");
        this.test_alta_plr = new Tests.TestAltaPosP(p);
        this.test_cambio= new Test_CambioPlan(p);
        
    }

    @Override
    public String test() {
        
        //Crea el Alta del PLR
        test_alta_plr.test();
        
        // Cambio to Low PLR
        p.setName_change_plan("PLR310");
        test_cambio.test();
        
        // Deberia hacer de esconexion
        //p.setName_change_plan("PLTTEF");
        //test_cambio.test();
      
        return "hello there!";
    }
    
   
}
