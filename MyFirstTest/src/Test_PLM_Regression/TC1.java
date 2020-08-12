/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test_PLM_Regression;

import Tests.TestNewResiClient;
import Tests.Test_CambioPlan;
import Utils.Client;
import Utils.Plan;
import org.junit.Test;

/**
 *
 * @author ipupo
 */
public class TC1 {
    private Tests.TestNewResiClient test_new_resi;
    private Tests.TestAltaPosP test_alta_plr;
    private Tests.Test_CambioPlan test_cambio_low_plr;
    private Plan p;
    private Client clte;
    //private Tests.Test Desconexion incluirlo
   
    public TC1(Tests.TestNewResiClient client){
        test_new_resi= client;
    
    }
    @Test
    
    public void TC(){
        
     this.test_alta_plr= new Tests.TestAltaPosP(p);
     this.test_cambio_low_plr= new Test_CambioPlan(p);
     this.test_new_resi= new TestNewResiClient(clte);
        
    }
      public static void main(String args[])  {
      }
}
