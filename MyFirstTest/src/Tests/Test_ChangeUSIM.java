package Tests;


import Base.BasePage;
import Utils.HandleFile;
import Utils.Plan;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
   private Plan plan;
   
   
    public Test_ChangeUSIM(Plan p) {
        
        ap = new CostumerPage();
        plan = p;
      
    }
    
     @Override
    public String test() {
        try {
            this.change_usim();
            return "OK";
        } catch (Exception ex) {
            try {
                HandleFile.getHandleFile().registrarError("ERROR en Cambio USIM \n\n"+ ex +"\n\n---------------------------------------------------------------------------\n\n");
            } catch (IOException ex1) {
                Logger.getLogger(TestAltaPosP.class.getName()).log(Level.SEVERE, null, ex1);
            }
            return "Falló";
        }finally{
            //BasePage.initBaseTest().closeDriver();
        }
    }
    
     @Test
     public void change_usim() throws Exception
     {
         BasePage.initBaseTest();
         BasePage.getNewDriver(); //
         this.ap = new CostumerPage();
         this.lp = LoginPage.getLoginPage();
         
         List<Plan> realPlans = new ArrayList<>();
         String enviroment = plan.getAmbiente();
         this.ap.initUrlBusqueda(enviroment);
         this.lp.Nav(enviroment);
         
         if(enviroment.equals("preprod")){
          this.lp.signIn_preprod();
       }
       else{
          this.lp.signIn();
      }
         List<Plan> newPlans = new LinkedList<>();
         Plan newPlan = this.ap.cambiarUSIM(plan, enviroment);
         if (newPlan.getName() != null) {
             newPlans.add(newPlan);
         }
         // only save in spreadsheet the changed Plan
         if (newPlans.size() > 0) {
            // System.out.println("Entra a guarda CHangeUSIM");
             HandleFile.getHandleFile().generateRegisteredChangeUSIMDatasource(newPlans);
             
         }
     }
}
