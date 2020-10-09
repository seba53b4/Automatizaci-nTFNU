/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test_PLM_Regression;

import Base.BasePage;
import Base.BaseTest;
import RegresionTests.TestAltaPosP_Regresion;
import Tests.TestAltaPP;
import Tests.TestAltaPosP;
import Tests.TestNewResiClient;
import Tests.Test_CambioPlan;
import Utils.Client;
import Utils.HandleFile;
import Utils.Plan;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Test;
import pages.ClientPage;
import pages.CostumerPage;
import pages.DesconectarPage;
import pages.LoginPage;
import pages.RechargePage;

/**
 *
 * @author ipupo
 */
public class TC4 extends BaseTest {
    
   
    private Plan p;
    private Client clte;
    
    //private Tests.Test Desconexion incluirlo
   
    public TC4(Client client) throws Exception{
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

    @Override
    public String test() {
        try {
           this.testCase4();
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
    private void testCase4() throws InterruptedException, Exception{
       
       //Crea el ChromeDriver a usar
       BasePage.getNewDriver();
       
       // Crean Objetos
       LoginPage lp = LoginPage.initLoginPage("seolivera", "wartel.1");
       CostumerPage cp = CostumerPage.getInstance();
       ClientPage clp = ClientPage.getInstance();
       
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
       System.out.println("ANTES de PP to change PLC: " + str );
       if (str.equals("Ok")) {
           
       // Cambio to PLC
           p.setObject_id(clte.getClientId());
           cp.cambioPlan(p, enviroment);
       } else {
           throw new Exception(" TESTCASE4 - PLM_REGRESION - PP to change PLC");
       }
      
     // Cambio to PP
       String str1 = cp.estadoSOFinal();
       System.out.println("ANTES de PLC to change PP: " + str1 ); 
       if(str1.equals("OK")){
       p.setObject_id(clte.getClientId());
       cp.cambioPlan(p, enviroment);
       } else {
           throw new Exception(" TESTCASE4 - PLM_REGRESION - PLC to change PP");
       }   
    }
       
        
        
    
   
}
