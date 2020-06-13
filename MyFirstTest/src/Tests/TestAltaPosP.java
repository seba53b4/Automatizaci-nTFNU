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
public class TestAltaPosP extends Base.BaseTest {
   private CostumerPage ap;
   private LoginPage lp;
   private Plan plan;
     
    public TestAltaPosP(Plan p) {
        this.plan = p;
    }

    @Override
    public String test() {
       try {
           this.altaPosP();
           return "OK";
       } catch (Exception ex) {
           try {
               HandleFile.getHandleFile().registrarError("ERROR en Alta de PosPago \n\n"+ ex +"\n\n---------------------------------------------------------------------------\n\n");
           } catch (IOException ex1) {
               Logger.getLogger(TestAltaPosP.class.getName()).log(Level.SEVERE, null, ex1);
           }
           return "Falló";
       }finally{
           //BasePage.initBaseTest().closeDriver();
       }
    }
    
    
    
    @Test
   public void altaPosP() throws Exception
   {     
       
       BasePage.getNewDriver();
       this.ap = new CostumerPage();
       this.lp = LoginPage.getLoginPage();
       List<Plan> realPlans = new ArrayList<>(); //pp plr plc
       String enviroment = plan.getAmbiente();
       this.ap.initUrlBusqueda(enviroment);
       this.lp.Nav(enviroment);
       if(enviroment.contains("preprod")){
           this.lp.signIn_preprod();
       } else{
           this.lp.signIn();
       }
       Plan newPlan = this.ap.AltaPosP(plan,enviroment);
       
       if (newPlan != null) {
           System.out.println("NO ES NULO EL PLAN");
           realPlans.add(newPlan);
           plan = newPlan;
       } else {
           System.out.println("ES RE NULO EL PLAN");
       }
       HandleFile.getHandleFile().generateRegisteredNewPlanDatasource(realPlans);
   }

  
}

