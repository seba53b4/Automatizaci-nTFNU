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

/**
 *
 * @author ipupo
 */
public class TC2 extends Base.BaseTest {
    
    //private Tests.TestNewResiClient test_alta_client;
    //private Tests.Test_CambioPlan test_cambio_low_plc_pp;
    private Plan p;
    private Client clte;
    
     public TC2(Client client) throws Exception{
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
           this.testCase2();
           return "OK";
       } catch (Exception ex) {
           
           try {
               HandleFile.getHandleFile().registrarError("ERROR en TestCase2 en Regresion de PLM \n\n"+ ex+"\n\n---------------------------------------------------------------------------\n\n");
           } catch (IOException ex1) {
               Logger.getLogger(TestAltaPP.class.getName()).log(Level.SEVERE, null, ex1);
           }
           return "Falló";
       } finally{
      //     BasePage.initBaseTest().closeDriver();
       }
    }
    
     private void testCase2() throws InterruptedException, Exception{
       
       //Crea el ChromeDriver a usar
       BasePage.getNewDriver();
       
       // Crean Objetos
       LoginPage lp = LoginPage.initLoginPage("seolivera", "wartel.1");
       CostumerPage cp = CostumerPage.getInstance();
       ClientPage clp = ClientPage.getInstance();
       DesconectarPage dp = DesconectarPage.getInstance();
       
       String enviroment = p.getAmbiente();
       cp.initUrlBusqueda(enviroment);
       
       lp.Nav(enviroment);
       lp.signIn_preprod();
       
       //Alta de cliente
       clp.crear_Cliente_Residencial(clte);
       System.out.println("Despues de alta " + clte.getClientId());
       
       //Alta de PLC
       p.setObject_id(clte.getClientId());
       cp.get_Type_PlanPos(p,p.getAmbiente());
       
       String str = cp.estadoSOFinal();
       System.out.println("ANTES de PLC to low: " + str );
       if (str.equals("Ok")) {
        
        // Cambio to Low PLC
           p.setName_change_plan("PLC");
           cp.cambioPlan(p, p.getAmbiente());
       } else {
           throw new Exception(" TESTCASE2 - PLM_REGRESION - PLC to low");
       }
       
      
   }
}
