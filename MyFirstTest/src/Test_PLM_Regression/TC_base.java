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
public class TC_base {
    //Tests.TestNewResiClient test_resi_ci;
      private Client clte;
      
       public TC_base(Client client) throws Exception{
        HandleFile.initHandleFile();
        clte = client;
   
        System.out.println("Object id cliente : " + clte.getClientId());
              
 }
    public String test() {
        
        try {
           this.testCaseBase();
           return "OK";
       } catch (Exception ex) {
           
           try {
               HandleFile.getHandleFile().registrarError("ERROR en TestCaseBase en Regresion de PLM \n\n"+ ex+"\n\n---------------------------------------------------------------------------\n\n");
           } catch (IOException ex1) {
               Logger.getLogger(TestAltaPP.class.getName()).log(Level.SEVERE, null, ex1);
           }
           return "Falló";
       } finally{
      //     BasePage.initBaseTest().closeDriver();
       }
    }
      private void testCaseBase() throws InterruptedException, Exception{
       
       //Crea el ChromeDriver a usar
       BasePage.getNewDriver();
       
       // Crean Objetos
       LoginPage lp = LoginPage.initLoginPage("seolivera", "wartel.1");
       CostumerPage cp = CostumerPage.getInstance();
       ClientPage clp = ClientPage.getInstance();
     
       cp.initUrlBusqueda(clte.getAmbiente());
       
       lp.Nav(clte.getAmbiente());
       lp.signIn_preprod();
       
       //Alta de cliente
       clp.crear_Cliente_Residencial(clte);
       System.out.println("Despues de alta " + clte.getClientId());
       
      
        }
      }
