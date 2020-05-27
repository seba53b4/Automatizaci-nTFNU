package Tests;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import Base.BasePage;
import Utils.HandleFile;
import Utils.Plan;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.junit.After;
import org.junit.Test;
import pages.CostumerPage;
import pages.LoginPage;
/**
 *
 * @author sdominguez
 */
public class TestAltaPP extends Base.BaseTest{
   
   //WebDriver driver ;
   private CostumerPage ap;
   private HandleFile hf;
   private LoginPage lp;
   
   
     
/*
   public TestAltaPP(WebDriver driver) {
        super(driver);
   }*/

    public TestAltaPP() {
        
      
    }
    
  
 
   @Test
   public void altaPP() throws Exception
   {      
       BasePage.initBaseTest();
        this.ap = new CostumerPage();
        this.lp = new LoginPage();
        this.hf = new HandleFile();
       List<Plan> realPlans = new ArrayList<>();
        HashMap<String, List<Plan>> dataSource = this.hf.readRegisterDataSource("new_plan");
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
                  Plan newPlan = this.ap.AltaPP(newPlans.get(i),enviroment);
                   if (newPlan.getName() != null) {
                        realPlans.add(newPlan);
                    }
                    
                   
                }
            }
        }
         // only save in spreadsheet the real Plan
        if (realPlans.size() > 0) {
            this.hf.generateRegisteredNewPlanDatasource(realPlans);
      
     
     }
   }

    @After
    public void CerrarNavegador() {
        super.CerrarNavegador(); //To change body of generated methods, choose Tools | Templates.
    }
   
 }  
   
