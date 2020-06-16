package Tests;



import Base.BasePage;
import Utils.HandleFile;
import Utils.Plan;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
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
public class Test_SimCardLost extends Base.BaseTest {
   private CostumerPage ap;
   private HandleFile hf;
   private LoginPage lp;
   private Plan plan;
    
     
    
     public Test_SimCardLost(Plan newPlan) {
        
        ap = new CostumerPage();
        plan = newPlan;
    }
     
      @Override
    public String test() {
       try {
           this.sim_Card_Lost();
           return "OK";
       } catch (Exception ex) {
           
           try {
               HandleFile.getHandleFile().registrarError("ERROR en Sim Card Lost \n\n"+ ex+"\n\n---------------------------------------------------------------------------\n\n");
           } catch (IOException ex1) {
               Logger.getLogger(TestAltaPP.class.getName()).log(Level.SEVERE, null, ex1);
           }
           return "Falló";
       } finally{
      //     BasePage.initBaseTest().closeDriver();
       }
    }
     
     
     @Test
     public void sim_Card_Lost() throws Exception
     {
         BasePage.initBaseTest();
         BasePage.getNewDriver(); // 
         HandleFile.initHandleFile(); // Se borra cuando se pase a proyecto.tests
         this.ap = new CostumerPage();
         this.lp =  this.lp = LoginPage.getLoginPage();
         
         List<Plan> realPlans = new ArrayList<>();
             
         String enviroment = plan.getAmbiente();
         this.ap.initUrlBusqueda(enviroment);
         this.lp.Nav(enviroment);
         if(enviroment.contains("preprod")){
             this.lp.signIn_preprod();
         }
         else{
             this.lp.signIn();
         }
         ;
         Plan newPlan = this.ap.simCardlost(plan, enviroment);
         if (newPlan  != null) {
             realPlans.add(newPlan);
         }
         
         
         // only save in spreadsheet the changed Plan
         if (realPlans.size() > 0) {
             HandleFile.getHandleFile().generateRegisteredSimCardLostDatasource(realPlans);
             
         }
     }
  }
