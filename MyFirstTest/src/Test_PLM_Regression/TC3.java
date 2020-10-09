/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test_PLM_Regression;

import Base.BasePage;
import Tests.TestAltaPP;
import Utils.Client;
import Utils.HandleFile;
import Utils.Plan;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import pages.ClientPage;
import pages.CostumerPage;
import pages.DesconectarPage;
import pages.LoginPage;
import pages.RechargePage;

/**
 *
 * @author ipupo
 */
public class TC3 {
    //private Tests.TestAltaPP test_alta_pp;
    //private Tests.TestRecarga test_recharge_pp;
    //private Tests.Test_CambioPlan test_cambio_cc;
    private Plan p;
    private Client clte;
    
      public TC3(Client client) throws Exception{
        HandleFile.initHandleFile();
        clte = client;
        p = new Plan("PLC280");
        System.out.println("Object id cliente : " + clte.getClientId());
        
        p.setMSISDN("94797890");
        p.setICCID("89598076101039727120");
        p.setAmbiente(clte.getAmbiente());
        p.setObject_id(clte.getClientId());
        p.setMSISDN(HandleFile.getHandleFile().getMSISDN_Regresion(p.getAmbiente()));
        p.setICCID(HandleFile.getHandleFile().getICCID_Regresion(p.getAmbiente()));
    }
      
      public String test() {
        
        try {
           this.testCase3();
           return "OK";
       } catch (Exception ex) {
           
           try {
               HandleFile.getHandleFile().registrarError("ERROR en TestCase3 en Regresion de PLM \n\n"+ ex+"\n\n---------------------------------------------------------------------------\n\n");
           } catch (IOException ex1) {
               Logger.getLogger(TestAltaPP.class.getName()).log(Level.SEVERE, null, ex1);
           }
           return "Falló";
       } finally{
      //     BasePage.initBaseTest().closeDriver();
       }
    }
       private void testCase3() throws InterruptedException, Exception{
       
       //Crea el ChromeDriver a usar
       BasePage.getNewDriver();
       
       // Crean Objetos
       LoginPage lp = LoginPage.initLoginPage("seolivera", "wartel.1");
       CostumerPage cp = CostumerPage.getInstance();
       ClientPage clp = ClientPage.getInstance();
       DesconectarPage dp = DesconectarPage.getInstance();
       RechargePage rp= RechargePage.getInstance();
       
       String enviroment = p.getAmbiente();
       cp.initUrlBusqueda(enviroment);
       
       lp.Nav(enviroment);
       lp.signIn_preprod();
       
       //Alta de cliente
       clp.crear_Cliente_Residencial(clte);
       System.out.println("Despues de alta " + clte.getClientId());
       
       //Alta de PP
       p.setObject_id(clte.getClientId());
       cp.AltaPP(p, enviroment);
       
       String str = cp.estadoSOFinal();
       System.out.println("ANTES de PP to recharge PP: " + str );
       if (str.equals("Ok")) {
           
       // Recharge PP
           p.setObject_id(clte.getClientId());
           rp.recargaLinea(clte, enviroment);
       } else {
           throw new Exception(" TESTCASE3 - PLM_REGRESION - PP recharge");
       }
     
        // Cambio USIM 
       p.setObject_id(clte.getClientId());
       cp.cambiarUSIM(p, enviroment);
         
       }   
      
   }

