
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
  /*private RechargePage rp;
   private HandleFile hf;
   private LoginPage lp;
 
   
public TestRecarga(){

}

    @Test
   public void Recarga_Linea() throws Exception
   {     
      BasePage.initBaseTest();
        this.rp = new RechargePage();
        this.lp = new LoginPage();
        this.hf = new HandleFile();
       List<Client> realrecarga = new ArrayList<>();
        HashMap<String, List<Client>> dataSource = this.hf.readRegisterDataSource("recharge_line");
        if (!dataSource.isEmpty()) {
            for (HashMap.Entry<String, List<Client>> entry : dataSource.entrySet()) {
                String enviroment = entry.getKey();
                this.rp.initUrlBusqueda(enviroment);
                this.lp.Nav(enviroment);
                if(enviroment.contains("preprod")){
                this.lp.signIn_preprod();
                }
                else{
                this.lp.signIn();
                }
                List<Client> newClients = entry.getValue();
                for (int i = 0; i < newClients.size(); i++) {
                  Client newClient = this.rp.recargaLinea(newClients.get(i),enviroment);
                   if (newClient.getLine() != null) {
                        realrecarga.add(newClient);
                    }
                    
                   
                }
            }
        }
         // only save in spreadsheet the recharge Line
        if (realrecarga.size() > 0) {
            this.hf.generateRegisteredRechargeDatasource(realrecarga); 
     
   }
  }*/
}
