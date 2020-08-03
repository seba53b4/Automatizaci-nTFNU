package Tests;


import pages.RechargePage;
import Base.BasePage;
import Utils.Client;
import Utils.HandleFile;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Test;
import pages.LoginPage;
//import pages.RechargePage;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ipupo
 */
public class TestRecarga extends Base.BaseTest{
   private RechargePage ap;
   private HandleFile hf;
   private LoginPage lp;
   private Client client;
   
public TestRecarga(Client c){
    client = c;
}


 @Override
    public String test() {
       try {
           this.Recarga_Linea();
           return "OK";
       } catch (Exception ex) {
           
           try {
               HandleFile.getHandleFile().registrarError("ERROR en Recarga Linea \n\n"+ ex+"\n\n---------------------------------------------------------------------------\n\n");
           } catch (IOException ex1) {
               Logger.getLogger(TestAltaPP.class.getName()).log(Level.SEVERE, null, ex1);
           }
           return "Falló";
       } finally{
      //     BasePage.initBaseTest().closeDriver();
       }
    }



    @Test
   public void Recarga_Linea() throws Exception
   {     
         BasePage.initBaseTest();
         BasePage.getNewDriver(); // 
         HandleFile.initHandleFile(); // Se borra cuando se pase a proyecto.tests
         this.ap = new RechargePage();
         this.lp = LoginPage.getLoginPage();
         
         List<Client> realClients = new ArrayList<>();
         
         
         String enviroment = client.getAmbiente();
         this.ap.initUrlBusqueda(enviroment);
         this.lp.Nav(enviroment);
        // if(enviroment.contains("preprod")){
             this.lp.signIn_preprod();
         //}
        // else{
       //      this.lp.signIn();
       //  }
         
         Client newClient = this.ap.recargaLinea(client, enviroment);
         if (newClient.getLink_recharge() != null) {
             realClients.add(newClient);
         }
         
         
         
         // only save in spreadsheet the recharge
         if (realClients.size() > 0) {
             HandleFile.getHandleFile().generateRegisteredRechargeDatasource(realClients);
             
         }
     }
}
