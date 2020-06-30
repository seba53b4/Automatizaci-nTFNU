
import Base.BasePage;
import Utils.HandleFile;
import Utils.Plan;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.junit.Test;
import pages.CostumerPage;
import pages.LoginPage;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ipupo
 */
public class Test_ChangeUSIM extends Base.BaseTest{
   private CostumerPage ap;
   private HandleFile hf;
   private LoginPage lp; 
   
   
    public Test_ChangeUSIM() {
        
        ap = new CostumerPage();
      
    }
     @Test
     public void change_usim() throws Exception
     {
         BasePage.initBaseTest();
         BasePage.getNewDriver(); // 
         HandleFile.initHandleFile(); // Se borra cuando se pase a proyecto.tests
         this.ap = new CostumerPage();
         this.lp = LoginPage.initLoginPage("ipupo", "Movistar.12345");
         List<Plan> realPlans = new ArrayList<>();
         HashMap<String, List<Plan>> dataSource = HandleFile.getHandleFile().readRegisterDataSource("change_usim");
         if (!dataSource.isEmpty()) {
             for (HashMap.Entry<String, List<Plan>> entry : dataSource.entrySet()) {
                 String enviroment = entry.getKey();
                 this.ap.initUrlBusqueda(enviroment);
                 this.lp.Nav(enviroment);
                 if(enviroment.contains("preprod")){
                     this.lp.signIn_preprod();
                 }
                 else{
                     this.lp.signIn();
                 }
                 List<Plan> newPlans = entry.getValue();
                 for (int i = 0; i < newPlans.size(); i++) {
                     Plan newPlan = this.ap.cambiarUSIM(newPlans.get(i), enviroment);
                     if (newPlan.getName() != null) {
                         realPlans.add(newPlan);
                     }
                 }
             }
         }
         // only save in spreadsheet the changed Plan
         if (realPlans.size() > 0) {
             HandleFile.getHandleFile().generateRegisteredSimCardLostDatasource(realPlans);
             
         }
     }
}
