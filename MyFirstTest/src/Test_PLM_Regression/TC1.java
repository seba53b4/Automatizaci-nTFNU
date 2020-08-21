/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test_PLM_Regression;

import Base.BasePage;
import Base.BaseTest;
import Tests.TestAltaPP;
import Tests.TestNewResiClient;
import Tests.Test_CambioPlan;
import Utils.Client;
import Utils.HandleFile;
import Utils.Plan;
import java.io.IOException;
import java.util.ArrayList;
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

/**
 *
 * @author ipupo
 */
public class TC1 extends BaseTest {
    
    private Plan p;
    private Client clte;
    
    //private Tests.Test Desconexion incluirlo
   
    public TC1(Client client) throws Exception{
        HandleFile.initHandleFile();
        clte = client;
        p = new Plan("PLR310");
        System.out.println("Object id cliente : " + clte.getClientId());
        
        p.setMSISDN("94797890");
        p.setICCID("89598076101039727120");
        p.setAmbiente(clte.getAmbiente());
        p.setObject_id(clte.getClientId());
        p.setMSISDN(HandleFile.getHandleFile().getMSISDN_Regresion(p.getAmbiente()));
        p.setICCID(HandleFile.getHandleFile().getICCID_Regresion(p.getAmbiente()));
        //p.setMSISDN("95059314");
       
  
 }

    @Override
    public String test() {
        
        try {
           this.testCase1();
           return "OK";
       } catch (Exception ex) {
           
           try {
               HandleFile.getHandleFile().registrarError("ERROR en TestCase1 en Regresion de PLM \n\n"+ ex+"\n\n---------------------------------------------------------------------------\n\n");
           } catch (IOException ex1) {
               Logger.getLogger(TestAltaPP.class.getName()).log(Level.SEVERE, null, ex1);
           }
           return "Falló";
       } finally{
      //     BasePage.initBaseTest().closeDriver();
       }
    }
    
    
   private void testCase1() throws InterruptedException, Exception{
       
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
       
       //Alta de PLR
       p.setObject_id(clte.getClientId());
       cp.get_Type_PlanPos(p,p.getAmbiente());
       
       String str = cp.estadoSOFinal();
       System.out.println("ANTES de PLR to low: " + str );
       if (str.equals("Ok")) {
           // Cambio to Low PLR
           p.setName_change_plan("PLR310");
           cp.cambioPlan(p, p.getAmbiente());
       } else {
           throw new Exception(" TESTCASE1 - PLM_REGRESION - PLR to low");
       }
      
       str = cp.estadoSOFinal();
       System.out.println("ANTES de PLR to disconnect: " + str );
       if (str.equals("Ok")) {
           // Deberia hacer de desconexion
           dp.initUrlBusqueda(enviroment);
           dp.Desconectar(p);
       } else {
           throw new Exception(" TESTCASE1 - PLM_REGRESION - PLR to disconnect");
       }
       
      
   }
}
