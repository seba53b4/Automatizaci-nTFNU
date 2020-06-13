
import Base.BasePage;
import Utils.HandleFile;
import Utils.Plan;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
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
public class Test_CambioPlan extends Base.BaseTest {
   private CostumerPage ap;
   private HandleFile hf;
   private LoginPage lp;
   
    
     public Test_CambioPlan() {
       
       
    }
     @Test
   public void Cambio_Plan() throws Exception
   {     
      BasePage.initBaseTest();
        this.ap = new CostumerPage();
        this.lp = LoginPage.getLoginPage();
        this.hf = new HandleFile();
       List<Plan> realPlans = new ArrayList<>();
        HashMap<String, List<Plan>> dataSource = this.hf.readRegisterDataSource("change_plan");
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
                  Plan newPlan = this.ap.cambioPlan(newPlans.get(i),enviroment);
                   if (newPlan.getName() != null) {
                        realPlans.add(newPlan);
                    }
                    
                   
                }
            }
        }
         // only save in spreadsheet the changed Plan
        if (realPlans.size() > 0) {
            this.hf.generateRegisteredChangedPlanDatasource(realPlans); 
     
   }
  }
}

