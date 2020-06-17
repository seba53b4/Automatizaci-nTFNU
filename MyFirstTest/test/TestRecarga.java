
import pages.RechargePage;
import Base.BasePage;
import Utils.Client;
import Utils.HandleFile;
import Utils.Plan;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.junit.Test;
import pages.CostumerPage;
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
 
   
public TestRecarga(){

}

    @Test
   public void Recarga_Linea() throws Exception
   {     
      BasePage.initBaseTest();
         BasePage.getNewDriver(); // 
         HandleFile.initHandleFile(); // Se borra cuando se pase a proyecto.tests
         this.ap = new RechargePage();
         this.lp = LoginPage.initLoginPage("ipupo", "Movistar.1234");
         List<Client> realClients = new ArrayList<>();
         HashMap<String, List<Client>> dataSource = HandleFile.getHandleFile().readRegisterDataSource("recharge_line");
         if (!dataSource.isEmpty()) {
             for (HashMap.Entry<String, List<Client>> entry : dataSource.entrySet()) {
                 String enviroment = entry.getKey();
                 this.ap.initUrlBusqueda(enviroment);
                 this.lp.Nav(enviroment);
                 if(enviroment.contains("preprod")){
                     this.lp.signIn_preprod();
                 }
                 else{
                     this.lp.signIn();
                 }
                 List<Client> newClients = entry.getValue();
                 for (int i = 0; i < newClients.size(); i++) {
                     Client newClient = this.ap.recargaLinea(newClients.get(i), enviroment);
                     if (newClient.getName() != null) {
                         realClients.add(newClient);
                     }
                 }
             }
         }
         // only save in spreadsheet the changed Plan
         if (realClients.size() > 0) {
             HandleFile.getHandleFile().generateRegisteredRechargeDatasource(realClients);
             
         }
     }
}
